/*
 * ConsultasBD.java
 *   Encargado de hacer consultas al servidor de la base de datos
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
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 * @author Pedro Cardoso Rodriguez
 */
public class ConsultasBD {
    
    private static Statement sentencia; // sentencia a ejecutar
    private static ResultSet resp; // resultado obtenido de la ultima sentencia ejecutada
    private static ResultSetMetaData respMetaData; // meta datos del resp actual
    private static String error=""; // descripcion del ultimo error ocurrido
    
    /** Realiza una consulta (select) al servidor 
     * @param parm la sentencia de la consulta a regresar
     * @return El resulset obtenido de la consulta convertido a un arreglo de string donde los 
     *   campos son concatenados y cada fila es un elemento del arreglo, si hay un error regresa null, 
     *   si no hay resultados (empty set) regresa una sola cadena null
     */
    public static String[] consultaLista(String parm){
        String[] resultado = new String[1];        
        java.util.ArrayList<String> lista = new java.util.ArrayList<String>();
        resultado[0]=null;
        int columnas=0;
        int tipo;
        try{
            sentencia = ConectaBD.conecBd.createStatement();
            resp = sentencia.executeQuery(parm);
            respMetaData = resp.getMetaData();
            columnas=respMetaData.getColumnCount();
            while(resp.next()){
                resultado[0]="";
                for(int j=0;j<columnas;j++){
                    tipo=respMetaData.getColumnType(j+1);
                    if(tipo==Types.VARCHAR || tipo==Types.CHAR)
                        resultado[0] += resp.getString(j+1)+" ";
                    else if(tipo==Types.DATE && resp.getDate(j+1)!=null)
                        resultado[0] += Logica.OprsDts.transformatFcha(resp.getDate(j+1).toString())+" ";
                    else if(tipo==Types.DATE && resp.getDate(j+1)==null)
                        resultado[0] += " ";
                    else if(tipo==Types.DECIMAL)
                        resultado[0] += ""+resp.getFloat(j+1)+" ";
                    else if(tipo==Types.TINYINT || tipo==Types.SMALLINT || tipo==Types.INTEGER)
                        resultado[0] += ""+resp.getInt(j+1)+" ";
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)!=null)
                        resultado[0] += Logica.OprsDts.transformatFchaHora(resp.getTimestamp(j+1).toString(),true)+" ";
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)==null)
                        resultado[0] += " ";
                    else if(tipo==Types.BIT)
                        resultado[0] += resp.getBoolean(j+1);
                    else resultado[j] = ""+resp.getObject(j+1);
                }                     
                lista.add(resultado[0]);
            }
            if(lista.size()>0){
                resultado = new String[lista.size()];
                for(int j=0;j<lista.size();j++) resultado[j]=lista.get(j);
            }
            resp.close();
            sentencia.close();
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return null;
        }
        catch(NullPointerException npExc){
            error="Verifique la conexion con el servidor!";
            return null;
        }
        return resultado;
    }
    
    /** Realiza una consulta (select) al servidor 
     * @param parm la sentencia de la consulta a regresar
     * @return El resulset convertido a un arreglo de string donde los campos simulan 
     *   la tabla si hay un error regresa null, si no hay resultados regresa una sola cadena null
     */
    public static String[][] consultaArray(String parm){
        String[][] resultado = new String[1][1];
        java.util.ArrayList<String[]> lista = new java.util.ArrayList<String[]>();
        resultado[0][0]=null;
        int columnas=0;
        int tipo;
        try{
            sentencia = ConectaBD.conecBd.createStatement();
            resp = sentencia.executeQuery(parm);
            respMetaData = resp.getMetaData();
            columnas=respMetaData.getColumnCount();
            while(resp.next()){
                resultado=new String[1][columnas];
                for(int j=0;j<columnas;j++){
                    tipo=respMetaData.getColumnType(j+1);
                    if(tipo==Types.VARCHAR || tipo==Types.CHAR)
                        resultado[0][j]=resp.getString(j+1);
                    else if(tipo==Types.DATE && resp.getDate(j+1)!=null)
                        resultado[0][j]=Logica.OprsDts.transformatFcha(resp.getDate(j+1).toString());
                    else if(tipo==Types.DATE && resp.getDate(j+1)==null)
                        resultado[0][j]="";
                    else if(tipo==Types.DECIMAL)
                        resultado[0][j]=""+resp.getFloat(j+1);
                    else if(tipo==Types.TINYINT || tipo==Types.SMALLINT || tipo==Types.INTEGER)
                        resultado[0][j]=""+resp.getInt(j+1);
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)!=null)
                        resultado[0][j]=Logica.OprsDts.transformatFchaHora(resp.getTimestamp(j+1).toString(),true);
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)==null)
                        resultado[0][j]="";
                    else if(tipo==Types.BIT)
                        resultado[0][j]=""+resp.getBoolean(j+1);
                    else resultado[0][j]=""+resp.getObject(j+1);
                }                     
                lista.add(resultado[0]);
            }
            if(lista.size()>0){
                resultado = new String[lista.size()][columnas];
                for(int j=0;j<lista.size();j++) resultado[j]=lista.get(j);
            }
            resp.close();
            sentencia.close();
            return resultado;
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return null;
        }
        catch(NullPointerException npExc){
            error="Verifique la conexion con el servidor!";
            return null;
        }
    }
    
    /** Realiza una consulta (select) al servidor 
     * @param parm la sentencia de la consulta a regresar
     * @return El resulset convertido a un arreglo de string donde los campos son los elementos del 
     *   arreglo, (pensado para consultas de un solo reglon por medio del campo llave) si hay un 
     *  error regresa null, si no hay resultados regresa una sola cadena null
     */
    public static String[] consultaUnCampo(String parm){
        String[] resultado = new String[1];
        int columnas=0;
        int tipo;
        resultado[0]=null;
        try{
            sentencia = ConectaBD.conecBd.createStatement();
            resp = sentencia.executeQuery(parm);
            respMetaData = resp.getMetaData();
            columnas=respMetaData.getColumnCount();            
            if(resp.next()){
                resultado = new String[columnas];
                for(int j=0;j<columnas;j++){
                    tipo=respMetaData.getColumnType(j+1);
                    if(tipo==Types.VARCHAR || tipo==Types.CHAR)
                        resultado[j] = resp.getString(j+1);
                    else if(tipo==Types.DATE && resp.getDate(j+1)!=null)
                        resultado[j] = Logica.OprsDts.transformatFcha(resp.getDate(j+1).toString());
                    else if(tipo==Types.DATE && resp.getDate(j+1)==null)
                        resultado[j] = "";
                    else if(tipo==Types.DECIMAL)
                        resultado[j] = ""+resp.getFloat(j+1);
                    else if(tipo==Types.TINYINT || tipo==Types.SMALLINT || tipo==Types.INTEGER)
                        resultado[j] = ""+resp.getInt(j+1);
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)!=null)
                        resultado[j] = Logica.OprsDts.transformatFchaHora(resp.getTimestamp(j+1).toString(),true);
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)==null)
                        resultado[j] = "";
                    else if(tipo==Types.BIT)
                        resultado[j] = ""+resp.getBoolean(j+1);
                    else resultado[j] = ""+resp.getObject(j+1);
                }                     
            }
            resp.close();
            sentencia.close();
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return null;
        }
        catch(NullPointerException npExc){
            error="Verifique la conexion con el servidor!";
            return null;
        }
        return resultado;
    }
    
    /** Realiza una consulta (select) al servidor 
     * @param parm la sentencia de la consulta a regresar
     * @return El resultado de una consulta select recibida como parametro en 
     *   un defaultTableModel o null si hubo error
     */
    public static DefaultTableModel consTipoTable(String cons){
        int cols;
        int tipo;
        Object[] fila;
        try{
            DefaultTableModel modeloTab = new DefaultTableModel();
            sentencia = ConectaBD.conecBd.createStatement();
            resp = sentencia.executeQuery(cons);
            respMetaData = resp.getMetaData();
            cols = respMetaData.getColumnCount();
            fila = new Object[cols];
            for(int i=0;i<cols;i++) fila[i] = respMetaData.getColumnLabel(i+1);
            modeloTab.setColumnIdentifiers(fila);
            while(modeloTab.getRowCount()>0) modeloTab.removeRow(0);
            while(resp.next()){
                for(int j=0;j<cols;j++){
                    tipo=respMetaData.getColumnType(j+1);
                    if(tipo==Types.VARCHAR || tipo==Types.CHAR)
                        fila[j] = resp.getString(j+1);
                    else if(tipo==Types.DATE && resp.getDate(j+1)!=null)
                        fila[j] = Logica.OprsDts.transformatFcha(resp.getDate(j+1).toString());
                    else if(tipo==Types.DATE && resp.getDate(j+1)==null)
                        fila[j] = "";
                    else if(tipo==Types.DECIMAL)
                        fila[j] = resp.getFloat(j+1);
                    else if(tipo==Types.TINYINT  || tipo==Types.SMALLINT || tipo==Types.INTEGER)
                        fila[j] = resp.getInt(j+1);
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)!=null)
                        fila[j] = Logica.OprsDts.transformatFchaHora(resp.getTimestamp(j+1).toString(),true);
                    else if(tipo==Types.TIMESTAMP && resp.getTimestamp(j+1)==null)
                        fila[j] = "";
                    else if(tipo==Types.BIT)
                        fila[j] = resp.getBoolean(j+1);
                    else fila[j] = ""+resp.getObject(j+1);
                }
                modeloTab.addRow(fila);
            }
            resp.close();
            sentencia.close();
            error=null;
            return modeloTab;
        }
        catch(SQLException excSqlCons){
            error = excSqlCons.getMessage();
            return null;
        }
        catch(NullPointerException npExc){
            error="Verifique la conexion con el servidor!";
            return null;
        }
    }

    /** Realiza una consulta (select) al servidor para sentencias elaboradas para obtener 
     *    un solo entero por ejemplo claves o sentencias count
     * @param parm la sentencia de la consulta a regresar
     * @return El valor encontrado. 0 si no hay resultados o -1 si falla
     */
    public static int consultaEntero(String parm){
        int numero;
        try{
            sentencia = ConectaBD.conecBd.createStatement();
            resp = sentencia.executeQuery(parm);
            respMetaData = resp.getMetaData();
            if(resp.next()) numero=resp.getInt(1);
            else numero=0;
            resp.close();
            sentencia.close();
            return numero;
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return -1;
        }
        catch(NullPointerException npExc){
            error="Verifique la conexion con el servidor!";
            return -1;
        }
    }
    
    /** Realiza una consulta (select) al servidor para sentencias elaboradas para obtener 
     *    valores enteros por ejemplo claves
     * @param parm la sentencia de la consulta a regresar
     * @return El resulset convertido a un vector de enteros donde los campos son los elementos 
     *   del arreglo, si hay error regresa null, si no hay resultados regresa un vector de 
     *   longitud 1 con un solo valor de -1
     */
    public static int[] consultaEnteros(String parm){
        int[] resultado=new int[1];
        java.util.ArrayList<Integer> lista = new java.util.ArrayList<Integer>();
        resultado[0]=-1;
        try{
            sentencia = ConectaBD.conecBd.createStatement();
            resp = sentencia.executeQuery(parm);
            while(resp.next()){
                resultado[0]++;
                lista.add(resp.getInt(resultado[0]+1));
            }
            if(lista.size()>0){
                resultado = new int[lista.size()];
                for(int j=0;j<lista.size();j++) resultado[j]=lista.get(j);
            }
            resp.close();
            sentencia.close();
        }
        catch(SQLException excSqlUpd){
            error=excSqlUpd.getMessage();
            return null;
        }
        catch(NullPointerException npExc){
            error="Verifique la conexion con el servidor!";
            return null;
        }
        return resultado;
    }
    
    /** Obtiene el utimo error ocurrido en los metodos de esta clase
     * @return el utimo error ocurrido en los metodos de esta clase
     */
    public static String getError(){
        return error;
    } 
}
