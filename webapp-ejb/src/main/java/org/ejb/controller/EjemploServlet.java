package org.ejb.controller;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ejb.models.Producto;
import org.ejb.service.ServiceEjb;
import org.ejb.service.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

  //  @Inject
  //  private ServiceEjb se;
 //   @Inject
 //   private ServiceEjb se2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceEjbLocal se = null;
        ServiceEjbLocal se2 = null;

        try {
            InitialContext ctx = new InitialContext();
            se = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.ejb.service.ServiceEjbLocal");
            se2 = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.ejb.service.ServiceEjbLocal");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        System.out.println("se si es igual al se2 ="+se.equals(se2));
        Producto p = se.crear(new Producto("uvas"));
        System.out.println("nuevo producto" +p);

        req.setAttribute("saludo",se.saludar("JARED")) ;
        req.setAttribute("saludo2",se2.saludar("MATHEW")) ;
        req.setAttribute("list",se.listar());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
