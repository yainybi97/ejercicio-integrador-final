package controller;

import dtos.AutoDTO;
import exception.DAOException;
import services.IAutoService;
import services.impl.AutoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 2/11/20
 **/
public class AutosController extends HttpServlet {

    IAutoService autoService;

    public AutosController() {

        this.autoService = new AutoServiceImpl();
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<AutoDTO> autos = null;
        try {
            autos = this.autoService.ConsultarAutos();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        res.setContentType("text/html");
        // Obtenemos un objeto Print Writer para enviar respuesta
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<h1>LISTADO AUTOS</h1>");

        pw.println("<table border=\"1\"> <tr> <th>ID</th> <th>Precio Final</th> </tr>");
        for (AutoDTO auto : autos) {
            pw.println(("<tr> <td>" +  auto.getId() + "</td>"));
            pw.println(("<td>" + auto.getPrecioFinal() + "</td> </tr>"));
        }
        pw.println("</table>");
        pw.println("</body></html>");
        pw.close();
    }

}
