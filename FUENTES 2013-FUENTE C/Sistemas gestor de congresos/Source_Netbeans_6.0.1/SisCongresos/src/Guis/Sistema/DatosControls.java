/*
 * DatosControls.java
 *   JPanel contenedor de controles correspondientes a los congresos existentes
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

import com.guis.SimpleButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;

/**
 * @author  Pedro Cardoso Rodriguez
 */
public class DatosControls extends JPanel implements ActionListener{
    
    private BasicArrowButton btnDisplay;
    private ArrayList<SimpleButton> btnsCongresos;
    
    /** Creates new form BeanForm */
    public DatosControls() {
        initComponents();
        btnDisplay=new BasicArrowButton(SwingConstants.WEST);
        btnDisplay.setActionCommand("-1");
        btnDisplay.addActionListener(this);
        btnDisplay.setToolTipText("Desplegar "+lblTitle.getText());
        btnDisplay.setDirection(SwingConstants.NORTH);
        pnlNorth.add(btnDisplay,java.awt.BorderLayout.EAST);
        btnNuevo.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnNuevo.addActionListener(this);
        btnNuevo.setDescrip("Nuevo");
        btnsCongresos=new ArrayList<SimpleButton>();
        if(BaseDatos.ConectaBD.hayConexion()) cargaCongresos();
        setTitle("Congresos","Lista de registros existentes");
    }
    
    public void setTitle(String tit, String contentReference){
        lblTitle.setText(tit);
        btnDisplay.setToolTipText("Desplegar "+tit);
        lblTitle.setToolTipText(contentReference);
    }
   
    /** Carga la lista de congresos registrado en la bd y crea un boton para cada 
     *   congreso registrado
     */
    public void cargaCongresos(){
        SimpleButton btnCongreso;
        java.awt.GridBagLayout gbl=((java.awt.GridBagLayout)pnlContainer.getLayout());
        java.awt.GridBagConstraints gbc=new java.awt.GridBagConstraints();
        String aux;
        DefaultTableModel tabla;
        tabla=BaseDatos.ConsultasBD.consTipoTable("select clvcon,titcon from congresos order by titcon;");
        if(tabla==null){
            aux="<html>Error al tratar de consultar los registros existentes<br>"+BaseDatos.ConsultasBD.getError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return;
        }
        btnsCongresos.clear();
        pnlContainer.removeAll();
        gbc.gridx=0; gbc.gridy=0; gbc.anchor=java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(0, 0, 5, 0);
        gbl.setConstraints(btnNuevo, gbc);
        pnlContainer.add(btnNuevo,gbc);
        if(tabla.getRowCount()==0) return;
        for(int h=0;h<tabla.getRowCount();h++){
            btnCongreso=new SimpleButton();
            aux=""+tabla.getValueAt(h,1);
            btnCongreso.setText(cortaName(aux));
            btnCongreso.setDescrip(aux);
            btnCongreso.setActionCommand(""+tabla.getValueAt(h,0));
            gbc.gridy=(h+1);
            gbl.setConstraints(btnCongreso, gbc);
            btnCongreso.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
            btnCongreso.addActionListener(this);
            pnlContainer.add(btnCongreso);
            btnsCongresos.add(btnCongreso);
        }
        validate();
    }
    
    /** Corta el nombre de un congreso si este es demasiado largo para 
     *   el texto del boton correspondiente a ese congreso
     * @param name El nombre a "cortar"
     * @return El nombre "cortado" por medio de saltos tipo <br> para utilizar como etiqueta html
     */
    private String cortaName(String name){
        String newName=name;
        String word;
        int aux;
        java.util.StringTokenizer toks = new java.util.StringTokenizer(name);
        if(name.length()>18){
            word=toks.nextToken();
            newName="<html>"+word;
            aux=word.length();
            while(toks.hasMoreTokens()){
                word=toks.nextToken();
                if(aux+word.length()<=17){
                    newName+=" "+word;
                    aux+=word.length();
                }
                else{
                    newName+="<br>"+word;
                    aux=word.length();
                }
            }
            newName+="</html>";
        }
        return newName;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlNorth = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();
        btnNuevo = new com.guis.SimpleButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        pnlNorth.setLayout(new java.awt.BorderLayout());

        lblTitle.setText("Title");
        pnlNorth.add(lblTitle, java.awt.BorderLayout.CENTER);

        add(pnlNorth, java.awt.BorderLayout.NORTH);

        pnlContainer.setLayout(new java.awt.GridBagLayout());

        btnNuevo.setText("Crear registro");
        btnNuevo.setActionCommand("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlContainer.add(btnNuevo, gridBagConstraints);

        add(pnlContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseEntered
    
    public void setColor(Color back,Color titleBar,Color body,Color borderColor,Color btnVerColor,Color toolTip){
        setBackground(back);
        pnlNorth.setBackground(titleBar);
        pnlContainer.setBackground(body);
        btnDisplay.setBackground(btnVerColor);
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11),borderColor));
        this.createToolTip().setBackground(toolTip);
        btnDisplay.createToolTip().setBackground(toolTip);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.guis.SimpleButton btnNuevo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlNorth;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        int actionCom=Integer.parseInt(e.getActionCommand());
        if(e.getSource() instanceof SimpleButton){
            String nom=((SimpleButton)e.getSource()).getDescrip();
            ((Ventana)getTopLevelAncestor()).cargaCongreso(actionCom,nom);
        }
        if(actionCom==-1){
            if(btnDisplay.getDirection()==SwingConstants.SOUTH){
                pnlContainer.setVisible(true);
                btnDisplay.setDirection(SwingConstants.NORTH);
            }
            else{
                pnlContainer.setVisible(false);
                btnDisplay.setDirection(SwingConstants.SOUTH);
            }
            getTopLevelAncestor().validate();
            return;
        }
    }
    
}
