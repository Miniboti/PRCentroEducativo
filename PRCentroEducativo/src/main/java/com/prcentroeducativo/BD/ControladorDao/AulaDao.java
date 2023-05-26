/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Aula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javip
 */
public interface AulaDao {
    int add(Aula a) throws SQLException;
    
    Aula getById(int id) throws SQLException;
        
    List<Aula> getAll()  throws SQLException;
    
    int update(Aula a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
