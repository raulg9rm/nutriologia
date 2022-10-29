package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class validaciones {
    
    public String  validarUsuario(String user, String pass) {
        
                Conexion con = new Conexion();
                try {
                    
                    Connection micon = con.conectarL();
                    PreparedStatement st = micon.prepareStatement("Select * from usuario where usuario=? and password=?");
                    st.setString(1, user);
                    st.setString(2, pass);
                    ResultSet rt = st.executeQuery();
                    if(rt.absolute(1)){
                        String tipo = rt.getString("tipo");
                        return tipo;
                    }
                } catch (Exception ex) {
                     Logger.getLogger(validaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
    
                return "";
    }
    
    public static void main(String[] args) throws Exception {
        validaciones v = new validaciones();
        System.out.println(v.validarUsuario("max", "123"));
    }
}
    

