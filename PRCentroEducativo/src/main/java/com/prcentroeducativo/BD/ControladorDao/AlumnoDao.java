/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao;

import com.prcentroeducativo.BD.ControladorDao.Entidades.Alumno;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javip
 */
public interface AlumnoDao {
    int add(Alumno a) throws SQLException;
    
    Alumno getById(int id) throws SQLException;
        
    List<Alumno> getAll()  throws SQLException;
    
    int update(Alumno a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
