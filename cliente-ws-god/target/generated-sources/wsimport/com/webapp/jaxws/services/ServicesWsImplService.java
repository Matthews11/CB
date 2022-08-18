
package com.webapp.jaxws.services;

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
@WebServiceClient(name = "ServicesWsImplService", targetNamespace = "http://services.jaxws.webapp.com/", wsdlLocation = "http://localhost:8080/web-app-jaxws/ServicesWsImpl?wsdl")
public class ServicesWsImplService
    extends Service
{

    private final static URL SERVICESWSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICESWSIMPLSERVICE_EXCEPTION;
    private final static QName SERVICESWSIMPLSERVICE_QNAME = new QName("http://services.jaxws.webapp.com/", "ServicesWsImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/web-app-jaxws/ServicesWsImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICESWSIMPLSERVICE_WSDL_LOCATION = url;
        SERVICESWSIMPLSERVICE_EXCEPTION = e;
    }

    public ServicesWsImplService() {
        super(__getWsdlLocation(), SERVICESWSIMPLSERVICE_QNAME);
    }

    public ServicesWsImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICESWSIMPLSERVICE_QNAME, features);
    }

    public ServicesWsImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICESWSIMPLSERVICE_QNAME);
    }

    public ServicesWsImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICESWSIMPLSERVICE_QNAME, features);
    }

    public ServicesWsImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicesWsImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicesWs
     */
    @WebEndpoint(name = "ServicesWsImplPort")
    public ServicesWs getServicesWsImplPort() {
        return super.getPort(new QName("http://services.jaxws.webapp.com/", "ServicesWsImplPort"), ServicesWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicesWs
     */
    @WebEndpoint(name = "ServicesWsImplPort")
    public ServicesWs getServicesWsImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.jaxws.webapp.com/", "ServicesWsImplPort"), ServicesWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICESWSIMPLSERVICE_EXCEPTION!= null) {
            throw SERVICESWSIMPLSERVICE_EXCEPTION;
        }
        return SERVICESWSIMPLSERVICE_WSDL_LOCATION;
    }

}
