/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Matricula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javip
 */
public interface MatriculaDao {
    int add(Matricula a) throws SQLException;
    
    Matricula getById(int id) throws SQLException;
        
    List<Matricula> getAll()  throws SQLException;
    
    int update(Matricula a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
