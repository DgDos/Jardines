/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Estudiante;
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
public class EstudianteDAO {

    private Connection connection;

    public EstudianteDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Estudiante> getEstudiantesByIDCurso(int id_curso) throws SQLException, URISyntaxException {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from estudiante where idcurso=" + id_curso);
        while (rs.next()) {
            Estudiante c = new Estudiante();
            c.setIdEstudiante(rs.getInt("documento"));
            c.setNombre(rs.getString("nombre"));
            estudiantes.add(c);
        }
        return estudiantes;
    }
    
    public Estudiante getEstudianteByID(int idEst) throws SQLException, URISyntaxException {
        Estudiante estudiante= new Estudiante();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from estudiante where documento=" + idEst);
        while (rs.next()) {
            estudiante.setIdEstudiante(rs.getInt("documento"));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setCelularContacto(rs.getString("celularcontacto"));
            estudiante.setDireccion(rs.getString("direccion"));
            estudiante.setFechaNacimiento(rs.getString("fechanacimiento"));
            estudiante.setTipoSangre(rs.getString("tiposangre"));
            estudiante.setIdCurso(rs.getInt("idcurso"));
        }
        return estudiante;
    }

    public void addEstudiante(Estudiante est) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into estudiante values (?,?,?,?,?,?,3,1)");
        preparedStatement.setInt(1, est.getIdEstudiante());
        preparedStatement.setString(2, est.getNombre());
        preparedStatement.setString(3, est.getCelularContacto());
        preparedStatement.setString(4, est.getDireccion());
        preparedStatement.setString(5, est.getFechaNacimiento());
        preparedStatement.setString(6, est.getTipoSangre());
        preparedStatement.executeUpdate();
    }
    public void eliminarEstudiante(int idE) throws SQLException{
         PreparedStatement preparedStatement = connection.prepareStatement("update estudiante set delete=0 where documento="+idE);
        preparedStatement.executeUpdate();
    }

    public void updateEstudiante(Estudiante e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update estudiante set nombre=?,celularcontacto=?,direccion=?,fechanacimiento=?,tiposangre=?" + " where documento=?");
        preparedStatement.setString(1, e.getNombre());
        preparedStatement.setString(2, e.getCelularContacto());
        preparedStatement.setString(3, e.getDireccion());
        preparedStatement.setString(4, e.getFechaNacimiento());
        preparedStatement.setString(5, e.getTipoSangre());
        preparedStatement.setInt(6, e.getIdEstudiante());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Estudiante> getAllEstudiantes() throws SQLException {
        
        ArrayList<Estudiante> estudiantes= new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from estudiante where delete=1");
        while (rs.next()) {
            Estudiante estudiante=new Estudiante();
            estudiante.setIdEstudiante(rs.getInt("documento"));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setCelularContacto(rs.getString("celularcontacto"));
            estudiante.setDireccion(rs.getString("direccion"));
            estudiante.setFechaNacimiento(rs.getString("fechanacimiento"));
            estudiante.setTipoSangre(rs.getString("tiposangre"));
            estudiante.setIdCurso(rs.getInt("idcurso"));
            estudiantes.add(estudiante);
        }
        return estudiantes;
    }
    
    
}
