/*
 * CamposEvento.java
 *   Para utilizar como elemento de campos para enviar a imprimir reportes
 *   de eventos de un congreso
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
public class CamposEvento {
    
    private String evento;
    private String tema;
    private String fechahour;
    
    public CamposEvento(String evento, String tema, String fechahour){
        this.evento=evento;
        this.tema=tema;
        this.fechahour=fechahour;
    }
    
    public String getEvento(){ return evento; }
    public String getTema(){ return tema; }
    public String getFechahour(){ return fechahour; }

}
