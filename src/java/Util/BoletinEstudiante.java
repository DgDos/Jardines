/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author FiJus
 */
public class BoletinEstudiante {
    private String actividad;
    private int idcm;
    private String tema;
    private float nota;

    public BoletinEstudiante(String actividad, int idcm, String tema, float nota) {
        this.actividad = actividad;
        this.idcm = idcm;
        this.tema = tema;
        this.nota = nota;
    }

    public BoletinEstudiante() {
    }

      public int getIdcm() {
        return idcm;
    }

    public void setIdcm(int idcm) {
        this.idcm = idcm;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    
    
    
}