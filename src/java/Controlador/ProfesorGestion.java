/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.EstudianteDAO;
import Dao.DirectorCursoDAO;
import Dao.ProfesorDAO;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Profesor;
import Modelo.DirectorCurso;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anfeg
 */
public class ProfesorGestion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfesorGestion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfesorGestion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int opc = Integer.parseInt(request.getParameter("opcion"));
           
            if (opc == 0) {
                String cedula = request.getParameter("cedula");
                System.out.println(cedula + "cedula");
                ProfesorDAO o = new ProfesorDAO();
                o.eliminarProfesor(cedula);
            }
            if (opc == 1) {
                String estId = request.getParameter("cedula");
                ProfesorDAO obs = new ProfesorDAO();
                Profesor e = obs.getProfesorById(estId);
                Gson g = new Gson();
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            if (opc == 2) {
                String cedula = request.getParameter("cedula");
                String nombre = request.getParameter("nombre");
                String correo = request.getParameter("correo");
                String celular = request.getParameter("celular");
                String direccion = request.getParameter("direccion");
                String experiencia = request.getParameter("experiencia");
                String fechaNacimiento = request.getParameter("fechanacimiento");
                String tipoSangre = request.getParameter("tiposangre");
                String usuario = request.getParameter("usuario");
                ProfesorDAO p = new ProfesorDAO();
                Profesor profe = new Profesor(cedula, nombre,correo, celular, direccion, experiencia, fechaNacimiento, tipoSangre, usuario);
                System.out.println(profe);
                p.updateProfesor(profe);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
