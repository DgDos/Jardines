/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LabingXEON
 */
public class Observador {
    private int idObs;
    private int calificacion;
    private String detalles;
    private int idEstudianteCurso;
    private String idProfesor;
    private String fecha;

    public Observador() {
    }

    public Observador(int idObs, int calificacion, String detalles, int idEstudianteCurso, String idProfesor, String fecha) {
        this.idObs = idObs;
        this.calificacion = calificacion;
        this.detalles = detalles;
        this.idEstudianteCurso = idEstudianteCurso;
        this.idProfesor = idProfesor;
        this.fecha = fecha;
    }

    public Observador(int idObs, int calificacion, String detalles, int idEstudianteCurso, String idProfesor) {
        this.idObs = idObs;
        this.calificacion = calificacion;
        this.detalles = detalles;
        this.idEstudianteCurso = idEstudianteCurso;
        this.idProfesor = idProfesor;
    }

    public int getIdObs() {
        return idObs;
    }

    public void setIdObs(int idObs) {
        this.idObs = idObs;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(int idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}