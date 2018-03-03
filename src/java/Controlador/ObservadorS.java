/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.ObservadorDAO;
import Dao.ProfesorCursoDAO;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Observador;
import Modelo.ProfesorCurso;
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
 * @author FiJus
 */
public class ObservadorS extends HttpServlet {

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
                int pi;
                pi=544856;
                ProfesorCursoDAO pc = new ProfesorCursoDAO();
                ArrayList<ProfesorCurso> pcm = pc.getAllProCur(pi);
                ArrayList<Curso> cursos=new ArrayList<>();
                CursoDAO c=new CursoDAO();
                for (ProfesorCurso profesorcurso : pcm) {                  
                    cursos.add(c.getCursoById(profesorcurso.getIdCurso()));
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }
            if (opc == 1) {
                int a = Integer.parseInt(request.getParameter("curso"));
                ObservadorDAO obs = new ObservadorDAO();
                ArrayList<Estudiante> estudiantes = obs.getEstudiantesByIDCurso(a);
                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
            if (opc == 2) {
                int estId = Integer.parseInt(request.getParameter("estudiante"));
                ObservadorDAO obs = new ObservadorDAO();
                ArrayList<Observador> observaciones = obs.getObservadorByID(estId);
                Gson g = new Gson();
                String pasareEsto = g.toJson(observaciones);
                out.print(pasareEsto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObservadorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ObservadorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObservadorS.class.getName()).log(Level.SEVERE, null, ex);
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
