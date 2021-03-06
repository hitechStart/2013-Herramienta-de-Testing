/*
 * ContDatos.java
 *   JPanel contenedor de todos los datos de registros correspondientes a un congreso
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


/**
 * @author  Pedro Cardoso Rodriguez
 */
public class ContDatos extends javax.swing.JPanel {
    
    private int clvCon; // clave del congreso actual
    private DtsGrls datosgenerales; 
    private DtsStaff datosstaff;
    private DtsEvents datoseventos;
    private DtsExps datosexps;
    private DtsAsis datosasis;
    
    /** Creates new form ContDatos */
    public ContDatos() {
        initComponents();
        java.awt.GridBagConstraints gblConst=new java.awt.GridBagConstraints();
        java.awt.GridBagLayout gblLayer=(java.awt.GridBagLayout)pnlContainer.getLayout();
        btnGuardarTodo.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        datosgenerales = new DtsGrls(this);
        datosgenerales.setColor(new Color(205,226,252),new Color(188,215,251),new Color(223,232,254),new Color(150,199,255),new Color(170,220,249),new Color(155,255,255));
        gblConst.fill=java.awt.GridBagConstraints.HORIZONTAL;
        gblConst.insets= new java.awt.Insets(4,2,0,2);
        gblConst.anchor=java.awt.GridBagConstraints.NORTH;
        gblConst.gridx=0; gblConst.gridy=1;
        gblLayer.setConstraints(datosgenerales, gblConst);
        datosgenerales.setTitle("Datos generales","Datos generales");
        pnlContainer.add(datosgenerales);
        datosstaff=new DtsStaff(this);
        datosstaff.setColor(new Color(205,226,252),new Color(188,215,251),new Color(223,232,254),new Color(150,199,255),new Color(170,220,249),new Color(155,255,255));
        datosstaff.setTitle("Personal (Staff)","Lista de personal");
        gblConst.gridy=2;
        gblLayer.setConstraints(datosstaff, gblConst);
        pnlContainer.add(datosstaff);
        datoseventos=new DtsEvents(this);
        datoseventos.setColor(new Color(205,226,252),new Color(188,215,251),new Color(223,232,254),new Color(150,199,255),new Color(170,220,249),new Color(155,255,255));
        datoseventos.setTitle("Eventos","Lista de eventos programados");
        gblConst.gridy=3;
        gblLayer.setConstraints(datoseventos, gblConst);
        pnlContainer.add(datoseventos);
        datosexps=new DtsExps(this);
        datosexps.setColor(new Color(205,226,252),new Color(188,215,251),new Color(223,232,254),new Color(150,199,255),new Color(170,220,249),new Color(155,255,255));
        datosexps.setTitle("Ponentes y sus trabajos","Lista de ponentes");
        gblConst.gridy=4;
        gblLayer.setConstraints(datosexps, gblConst);
        pnlContainer.add(datosexps);
        datosasis=new DtsAsis(this);
        datosasis.setColor(new Color(205,226,252),new Color(188,215,251),new Color(223,232,254),new Color(150,199,255),new Color(170,220,249),new Color(155,255,255));
        datosasis.setTitle("Asistentes","Lista de asistentes");
        gblConst.gridy=5;
        gblLayer.setConstraints(datosasis, gblConst);
        pnlContainer.add(datosasis);
        clvCon=0;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspCont = new javax.swing.JScrollPane();
        pnlContZero = new javax.swing.JPanel();
        pnlContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnGuardarTodo = new com.guis.SimpleButton();

        setLayout(new java.awt.BorderLayout());

        pnlContZero.setBackground(new java.awt.Color(200, 223, 253));
        pnlContZero.setLayout(new java.awt.BorderLayout());

        pnlContainer.setBackground(new java.awt.Color(200, 223, 253));
        pnlContainer.setLayout(new java.awt.GridBagLayout());
        pnlContZero.add(pnlContainer, java.awt.BorderLayout.CENTER);

        jspCont.setViewportView(pnlContZero);

        add(jspCont, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(200, 223, 253));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 16));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Titulo");

        btnGuardarTodo.setText("Guardar Todo");
        btnGuardarTodo.setToolTipText("Guardar cambios en todas las areas");
        btnGuardarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarTodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTodoActionPerformed
        if(datosgenerales.hayCambios()){
            if(!datosgenerales.guardaCambios()) return;
        }
        if(datosstaff.hayCambios()){
            if(!datosstaff.guardaCambios()) return;
        }
        if(datosexps.hayCambios()){
            if(!datosexps.guardaCambios()) return;
        }
        if(datosasis.hayCambios()){
            if(!datosasis.guardaCambios()) return;
        }
        if(datoseventos.hayCambios()){
            if(!datoseventos.guardaCambios()) return;
        }
}//GEN-LAST:event_btnGuardarTodoActionPerformed
    
    /** Carga un congreso desde la base de datos
     * @param clave la clave del congreso a cargar
     * @param nomCon el nombre del congreso a cargar
     * @return true si el congreso se cargo correctamente false en caso contrario
     */
    public boolean cargaCongreso(int clave,String nomCon){
        String aux;
        if(clave==0){
            lblTitle.setText("Nuevo registro de congreso");
            return true;
        }
        if(!datosgenerales.cargaDatos(clave)){
            aux="<html>Error al tratar de consultar congreso:<br>"+nomCon+"<br>"+BaseDatos.ConsultasBD.getError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return false;
        }
        clvCon=clave;
        datosgenerales.setTitle("Datos generales "+nomCon,"Datos generales del congreso");
        if(!datosstaff.cargaDatos()) return false;
        datosstaff.setTitle("Personal (Staff) "+nomCon,"Lista de personal (Staff)");
        if(!datoseventos.cargaDatos()) return false;
        datoseventos.setTitle("Eventos "+nomCon,"Lista de eventos programados");
        datosexps.actualizaEventos();
        if(!datosexps.cargaDatos()) return false;
        datosexps.setTitle("Ponentes y sus trabajos "+nomCon,"Lista de ponentes y sus trabajos");
        if(!datosasis.cargaDatos()) return false;
        datosasis.setTitle("Asistentes "+nomCon,"Lista de asistentes al congreso y por eventos");
        lblTitle.setText(nomCon);
        return true;
    }
    
    /** Manda actualizar la lista de eventos en las tablas de ponentes y de asistentes
     */
    public void actuEventos(){
        datosexps.actualizaEventos();
        datosasis.cargaDatos();
    }
    
    /** Establece la clave del congreso actual
     * @param clv la clave a establecer como correspondiente al congreso actual
     */
    public void setClave(int clv){ clvCon=clv; }
  
    /** Obtiene la clave del congreso actual
     * @return la clave del congreso actual
     */
    public int getClave(){ return clvCon; }
    
    /** Elimina de la bd el congreso actual
     */
    public void eliminaCongreso(){
        boolean proceder;
        java.util.ArrayList<String> comandos;
        java.util.ArrayList<String> coms;
        String aux;
        if(clvCon==0){
            aux="<html>No se puede realizar la accion:<br>El registro actual no se ha guardado aun</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.INF_MESS);
            return;
        }
        aux="<html>Eliminar registro <u>"+datosgenerales.getTitCon()+"</u><br>Se eliminaran todos los datos relacionados:";
        aux+="<br>Personal, Eventos, Ponentes y sus trabajos, Asistentes<br>¿Desea proceder?</html>";
        proceder=((Ventana)getTopLevelAncestor()).askYesNoOption(aux);
        if(!proceder) return;
        comandos= new java.util.ArrayList<String>();
        comandos.add("delete from congresos where clvcon="+clvCon+";");
        coms=datosstaff.getComsDelete();
        for(int f=0;f<coms.size();f++) comandos.add(coms.get(f));
        coms=datoseventos.getComsDelete();
        for(int f=0;f<coms.size();f++) comandos.add(coms.get(f));
        coms=datosexps.getComsDelete();
        for(int f=0;f<coms.size();f++) comandos.add(coms.get(f));
        coms=datosasis.getComsDelete();
        for(int f=0;f<coms.size();f++) comandos.add(coms.get(f));
        if(BaseDatos.InsUpdBD.transaccion(comandos)){
            aux="delete from dtspers where clvdts not in (select clvdts from asistentes) and clvdts ";
            aux+="not in (select clvdts from personal) and clvdts not in (select clvdts from exptiene);";
            BaseDatos.InsUpdBD.actualiza(aux);
            aux="<html>Accion realizada<br>Se elimino todo el registro</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.INF_MESS);
            ((Ventana)getTopLevelAncestor()).quitaCongreso(clvCon);
        }
        else{
            aux="<html>Error al intertar realizar la accion:<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
        }
    }
    
    /** Indica si hay cambios sin guardar
     * @return Si hay cambios sin guardar regresa una string (con saltos <br> para 
     *   insertar en una label html)indicando el nombre de este congreso y las areas 
     *   que hay cambios o si no hay cambios regresa null
     */
    public String hayCambios(){
        String cambios="En <font color=\"RED\">"+datosgenerales.getTitCon()+"</font><br>";
        if(datosgenerales.hayCambios()) cambios+=" * En Datos generales<br>";
        if(datosstaff.hayCambios()) cambios+=" * En Datos de personal<br>";
        if(datoseventos.hayCambios()) cambios+=" * En Lista de eventos<br>";
        if(datosexps.hayCambios()) cambios+=" * En Lista de ponentes<br>";
        if(datosasis.hayCambios()) cambios+=" * En Lista de asistentes<br>";
        return (cambios.endsWith("</font><br>")?null:cambios);
    }
   
    /** Obtiene el nombre del congreso actual
     * @return el nombre del congreso actual
     */
    public String getTitCon(){
        return datosgenerales.getTitCon();
    }
    
    /** Obtiene el tema del congreso actual
     * @return el tema del congreso actual
     */
    public String geTemaCon(){
        return datosgenerales.getTemaCon();
    }
    
    /** Obtiene el periodo en el cual se lleva a cabo el congreso actual
     * @return el periodo en el cual se lleva a cabo el congreso actual
     */
    public String getPerCon(){
        return datosgenerales.getPerCon();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.guis.SimpleButton btnGuardarTodo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jspCont;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlContZero;
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables
    
}
