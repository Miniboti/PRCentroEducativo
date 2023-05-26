/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Aula;
import com.prcentroeducativo.BD.ControladorDao.Entidades.CursoAcademico;
import com.prcentroeducativo.BD.ControladorDao.Entidades.Unidad;
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
public class AulaDaoImp implements AulaDao{
    private static AulaDaoImp instance;
    
    static{
        instance=new AulaDaoImp();
    }
    
    private AulaDaoImp(){ }
    
    public static AulaDaoImp getInstance(){
        return instance;
    }
    
    @Override
    public int add(Aula a) throws SQLException {

      String sql="""
                  insert into aula(id,codigo,descripcion)
                  values (?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, a.getId());
            pstm.setString(2, a.getCodigo());
            pstm.setString(3, a.getDescripcion());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
        
        
    }

    @Override
    public Aula getById(int id) throws SQLException {
        Aula au=null;
        String sql="select * from aula where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                au=new Aula();
                
                au.setId(rs.getInt("id"));
                
                au.setCodigo(rs.getString("codigo"));
                au.setDescripcion(rs.getString("descripcion"));
                
            }
            
        }
        
        return au;
    }
 @Override
    public List<Aula> getAll() throws SQLException {
        Aula aula=null;
        String sql="select * from aula";
        
        List<Aula> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                aula=new Aula();
                
                aula.setId(rs.getInt("id"));
                aula.setCodigo(rs.getString("codigo"));
                aula.setDescripcion("descripcion");
                
                result.add(aula);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Aula a) throws SQLException {
        String sql="""
                  update aula
                  set codigo=?, nombre=?, descripcion=?
                   where id=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
                
                pstm.setString(1, a.getCodigo());
                pstm.setString(2, a.getCodigo());
                pstm.setString(3, a.getDescripcion());
                
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                  delete from aula
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
