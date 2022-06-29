/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.maven.plugin.ittests;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;
import org.kie.dmn.core.api.DMNFactory;
import org.kie.dmn.core.compiler.execmodelbased.DMNRuleClassFile;

import static org.assertj.core.api.Assertions.assertThat;

public class KJarWithDMNIntegrationTestIT {


    private final static String GROUP_ID = "org.kie";
    private static final String GAV_ARTIFACT_ID = "kie-maven-plugin-test-kjar-14-yes-generate-dmn";
    private static final String GAV_VERSION = "${org.kie.version}";
    private final static String KBASE_NAME = "dmnkiebase";

    @Test
    public void testComplexDMNModel() throws Exception {
        final URL targetLocation = KJarWithDMNIntegrationTestIT.class.getProtectionDomain().getCodeSource().getLocation();
        final KieSession kieSession = ITTestsUtils.getKieSession(targetLocation, GAV_ARTIFACT_ID, GAV_VERSION, KBASE_NAME);

        // verify DMN file is present
        assertThat(getClass().getClassLoader().getResourceAsStream(DMNRuleClassFile.RULE_CLASS_FILE_NAME)).isNotNull();

        try {
            final DMNRuntime dmnRuntime = kieSession.getKieRuntime(DMNRuntime.class);
            final DMNModel dmnModel = dmnRuntime.getModel("https://kiegroup.org/dmn/_DB783BAD-4250-4028-93C6-1C3C914DE712",
                                                          "Decision");
            assertThat(dmnModel).isNotNull();
            assertThat(dmnModel.getMessages()).isEmpty();
        } finally {
            kieSession.dispose();
        }
    }
}