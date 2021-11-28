/*
 * CampoExps.java
 *   Para utilizar como elemento de campos para enviar a imprimir reportes
 *   de ponentes de un congreso
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

package CamposReport;

/**
 * @author Pedro Cardoso Rodriguez
 */
public class CampoExps {
    
    private String trabajo;
    private String nombre;
    private String evento;
    
    public CampoExps(String trabajo, String nombre, String evento){
        this.trabajo=trabajo;
        this.nombre=nombre;
        this.evento=evento;
    }
    
    public String getTrabajo(){ return trabajo; }
    public String getNombre(){ return nombre; }
    public String getEvento(){ return evento; }

}
