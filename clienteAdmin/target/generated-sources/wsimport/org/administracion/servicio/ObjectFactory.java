
package org.administracion.servicio;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.administracion.servicio package. 
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

    private final static QName _EliminarRol_QNAME = new QName("http://servicio.administracion.org/", "eliminarRol");
    private final static QName _EliminarRolResponse_QNAME = new QName("http://servicio.administracion.org/", "eliminarRolResponse");
    private final static QName _EliminarUsuario_QNAME = new QName("http://servicio.administracion.org/", "eliminarUsuario");
    private final static QName _EliminarUsuarioResponse_QNAME = new QName("http://servicio.administracion.org/", "eliminarUsuarioResponse");
    private final static QName _GuardarRol_QNAME = new QName("http://servicio.administracion.org/", "guardarRol");
    private final static QName _GuardarRolResponse_QNAME = new QName("http://servicio.administracion.org/", "guardarRolResponse");
    private final static QName _GuardarUsuario_QNAME = new QName("http://servicio.administracion.org/", "guardarUsuario");
    private final static QName _GuardarUsuarioResponse_QNAME = new QName("http://servicio.administracion.org/", "guardarUsuarioResponse");
    private final static QName _ListarRol_QNAME = new QName("http://servicio.administracion.org/", "listarRol");
    private final static QName _ListarRolResponse_QNAME = new QName("http://servicio.administracion.org/", "listarRolResponse");
    private final static QName _ListarUsuario_QNAME = new QName("http://servicio.administracion.org/", "listarUsuario");
    private final static QName _ListarUsuarioResponse_QNAME = new QName("http://servicio.administracion.org/", "listarUsuarioResponse");
    private final static QName _ObtenerRol_QNAME = new QName("http://servicio.administracion.org/", "obtenerRol");
    private final static QName _ObtenerRolResponse_QNAME = new QName("http://servicio.administracion.org/", "obtenerRolResponse");
    private final static QName _ObtenerUsuario_QNAME = new QName("http://servicio.administracion.org/", "obtenerUsuario");
    private final static QName _ObtenerUsuarioResponse_QNAME = new QName("http://servicio.administracion.org/", "obtenerUsuarioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.administracion.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EliminarRol }
     * 
     */
    public EliminarRol createEliminarRol() {
        return new EliminarRol();
    }

    /**
     * Create an instance of {@link EliminarRolResponse }
     * 
     */
    public EliminarRolResponse createEliminarRolResponse() {
        return new EliminarRolResponse();
    }

    /**
     * Create an instance of {@link EliminarUsuario }
     * 
     */
    public EliminarUsuario createEliminarUsuario() {
        return new EliminarUsuario();
    }

    /**
     * Create an instance of {@link EliminarUsuarioResponse }
     * 
     */
    public EliminarUsuarioResponse createEliminarUsuarioResponse() {
        return new EliminarUsuarioResponse();
    }

    /**
     * Create an instance of {@link GuardarRol }
     * 
     */
    public GuardarRol createGuardarRol() {
        return new GuardarRol();
    }

    /**
     * Create an instance of {@link GuardarRolResponse }
     * 
     */
    public GuardarRolResponse createGuardarRolResponse() {
        return new GuardarRolResponse();
    }

    /**
     * Create an instance of {@link GuardarUsuario }
     * 
     */
    public GuardarUsuario createGuardarUsuario() {
        return new GuardarUsuario();
    }

    /**
     * Create an instance of {@link GuardarUsuarioResponse }
     * 
     */
    public GuardarUsuarioResponse createGuardarUsuarioResponse() {
        return new GuardarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ListarRol }
     * 
     */
    public ListarRol createListarRol() {
        return new ListarRol();
    }

    /**
     * Create an instance of {@link ListarRolResponse }
     * 
     */
    public ListarRolResponse createListarRolResponse() {
        return new ListarRolResponse();
    }

    /**
     * Create an instance of {@link ListarUsuario }
     * 
     */
    public ListarUsuario createListarUsuario() {
        return new ListarUsuario();
    }

    /**
     * Create an instance of {@link ListarUsuarioResponse }
     * 
     */
    public ListarUsuarioResponse createListarUsuarioResponse() {
        return new ListarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerRol }
     * 
     */
    public ObtenerRol createObtenerRol() {
        return new ObtenerRol();
    }

    /**
     * Create an instance of {@link ObtenerRolResponse }
     * 
     */
    public ObtenerRolResponse createObtenerRolResponse() {
        return new ObtenerRolResponse();
    }

    /**
     * Create an instance of {@link ObtenerUsuario }
     * 
     */
    public ObtenerUsuario createObtenerUsuario() {
        return new ObtenerUsuario();
    }

    /**
     * Create an instance of {@link ObtenerUsuarioResponse }
     * 
     */
    public ObtenerUsuarioResponse createObtenerUsuarioResponse() {
        return new ObtenerUsuarioResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Rol }
     * 
     */
    public Rol createRol() {
        return new Rol();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarRol }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarRol }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "eliminarRol")
    public JAXBElement<EliminarRol> createEliminarRol(EliminarRol value) {
        return new JAXBElement<EliminarRol>(_EliminarRol_QNAME, EliminarRol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarRolResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarRolResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "eliminarRolResponse")
    public JAXBElement<EliminarRolResponse> createEliminarRolResponse(EliminarRolResponse value) {
        return new JAXBElement<EliminarRolResponse>(_EliminarRolResponse_QNAME, EliminarRolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "eliminarUsuario")
    public JAXBElement<EliminarUsuario> createEliminarUsuario(EliminarUsuario value) {
        return new JAXBElement<EliminarUsuario>(_EliminarUsuario_QNAME, EliminarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarUsuarioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "eliminarUsuarioResponse")
    public JAXBElement<EliminarUsuarioResponse> createEliminarUsuarioResponse(EliminarUsuarioResponse value) {
        return new JAXBElement<EliminarUsuarioResponse>(_EliminarUsuarioResponse_QNAME, EliminarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarRol }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GuardarRol }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "guardarRol")
    public JAXBElement<GuardarRol> createGuardarRol(GuardarRol value) {
        return new JAXBElement<GuardarRol>(_GuardarRol_QNAME, GuardarRol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarRolResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GuardarRolResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "guardarRolResponse")
    public JAXBElement<GuardarRolResponse> createGuardarRolResponse(GuardarRolResponse value) {
        return new JAXBElement<GuardarRolResponse>(_GuardarRolResponse_QNAME, GuardarRolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GuardarUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "guardarUsuario")
    public JAXBElement<GuardarUsuario> createGuardarUsuario(GuardarUsuario value) {
        return new JAXBElement<GuardarUsuario>(_GuardarUsuario_QNAME, GuardarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarUsuarioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GuardarUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "guardarUsuarioResponse")
    public JAXBElement<GuardarUsuarioResponse> createGuardarUsuarioResponse(GuardarUsuarioResponse value) {
        return new JAXBElement<GuardarUsuarioResponse>(_GuardarUsuarioResponse_QNAME, GuardarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarRol }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarRol }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "listarRol")
    public JAXBElement<ListarRol> createListarRol(ListarRol value) {
        return new JAXBElement<ListarRol>(_ListarRol_QNAME, ListarRol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarRolResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarRolResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "listarRolResponse")
    public JAXBElement<ListarRolResponse> createListarRolResponse(ListarRolResponse value) {
        return new JAXBElement<ListarRolResponse>(_ListarRolResponse_QNAME, ListarRolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "listarUsuario")
    public JAXBElement<ListarUsuario> createListarUsuario(ListarUsuario value) {
        return new JAXBElement<ListarUsuario>(_ListarUsuario_QNAME, ListarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "listarUsuarioResponse")
    public JAXBElement<ListarUsuarioResponse> createListarUsuarioResponse(ListarUsuarioResponse value) {
        return new JAXBElement<ListarUsuarioResponse>(_ListarUsuarioResponse_QNAME, ListarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRol }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerRol }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "obtenerRol")
    public JAXBElement<ObtenerRol> createObtenerRol(ObtenerRol value) {
        return new JAXBElement<ObtenerRol>(_ObtenerRol_QNAME, ObtenerRol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRolResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerRolResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "obtenerRolResponse")
    public JAXBElement<ObtenerRolResponse> createObtenerRolResponse(ObtenerRolResponse value) {
        return new JAXBElement<ObtenerRolResponse>(_ObtenerRolResponse_QNAME, ObtenerRolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "obtenerUsuario")
    public JAXBElement<ObtenerUsuario> createObtenerUsuario(ObtenerUsuario value) {
        return new JAXBElement<ObtenerUsuario>(_ObtenerUsuario_QNAME, ObtenerUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerUsuarioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.administracion.org/", name = "obtenerUsuarioResponse")
    public JAXBElement<ObtenerUsuarioResponse> createObtenerUsuarioResponse(ObtenerUsuarioResponse value) {
        return new JAXBElement<ObtenerUsuarioResponse>(_ObtenerUsuarioResponse_QNAME, ObtenerUsuarioResponse.class, null, value);
    }

}
