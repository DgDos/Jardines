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
    
    public void addCM(int idC,int idM,int idP,String fechaInicial, String fechaFinal) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("insert into cursomateria(idcurso,idmateria,idprofesor,fechainicio,fechafinal,delete) values (?,?,?,?,?,1)");
        System.out.println(idC+"----"+idM+"----"+idP);
        preparedStatement.setInt(1, idC);
        preparedStatement.setInt(2, idM);
        preparedStatement.setInt(3, idP);
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
            c.setIdProfesor(rs.getInt("idprofesor"));
            c.setFechaInicial(rs.getString("fechainicial"));
            c.setFechaFinal(rs.getString("fechafinal"));
            cursos.add(c);
        }
        return cursos; 
    }
    
    public ArrayList<CursoMateria> getAllCMProfesor(int idP) throws SQLException {
       ArrayList<CursoMateria> cursos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from cursomateria where delete=1 and idprofesor="+idP);
        while (rs.next()) {
            CursoMateria c = new CursoMateria();
            c.setIdCM(rs.getInt("id"));
            c.setIdCurso(rs.getInt("idcurso"));
            c.setIdMateria(rs.getInt("idmateria"));
            c.setIdProfesor(rs.getInt("idprofesor"));
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
    
     public void updateCursoMateria(CursoMateria e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update cursomateria set idcurso=?,idmateria=?,idprofesor=?,fechainicio=?,fechafinal=?" + " where id=?");
        preparedStatement.setInt(1, e.getIdCurso());
        preparedStatement.setInt(2, e.getIdMateria());
        preparedStatement.setInt(3, e.getIdProfesor());
        preparedStatement.setString(4, e.getFechaInicio());
        preparedStatement.setString(5, e.getFechaFinal());
        preparedStatement.setInt(6, e.getIdCM());
        preparedStatement.executeUpdate();
    }
    
    
}
