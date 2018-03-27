/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Nota;
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
 * @author JulDa
 */
public class NotaDAO {

    private Connection connection;

    public NotaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Nota> getNotaByIdEstudiante(int id_estudiante) throws SQLException, URISyntaxException {
        ArrayList<Nota> notas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from nota where idestudiante=" + id_estudiante);
        while (rs.next()) {
            Nota n = new Nota();
            n.setIdEstudianteCurso(rs.getInt("id_Est"));
            n.setNota(rs.getFloat("nota"));
            notas.add(n);
        }
        return notas;
    }
    
    public Nota getNotaByIdActividad(int idActividad) throws SQLException, URISyntaxException {
        Nota nota= new Nota();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from nota where idActividad=" + idActividad);
        while (rs.next()) {
            nota.setNota(rs.getFloat("nota"));
            nota.setIdEstudianteCurso(rs.getInt("id_Est"));
            nota.setIdActividad(rs.getInt("idactividad"));
            nota.setDetallesExtra(rs.getString("detalles"));
            
        }
        return nota;
    }

    public void addNota(float nota, int IdEstudianteCurso, int IdActividad, String DetallesExtra) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into nota values (?,?,?,?,1)");
        preparedStatement.setFloat(1, nota);
        preparedStatement.setInt(2, IdEstudianteCurso);
        preparedStatement.setInt(3, IdActividad);
        preparedStatement.setString(4, DetallesExtra);
        preparedStatement.executeUpdate();
    }
    
    public void eliminarNota(int idA) throws SQLException{
         PreparedStatement preparedStatement = connection.prepareStatement("update nota set delete=0 where idActividad="+idA);
        
        preparedStatement.executeUpdate();
    }
    
    public void updateNota(Nota e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update nota set nota=?,idestudiantecurso=?, idactividad=?,detallesextra=?" + " where id=?");
        preparedStatement.setFloat(1, e.getNota());
        preparedStatement.setInt(2, e.getIdEstudianteCurso());
        preparedStatement.setInt(3, e.getIdActividad());
        preparedStatement.setString(4, e.getDetallesExtra());
        preparedStatement.executeUpdate();
    }
}
