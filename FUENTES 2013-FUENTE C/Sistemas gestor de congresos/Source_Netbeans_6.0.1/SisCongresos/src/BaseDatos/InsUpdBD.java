/*
 * InsUpdBD.java
 *   Encargado de insert y update en la base de datos
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
public class InsUpdBD {
    
    private static Statement sentencia; // sentencia a ejecutar
    private static CallableStatement callProcedure; // para llamadas a procedimientos almacenados
    private static String error; // descripcion del ultimo error ocurrido
    private static int clave; // ultima clave generada en inserciones a campos auto_increment
    
    /** Crea un nuevo registro de congreso
     * @param datos Vector con los datos del nuevo registro: 
     *   Tittulo, Tema del Congreso, Sede, Fecha Inicial y Fecha Final
     * @return true si el registro se creo correctamente false en caso contrario
     *   Si el registro se creo correctamente se puede obtener su clave con el metodo obtenClave()
     */
    public static boolean nuevoCongreso(String[] datos){
        try{            
            String aux="?,?,?,?,?,?";
            callProcedure = ConectaBD.conecBd.prepareCall("{call nuevoCongreso("+aux+")}");
            for(int j=0;j<datos.length;j++)
                callProcedure.setString(j+1, datos[j]);
            callProcedure.registerOutParameter(datos.length+1, Types.INTEGER);
            callProcedure.executeUpdate();
            clave=Integer.parseInt(""+callProcedure.getObject(datos.length+1));
            callProcedure.close();
            if(clave==0){ 
                error="No se pudo realizar la accion";
                return false;
            }
                    
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return false;
        }
        catch(NullPointerException npExc){
            error="Verifique que haya conexion con el servidor!";
            return false;
        }
        return true;
    }
    
    /** Crea un nuevo registro de DtsPers
     * @param datos Vector con los datos del nuevo registro: 
     *   Nombre, Apellido paterno, Apellido materno, Direccion, Ciudad, Estado, Telefono de Casa,
     *   Telefono de Oficina, Telefono Movil, Correo Electronico, Titulo profesional
     * @return true si el registro se creo correctamente false en caso contrario
     *   Si el registro se creo correctamente se puede obtener su clave con el metodo obtenClave()
     */
    public static boolean nuevoDtsPers(String[] datos){
        try{            
            String aux="?,?,?,?,?,?,?,?,?,?,?,?";
            callProcedure = ConectaBD.conecBd.prepareCall("{call nuevoDtsPers("+aux+")}");
            for(int j=0;j<datos.length;j++)
                callProcedure.setString(j+1, datos[j]);
            callProcedure.registerOutParameter(datos.length+1, Types.INTEGER);
            callProcedure.executeUpdate();
            clave=Integer.parseInt(""+callProcedure.getObject(datos.length+1));
            callProcedure.close();
            if(clave==0){ 
                error="No se pudo realizar la accion";
                return false;
            }
                    
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return false;
        }
        catch(NullPointerException npExc){
            error="Verifique que haya conexion con el servidor!";
            return false;
        }
        return true;
    }
    
    /** Crea un nuevo registro de eventos
     * @param datos Vector con los datos del nuevo registro: 
     *   Titulo del Even, Tema del Evento, Fecha Y Hora, Tipo de Evento
     * @return true si el registro se creo correctamente false en caso contrario
     *   Si el registro se creo correctamente se puede obtener su clave con el metodo obtenClave()
     */
    public static boolean nuevoEvento(String[] datos){
        try{            
            String aux="?,?,?,?,?";
            callProcedure = ConectaBD.conecBd.prepareCall("{call nuevoEvento("+aux+")}");
            for(int j=0;j<datos.length;j++)
                callProcedure.setString(j+1, datos[j]);
            callProcedure.registerOutParameter(datos.length+1, Types.INTEGER);
            callProcedure.executeUpdate();
            clave=Integer.parseInt(""+callProcedure.getObject(datos.length+1));
            callProcedure.close();
            if(clave==0){ 
                error="No se pudo realizar la accion";
                return false;
            }
                    
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return false;
        }
        catch(NullPointerException npExc){
            error="Verifique que haya conexion con el servidor!";
            return false;
        }
        return true;
    }
    
    /** Crea un nuevo registro de Ponentes
     * @param datos Vector con los datos del nuevo registro: 
     *   Titulo del Trabajo, Categoria del Trabajo, Tipo de Trabajo, si es Individual boolean, envio de Convocatoria, 
     *   envio de Oficio, envio de Mail, Fecha de Recepcion, Fecha de Aceptacion, Confirmacion de Asistencia boolean, 
     *   Acuse de Recibo, ubicacion en memorias, ubicacion en instalaciones, observaciones
     * @return true si el registro se creo correctamente false en caso contrario
     *   Si el registro se creo correctamente se puede obtener su clave con el metodo obtenClave()
     */
    public static boolean nuevoExponente(String[] datos){
        try{            
            String aux="?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            callProcedure = ConectaBD.conecBd.prepareCall("{call nuevoExponente("+aux+")}");
            for(int j=0;j<datos.length;j++){
                if(j==3 || j==9) callProcedure.setInt(j+1,Integer.parseInt(datos[j]));
                callProcedure.setString(j+1, datos[j]);
            }
            callProcedure.registerOutParameter(datos.length+1, Types.INTEGER);
            callProcedure.executeUpdate();
            clave=Integer.parseInt(""+callProcedure.getObject(datos.length+1));
            callProcedure.close();
            if(clave==0){ 
                error="No se pudo realizar la accion";
                return false;
            }
            return true;        
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return false;
        }
        catch(NullPointerException npExc){
            error="Verifique que haya conexion con el servidor!";
            return false;
        }
    }
    
    /** Ejecuta comandos de actualizaciones en el servidor tipo update o delete
     * @param com Sentencia a ejecutar
     * @return True si la ejecucion se realizo correctamente false en caso contrario
     */
    public static boolean actualiza(String com){
        try{            
            sentencia = ConectaBD.conecBd.createStatement();
            sentencia.execute(com);            
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return false;
        }
        catch(NullPointerException npExc){
            error="Verifique que haya conexion con el servidor!";
            return false;
        }
        return true;
    }
    
    /** Ejecuta una transaccion en el servidor 
     * @param comandos los comandos de la transaccion  cada comando debe estar separado por dos puntos
     * @return True si la ejecucion se realizo correctamente false en caso contrario
     */
    public static boolean transaccion(java.util.ArrayList<String> comandos){
        try{
            sentencia = ConectaBD.conecBd.createStatement();
            sentencia.execute("start transaction;");
            for(int k=0;k<comandos.size();k++) sentencia.execute(comandos.get(k));
            sentencia.execute("commit;");
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            try{ sentencia.execute("rollback;"); }
            catch(SQLException excSqlUpd2){}
            return false;
        }
        catch(NullPointerException npExc){
            error="Verifique que haya conexion con el servidor!";
            try{ sentencia.execute("rollback;"); }
            catch(SQLException excSqlUpd2){}
            return false;
        }
        return true;
    }
    
    /** Obtiene el utimo error ocurrido en los metodos de esta clase
     * @return el utimo error ocurrido en los metodos de esta clase
     */
    public static String obtenError(){
        return error;
    }

    /** Obtiene la utima clave autogenerada correspondiente al ultimo registro nuevo dado de alta 
     * @return la utima clave autogenerada correspondiente al ultimo registro nuevo dado de alta 
     */
    public static int obtenClave(){
        return clave;
    }
}
