/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.AsistenciaDAO;
import Dao.CursoDAO;
import Dao.EstudianteDAO;
import Dao.FechaDAO;
import Dao.DirectorCursoDAO;
import Dao.EstudianteCursoDAO;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Fecha;
import Modelo.Profesor;
import Modelo.Asistencia;
import Modelo.DirectorCurso;
import Modelo.EstudianteCurso;
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
 * @author Gibran
 */
public class AsistenciaS extends HttpServlet {

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

         Profesor p = (Profesor) request.getSession().getAttribute("profesor");
      
                int op = Integer.parseInt(request.getParameter("op"));
                if (op == 0) {
                    String pi = p.getIdProfesor();
                   
                    DirectorCursoDAO pc = new DirectorCursoDAO();
                    ArrayList<DirectorCurso> pcm = pc.getAllProCur(pi);
                    ArrayList<Curso> cursos = new ArrayList<>();
                    CursoDAO c = new CursoDAO();
                    for (DirectorCurso profesorcurso : pcm) {
                        cursos.add(c.getCursoById(profesorcurso.getIdCurso()));
                    }
                    Gson g = new Gson();
                    String pasareEsto = g.toJson(cursos);
                    out.print(pasareEsto);
                }
                if (op == 1) {
                    FechaDAO dao = new FechaDAO();
                    ArrayList<Fecha> fechas = dao.allFechas();
                    Gson g = new Gson();
                    String pasareEsto = g.toJson(fechas);
                    out.print(pasareEsto);
                }

                if (op == 2) {
                    int idCurso = Integer.parseInt(request.getParameter("curso"));
                    EstudianteDAO dao = new EstudianteDAO();
                    ArrayList<Estudiante> estudiantes = dao.getEstudiantesByIDCurso(idCurso);

                    Gson g = new Gson();
                    String pasareEsto = g.toJson(estudiantes);
                    out.print(pasareEsto);
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
         try { 
         String[] idEstudiante =  request.getParameterValues("idEstudiante[]");
         String fecha = request.getParameter("fecha");
         String[] vino = request.getParameterValues("vino[]");
         
         ArrayList<Integer> idEstudianteCurso = new ArrayList<>();
         
         for(int i=0; i < idEstudiante.length;i++){
             EstudianteCursoDAO dao = new EstudianteCursoDAO();
             int idEC = dao.getEstCur(idEstudiante[i]);
             idEstudianteCurso.add(idEC);
         }
             
         String[] fechaAux = fecha.split(" ");
         System.out.println(fecha);
         for(int i=0; i<idEstudiante.length; i++){
             
             Asistencia asistencia = new Asistencia(idEstudianteCurso.get(i), fechaAux[0],vino[i]);
            
             AsistenciaDAO dao = new AsistenciaDAO();
             dao.addAsistencia(asistencia);
             
         }
         
           } catch (SQLException ex) {
                Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
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
