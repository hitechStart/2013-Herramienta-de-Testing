/*
 * ConectaBD.java
 *   Encargado de conectar al servidor de la base de datos
 *   Todos los metodos son static
 * Parte de proyecto: SisCongresos
 * Author: Pedro Cardoso Rdz
 * Mail: cardp_2004@yahoo.com.mx
 * Place: Zacatecas Mexico
 * 
    Copyright © 2010 Pedro Cardoso Rodriguez

    SisCongresos is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or any 
    later version.

    SisCongresos is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SisCongresos.  If not, see <http://www.gnu.org/licenses/>
 */

package BaseDatos;
import java.sql.*;

/**
 * @author Pedro Cardoso Rodriguez
 */
public class ConectaBD {

    public static Connection conecBd; // puntero a conexion con el servidor
    private static String error = null; // descripcion del ultimo error ocurrido
    
    /** Conecta el programa con el servidor MySQL
     *   NOTA: la base de datos debe llamarse congresos
     * @param ip Direccion ip de la maquina donde corre MySQL
     * @param prt Puerto de escucha de MySQL
     * @param user Usuario con el cual conectarse a MySQL
     * @param pass Password correspondiente al usuario  del parametro anterior 
     * @return True si la conexion se establecio con exito false en caso contrario
     */
    public static boolean conecta(String ip, int prt, String user, String pass){
        try{
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            /* se tuvo que especificar el parametro: noAccessToProcedureBodies=true
             * para poder utilizar procedimientos almacenados */
            conecBd = DriverManager.getConnection("jdbc:mysql://"+ip+":"+prt+"/congresos?noAccessToProcedureBodies=true",user,pass);
            return true;
        }
        catch(SQLException excSql){
            error=""+excSql.getMessage();
            return false;
        }
    }
    
    /** Indica si actualmente hay conexion con el servidor
     * @return True si actualmente hay conexion false en caso contrario
     */
    public static boolean hayConexion(){
        try{ return !conecBd.isClosed(); }
        catch(SQLException excSql){ return false; }
        catch(NullPointerException excNullPE){ return false; }
    }
    
    /** Obtiene el utimo error ocurrido en los metodos de esta clase
     * @return el utimo error ocurrido en los metodos de esta clase
     */
    public static String obtenError(){
        return error;
    }
}
