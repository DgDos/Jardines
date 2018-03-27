/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.NotaDAO;
import Dao.DirectorCursoDAO;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Nota;
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
 * @author JulDa
 */
public class NotaS extends HttpServlet {

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
            out.println("<title>Servlet NotaS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotaS at " + request.getContextPath() + "</h1>");
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
                Profesor p=(Profesor)request.getSession().getAttribute("profesor");
                DirectorCursoDAO pc = new DirectorCursoDAO();
                ArrayList<DirectorCurso> pcm = pc.getAllProCur(p.getIdProfesor());
                ArrayList<Curso> cursos=new ArrayList<>();
                CursoDAO c=new CursoDAO();
                for (DirectorCurso profesorcurso : pcm) {                  
                    cursos.add(c.getCursoById(profesorcurso.getIdCurso()));
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }
            if (opc == 1) {
                int a = Integer.parseInt(request.getParameter("curso"));
                NotaDAO notica = new NotaDAO();
                ArrayList<Nota> notas = notica.getNotaByIdEstudiante(a);
                Gson g = new Gson();
                String pasareEsto = g.toJson(notas);
                out.print(pasareEsto);
            }
            if (opc == 2) {
                int estId = Integer.parseInt(request.getParameter("estudiante"));
                NotaDAO notica = new NotaDAO();
                ArrayList<Nota> notas = notica.getNotaByIdEstudiante(estId);
                Gson g = new Gson();
                String pasareEsto = g.toJson(notas);
                out.print(pasareEsto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            float nota=Float.parseFloat(request.getParameter("nota"));
            int IdEstudiante=Integer.parseInt(request.getParameter("idEstudiante"));
            int IdTema=Integer.parseInt(request.getParameter("idTema"));
            String DetallesExtra=request.getParameter("DetallesExtra");
            NotaDAO n=new NotaDAO();
            n.addNota( nota,IdEstudiante,IdTema, DetallesExtra);
            
        } catch (SQLException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
