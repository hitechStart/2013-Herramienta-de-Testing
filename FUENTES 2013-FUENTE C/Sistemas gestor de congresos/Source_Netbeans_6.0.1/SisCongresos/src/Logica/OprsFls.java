/*
 * OprsFls.java
 *  Operaciones comunes sobre archivos, lectura  escritura
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

public class OprsFls {
    
    private static String error;

    /** Lee un archivo formato binario con contenido en formato de n cadenas 
     * @param nomArel nombre del archivo a leer
     * @param nCads el numero de cadenas a leer (presupone q son las que contiene en archivo)
     * @return el  arreglo de las cadenas leidas si hay un error regresa null, si 
     *   el archivo no existe regresa una sola cadena null
     */
    public static String[] leeBin(String nomAr, int nCads){
        java.io.File ar = new java.io.File(nomAr);
        boolean bandera=true;
        String[] cont;
        if(ar.isFile()){
            cont = new String[nCads];
            try{
                java.io.FileInputStream arSrc = new java.io.FileInputStream(nomAr);
                java.io.ObjectInputStream dtSrc = new java.io.ObjectInputStream(arSrc);
                for(int t=0;t<nCads;t++) cont[t] = (String)dtSrc.readObject();
                dtSrc.close();         
            }
            catch(java.io.IOException ioExc){ error=ioExc.getMessage(); bandera=false; }
            catch(ClassNotFoundException cnfExc){ error=cnfExc.getMessage(); bandera=false; }
            catch(NullPointerException npExc){ error=npExc.getMessage(); bandera=false; }
            if(!bandera) return null;            
            return cont;
        }
        else{
            cont = new String[1];
            cont[0]=null;
            return cont;
        }
    }
    
    /** Escribe un archivo formato binario con contenido en formato de n cadenas 
     *   si el archivo no existe lo crea de lo contrario lo sobreescribe
     * @param nomAr el nombre del archivo a escribir
     * @param cads las cadenas a escribir
     * @return true si el archivop se guardo correctamente false en caso contrario
     */
    public static boolean escribeBin(String nomAr, String[] cads){
        java.io.File ar;
        java.io.ObjectOutputStream artOut;
        try{
            ar = new java.io.File(nomAr);
            artOut = new java.io.ObjectOutputStream(new java.io.FileOutputStream(ar));
            for(int g=0;g<cads.length;g++) artOut.writeObject(cads[g]);
            artOut.close();
            return true;
        }
        catch(java.io.IOException ioExc){
            error=ioExc.getMessage();
            return false;
        }            
    }
  
    /** Obtiene la descripcion del ultimo error ocurrido
     * @return la descripcion del ultimo error ocurrido
     */
    public static String obtenError(){
        return error;
    }
}
