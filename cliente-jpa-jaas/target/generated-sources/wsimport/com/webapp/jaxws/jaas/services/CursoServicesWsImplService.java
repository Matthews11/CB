
package com.webapp.jaxws.jaas.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "CursoServicesWsImplService", targetNamespace = "http://services.jaas.jaxws.webapp.com/", wsdlLocation = "http://localhost:8081/web-app-jaxws-jpa-jaas/CursoServicesWsImpl?wsdl")
public class CursoServicesWsImplService
    extends Service
{

    private final static URL CURSOSERVICESWSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CURSOSERVICESWSIMPLSERVICE_EXCEPTION;
    private final static QName CURSOSERVICESWSIMPLSERVICE_QNAME = new QName("http://services.jaas.jaxws.webapp.com/", "CursoServicesWsImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/web-app-jaxws-jpa-jaas/CursoServicesWsImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CURSOSERVICESWSIMPLSERVICE_WSDL_LOCATION = url;
        CURSOSERVICESWSIMPLSERVICE_EXCEPTION = e;
    }

    public CursoServicesWsImplService() {
        super(__getWsdlLocation(), CURSOSERVICESWSIMPLSERVICE_QNAME);
    }

    public CursoServicesWsImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CURSOSERVICESWSIMPLSERVICE_QNAME, features);
    }

    public CursoServicesWsImplService(URL wsdlLocation) {
        super(wsdlLocation, CURSOSERVICESWSIMPLSERVICE_QNAME);
    }

    public CursoServicesWsImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CURSOSERVICESWSIMPLSERVICE_QNAME, features);
    }

    public CursoServicesWsImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CursoServicesWsImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CursoServicesWs
     */
    @WebEndpoint(name = "CursoServicesWsImplPort")
    public CursoServicesWs getCursoServicesWsImplPort() {
        return super.getPort(new QName("http://services.jaas.jaxws.webapp.com/", "CursoServicesWsImplPort"), CursoServicesWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CursoServicesWs
     */
    @WebEndpoint(name = "CursoServicesWsImplPort")
    public CursoServicesWs getCursoServicesWsImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.jaas.jaxws.webapp.com/", "CursoServicesWsImplPort"), CursoServicesWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CURSOSERVICESWSIMPLSERVICE_EXCEPTION!= null) {
            throw CURSOSERVICESWSIMPLSERVICE_EXCEPTION;
        }
        return CURSOSERVICESWSIMPLSERVICE_WSDL_LOCATION;
    }

}
