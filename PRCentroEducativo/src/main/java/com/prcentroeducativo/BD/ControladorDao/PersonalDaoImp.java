/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Personal;
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
public class PersonalDaoImp implements PersonalDao {
    private static PersonalDaoImp instance;
    
    static{
        instance=new PersonalDaoImp();
    }
    
    private PersonalDaoImp(){ }
    
    public static PersonalDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(Personal p) throws SQLException {
        String sql="""
                  insert into personal(dni,nombre,apellido1,apellido2,direccion,cp,poblacion,provincia,telefono,email,tipo)
                  values (?,?,?,?,?,?,?,?,?,?,?)
                  """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, p.getDni());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido1());
            pstm.setString(4, p.getApellido2());
            pstm.setString(5, p.getDireccion());
            pstm.setInt(6, p.getCp());
            pstm.setString(7, p.getPoblacion());
            pstm.setString(8, p.getProvincia());
            pstm.setInt(9, p.getTelefono());
            pstm.setString(10, p.getEmail());
            pstm.setInt(11, p.getTipo());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Personal getById(int id) throws SQLException {
        Personal personal=null;
        String sql="select * from personal where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                personal=new Personal();

                personal.setId(rs.getInt("id"));
                personal.setDni(rs.getString("dni"));
                personal.setNombre(rs.getString("Nombre"));
                personal.setApellido1(rs.getString("apellido1"));
                personal.setApellido2(rs.getString("apellido2"));
                personal.setDireccion(rs.getString("direccion"));
                personal.setCp(rs.getInt("cp"));
                personal.setPoblacion(rs.getString("poblacion"));
                personal.setProvincia(rs.getString("provincia"));
                personal.setTelefono(rs.getInt("telefono"));
                personal.setEmail(rs.getString("email"));
                personal.setTipo(rs.getInt("tipo"));

            }
            
        }
        
        return personal;
    }

    @Override
    public List<Personal> getAll() throws SQLException {
        Personal personal=null;
        String sql="select * from personal";
        
        List<Personal> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                
                personal=new Personal();
                personal.setId(rs.getInt("id"));
                personal.setDni(rs.getString("dni"));
                personal.setNombre(rs.getString("Nombre"));
                personal.setApellido1(rs.getString("apellido1"));
                personal.setApellido2(rs.getString("apellido2"));
                personal.setDireccion(rs.getString("direccion"));
                personal.setCp(rs.getInt("cp"));
                personal.setPoblacion(rs.getString("poblacion"));
                personal.setProvincia(rs.getString("provincia"));
                personal.setTelefono(rs.getInt("telefono"));
                personal.setEmail(rs.getString("email"));
                personal.setTipo(rs.getInt("tipo"));

                
                result.add(personal);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Personal p) throws SQLException {
        String sql="""
                  update personal
                  set Dni=?, nombre=?, apellido1=?, apellido2=?, direccion=?, cp=?, poblacion=?, provincia=?, telefono=?, email=?, tipo=?
                   where id=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
                
                pstm.setString(1, p.getDni());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido1());
            pstm.setString(4, p.getApellido2());
            pstm.setString(5, p.getDireccion());
            pstm.setInt(6, p.getCp());
            pstm.setString(7, p.getPoblacion());
            pstm.setString(8, p.getProvincia());
            pstm.setInt(9, p.getTelefono());
            pstm.setString(10, p.getEmail());
            pstm.setInt(11, p.getTipo());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                  delete from personal
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
