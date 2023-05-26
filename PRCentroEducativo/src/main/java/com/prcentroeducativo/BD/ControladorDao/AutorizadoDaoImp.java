/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Alumno;
import com.prcentroeducativo.BD.ControladorDao.Entidades.Autorizado;
import com.prcentroeducativo.BD.ControladorDao.Entidades.Parentesto;
import com.prcentroeducativo.BD.MyDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javip
 */
public class AutorizadoDaoImp implements AutorizadoDao{
    
    @Override
    public int add(Autorizado a) throws SQLException {
         String sql="""
                  insert into autorizado(dni,nombre,apellido1,apellido2,parentesto)
                  values (?,?,?,?,?)
                  """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, String.valueOf(a.getParentesto()));
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Autorizado getById(int id) throws SQLException {
        Autorizado autori=null;
        String sql="select * from autorizado where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                autori=new Autorizado();
                
                autori.setId(rs.getInt("id"));
                autori.setDni(rs.getString("dni"));
                autori.setNombre(rs.getString("nombre"));
                autori.setApellido1(rs.getString("apellido1"));
                autori.setApellido2(rs.getString("apellido2"));
                autori.setParentesto(Parentesto.valueOf(rs.getString("parentesto")));
                
            }
            
        }
        
        return autori;
    }

    @Override
    public List<Autorizado> getAll() throws SQLException {
        Autorizado autori=null;
        String sql="select * from autorizado";
        
        List<Autorizado> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                autori=new Autorizado();
                
                autori.setId(rs.getInt("id"));
                autori.setDni(rs.getString("dni"));
                autori.setNombre(rs.getString("nombre"));
                autori.setApellido1(rs.getString("apellido1"));
                autori.setApellido2(rs.getString("apellido2"));
                autori.setParentesto(Parentesto.valueOf(rs.getString("parentesto")));    
                
                result.add(autori);
            }
            
        }
        
        return result;
    }

    @Override
    public int update(Autorizado a) throws SQLException {
        String sql="""
                  update autorizado
                  set dni=?, nombre=?, apellido1=?, apellido2=?, parentesto=?
                   where id=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, String.valueOf(a.getParentesto()));
            pstm.setInt(6, a.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                  delete from autorizado 
                   where id=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            result=pstm.executeUpdate();
            
        }
    }
}
