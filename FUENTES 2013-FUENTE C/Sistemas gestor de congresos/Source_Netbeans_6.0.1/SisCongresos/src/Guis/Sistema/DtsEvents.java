/*
 * DtsEvents.java
 *   JPanel que contiene la tabla con los registros de eventos del congreso actual
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

import BaseDatos.FunsComms;
import Logica.OprsDts;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;

/**
 * @author  Pedro Cardoso Rodriguez
 */
public class DtsEvents extends JPanel implements ActionListener, TableModelListener{
    
    private ContDatos contenedor; // referencia al contenedor superior
    private BasicArrowButton btnDisplay;
    private boolean hayCambios;
    
    /** Creates new form BeanForm */
    public DtsEvents(ContDatos contenedor) {
        initComponents();
        this.contenedor=contenedor;
        btnDisplay=new BasicArrowButton(SwingConstants.WEST);
        btnDisplay.addActionListener(this);
        btnDisplay.setToolTipText("Desplegar "+lblTitle.getText());
        btnDisplay.setDirection(SwingConstants.NORTH);
        pnlNorth.add(btnDisplay,java.awt.BorderLayout.EAST);
        btnAgrega.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnQuita.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnGuarda.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnImprime.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnToCSV.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        iniModelo(); hayCambios=false;
    }
    
    public void setTitle(String tit, String contentReference){
        lblTitle.setText(tit);
        btnDisplay.setToolTipText("Desplegar "+tit);
        lblTitle.setToolTipText(contentReference);
    }
    
    private void iniModelo(){
        java.util.Vector cols=new java.util.Vector();
        cols.add("clveven"); cols.add("Titulo"); cols.add("Tema");
        cols.add("Fecha y Hora"); cols.add("Tipo de evento");
        jtbTabla.setModel(new ModeloEvents((DefaultTableModel)jtbTabla.getModel(),cols));
        ocultaColumna("clveven");
        jtbTabla.getColumn("Titulo").setPreferredWidth(170);
        jtbTabla.getColumn("Tema").setPreferredWidth(220);
        jtbTabla.getColumn("Fecha y Hora").setPreferredWidth(120);
        jtbTabla.getColumn("Tipo de evento").setPreferredWidth(260);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNorth = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();
        btnAgrega = new com.guis.SimpleButton();
        btnQuita = new com.guis.SimpleButton();
        btnGuarda = new com.guis.SimpleButton();
        btnToCSV = new com.guis.SimpleButton();
        btnImprime = new com.guis.SimpleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTabla = new javax.swing.JTable();

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

        btnAgrega.setText("Agregar");
        btnAgrega.setToolTipText("Agregar un nuevo evento");
        btnAgrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaActionPerformed(evt);
            }
        });

        btnQuita.setText("Quitar");
        btnQuita.setToolTipText("Quitar evento(s)  seleccionado(s) de la tabla");
        btnQuita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitaActionPerformed(evt);
            }
        });

        btnGuarda.setText("Guardar");
        btnGuarda.setToolTipText("Guardar los datos actuales de eventos");
        btnGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaActionPerformed(evt);
            }
        });

        btnToCSV.setText("Exportar a CSV");
        btnToCSV.setToolTipText("<html>Exportar la tabla actual a archivo CSV<br>(Para abrir desde Excel)</html>");
        btnToCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToCSVActionPerformed(evt);
            }
        });

        btnImprime.setText("Imprimir");
        btnImprime.setToolTipText("Imprimir la tabla actual de eventos");
        btnImprime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimeActionPerformed(evt);
            }
        });

        jtbTabla.setAutoCreateRowSorter(true);
        jtbTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "Titulo", "Tema", "Fecha y hora", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jtbTabla);
        jtbTabla.getColumnModel().getColumn(0).setHeaderValue(null);
        jtbTabla.getColumnModel().getColumn(1).setPreferredWidth(250);
        jtbTabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        jtbTabla.getColumnModel().getColumn(3).setPreferredWidth(110);
        jtbTabla.getColumnModel().getColumn(4).setPreferredWidth(100);

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addComponent(btnAgrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnToCSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToCSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseEntered

    private void btnAgregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaActionPerformed
        int clvcong=contenedor.getClave();
        String aux;
        ModeloEvents modelo;
        if(clvcong<1){
            aux="<html>Primero debe guardar los datos generales del congreso<br> Para poder agregar eventos</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return;
        }
        modelo=((ModeloEvents)jtbTabla.getModel());
        modelo.addRow(new Object[]{"-1","","","","",});
        modelo.addTableModelListener(this);
        jtbTabla.setModel(modelo); hayCambios=true;
}//GEN-LAST:event_btnAgregaActionPerformed

    private void btnQuitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitaActionPerformed
        java.util.ArrayList<String> coms;
        java.util.ArrayList<String> com;
        int[] filas=jtbTabla.getSelectedRows();
        int clave;
        String aux;
        if(filas.length<=0) return;
        aux="<html>En verdad desea quitar los eventos seleccionados de la tabla<br>";
        aux+="Esta accion no se podra deshacer<br>¿Desea continuar?</html>";
        if(!((Ventana)getTopLevelAncestor()).askYesNoOption(aux)) return;
        coms=new java.util.ArrayList<String>();
        for(int f=0;f<filas.length;f++){
            clave=Integer.parseInt(""+jtbTabla.getValueAt(filas[f],0));
            com=FunsComms.getComBorrarEvento(clave,contenedor.getClave());
            for(int g=0;g<com.size();g++) coms.add(com.get(g));
        }
        if(BaseDatos.InsUpdBD.transaccion(coms)){
            actualizaLista(); contenedor.actuEventos();
            aux="<html>Accion realizada<br>Se quitaron los eventos seleccionadas</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.INF_MESS);
        }
        else{
            aux="<html>Error al intertar realizar la accion:<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
        }
    }//GEN-LAST:event_btnQuitaActionPerformed

    /** Guarda los cambios realizados en los datos de la tabla
     * @return true si se pudieron guardar lo cambios false en caso contrario
     */
    public boolean guardaCambios(){
        java.util.ArrayList<String> coms;
        String aux;
        String[] dts;
        int clvtemp;
        if(contenedor.getClave()<1){
            aux="<html>Primero debe guardar los datos generales del congreso<br> Para poder guardar eventos</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return false;
        }
        aux=hayDatoInvalido();
        if(aux!=null){
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return false;
        }
        coms=new java.util.ArrayList<String>();
        for(int f=0;f<jtbTabla.getRowCount();f++){ // guardar nuevos
            if(Integer.parseInt(""+jtbTabla.getValueAt(f,0))==-1){
                clvtemp=guardaFila(f);
                if(clvtemp==-1) return false;
                jtbTabla.setValueAt(""+clvtemp,f,0);
            }
            else{
                dts=getDatos(f,true);
                dts[3]=OprsDts.transformatFchaHora(dts[3],false);
                aux="update Eventos set TitEven='"+dts[1]+"',TemaEven='"+dts[2]+"',FechaYHora='";
                aux+=dts[3]+"',TipoEven='"+dts[4]+"' where ClvEven="+dts[0]+";";
                coms.add(aux);
            }
        }
        if(coms.size()>0){
            if(!BaseDatos.InsUpdBD.transaccion(coms)){ // hacer update de todo
                aux="<html>Error al intertar realizar la accion:<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
                ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
                return false;
            }
        }
        aux="<html>Accion realizada<br>Se guardo la tabla de eventos</html>";
        ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.INF_MESS);
        contenedor.actuEventos();
        hayCambios=false; return true;
    }
    
    private void btnGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaActionPerformed
        guardaCambios();
    }//GEN-LAST:event_btnGuardaActionPerformed

    private void btnToCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToCSVActionPerformed
        if(jtbTabla.getRowCount()==0){
            ((Ventana)getTopLevelAncestor()).message("<html>No se puede exportar<br>La tabla esta vacia</html>",DialogMessages.ERROR_MESS);
            return;
        }
        ((Ventana)getTopLevelAncestor()).exportTablaToCSV(2,jtbTabla.getModel());
    }//GEN-LAST:event_btnToCSVActionPerformed

    private void btnImprimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimeActionPerformed
        Map<String,String> parametros = new HashMap<String,String>();
        ArrayList campos=new ArrayList();
        CamposReport.CamposEvento campo;
        String aux;
        if(jtbTabla.getRowCount()==0){
            ((Ventana)getTopLevelAncestor()).message("<html>No se puede imprimir<br>La tabla esta vacia</html>",DialogMessages.ERROR_MESS);
            return;
        }
        parametros.put("TITCONG",contenedor.getTitCon());
        parametros.put("TEMACONG",contenedor.geTemaCon());
        parametros.put("PERIODOCONG",contenedor.getPerCon());
        for(int s=0;s<jtbTabla.getRowCount();s++){
            aux=""+jtbTabla.getValueAt(s,3);
            campo=new CamposReport.CamposEvento(""+jtbTabla.getValueAt(s,1),""+jtbTabla.getValueAt(s,2),aux);
            campos.add(campo);
        }
        ((Ventana)getTopLevelAncestor()).sendToPrint("Tabla de Eventos",2,parametros,campos);
    }//GEN-LAST:event_btnImprimeActionPerformed
    
    /** Revisa si hay algun dato invalido en la tabla
     * @return Cadena con la descripcion del dato invalido o null si todos los datos son validos
     */
    private String hayDatoInvalido(){
        String[] datos;
        for(int x=0;x<jtbTabla.getRowCount();x++){
            datos=getDatos(x,true);
            if(datos[1].length()<1||datos[1].length()>125)
                return "<html>Hay datos invalidos en Eventos<br>En fila: "+(x+1)+", <font color=\"RED\">Titulo</font> invalido, longitud invalida</html>";
            if(datos[2].length()<1||datos[2].length()>125)
                return "<html>Hay datos invalidos en Eventos<br>En fila: "+(x+1)+", <font color=\"RED\">Tema</font> invalido, longitud invalida</html>";
            if(!OprsDts.valFechaYHora(datos[3]))
                return "<html>Hay datos invalidos en Eventos<br>En fila: "+(x+1)+", <font color=\"RED\">Fecha y Hora</font> invalidos, Debe ser formato DD-MM-YYYY HH:MM<br>Y los valores deben ser validos</html>";
            if(datos[4].length()<1||datos[4].length()>125)
                return "<html>Hay datos invalidos en Eventos<br>En fila: "+(x+1)+", <font color=\"RED\">Tipo evento</font> invalido, longitud invalida</html>";
        }
        return null;
    }
    
    /** Guarda los datos de una fila de la tabla (para filas nuevas sin clave)
     * @param fila el numero de la fila a guardar
     * @return true si los datos se guardaron false en caso contrario
     */
    private int guardaFila(int fila){
        int intAux;
        String[] dts=getDatos(fila,false);
        String sen;
        dts[2]=OprsDts.transformatFchaHora(dts[2],false);
        if(!BaseDatos.InsUpdBD.nuevoEvento(dts)){
            sen="<html>Error al intentar guardar datos de fila: "+(fila+1)+"<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return -1;
        }
        intAux=BaseDatos.InsUpdBD.obtenClave();
        sen="insert into Planea values("+contenedor.getClave()+","+intAux+");";
        if(!BaseDatos.InsUpdBD.actualiza(sen)){
            BaseDatos.InsUpdBD.actualiza("delete from Eventos where ClvEven="+intAux+";");
            sen="<html>Error al intentar guardar datos de fila: "+(fila+1)+"<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return -1;
        }
        return intAux;
    }
    
    /** Obtiene los datos de evento de una fila de la tabla
     * @param fila numero de fila de la tabla de la cual obtener los datos
     * @param conClave si es true incluye la clave del congreso en el vetor
     * @return los datos obtenidos segun fila y conClave
     */
    private String[] getDatos(int fila, boolean conClave){
        String[] datos=new String[jtbTabla.getColumnCount()-(conClave?0:1)];
        for(int c=(conClave?0:1);c<jtbTabla.getColumnCount();c++){
            datos[c-(conClave?0:1)]=""+jtbTabla.getValueAt(fila,c);
        }
        return datos;
    }
    
    public void setColor(Color back,Color titleBar,Color body,Color borderColor,Color btnVerColor,Color toolTip){
        setBackground(back);
        pnlNorth.setBackground(titleBar);
        pnlContainer.setBackground(body);
        btnDisplay.setBackground(btnVerColor);
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11),borderColor));
        this.createToolTip().setBackground(toolTip);
        btnDisplay.createToolTip().setBackground(toolTip);
    }
    
    /** Carga los datos de la tabla
     * @return true si los datos se cargaron correctamente false en caso contrario
     */
    public boolean cargaDatos(){
        return actualizaLista();
    }
    
    /** Actualiza los datos de la tabla
     * @return true si los datos se actualizaron correctamente false en caso contrario
     */
    private boolean actualizaLista(){
        DefaultTableModel modelo;
        ModeloEvents modelo2;
        java.util.Vector cols=new java.util.Vector();
        String sen="select Eventos.clveven,TitEven as 'Titulo',temaeven as 'Tema',";
        sen+="fechayhora as 'Fecha y Hora',tipoEven as 'Tipo de evento' from Eventos";
        sen+=",Planea where Eventos.clveven=planea.clveven and clvcon="+contenedor.getClave();
        sen+=" order by fechayhora;";
        cols.add("clveven"); cols.add("Titulo"); cols.add("Tema");
        cols.add("Fecha y Hora"); cols.add("Tipo de evento");
        modelo=BaseDatos.ConsultasBD.consTipoTable(sen);
        if(modelo==null){
            sen="<html>Error al intentar actualizar la tabla de eventos"+BaseDatos.ConsultasBD.getError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return false;
        }
        modelo2=new ModeloEvents(modelo,cols);
        modelo2.addTableModelListener(this);
        jtbTabla.setModel(modelo2);
        (jtbTabla.getTableHeader()).setReorderingAllowed(false);
        ocultaColumna("clveven"); hayCambios=false;
        jtbTabla.getColumn("Titulo").setPreferredWidth(170);
        jtbTabla.getColumn("Tema").setPreferredWidth(220);
        jtbTabla.getColumn("Fecha y Hora").setPreferredWidth(120);
        jtbTabla.getColumn("Tipo de evento").setPreferredWidth(260);
        return true;
    }
    
    /** Oculta una columna de la tabla
     * @param nomCol El nombre de la columna a ocultar
     */
    private void ocultaColumna(String nomCol){
        jtbTabla.getColumn(nomCol).setPreferredWidth(0);
        jtbTabla.getColumn(nomCol).setMinWidth(0);
        jtbTabla.getColumn(nomCol).setMaxWidth(0);
        jtbTabla.getColumn(nomCol).setResizable(false);
    }
    
    /** Obtiene los comandos de borrado de registros para los datos de la tabla
     * @return los comandos de borrado de registros para los datos de la tabla
     */
    public java.util.ArrayList<String> getComsDelete(){
        java.util.ArrayList<String> coms;
        int clave;
        coms=new java.util.ArrayList<String>();
        for(int y=0;y<jtbTabla.getRowCount();y++){
            clave=Integer.parseInt(""+jtbTabla.getValueAt(y,0));
            coms.add("delete from eventos where clveven="+clave+";");
            coms.add("delete from planea where clveven="+clave+";");
            coms.add("delete from expeve where clveven="+clave+";");
        }
        return coms;
    }
    
    /** Obtiene si hay cambios en los datos de la tabla sin guardar
     * @return true si hay cambios en los datos de la tabla sin guardar false en caso contrario
     */
    public boolean hayCambios(){
        return hayCambios;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.guis.SimpleButton btnAgrega;
    private com.guis.SimpleButton btnGuarda;
    private com.guis.SimpleButton btnImprime;
    private com.guis.SimpleButton btnQuita;
    private com.guis.SimpleButton btnToCSV;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbTabla;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlNorth;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        if(btnDisplay.getDirection()==SwingConstants.SOUTH){
            pnlContainer.setVisible(true);
            btnDisplay.setDirection(SwingConstants.NORTH);
        }
        else{
            pnlContainer.setVisible(false);
            btnDisplay.setDirection(SwingConstants.SOUTH);
        }
        this.getTopLevelAncestor().validate();
    }

    public void tableChanged(TableModelEvent e) {
        hayCambios=true;
    }
    
    /** Clase con la definicion del modelo de datos de la tabla */
    private class ModeloEvents extends DefaultTableModel{
        
        public ModeloEvents(DefaultTableModel m,java.util.Vector cols){
            super(m.getDataVector(),cols);
        }
        
        @Override
        public boolean isCellEditable(int row, int col){
            return (col>0);
        }
    }
}
