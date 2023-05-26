/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.prcentroeducativo;

import com.prcentroeducativo.BD.ControladorDao.CursoAcademicoDaoImp;
import com.prcentroeducativo.BD.ControladorDao.Entidades.CursoAcademico;
import com.prcentroeducativo.BD.MyDataSource;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author javip
 */
public class PRCentroEducativo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection cnlocal=MyDataSource.getConnection();
        System.out.println("Conexion...");
        Test();
    }
    
    
    public static void Test(){
    
        CursoAcademicoDaoImp daoCursoAcademico=CursoAcademicoDaoImp.getInstance();
    
        try {
            CursoAcademico cursoaca=daoCursoAcademico.getById(1);
            System.out.println(cursoaca);
                        
            cursoaca=daoCursoAcademico.getById(1);
            System.out.println(cursoaca);
            
            List<CursoAcademico> lst=daoCursoAcademico.getAll();
            
            System.out.println("Mostrando cursos academicos");
            for(CursoAcademico c : lst){
                System.out.println(c+"\n");
            
            }
            
            // probando inserccion
            //daoCursoAcademico.add(new CursoAcademico(2023,2024,"23-24"));
            
        } catch (Exception ex) {
            System.out.println("Error..."+ex.getMessage());
        }
    }
    
}
