/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Autorizaciones;
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
public class AutorizacionesDaoImp implements AutorizacionesDao{
     private static AutorizacionesDaoImp instance;
    
    static{
        instance=new AutorizacionesDaoImp();
    }
    
    private AutorizacionesDaoImp(){ }
    
    public static AutorizacionesDaoImp getInstance(){
        return instance;
    }
    
    
    
     @Override
    public int add(Autorizaciones a) throws SQLException {

      String sql="""
                  insert into Autorizaciones(idalumno,idautorizado)
                  values (?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, a.getIdalumno());
            pstm.setInt(2, a.getIdautorizado());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
        
        
    }

    @Override
    public Autorizaciones getById(int id) throws SQLException {
        Autorizaciones Autorizaciones=null;
        String sql="select * from autorizaciones where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                Autorizaciones=new Autorizaciones();
                
                Autorizaciones.setIdalumno(rs.getInt("idalumno"));
                Autorizaciones.setIdautorizado(rs.getInt("idalumno"));
             
                
            }
            
        }
        
        return Autorizaciones;
    }

     @Override
    public List<Autorizaciones> getAll() throws SQLException {
        Autorizaciones auto=null;
        String sql="select * from autorizaciones";
        
        List<Autorizaciones> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                auto=new Autorizaciones();
                
                auto.setIdalumno(rs.getInt("id alumno"));
                auto.setIdautorizado(rs.getInt("id autorizado"));
                                
                
                result.add(auto);
            }
            
        }
        
        return result; 
    }

    public List<Autorizaciones> getAllByAutorizaciones(int idAutorizaciones) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        @Override
    public int update(Autorizaciones auto) throws SQLException {

        String sql="""
                  update autorizaciones
                  set idalumno=?, idautorizado=?
                   where idautorizado=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, auto.getIdalumno());
            pstm.setInt(2, auto.getIdautorizado());
            
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
      
    }

    @Override
    public void delete(int id) throws SQLException {
 String sql="""
                  delete from  Autorizaciones
                   where idautorizado=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
           
            
            result=pstm.executeUpdate();
            
        }
       
    }
    public Autorizaciones getAutorizaciones(Autorizaciones au) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
