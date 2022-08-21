
package org.uws.servicio;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.uws.servicio package. 
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

    private final static QName _Crear_QNAME = new QName("http://servicio.uws.org/", "crear");
    private final static QName _CrearResponse_QNAME = new QName("http://servicio.uws.org/", "crearResponse");
    private final static QName _Eliminar_QNAME = new QName("http://servicio.uws.org/", "eliminar");
    private final static QName _EliminarResponse_QNAME = new QName("http://servicio.uws.org/", "eliminarResponse");
    private final static QName _Listar_QNAME = new QName("http://servicio.uws.org/", "listar");
    private final static QName _ListarResponse_QNAME = new QName("http://servicio.uws.org/", "listarResponse");
    private final static QName _Obtener_QNAME = new QName("http://servicio.uws.org/", "obtener");
    private final static QName _ObtenerResponse_QNAME = new QName("http://servicio.uws.org/", "obtenerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.uws.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Crear }
     * 
     */
    public Crear createCrear() {
        return new Crear();
    }

    /**
     * Create an instance of {@link CrearResponse }
     * 
     */
    public CrearResponse createCrearResponse() {
        return new CrearResponse();
    }

    /**
     * Create an instance of {@link Eliminar }
     * 
     */
    public Eliminar createEliminar() {
        return new Eliminar();
    }

    /**
     * Create an instance of {@link EliminarResponse }
     * 
     */
    public EliminarResponse createEliminarResponse() {
        return new EliminarResponse();
    }

    /**
     * Create an instance of {@link Listar }
     * 
     */
    public Listar createListar() {
        return new Listar();
    }

    /**
     * Create an instance of {@link ListarResponse }
     * 
     */
    public ListarResponse createListarResponse() {
        return new ListarResponse();
    }

    /**
     * Create an instance of {@link Obtener }
     * 
     */
    public Obtener createObtener() {
        return new Obtener();
    }

    /**
     * Create an instance of {@link ObtenerResponse }
     * 
     */
    public ObtenerResponse createObtenerResponse() {
        return new ObtenerResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Crear }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Crear }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "crear")
    public JAXBElement<Crear> createCrear(Crear value) {
        return new JAXBElement<Crear>(_Crear_QNAME, Crear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "crearResponse")
    public JAXBElement<CrearResponse> createCrearResponse(CrearResponse value) {
        return new JAXBElement<CrearResponse>(_CrearResponse_QNAME, CrearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Eliminar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Eliminar }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "eliminar")
    public JAXBElement<Eliminar> createEliminar(Eliminar value) {
        return new JAXBElement<Eliminar>(_Eliminar_QNAME, Eliminar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "eliminarResponse")
    public JAXBElement<EliminarResponse> createEliminarResponse(EliminarResponse value) {
        return new JAXBElement<EliminarResponse>(_EliminarResponse_QNAME, EliminarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "listar")
    public JAXBElement<Listar> createListar(Listar value) {
        return new JAXBElement<Listar>(_Listar_QNAME, Listar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "listarResponse")
    public JAXBElement<ListarResponse> createListarResponse(ListarResponse value) {
        return new JAXBElement<ListarResponse>(_ListarResponse_QNAME, ListarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obtener }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Obtener }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "obtener")
    public JAXBElement<Obtener> createObtener(Obtener value) {
        return new JAXBElement<Obtener>(_Obtener_QNAME, Obtener.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.uws.org/", name = "obtenerResponse")
    public JAXBElement<ObtenerResponse> createObtenerResponse(ObtenerResponse value) {
        return new JAXBElement<ObtenerResponse>(_ObtenerResponse_QNAME, ObtenerResponse.class, null, value);
    }

}
