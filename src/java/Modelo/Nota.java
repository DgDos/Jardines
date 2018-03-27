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
public class Nota {
    private float nota;
    private int idEstudianteCurso;
    private int idActividad;
    private String detallesExtra;

    public Nota() {
    }

    public Nota(float nota, int idEstudianteCurso, int idActividad, String detallesExtra) {
        this.nota = nota;
        this.idEstudianteCurso = idEstudianteCurso;
        this.idActividad = idActividad;
        this.detallesExtra = detallesExtra;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(int idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDetallesExtra() {
        return detallesExtra;
    }

    public void setDetallesExtra(String detallesExtra) {
        this.detallesExtra = detallesExtra;
    }
    
    
}
