/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Observador;
import Util.DbUtil;
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

    public void addObservador(String detalles, int calificacion, int idEst, int idProfesor) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into observador(idprofesor,detalles,calificacion,idestudiantecurso,delete) values (?,?,?,?,?)");
        preparedStatement.setInt(1, idProfesor);
        preparedStatement.setString(2, detalles);
        preparedStatement.setInt(3, calificacion);
        preparedStatement.setInt(4, idEst);
        preparedStatement.setInt(5, 1);
        preparedStatement.executeUpdate();
    }

    public void updateObservador(Observador obs) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update observador set idprofesor=?,detalles=?,calificacion=?,idestudiantecurso=?" + " where id=?");
        preparedStatement.setInt(1, obs.getIdProfesor());
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
            c.setIdProfesor(rs.getInt("idprofesor"));
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
            c.setIdProfesor(rs.getInt("idprofesor"));
            c.setDetalles(rs.getString("detalles"));
            c.setCalificacion(rs.getInt("calificacion"));
            c.setIdEstudianteCurso(rs.getInt("idestudiantecurso"));
            observadores.add(c);
        }
        return observadores;
    }

}
