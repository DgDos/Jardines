/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Observador;
import Util.DbUtil;
import Util.consultaCM;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LabingXEON
 */
public class ObservadorDAO {

    private Connection connection;

    public ObservadorDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void addObservador(String detalles, int calificacion, int idEst, String idProfesor,String fecha) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into observador(idprofesor,detalles,calificacion,idestudiantecurso,fecha,delete) values (?,?,?,?,?,?)");
        preparedStatement.setString(1, idProfesor);
        preparedStatement.setString(2, detalles);
        preparedStatement.setInt(3, calificacion);
        preparedStatement.setInt(4, idEst);
        preparedStatement.setString(5, fecha);
        preparedStatement.setInt(6, 1);
        preparedStatement.executeUpdate();
    }

    public void updateObservador(Observador obs) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update observador set idprofesor=?,detalles=?,calificacion=?,idestudiantecurso=?" + " where id=?");
        preparedStatement.setString(1, obs.getIdProfesor());
        preparedStatement.setString(2, obs.getDetalles());
        preparedStatement.setInt(3, obs.getCalificacion());
        preparedStatement.setInt(4, obs.getIdEstudianteCurso());
        preparedStatement.setInt(5, obs.getIdObs());
        preparedStatement.executeUpdate();
    }
    
    public void deleteObservador(int idObs) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update observador set delete=0 where id=?");
        preparedStatement.setInt(1, idObs);
        preparedStatement.executeUpdate();
    }
    


    public ArrayList<Observador> getObservadorByID(int id_estudiante) throws SQLException, URISyntaxException {
        ArrayList<Observador> notasObs = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from observador where idestudiantecurso=" + id_estudiante+" and delete=1");
        while (rs.next()) {
            Observador c = new Observador();
            c.setIdObs(rs.getInt("id"));
            c.setIdEstudianteCurso(rs.getInt("idestudiantecurso"));
            c.setCalificacion(rs.getInt("calificacion"));
            c.setDetalles(rs.getString("detalles"));
            c.setIdProfesor(rs.getString("idprofesor"));
            c.setFecha(rs.getString("fecha"));
            notasObs.add(c);
        }
        return notasObs;
    }

    public ArrayList<Observador> getAllObservadores() throws SQLException, URISyntaxException {
        ArrayList<Observador> observadores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from observador");
        while (rs.next()) {
            Observador c = new Observador();
            c.setIdObs(rs.getInt("id"));
            c.setIdProfesor(rs.getString("idprofesor"));
            c.setDetalles(rs.getString("detalles"));
            c.setCalificacion(rs.getInt("calificacion"));
            c.setIdEstudianteCurso(rs.getInt("idestudiantecurso"));
            c.setFecha(rs.getString("fecha"));
            observadores.add(c);
        }
        return observadores;
    }

    public ArrayList<consultaCM> getNotasById(int estCur) throws SQLException {
       ArrayList<consultaCM> notas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select nota.nota,nota.detallesextra,actividad.nombre from actividad,nota where actividad.id=nota.idactividad and idestudiantecurso="+estCur); 
        while(rs.next()){
            consultaCM n=new consultaCM();
            n.setCurso(rs.getString("nombre"));
            n.setMateria(rs.getString("detallesextra"));
            n.setProfesor(rs.getString("nota"));
            notas.add(n);
        }
        return notas;
    }

}
