
package co.com.parking.parkingpractice.superintendencia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for queryTCRM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryTCRM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tcrmQueryAssociatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryTCRM", propOrder = {
    "tcrmQueryAssociatedDate"
})
public class QueryTCRM {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tcrmQueryAssociatedDate;

    /**
     * Gets the value of the tcrmQueryAssociatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTcrmQueryAssociatedDate() {
        return tcrmQueryAssociatedDate;
    }

    /**
     * Sets the value of the tcrmQueryAssociatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTcrmQueryAssociatedDate(XMLGregorianCalendar value) {
        this.tcrmQueryAssociatedDate = value;
    }

}
