/*
 * Tiempo.java
 *   Encargado de datos de tiempo fecha del sistema
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
import java.util.*;

public class Tiempo {
    
    private static GregorianCalendar calendario;
   
    /** Metodo para inicializar el trabajo de esta clase
     *  Debe ser llamado antes que cualquier otro metodo
     */
    public static void inicia(){
        calendario = new GregorianCalendar();
    }

    /** Obtiene la fecha actual en formato "DiaSemana, numDiaDelMes de nombreMes del numAnyo"
     * @return la fecha actual en formato "DiaSemana, numDiaDelMes de nombreMes del numAnyo"
     */
  public static String getFecha(){
    int dia = calendario.get(Calendar.DAY_OF_WEEK)-1;
    int mes = calendario.get(Calendar.MONTH);
    String[] diaNom={"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
    String[] mesNom={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    String fechaAct = " "+diaNom[dia]+", "+(calendario.get(Calendar.DAY_OF_MONTH))+" de ";
    fechaAct += mesNom[mes]+" del "+calendario.get(Calendar.YEAR);
    return fechaAct;
  }
  
  /** Obtiene la fecha actual en formato solo numeros DD-MM-AAAA
   * @return la fecha actual en formato solo numeros DD-MM-AAAA
   */
  public static String getFechaFormatoNums(){
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    int mes = calendario.get(Calendar.MONTH)+1;
    return (dia<9?"0":"")+dia+(mes<9?"-0":"-")+mes+"-"+calendario.get(Calendar.YEAR);
  }
  
  /** Obtiene el numero de dia actual del mes
   * @return el numero de dia actual del mes
   */
  public static int getDia(){ 
      return calendario.get(Calendar.DAY_OF_MONTH); 
  }
  
  /** Obtiene el numero del mes actual (1-12)
   * @return el numero del mes actual (1-12)
   */
  public static int getMes(){ 
      return calendario.get(Calendar.MONTH)+1;
  }
  
  /** Obtiene el numero del Anyo actual
   * @return el numero del Anyo actual
   */
  public static int getAnyo(){ 
      return calendario.get(Calendar.YEAR);
  }

  /** Obtiene la hora actual en formato HH:MM:SS (AM || PM)
   * @return la hora actual en formato HH:MM:SS (AM || PM)
   */
  public static String getHora(){
    calendario.setTime(new Date());
    int h = calendario.get(Calendar.HOUR);
    int m = calendario.get(Calendar.MINUTE);
    int s = calendario.get(Calendar.SECOND);
    int apm = calendario.get(Calendar.AM_PM);
    h=(h==0?12:h);
    return (" "+(h<10?"0":"")+h+":"+(m<10?"0":"")+m+":"+(s<10?"0":"")+s+" "+(apm==0?"AM ":"PM "));
  }
  
  /** Obtiene la hora actual en formato HH:MM:SS
   * @return la hora actual en formato HH:MM:SS
   */
  public static String getHoraNoFormato(){
    calendario.setTime(new Date());
    int h = calendario.get(Calendar.HOUR);
    int m = calendario.get(Calendar.MINUTE);
    int s = calendario.get(Calendar.SECOND);
    return ((h<10?"0":"")+h+(m<10?"0":"")+m+(s<10?"0":"")+s);
  }

}
