/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Asistencia;
import Util.ConsultaAsistencia;
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
public class AsistenciaDAO {
    
    private Connection connection;

    public AsistenciaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }
    
    public ArrayList<ConsultaAsistencia> getAsistenciaFecha(int idCurso,String fecha) throws SQLException{
        ArrayList<ConsultaAsistencia> asis=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select estudiante.nombre,asistencia.vino from estudiante,estudiantecurso,asistencia where estudiante.documento = estudiantecurso.idestudiante and asistencia.idestudiantecurso = estudiantecurso.id and estudiantecurso.idcurso ="+idCurso+" and  asistencia.fecha ='" + fecha+"'");
        while (rs.next()) {
            ConsultaAsistencia ca= new ConsultaAsistencia();
            ca.setNombre(rs.getString("nombre"));
            ca.setVino(rs.getString("vino"));
            asis.add(ca);
        }
        return asis;
    }
    
    public void addAsistencia(Asistencia asistencia) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into asistencia values (?,?,?,1)");
        preparedStatement.setInt(1, asistencia.getIdEstudianteCurso());
        preparedStatement.setString(2, asistencia.getFecha());
        preparedStatement.setString(3, asistencia.getVino());
       
       
        preparedStatement.executeUpdate();
    }
    
}
