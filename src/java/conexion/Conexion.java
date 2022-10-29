/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;


/**
 *
 * @author Alumno
 */
public class Conexion {
    private Connection conexion=null;
    private Statement sentenciaSQL = null;
    
    
    
    public void conectar(){
        try{
            String controlador="com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
            
            conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nutria","root","");
            sentenciaSQL=getConexion().createStatement();
        }
        catch(ClassNotFoundException e){
            System.out.println("No se pudo cargar el controlador " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Excepción SQL: " + e.getMessage());
        }
        catch(IllegalAccessException e){
            System.out.println("Acceso ilegal. " + e.getMessage());
        } catch (InstantiationException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrar(){
        try {
            if(getSentenciaSQL() !=null)getSentenciaSQL().close();
            
            if(getConexion() != null) getConexion().close();
        }
        catch(SQLException ignorada){
        }
    
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public Statement getSenteciaSQL(){
        return sentenciaSQL;
    }

    public Statement getSentenciaSQL() {
        return sentenciaSQL;
    }

    public void setSentenciaSQL(Statement sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    
    Connection cn = null;
    public Connection conectarL() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //cn = DriverManager.getConnection("jdbc:mysql//localhost/final", "root", "");
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nutria", "root", "");
        } catch (SQLException ex) {
           
        }
        return cn;
    
}
    
}

