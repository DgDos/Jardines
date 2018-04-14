/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.DirectorCurso;
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
public class DirectorCursoDAO {

    private Connection connection;

    public DirectorCursoDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    /**
     * @param idPro= documento profesor
     * @return retorna la lista de cursos a los que pertenece un profesor
     * @throws SQLException
     * @throws URISyntaxException
     */
    public ArrayList<DirectorCurso> getAllProCur(String idPro) throws SQLException, URISyntaxException {
        ArrayList<DirectorCurso> procur = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from directorcurso where delete=1 and cedula=" + idPro);
        while (rs.next()) {
            DirectorCurso c = new DirectorCurso();
            c.setIdCurso(rs.getInt("idcurso"));
            c.setIdDirector(idPro);
            procur.add(c);
        }
        return procur;
    }

    public void addDirectorCurso(String cedula, int idcurso, String fechainicio, String fechafinal) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into directorcurso(cedula,idcurso,fechainicio,fechafinal,delete) values (?,?,?,?,1)");
        preparedStatement.setString(1, cedula);
        preparedStatement.setInt(2, idcurso);
        preparedStatement.setString(3, fechainicio);
        preparedStatement.setString(4, fechafinal);
        preparedStatement.executeUpdate();

    }

    public void deleteDirectorCurso(int idD) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update directorcurso set delete=0 where id=" + idD);
        preparedStatement.executeUpdate();
    }

    public void updateDirectorCurso(DirectorCurso e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update directorcurso set cedula=?,idcurso=?,fechainicio=?,fechafinal=?" + " where id=?");
        preparedStatement.setInt(1, e.getCedula());
        preparedStatement.setInt(2, e.getIdCurso());
        preparedStatement.setString(3, e.getFechainicio());
        preparedStatement.setString(4, e.getFechafinal());
        preparedStatement.setString(5, e.getIdDirector());

        preparedStatement.executeUpdate();
    }

    public boolean knowCedula(String cedula) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from directorcurso where delete=1 and cedula='" + cedula+"'");
        while(rs.next()){
            return false;
        }      
        return true;
    }

    public boolean knowCurso(int idCurso) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from directorcurso where delete=1 and idcurso=" + idCurso);
        while(rs.next()){
            return false;
        }      
        return true;
    }
    
}
