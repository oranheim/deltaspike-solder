//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 10:17:09 PM CEST 
//


package org.jboss.seam.security.external.jaxb.samlv2.metadata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeConsumingServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttributeConsumingServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:2.0:metadata}ServiceName" maxOccurs="unbounded"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:2.0:metadata}ServiceDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:2.0:metadata}RequestedAttribute" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="isDefault" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeConsumingServiceType", propOrder = {
    "serviceName",
    "serviceDescription",
    "requestedAttribute"
})
public class AttributeConsumingServiceType {

    @XmlElement(name = "ServiceName", required = true)
    protected List<LocalizedNameType> serviceName;
    @XmlElement(name = "ServiceDescription")
    protected List<LocalizedNameType> serviceDescription;
    @XmlElement(name = "RequestedAttribute", required = true)
    protected List<RequestedAttributeType> requestedAttribute;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "unsignedShort")
    protected int index;
    @XmlAttribute
    protected Boolean isDefault;

    /**
     * Gets the value of the serviceName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizedNameType }
     * 
     * 
     */
    public List<LocalizedNameType> getServiceName() {
        if (serviceName == null) {
            serviceName = new ArrayList<LocalizedNameType>();
        }
        return this.serviceName;
    }

    /**
     * Gets the value of the serviceDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizedNameType }
     * 
     * 
     */
    public List<LocalizedNameType> getServiceDescription() {
        if (serviceDescription == null) {
            serviceDescription = new ArrayList<LocalizedNameType>();
        }
        return this.serviceDescription;
    }

    /**
     * Gets the value of the requestedAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestedAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestedAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestedAttributeType }
     * 
     * 
     */
    public List<RequestedAttributeType> getRequestedAttribute() {
        if (requestedAttribute == null) {
            requestedAttribute = new ArrayList<RequestedAttributeType>();
        }
        return this.requestedAttribute;
    }

    /**
     * Gets the value of the index property.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Gets the value of the isDefault property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDefault() {
        return isDefault;
    }

    /**
     * Sets the value of the isDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDefault(Boolean value) {
        this.isDefault = value;
    }

}
