
package fr.toto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour enregistrerPaiement complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="enregistrerPaiement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroCarte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crypto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateExpiration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enregistrerPaiement", propOrder = {
    "numeroCarte",
    "crypto",
    "dateExpiration",
    "montant"
})
public class EnregistrerPaiement {

    protected String numeroCarte;
    protected String crypto;
    protected String dateExpiration;
    protected double montant;

    /**
     * Obtient la valeur de la propri�t� numeroCarte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCarte() {
        return numeroCarte;
    }

    /**
     * D�finit la valeur de la propri�t� numeroCarte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCarte(String value) {
        this.numeroCarte = value;
    }

    /**
     * Obtient la valeur de la propri�t� crypto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrypto() {
        return crypto;
    }

    /**
     * D�finit la valeur de la propri�t� crypto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrypto(String value) {
        this.crypto = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateExpiration.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateExpiration() {
        return dateExpiration;
    }

    /**
     * D�finit la valeur de la propri�t� dateExpiration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateExpiration(String value) {
        this.dateExpiration = value;
    }

    /**
     * Obtient la valeur de la propri�t� montant.
     * 
     */
    public double getMontant() {
        return montant;
    }

    /**
     * D�finit la valeur de la propri�t� montant.
     * 
     */
    public void setMontant(double value) {
        this.montant = value;
    }

}
