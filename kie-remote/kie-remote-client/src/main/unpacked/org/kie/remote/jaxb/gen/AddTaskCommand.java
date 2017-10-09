//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.28 at 12:40:13 PM CEST 
//


package org.kie.remote.jaxb.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Operation.Start : [ new OperationCommand().{ status = [ Status.Ready ],
 * allowed = [ Allowed.PotentialOwner ], setNewOwnerToUser = true, newStatus =
 * Status.InProgress }, new OperationCommand().{ status = [ Status.Reserved ],
 * allowed = [ Allowed.Owner ], newStatus = Status.InProgress } ], *
 * 
 * <p>Java class for addTaskCommand complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addTaskCommand"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}taskCommand"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jaxbTask" type="{}jaxbTask" minOccurs="0"/&gt;
 *         &lt;element name="parameter" type="{}jaxbStringObjectPairArray" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addTaskCommand", propOrder = {
    "jaxbTask",
    "parameter"
})
@XmlRootElement(name = "add-task-command")
public class AddTaskCommand
    extends TaskCommand
{

    protected Task jaxbTask;
    protected JaxbStringObjectPairArray parameter;

    /**
     * Gets the value of the jaxbTask property.
     * 
     * @return
     *     possible object is
     *     {@link Task }
     *     
     */
    public Task getJaxbTask() {
        return jaxbTask;
    }

    /**
     * Sets the value of the jaxbTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link Task }
     *     
     */
    public void setJaxbTask(Task value) {
        this.jaxbTask = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link JaxbStringObjectPairArray }
     *     
     */
    public JaxbStringObjectPairArray getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JaxbStringObjectPairArray }
     *     
     */
    public void setParameter(JaxbStringObjectPairArray value) {
        this.parameter = value;
    }

}