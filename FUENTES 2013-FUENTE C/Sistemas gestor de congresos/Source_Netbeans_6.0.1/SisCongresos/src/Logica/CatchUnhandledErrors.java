/*
 * CatchUnhandledErrors.java
 *   Clase para atrapar fallas inesperadas en tiempo de ejecucion
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

import Guis.Sistema.Ventana;
import javax.swing.JFileChooser;

/**
 * @author Pedro Cardoso Rodriguez
 */
public class CatchUnhandledErrors implements Thread.UncaughtExceptionHandler{
    
    private Ventana ventana;
    
    public CatchUnhandledErrors(Ventana ventana){
        this.ventana=ventana;
    }
    
    public void uncaughtException(Thread trd, Throwable exc) {
            JFileChooser cajaArchivo;
            java.io.File archivo;
            String aux="<html>Ha ocurrido un error inesperado!!<br>Puede informar de errores inesperados ";
            aux+="enviando un archivo de informe<br>a la direccion de correo electronico que aparece en Acerca de.";
            aux+="<br>¿Desea crear un archivo de informe de errores?</html>";
            if(!ventana.askYesNoOption(aux)) return;
            cajaArchivo= new JFileChooser();
            do{
                if(cajaArchivo.showSaveDialog(ventana)!=JFileChooser.APPROVE_OPTION) return;
                archivo=cajaArchivo.getSelectedFile();
                aux="<html>El archivo: "+archivo.getName()+" ya existe.<br>¿Desea sobreescribir el archivo?</html>";
            }while(archivo.isFile()&&!ventana.askYesNoOption(aux));
            try{
                java.io.FileWriter arsale = new java.io.FileWriter(archivo);
                java.io.BufferedWriter bufw = new java.io.BufferedWriter(arsale);
                java.lang.StackTraceElement[] elementospila;
                elementospila=exc.getStackTrace();
                bufw.write(" <<- SisCongresos (V0.035) log de error ->>\n\tOcurrido en:\n");
                bufw.write(""+Logica.Tiempo.getFecha()+Logica.Tiempo.getHora());
                bufw.write("\nOcurrio un error definido: "+exc.toString()+"\n\tTrazado de pila:\n");
                for(int j=0;j<elementospila.length;j++) 
                    bufw.write(elementospila[j]+"\n");
                bufw.close();
                arsale.close();
                aux="El archivo de informe ha sido creado";
            }
            catch(Exception excLocal){
                aux="<html>No se pudo crear el archivo de informe<br>";
                aux+="Error: "+excLocal.getMessage()+"</html>";
            }
            ventana.message(aux,2);
         }
    
}
