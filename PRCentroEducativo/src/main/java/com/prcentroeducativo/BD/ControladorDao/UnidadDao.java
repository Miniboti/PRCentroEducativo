/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Unidad;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javip
 */
public interface UnidadDao {
    int add(Unidad a) throws SQLException;
    
    Unidad getById(int id) throws SQLException;
        
    List<Unidad> getAll()  throws SQLException;
    
    int update(Unidad a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
    
    Unidad getByIdcurso(int id) throws SQLException;
    
    Unidad getByIdtutor(int id) throws SQLException;
    
    Unidad getByIdaula(int id) throws SQLException;
}
