/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javip
 */
public interface UsuarioDao {
     int add(Usuario u) throws SQLException;
    
    Usuario getById(int id) throws SQLException;
        
    List<Usuario> getAll()  throws SQLException;
    
    int update(Usuario c)  throws SQLException;
    
    void delete(int id)  throws SQLException;
    
    boolean valida(String Usuario, String password) throws SQLException;
}
