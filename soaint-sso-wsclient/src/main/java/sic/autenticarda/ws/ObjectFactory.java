
package sic.autenticarda.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sic.autenticarda.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AutenticarDA_QNAME = new QName("http://ws.autenticarda.sic/", "autenticarDA");
    private final static QName _AutenticarDAResponse_QNAME = new QName("http://ws.autenticarda.sic/", "autenticarDAResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sic.autenticarda.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AutenticarDA_Type }
     * 
     */
    public AutenticarDA_Type createAutenticarDA_Type() {
        return new AutenticarDA_Type();
    }

    /**
     * Create an instance of {@link AutenticarDAResponse }
     * 
     */
    public AutenticarDAResponse createAutenticarDAResponse() {
        return new AutenticarDAResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarDA_Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AutenticarDA_Type }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.autenticarda.sic/", name = "autenticarDA")
    public JAXBElement<AutenticarDA_Type> createAutenticarDA(AutenticarDA_Type value) {
        return new JAXBElement<AutenticarDA_Type>(_AutenticarDA_QNAME, AutenticarDA_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarDAResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AutenticarDAResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.autenticarda.sic/", name = "autenticarDAResponse")
    public JAXBElement<AutenticarDAResponse> createAutenticarDAResponse(AutenticarDAResponse value) {
        return new JAXBElement<AutenticarDAResponse>(_AutenticarDAResponse_QNAME, AutenticarDAResponse.class, null, value);
    }

}
