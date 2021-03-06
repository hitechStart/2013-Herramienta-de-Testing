/*
 * MainControls.java
 *   JPanel que contiene los controles generales y de congresos
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

package Guis.Sistema;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * @author  Pedro Cardoso Rodriguez
 */
public class MainControls extends javax.swing.JPanel implements ActionListener{
    
    private BasicArrowButton btnDisplay;
    private int orientacion; // lugar del boton 
      // 1=este, 2=sur 3=oeste 4=norte
    private int abierto;
    private int cerrado;
    private javax.swing.JPanel pnlContZero;
    private DatosControls datoscontrols;
    private SisControls siscontrols;
    
    /** Creates new form DisplayBar */
    public MainControls() {
        initComponents();
        pnlContZero= new javax.swing.JPanel();
        java.awt.GridBagConstraints gblConst=new java.awt.GridBagConstraints();
        java.awt.GridBagLayout gblLayer=(java.awt.GridBagLayout)pnlContainer.getLayout();
        pnlContZero.setLayout(new java.awt.BorderLayout());
        pnlContZero.add(pnlContainer, java.awt.BorderLayout.NORTH);
        jscContainer.setViewportView(pnlContZero);
        btnDisplay=new BasicArrowButton(SwingConstants.WEST);
        btnDisplay.addActionListener(this);
        btnDisplay.setToolTipText("Mostrar barra de controles");
        siscontrols=new SisControls();
        siscontrols.setColor(new Color(205,226,252),new Color(188,215,251),new Color(223,232,254),new Color(150,199,255),new Color(170,220,249),new Color(155,255,255));
        datoscontrols=new DatosControls();
        datoscontrols.setColor(new Color(205,226,252),new Color(188,215,251),new Color(223,232,254),new Color(150,199,255),new Color(170,220,249),new Color(155,255,255));
        gblConst.fill=java.awt.GridBagConstraints.HORIZONTAL;
        gblConst.insets= new java.awt.Insets(4,2,0,2);
        gblConst.anchor=java.awt.GridBagConstraints.NORTH;
        gblConst.gridx=0; gblConst.gridy=0;
        gblLayer.setConstraints(siscontrols, gblConst);
        pnlContainer.add(siscontrols);
        gblConst.gridy=1;
        gblLayer.setConstraints(datoscontrols, gblConst);
        pnlContainer.add(datoscontrols);
    }
    
    /** Ordena revisar si actualmente hay conexion con  el servidor de base de datos
     */
    public void checkConn(){
        siscontrols.checkConn();
    }
    
    /** Actualiza la lista de congresos actuales
     */
    public void recargaListaCons(){
        datoscontrols.cargaCongresos();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        jscContainer = new javax.swing.JScrollPane();

        pnlContainer.setLayout(new java.awt.GridBagLayout());

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());
        add(jscContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseEntered
    
    /** Establece el lugar del boton de despliege
     * @param orientacion 1=este, 2=sur 3=oeste 4=norte
     */
    public void setOrientacion(int orientacion){
        boolean cerr = (btnDisplay.getDirection()==cerrado);
        if(orientacion<1||orientacion>4) return;
        this.orientacion=orientacion;
        remove(btnDisplay);
        if(orientacion==1){ 
            add(btnDisplay,java.awt.BorderLayout.EAST);
            abierto=SwingConstants.WEST;
            cerrado=SwingConstants.EAST;
        }
        else if(orientacion==2){ 
            add(btnDisplay,java.awt.BorderLayout.SOUTH);
            abierto=SwingConstants.NORTH;
            cerrado=SwingConstants.SOUTH;
        }
        else if(orientacion==3){ 
            add(btnDisplay,java.awt.BorderLayout.WEST);
            abierto=SwingConstants.EAST;
            cerrado=SwingConstants.WEST;
        }
        else if(orientacion==4){ 
            add(btnDisplay,java.awt.BorderLayout.NORTH);
            abierto=SwingConstants.SOUTH;
            cerrado=SwingConstants.NORTH;
        }
        btnDisplay.setDirection(cerr?cerrado:abierto);
    }
    
    public void setColor(Color body, Color button, Color toolTip){
        pnlContainer.setBackground(body);
        pnlContZero.setBackground(body);
        btnDisplay.setBackground(button);
        btnDisplay.createToolTip().setBackground(toolTip);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jscContainer;
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        if(btnDisplay.getDirection()==cerrado){
            jscContainer.setVisible(true);
            btnDisplay.setDirection(abierto);
        }
        else{
            jscContainer.setVisible(false);
            btnDisplay.setDirection(cerrado);
        }
        getParent().validate();
    }
    
}
