/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.EstudianteCurso;
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
 * @author FiJus
 */
public class EstudianteCursoDAO {

    private Connection connection;

    public EstudianteCursoDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void addEstCur(EstudianteCurso e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into estudiantecurso(idestudiante,idcurso,fechainicio,fechafinal,delete) values (?,?,?,?,?)");
        preparedStatement.setString(1, e.getIdEstudiante());
        preparedStatement.setInt(2, e.getIdCurso());
        preparedStatement.setString(3, e.getFechaInicio());
        preparedStatement.setString(4, e.getFechaFinal());
        preparedStatement.setInt(5, 1);
        preparedStatement.executeUpdate();
    }

    public void updateEstCur(EstudianteCurso e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update estudiantecurso set idestudiante=?,idcurso=?,fechainicio=?,fechafinal=?" + " where id=?");
        preparedStatement.setString(1, e.getIdEstudiante());
        preparedStatement.setInt(2, e.getIdCurso());
        preparedStatement.setString(3, e.getFechaInicio());
        preparedStatement.setString(4, e.getFechaFinal());
        preparedStatement.setInt(5, e.getIdEstCur());
        preparedStatement.executeUpdate();
    }

    public void deleteEstCur(int idEstCur) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update estudiantecurso set delete=0 where id=?");
        preparedStatement.setInt(1, idEstCur);
        preparedStatement.executeUpdate();
    }

    public ArrayList<EstudianteCurso> getEstCurById(int idEstCur) throws SQLException, URISyntaxException {
        ArrayList<EstudianteCurso> estudiantesCurso = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from estudiantecurso where id=" + idEstCur + " and delete=1");
        while (rs.next()) {
            EstudianteCurso c = new EstudianteCurso();
            c.setIdEstCur(idEstCur);
            c.setIdEstudiante(rs.getString("idestudiante"));
            c.setIdCurso(rs.getInt("idcurso"));
            c.setFechaInicio(rs.getString("fechainicio"));
            c.setFechaFinal(rs.getString("fechafinal"));
            estudiantesCurso.add(c);
        }
        return estudiantesCurso;
    }

    public int getEstCur(int idEst) throws SQLException, URISyntaxException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from estudiantecurso where delete=1 and idestudiante="+idEst);
        while(rs.next()){
        return rs.getInt("id");
        }
        return 0;
    }
    
    
}
