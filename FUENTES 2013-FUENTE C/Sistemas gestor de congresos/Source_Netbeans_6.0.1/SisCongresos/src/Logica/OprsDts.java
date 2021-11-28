/*
 * OprsDts.java
 *   Encargado de operaciones sobre datos (cambiar formatos)
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

package Logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OprsDts {
    
    private static Matcher matcher;
    
    /** Cambia el formato de una fecha recibida como parametro el cambio es del 
     *   formato yyyy-mm-dd : dd-mm-yyyy y viceversa (para interaccion con el servidor 
     *   que maneja el formato yyyy-mm-dd)
     * @param fcha la fecha original
     * @return la fecha transformada
     */
    public static String transformatFcha(String fcha){
        java.util.StringTokenizer toks = new java.util.StringTokenizer(fcha,"-");
        String tk1;
        String tk2;
        String tk3;
        if(fcha==null || fcha.length()==0) return null;
        tk1 = toks.nextToken();
        tk2 = toks.nextToken();
        tk3 = toks.nextToken();
        return tk3+"-"+tk2+"-"+tk1;
    } 
    
    /** Obtiene el numero de mes de una cadena con formato de fecha yyyy-mm-dd o dd-mm-yyyy
     * @param fcha la cadena con la fecha
     * @return el numero de mes de la fecha (1-12)
     */
    public static int obtenMesDeFecha(String fcha){
        java.util.StringTokenizer toks = new java.util.StringTokenizer(fcha,"-");
        String tk = toks.nextToken();
        tk = toks.nextToken();
        return Integer.parseInt(tk);
    }
    
    /** Transforma dos fechas (formato dd-mm-yyyy) a su descripcion de periodo
     * @param fcha1 la fecha uno
     * @param fcha2 la fecha dos
     * @return la descripcion de periodo de las dos fechas
     */
    public static String transFechasDescPer(String fcha1, String fcha2){
        String[] meses={"ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV","DIC"};
        String per;
        java.util.StringTokenizer toks = new java.util.StringTokenizer(fcha1,"-");
        toks.nextToken();
        per=meses[Integer.parseInt(toks.nextToken())-1]+toks.nextToken().substring(2)+"-";
        toks = new java.util.StringTokenizer(fcha2,"-");
        toks.nextToken();
        per+=meses[Integer.parseInt(toks.nextToken())-1]+toks.nextToken().substring(2);
        return per;
    }
    
    /**  Cambia el formato de una fecha recibida como parametro el cambio es del formato 
     *   yyyy-mm-dd hh:mm:ss hacia el formato dd-mm-yyyy hh:mm:ss
     *   y viceversa (para interaccion con el servidor  que maneja el formato yyyy-mm-dd) A la parte de la hora 
     *   le quita los segundos (cadena :00) si el parametro quitaSegundos es true de lo contrario se los agrega
     * @param fchahor la fecha y hora original
     * @param quitaSegundos indica si se deben quitar o agregar los segundos
     * @return la fecha transformada
     */
    public static String transformatFchaHora(String fchahor, boolean quitaSegundos){
        java.util.StringTokenizer toks = new java.util.StringTokenizer(fchahor," ");
        java.util.StringTokenizer toksFcha = new java.util.StringTokenizer(toks.nextToken(),"-");
        String tk1 = toksFcha.nextToken();
        String tk2 = toksFcha.nextToken();
        String tk3 = toksFcha.nextToken();
        String hora=toks.nextToken();
        fchahor=tk3+"-"+tk2+"-"+tk1+" ";
        if(quitaSegundos){
            toks = new java.util.StringTokenizer(hora,":");
            fchahor+=toks.nextToken()+":"+toks.nextToken();
        }
        else fchahor+=hora+":00";
        return fchahor;
    } 
    
    /** Valida que una fecha tenga el formato dd-mm-aaaa
     * @param fcha la fecha a validar
     * @return true si es valida false en caso contrario
     */
    public static boolean valFecha(String fcha){
        Pattern ptrFecha  = Pattern.compile("[0-9]{2}-[0-9]{2}-[0-9]{4}");
        matcher = ptrFecha.matcher(fcha);
        return matcher.matches();
    }
     
    /** Valida fecha y hora formato DD-MM-YYYY HH:MM
     * @param dateHour la fecha a validar
     * @return true si es valida false en caso contrario
     */
    public static boolean valFechaYHora(String dateHour){
        Pattern ptrPhr  = Pattern.compile("[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}");
        java.util.StringTokenizer toks=new java.util.StringTokenizer(dateHour);
        int aux;
        matcher = ptrPhr.matcher(dateHour);
        if(!matcher.matches()) return false;
        aux=Integer.parseInt(toks.nextToken("-"));
        if(aux<01||aux>31) return false;
        aux=Integer.parseInt(toks.nextToken("-"));
        if(aux<01||aux>12) return false;
        aux=Integer.parseInt(toks.nextToken("- "));
        if(aux<1000) return false;
        aux=Integer.parseInt(toks.nextToken(" :"));
        if(aux>23) return false;
        aux=Integer.parseInt(toks.nextToken(":"));
        if(aux>59) return false;
        return true;
    }
    
}
