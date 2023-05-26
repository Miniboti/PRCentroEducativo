/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Personal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javip
 */
public interface PersonalDao {
    int add(Personal a) throws SQLException;
    
    Personal getById(int id) throws SQLException;
        
    List<Personal> getAll()  throws SQLException;
    
    int update(Personal a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
