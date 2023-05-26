/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Curso;
import com.prcentroeducativo.BD.ControladorDao.Entidades.CursoAcademico;
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
public class CursoDaoImp implements CursoDao {
     private static CursoDaoImp instance;
    
    static{
        instance=new CursoDaoImp();
    }
    
    private CursoDaoImp(){ }
    
    public static CursoDaoImp getInstance(){
        return instance;
    }
    
     @Override
    public int add(Curso c) throws SQLException {

      String sql="""
                  insert into curso(id,codigo,nombre,Observaciones,idcursoacademico)
                  values (?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, c.getId());
            pstm.setString(2, c.getCodigo());
            pstm.setString(3, c.getNombre());
            pstm.setString(4, c.getObservaciones());
            pstm.setInt(5, c.getIdcursoacademico());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
        
        
    }

    @Override
    public Curso getById(int id) throws SQLException {
        Curso Curso=null;
        String sql="select * from curso where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                Curso=new Curso();
                
                Curso.setId(rs.getInt("id"));
                Curso.setCodigo(rs.getString("Codigo"));
                Curso.setNombre(rs.getString("Nombre"));
                Curso.setObservaciones(rs.getString("descripcion"));
                Curso.setIdcursoacademico(rs.getInt("IdCursoAcademico"));

            }
            
        }
        
        return Curso;
    }

    @Override
    public List<Curso> getAll() throws SQLException {
                Curso curso=null;
        String sql="select * from curso";
        
        List<Curso> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                curso=new Curso();
                
                curso.setId(rs.getInt("id"));
                curso.setCodigo(rs.getString("codigo"));
                curso.setNombre(rs.getString("nombre"));
                curso.setObservaciones(rs.getString("observaciones"));
                curso.setIdcursoacademico(rs.getInt("idcursoacademico"));                    
                
                result.add(curso);
            }
            
        }
        
        return result; 

    }

    @Override
    public int update(Curso c) throws SQLException {

        String sql="""
                  update curso
                  set yearinicio=?, yearfin=?, descripcion=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
                        
            pstm.setInt(1, c.getId());
            pstm.setString(2, c.getCodigo());
            pstm.setString(3, c.getNombre());
            pstm.setString(4, c.getObservaciones());
            pstm.setInt(5, c.getIdcursoacademico());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
      
    }

    @Override
    public void delete(int id) throws SQLException {
 String sql="""
                  delete from  curso
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
           
            
            result=pstm.executeUpdate();
            
        }
       
    }
    

    @Override
    public CursoAcademico getCursoAcademico(Curso cu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Curso> getAllByCursoAcademico(int idcursoacademico) throws SQLException {
Curso Curso=null;
        String sql="select * from curso where idcursoacademico=?";
        List<Curso> Cursos= new ArrayList();
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1,idcursoacademico );
            
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                Curso=new Curso();
                
                Curso.setId(rs.getInt("id"));
                Curso.setCodigo(rs.getString("Codigo"));
                Curso.setNombre(rs.getString("Nombre"));
                Curso.setObservaciones(rs.getString("descripcion"));
                Curso.setIdcursoacademico(rs.getInt("IdCursoAcademico"));
                Cursos.add(Curso);
            }
            
        }
        
        return Cursos ;
    }
}
