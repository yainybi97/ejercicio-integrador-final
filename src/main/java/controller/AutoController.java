package controller;

import dtos.*;
import exception.DAOException;
import exception.ServiceException;

import services.impl.AutoServiceImpl;
import services.impl.OpcionServiceImpl;
import services.impl.VarianteServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public class AutoController extends HttpServlet {

    private AutoServiceImpl autoService;
    private VarianteServiceImpl varianteService;
    private OpcionServiceImpl opcionService;

    public AutoController() {

        this.autoService = new AutoServiceImpl();
        this.varianteService = new VarianteServiceImpl();
        this.opcionService = new OpcionServiceImpl();

    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            this.autoService.eliminar(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer precio = null;
        try {
            precio = this.autoService.consultaPrecioPorAuto(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<h1>Precio de auto</h1>");
        pw.println("<h2>Para el auto con Id " + id + " tiene un precio de " + precio + "</h2>");
        pw.println("</body></html>");
        pw.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        AutoDTO autoDTO = new AutoDTO();
        this.autoService.setAuto(autoDTO);

        ArrayList<OpcionDTO> opcionales = new ArrayList<>();

        //asignamos variante
        try {
            autoDTO.setVariante(this.varianteService.consultarVariante(Integer.parseInt(req.getParameter("variante"))));
        } catch (DAOException e) {
            e.printStackTrace();
        }

        //creamos opcionales porque Auto recibe es una lista de opcionales
        OpcionDTO opcionDTO = null;
        try {
            opcionDTO = this.opcionService.consultarOpcion(Integer.parseInt(req.getParameter("opcional")));
        } catch (DAOException e) {
            e.printStackTrace();
        }

        opcionales.add(opcionDTO);

        //asignamos opcionales
        try {
            autoService.agregarOpcionales(opcionales);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        try {
            autoDTO.setPrecioFinal(autoService.calcularPrecioFinal());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        try {
            autoService.agregar(autoDTO);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }





    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //solo le voy actualizar la variante
        AutoDTO autoDTOact = new AutoDTO();

        this.autoService.setAuto(autoDTOact);

        autoDTOact.setId(Integer.parseInt(req.getParameter("id")));
        try {
            autoDTOact.setVariante(this.varianteService.consultarVariante(Integer.parseInt(req.getParameter("variante"))));
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            autoDTOact.setPrecioFinal(autoService.calcularPrecioFinal());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        try {
            this.autoService.modificar(autoDTOact);
        } catch (DAOException e) {
            e.printStackTrace();
        }


    }


    public VarianteServiceImpl getVarianteService() {
        return varianteService;
    }

    public void setVarianteService(VarianteServiceImpl varianteService) {
        this.varianteService = varianteService;
    }

    public OpcionServiceImpl getOpcionService() {
        return opcionService;
    }

    public void setOpcionService(OpcionServiceImpl opcionService) {
        this.opcionService = opcionService;
    }

    public AutoServiceImpl getAutoService() {
        return autoService;
    }

    public void setAutoService(AutoServiceImpl autoService) {
        this.autoService = autoService;
    }


}
