/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author FiJus
 */
public class DirectorCurso {
    private int idDirector;
    private int idCurso;
    private int cedula;
    private String fechainicio;
    private String fechafinal;
    

    public DirectorCurso() {
    }

    public DirectorCurso(int idProfesor, int idCurso, int cedula, String fechainicio, String fechafinal) {
        this.idDirector = idProfesor;
        this.idCurso = idCurso;
        this.cedula = cedula;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

   

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
