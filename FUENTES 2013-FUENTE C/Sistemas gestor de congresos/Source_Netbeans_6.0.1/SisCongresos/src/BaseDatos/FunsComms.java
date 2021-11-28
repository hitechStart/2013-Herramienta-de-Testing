/*
 * FunsComms.java
 *   Contiene funciones comunes utilizadas desde diversas partes del sistema
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

/**
 * @author Pedro Cardoso Rodriguez
 */
public class FunsComms {
    
    /** Obtiene los comandos de borrado de datos de una persona (Ver garfico de modelo relacional)
     * @param clave La clave del registro a borrar (dtspers)
     * @param tipoRel el tipo de relacion desde el que se envia la accion de borrar
     *   1=Staff, 2=Exponente, 3=Asistente congreso
     * @param clvrel la clave correspondiente a la relacion desde la que se envia a borrar
     * @return lista de comandos correspondientes segun si debe borrar solo la relacion 
     *   o tambien los datos personales
     */
    public static java.util.ArrayList<String> getComBorrarPersona(int clave, int tipoRel, int clvrel){
        boolean conservarPers=existeEnOtraTabla(tipoRel,clave);
        java.util.ArrayList<String> comandos;
        comandos= new java.util.ArrayList<String>();
        String sen="";
        int aux;
        if(tipoRel==1){
            if(!conservarPers){
                sen="select count(*) from Personal where clvdts="+clave+" and clvcon<>"+clvrel+";";
                aux=BaseDatos.ConsultasBD.consultaEntero(sen);
                conservarPers=(aux>0);
            }
            sen="delete from Personal where clvdts="+clave+" and clvcon="+clvrel+";";
        }
        else if(tipoRel==2){
            if(!conservarPers){
                sen="select count(*) from ExpTiene where clvdts="+clave+" and clvexp<>"+clvrel+";";
                aux=BaseDatos.ConsultasBD.consultaEntero(sen);
                conservarPers=(aux>0);
            }
            sen="delete from ExpTiene where clvdts="+clave+" and clvexp="+clvrel+";";
        }
        else if(tipoRel==3){
            if(!conservarPers){
                sen="select count(*) from Asistentes where clvdts="+clave+" and clvcon<>"+clvrel+";";
                aux=BaseDatos.ConsultasBD.consultaEntero(sen);
                conservarPers=(aux>0);
            }
            sen="delete from Asistentes where clvdts="+clave+" and clvcon="+clvrel+";";
        }
        comandos.add(sen);
        if(!conservarPers)
            comandos.add("delete from DtsPers where clvdts="+clave+";");
        return comandos;
    }
    
    /** Verifica si el registro de una persona existe relacionado con otra tabla diferente
     *   de la tabla indicada en el parametro tablaBase (Ver garfico de modelo relacional)
     * @param tablaBase valor de la tabla en la cual se desea eliminar
     *   donde: 1=Staff 2=Exponente, 3=Asistente congreso
     * @param cdp clave de datos personales
     * @return true si existe en otra tabla ademas de la tablaBase false en caso contrario
     */
    private static boolean existeEnOtraTabla(int tablaBase, int cdp){
        String[] tablas={"Personal","ExpTiene","Asistentes"};
        boolean existe=false;
        int aux;
        tablaBase-=1;
        for(int g=0;g<tablas.length;g++){
            if(g!=tablaBase){
                aux=BaseDatos.ConsultasBD.consultaEntero("select count(*) from "+tablas[g]+" where clvdts="+cdp+";");
                existe=(existe||(aux>0));
            }
        }
        return existe;
    }
    
    /** Elabora los comandos para borrar el registro de un evento segun su clave y el congreso 
     *   al cual este relacionada (Ver garfico de modelo relacional)
     * @param clave La clave del evento 
     * @param clvcon La clave del congreso al que pertenece 
     * @return Una lista de comandos delete correspondientes al evento correspondinte al parametro clave
     */
    public static java.util.ArrayList<String> getComBorrarEvento(int clave, int clvcon){
        java.util.ArrayList<String> comandos;
        comandos= new java.util.ArrayList<String>();
        String sen;
        sen="delete from Eventos where ClvEven="+clave+";";
        comandos.add(sen);
        sen="delete from Planea where ClvEven="+clave+" and  ClvCon="+clvcon+";";
        comandos.add(sen);
        sen="delete from ExpEve where ClvEven="+clave+";";
        comandos.add(sen);
        return comandos;
    }

}
