/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.CursoMateria;
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
public class CursoMateriaDAO {
    private Connection connection;

    public CursoMateriaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }
    
    public void addCM(int idC,int idM,String idP,String fechaInicial, String fechaFinal) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("insert into cursomateria(idcurso,idmateria,idprofesor,fechainicio,fechafinal,delete) values (?,?,?,?,?,1)");
        preparedStatement.setInt(1, idC);
        preparedStatement.setInt(2, idM);
        preparedStatement.setString(3, idP);
        preparedStatement.setString(4, fechaInicial);
        preparedStatement.setString(5, fechaFinal);
        preparedStatement.executeUpdate();
    }

    public ArrayList<CursoMateria> getAllCM() throws SQLException {
       ArrayList<CursoMateria> cursos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from cursomateria where delete=1");
        while (rs.next()) {
            CursoMateria c = new CursoMateria();
            c.setIdCM(rs.getInt("id"));
            c.setIdCurso(rs.getInt("idcurso"));
            c.setIdMateria(rs.getInt("idmateria"));
            c.setIdProfesor(rs.getString("idprofesor"));
            c.setFechaInicial(rs.getString("fechainicio"));
            c.setFechaFinal(rs.getString("fechafinal"));
            cursos.add(c);
        }
        return cursos; 
    }
    
    public ArrayList<CursoMateria> getAllCMProfesor(String idP) throws SQLException {
       ArrayList<CursoMateria> cursos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from cursomateria where delete=1 and idprofesor='"+idP+"'");
        while (rs.next()) {
            CursoMateria c = new CursoMateria();
            c.setIdCM(rs.getInt("id"));
            c.setIdCurso(rs.getInt("idcurso"));
            c.setIdMateria(rs.getInt("idmateria"));
            c.setIdProfesor(rs.getString("idprofesor"));
            c.setFechaInicial(rs.getString("fechainicio"));
            c.setFechaFinal(rs.getString("fechafinal"));
            cursos.add(c);
        }
        return cursos; 
    }
    
    public void eliminarCursoMateria(int idCM) throws SQLException{
         PreparedStatement preparedStatement = connection.prepareStatement("update cursomateria set delete=0 where id="+idCM);
        
        preparedStatement.executeUpdate();
    }
    
     public void updateCursoMateria(String idProfesor,int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update cursomateria set idprofesor=?" + " where id=?");
        preparedStatement.setString(1, idProfesor);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    public String getProfesorById(int idP) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select profesor.nombre as nombre from cursomateria,profesor where cursomateria.delete=1 and cursomateria.idprofesor=profesor.cedula and cursomateria.id="+idP);
        rs.next();
        return rs.getString("nombre");
    }


}
