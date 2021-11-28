/*
 * DtsExps.java
 *   JPanel que contiene la tabla con los registros de ponentes del congreso actual
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
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 * @author  Pedro Cardoso Rodriguez
 */
public class DtsExps extends JPanel implements ActionListener, TableModelListener{
    
    private ContDatos contenedor; // referencia al contenedor superior
    private BasicArrowButton btnDisplay;
    private CeldaEditorJCombo celdaEves=null;
    private boolean hayCambios;
    private Evento noEve=new Evento(-1,"<No asignado>",null);
    
    /** Creates new form BeanForm */
    public DtsExps(ContDatos contenedor) {
        initComponents();
        this.contenedor=contenedor;
        btnDisplay=new BasicArrowButton(SwingConstants.WEST);
        btnDisplay.addActionListener(this);
        btnDisplay.setToolTipText("Desplegar "+lblTitle.getText());
        btnDisplay.setDirection(SwingConstants.NORTH);
        pnlNorth.add(btnDisplay,java.awt.BorderLayout.EAST);
        btnAgrega.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnQuita.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnImportar.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnGuarda.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnImprime.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        btnCSV.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        celdaEves=new CeldaEditorJCombo(); 
        jtbTabla.setDefaultEditor(Evento.class, celdaEves);
        jtbTabla.setRowHeight(22);
        iniModelo(); hayCambios=false;
    }
    
    public void setTitle(String tit, String contentReference){
        lblTitle.setText(tit);
        btnDisplay.setToolTipText("Desplegar "+tit);
        lblTitle.setToolTipText(contentReference);
    }
    
    private void iniModelo(){
        java.util.Vector cols=new java.util.Vector();
        cols.add("clv1"); cols.add("clv2"); cols.add("Nombre"); cols.add("A Paterno"); cols.add("A Materno"); 
        cols.add("Titulo del trabajo"); cols.add("Categoria"); cols.add("Tipo de trabajo"); cols.add("Individual");
        cols.add("Evento"); cols.add("Convocatoria enviada"); cols.add("Oficio enviado"); cols.add("Correo enviado");
        cols.add("Recibido"); cols.add("Trabajo aceptado"); cols.add("Asistencia confirmada"); cols.add("Acuse de recibo");
        cols.add("Ubicacion en memorias"); cols.add("Ubicacion en instalaciones"); cols.add("Observaciones");
        cols.add("Direccion"); cols.add("Ciudad"); cols.add("Estado"); cols.add("Tel Casa"); cols.add("Tel Oficina");
        cols.add("Tel Movil"); cols.add("Titulo Profecional"); cols.add("Correo Electronico");
        jtbTabla.setModel(new ModeloExp((DefaultTableModel)jtbTabla.getModel(),cols));
        ocultaColumna("clv1"); ocultaColumna("clv2");
        jtbTabla.getColumn("Nombre").setPreferredWidth(80);
        jtbTabla.getColumn("A Paterno").setPreferredWidth(80);
        jtbTabla.getColumn("A Materno").setPreferredWidth(80);
        jtbTabla.getColumn("Titulo del trabajo").setPreferredWidth(250);
        jtbTabla.getColumn("Categoria").setPreferredWidth(120);
        jtbTabla.getColumn("Tipo de trabajo").setPreferredWidth(120);
        jtbTabla.getColumn("Individual").setPreferredWidth(70);
        jtbTabla.getColumn("Evento").setPreferredWidth(160);
        jtbTabla.getColumn("Convocatoria enviada").setPreferredWidth(120);
        jtbTabla.getColumn("Oficio enviado").setPreferredWidth(100);
        jtbTabla.getColumn("Correo enviado").setPreferredWidth(100);
        jtbTabla.getColumn("Recibido").setPreferredWidth(80);
        jtbTabla.getColumn("Trabajo aceptado").setPreferredWidth(100);
        jtbTabla.getColumn("Asistencia confirmada").setPreferredWidth(120);
        jtbTabla.getColumn("Acuse de recibo").setPreferredWidth(100);
        jtbTabla.getColumn("Ubicacion en memorias").setPreferredWidth(150);
        jtbTabla.getColumn("Ubicacion en instalaciones").setPreferredWidth(160);
        jtbTabla.getColumn("Observaciones").setPreferredWidth(180);
        jtbTabla.getColumn("Direccion").setPreferredWidth(140);
        jtbTabla.getColumn("Ciudad").setPreferredWidth(80);
        jtbTabla.getColumn("Estado").setPreferredWidth(80);
        jtbTabla.getColumn("Tel Casa").setPreferredWidth(85);
        jtbTabla.getColumn("Tel Oficina").setPreferredWidth(85);
        jtbTabla.getColumn("Tel Movil").setPreferredWidth(85);
        jtbTabla.getColumn("Titulo Profecional").setPreferredWidth(120);
        jtbTabla.getColumn("Correo Electronico").setPreferredWidth(120);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTabla = new javax.swing.JTable();
        btnAgrega = new com.guis.SimpleButton();
        btnQuita = new com.guis.SimpleButton();
        btnGuarda = new com.guis.SimpleButton();
        btnImprime = new com.guis.SimpleButton();
        btnCSV = new com.guis.SimpleButton();
        btnImportar = new com.guis.SimpleButton();

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

        jtbTabla.setAutoCreateRowSorter(true);
        jtbTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "clv1", "clv2", "Nombre", "A Paterno", "A Materno", "Titulo del trabajo", "Categoria", "Tipo de trabajo", "Individual", "Evento", "Convocatoria enviada", "Oficio enviado", "Mail enviado", "Recibido", "Trabajo Aceptado", "Asistencia confirmada", "Acuse de recibo", "Ubicacion en memorias", "Ubicacion en instalaciones", "Observaciones", "Direccion", "Ciudad", "Estado", "Tel Casa", "Tel Oficina", "Tel Movil", "Titulo Profecional", "Correo Electronico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jtbTabla);
        jtbTabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        jtbTabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtbTabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        jtbTabla.getColumnModel().getColumn(7).setPreferredWidth(70);
        jtbTabla.getColumnModel().getColumn(8).setPreferredWidth(60);
        jtbTabla.getColumnModel().getColumn(9).setPreferredWidth(120);
        jtbTabla.getColumnModel().getColumn(10).setPreferredWidth(130);
        jtbTabla.getColumnModel().getColumn(11).setPreferredWidth(110);
        jtbTabla.getColumnModel().getColumn(12).setPreferredWidth(90);
        jtbTabla.getColumnModel().getColumn(13).setPreferredWidth(75);
        jtbTabla.getColumnModel().getColumn(14).setPreferredWidth(150);
        jtbTabla.getColumnModel().getColumn(15).setPreferredWidth(160);
        jtbTabla.getColumnModel().getColumn(16).setPreferredWidth(140);
        jtbTabla.getColumnModel().getColumn(17).setPreferredWidth(180);
        jtbTabla.getColumnModel().getColumn(18).setPreferredWidth(180);
        jtbTabla.getColumnModel().getColumn(19).setPreferredWidth(300);

        btnAgrega.setText("Agregar");
        btnAgrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaActionPerformed(evt);
            }
        });

        btnQuita.setText("Quitar");
        btnQuita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitaActionPerformed(evt);
            }
        });

        btnGuarda.setText("Guardar");
        btnGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaActionPerformed(evt);
            }
        });

        btnImprime.setText("Imprimir");
        btnImprime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimeActionPerformed(evt);
            }
        });

        btnCSV.setText("Exportar a CSV");
        btnCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSVActionPerformed(evt);
            }
        });

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addComponent(btnAgrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
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
        ModeloExp modelo;
        if(clvcong<1){
            aux="<html>Primero debe guardar los datos generales del congreso<br> Para poder agregar Ponentes y trabajos</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return;
        }
        modelo=((ModeloExp)jtbTabla.getModel());
        modelo.addRow(new Object[]{"-1","-1","","","","","","",true,noEve,"","","","","",false,"","","","","","","","","","","",""});
        modelo.addTableModelListener(this);
        jtbTabla.setModel(modelo); hayCambios=true;
    }//GEN-LAST:event_btnAgregaActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        DialogImportPerson bscprns;
        ModeloExp modelo;
        String aux;
        String[] datos;
        String[] datos2;
        java.util.ArrayList<String> coms;
        int clv=contenedor.getClave();
        if(clv<1){
            aux="<html>Primero debe guardar los datos generales del congreso<br> Para poder importar datos de ponentes</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return;
        }
        bscprns=new DialogImportPerson(((Ventana)getTopLevelAncestor()),true);
        datos=bscprns.getDatosImp();
        if(datos==null) return;
        datos2=new String[14]; 
        datos2[13]=Logica.OprsDts.transformatFcha(Logica.Tiempo.getFechaFormatoNums());
        datos2[0]="<-- No especificado !!-->"; datos2[1]="<-- No especificado !!-->";
        datos2[2]="<-- No especificado !!-->"; datos2[3]="1"; datos2[4]="<-- No especificado !!-->";
        datos2[5]="<-- No especificado !!-->"; datos2[6]="<-- No especificado !!-->"; datos2[7]=datos2[13];
        datos2[8]=datos2[13]; datos2[9]="0"; datos2[10]="<-- No especificado !!-->";
        datos2[11]="<-- No especificado !!-->"; datos2[12]="<-- No especificado !!-->"; datos2[13]=null;
        if(!BaseDatos.InsUpdBD.nuevoExponente(datos2)){
            aux="<html>Error al intentar guardar datos <br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return;
        }
        clv=BaseDatos.InsUpdBD.obtenClave();
        coms=new java.util.ArrayList<String>();
        coms.add("insert into participan values("+contenedor.getClave()+","+clv+");");
        coms.add("insert into exptiene values("+datos[0]+","+clv+");");
        if(!BaseDatos.InsUpdBD.transaccion(coms)){
            aux="<html>No se pudo importar la persona indicada<br>Ocurrio el error: "+BaseDatos.InsUpdBD.obtenError()+"</html>";
            BaseDatos.InsUpdBD.actualiza("delete from Exponentes where ClvExp="+clv+";");
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
            return;
        }
        aux="<html>La persona indicada ha sido importada<br>Indique datos del trabajo</html>";
        ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.INF_MESS);
        modelo=((ModeloExp)jtbTabla.getModel());
        datos2[7]=Logica.OprsDts.transformatFcha(datos2[7]);
        datos2[8]=Logica.OprsDts.transformatFcha(datos2[8]);
        modelo.addRow(new Object[]{datos[0],clv,datos[1],datos[2],datos[3],datos2[0],datos2[1],datos2[2],
          true,noEve,datos2[4],datos2[5],datos2[6],datos2[7],datos2[8],false,datos2[10],datos2[11],datos2[12],
          datos2[13],datos[4],datos[5],datos[6],datos[7],datos[8],datos[9],datos[11],datos[10]});
        modelo.addTableModelListener(this);
        jtbTabla.setModel(modelo); hayCambios=true;
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaActionPerformed
        guardaCambios();
    }//GEN-LAST:event_btnGuardaActionPerformed

    private void btnQuitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitaActionPerformed
        java.util.ArrayList<String> coms;
        java.util.ArrayList<String> com;
        int[] filas=jtbTabla.getSelectedRows();
        int clavePer;
        int claveExp;
        String aux;
        if(filas.length<=0) return;
        aux="<html>En verdad desea quitar las personas seleccionadas de la tabla<br>";
        aux+="Esta accion no se podra deshacer<br>¿Desea continuar?</html>";
        if(!((Ventana)getTopLevelAncestor()).askYesNoOption(aux)) return;
        coms=new java.util.ArrayList<String>();
        for(int f=0;f<filas.length;f++){
            clavePer=Integer.parseInt(""+jtbTabla.getValueAt(filas[f],0));
            claveExp=Integer.parseInt(""+jtbTabla.getValueAt(filas[f],1));
            com=FunsComms.getComBorrarPersona(clavePer,2,claveExp);
            for(int g=0;g<com.size();g++) coms.add(com.get(g));
            coms.add("delete from expeve where clvexp="+claveExp+";");
            coms.add("delete from participan where clvexp="+claveExp+";");
            coms.add("delete from exponentes where clvexp="+claveExp+";");
        }
        if(BaseDatos.InsUpdBD.transaccion(coms)){
            actualizaLista();
            aux="<html>Accion realizada<br>Se quitaron las personas seleccionadas</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.INF_MESS);
        }
        else{
            aux="<html>Error al intertar realizar la accion:<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
        }
    }//GEN-LAST:event_btnQuitaActionPerformed

    private void btnCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSVActionPerformed
        if(jtbTabla.getRowCount()==0){
            ((Ventana)getTopLevelAncestor()).message("<html>No se puede exportar<br>La tabla esta vacia</html>",DialogMessages.ERROR_MESS);
            return;
        }
        ((Ventana)getTopLevelAncestor()).exportTablaToCSV(3,jtbTabla.getModel());
    }//GEN-LAST:event_btnCSVActionPerformed

    private void btnImprimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimeActionPerformed
        Map<String,String> parametros = new HashMap<String,String>();
        ArrayList campos=new ArrayList();
        CamposReport.CampoExps campo;
        String aux;
        String descEvento=null;
        Evento evento;
        if(jtbTabla.getRowCount()==0){
            ((Ventana)getTopLevelAncestor()).message("<html>No se puede imprimir<br>La tabla esta vacia</html>",DialogMessages.ERROR_MESS);
            return;
        }
        parametros.put("TITCONG",contenedor.getTitCon());
        parametros.put("TEMACONG",contenedor.geTemaCon());
        parametros.put("PERIODOCONG",contenedor.getPerCon());
        for(int s=0;s<jtbTabla.getRowCount();s++){
            aux=""+jtbTabla.getValueAt(s,2)+" "+jtbTabla.getValueAt(s,3)+" "+jtbTabla.getValueAt(s,4);
            evento=(Evento)jtbTabla.getValueAt(s,9);
            if(evento.clave>0){
                descEvento=evento.toString()+"\n("+evento.fecha+")";
            }
            else descEvento=null;
            campo=new CamposReport.CampoExps(""+jtbTabla.getValueAt(s,5),aux,descEvento);
            campos.add(campo);
        }
        ((Ventana)getTopLevelAncestor()).sendToPrint("Tabla de Ponentes",3,parametros,campos);
    }//GEN-LAST:event_btnImprimeActionPerformed

    /** Guarda los cambios realizados en los datos de la tabla
     * @return true si se pudieron guardar lo cambios false en caso contrario
     */
    public boolean guardaCambios(){
        java.util.ArrayList<String> coms;
        String aux;
        String[] dts;
        int[] clvtemp;
        Evento eve;
        if(contenedor.getClave()<1){
            aux="<html>Primero debe guardar los datos generales del congreso<br> Para poder guardar datos de Ponentes</html>";
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
                if(clvtemp==null) return false;
                jtbTabla.setValueAt(""+clvtemp[0],f,0);
                jtbTabla.setValueAt(""+clvtemp[1],f,1);
            }
            else{
                dts=getDatos(f,0);
                aux="update DtsPers set Nombre='"+dts[2]+"',Appat='"+dts[3]+"',Apmat='";
                aux+=dts[4]+"',Dir='"+dts[19]+"',Ciudad='"+dts[20]+"',Estado='"+dts[21];
                aux+="',TelCasa='"+dts[22]+"',TelOfic='"+dts[23]+"',TelMovil='"+dts[24];
                aux+="',CorreoE='"+dts[26]+"',Titulo='"+dts[25]+"' where ClvDts="+dts[0]+";";
                coms.add(aux);
                aux="update Exponentes set TitTrab='"+dts[5]+"',CatTrab='"+dts[6]+"',TipoTrab='";
                aux+=dts[7]+"',Individual="+(dts[8].equals("true")?1:0)+",eConv="+(dts[9].length()>0?"'"+dts[9]+"'":"null");
                aux+=",eOfic="+(dts[10].length()>0?"'"+dts[10]+"'":"null");
                aux+=",eMail="+(dts[11].length()>0?"'"+dts[11]+"'":"null");
                aux+=",FchaRec="+(dts[12].length()>0?"'"+Logica.OprsDts.transformatFcha(dts[12])+"'":"null");
                aux+=",FchaAcep="+(dts[13].length()>0?"'"+Logica.OprsDts.transformatFcha(dts[13])+"'":"null");
                aux+=",ConfAsis="+(dts[14].equals("true")?1:0);
                aux+=",AcRec="+(dts[15].length()>0?"'"+dts[15]+"'":"null");
                aux+=",ubEnMem="+(dts[16].length()>0?"'"+dts[16]+"'":"null");
                aux+=",ubEnInst="+(dts[17].length()>0?"'"+dts[17]+"'":"null");
                aux+=",obser="+(dts[18].length()>0?"'"+dts[18]+"'":"null");
                aux+=" where ClvExp="+dts[1]+";";
                coms.add(aux);
                coms.add("delete from ExpEve where ClvExp="+dts[1]+";");
                eve=(Evento)jtbTabla.getValueAt(f,9);
                if(eve.clave>0)
                    coms.add("insert ExpEve values("+eve.clave+","+dts[1]+");");
            }
        }
        if(coms.size()>0){
            if(!BaseDatos.InsUpdBD.transaccion(coms)){ // hacer update de todo
                aux="<html>Error al intertar realizar la accion:<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
                ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.ERROR_MESS);
                return false;
            }
        }
        aux="<html>Accion realizada<br>Se guardaron los datos de Ponentes</html>";
        ((Ventana)getTopLevelAncestor()).message(aux,DialogMessages.INF_MESS);
        hayCambios=false; return true;
    }
    
    /** Revisa si hay algun dato invalido en la tabla
     * @return Cadena con la descripcion del dato invalido o null si todos los datos son validos
     */
    private String hayDatoInvalido(){
        String[] datos;
        for(int x=0;x<jtbTabla.getRowCount();x++){
            datos=getDatos(x,0);
            if(datos[2].length()<1||datos[2].length()>85)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Nombre</font> invalido, longitud invalida</html>";
            if(datos[3].length()<1||datos[3].length()>85)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Apellido paterno</font> invalido, longitud invalida</html>";
            if(datos[4].length()<1||datos[4].length()>85)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Apellido materno</font> invalido, longitud invalida</html>";
            if(datos[5].length()<1||datos[5].length()>125)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Titulo del trabajo</font> invalido, longitud invalida</html>";
            if(datos[6].length()<1||datos[6].length()>125)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Categoria</font> invalida, longitud invalida</html>";
            if(datos[7].length()<1||datos[7].length()>125)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Tipo de trabajo</font> invalido, longitud invalida</html>";
            if(datos[9].length()>25)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Convocatoria enviada</font> invalida, longitud invalida</html>";
            if(datos[10].length()>25)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Oficio enviado</font> invalido, longitud invalida</html>";
            if(datos[11].length()>25)
                return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Correo enviado</font> invalido, longitud invalida</html>";
            if(datos[12].length()>0){
                if(!Logica.OprsDts.valFecha(datos[12]))
                    return "<html>Hay datos invalidos en Exponentes<br>En fila: "+(x+1)+", <font color=\"RED\">Recibido</font> invalido, Debe ser fecha formato DD-MM-AAAA</html>";
            }
            if(datos[13].length()>0){
                if(!Logica.OprsDts.valFecha(datos[13]))
                    return "<html>En fila: "+(x+1)+", <font color=\"RED\">Trabajo aceptado</font> invalido, Debe ser fecha formato DD-MM-AAAA</html>";
            }
            if(datos[15].length()>125)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Acuse de recibo</font> invalido, longitud invalida</html>";
            if(datos[16].length()>125)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Ubicacion en memorias</font> invalido, longitud invalida</html>";
            if(datos[17].length()>125)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Ubicacion en instalaciones</font> invalido, longitud invalida</html>";
            if(datos[18].length()>255)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Observaciones</font> invalido, longitud invalida</html>";
            if(datos[19].length()<1||datos[20].length()>45)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Direccion</font> invalida, longitud invalida</html>";
            if(datos[20].length()<1||datos[21].length()>25)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Ciudad</font> invalida, longitud invalida</html>";
            if(datos[21].length()<1||datos[22].length()>25)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Estado</font> invalido, longitud invalida</html>";
            if(datos[22].length()<1||datos[23].length()>10)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Telefono de casa</font> invalido, longitud invalida</html>";
            if(datos[23].length()<1||datos[23].length()>20)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Telefono de oficina</font> invalido, longitud invalida</html>";
            if(datos[24].length()<1||datos[24].length()>10)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Telefono movil</font> invalido, longitud invalida</html>";
            if(datos[25].length()>125)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Titulo Profecional</font> invalido, longitud invalida</html>";
            if(datos[26].length()<1||datos[26].length()>25)
                return "<html>En fila: "+(x+1)+", <font color=\"RED\">Correo electronico</font> invalido, longitud invalida</html>";
        }
        return null;
    }

    /** Guarda los datos de una fila de la tabla (para filas nuevas sin clave)
     * @param fila el numero de la fila a guardar
     * @return Vector con las claves generadas para datos personales y datos de exponente
     *   o null si no se pudo guardar la fila
     */
    private int[] guardaFila(int fila){
        int[] intAux=new int[2];
        Evento eve;
        java.util.ArrayList<String> coms;
        String[] dts=getDatos(fila,3);
        String sen="select count(ClvDts) from DtsPers where Nombre='";
        sen+=dts[0]+"' and Appat='"+dts[1]+"' and Apmat='"+dts[2]+"';";
        intAux[0]=BaseDatos.ConsultasBD.consultaEntero(sen);
        if(intAux[0]==-1){
            sen="<html>Error al intentar verificar datos previos al registro<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return null;
        }
        else if(intAux[0]>0){
            sen="<html>Ya existe un registro a nombre de:<br><u>"+dts[0]+" "+dts[1]+" "+dts[2];
            sen+="</u><br>Si es la misma persona use el boton <u>importar</u><br>Si esta seguro que ";
            sen+="se trata de personas distintas elija continuar<br>¿Desea continuar?</html>";
            if(!((Ventana)getTopLevelAncestor()).askYesNoOption(sen)) return null;
        }
        sen=dts[dts.length-1]; dts[dts.length-1]=dts[dts.length-2]; dts[dts.length-2]=sen;
        if(!BaseDatos.InsUpdBD.nuevoDtsPers(dts)){
            sen="<html>Error al intentar guardar datos de fila: "+(fila+1)+"<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return null;
        }
        intAux[0]=BaseDatos.InsUpdBD.obtenClave();
        dts=getDatos(fila,4); dts[3]=""+(dts[3].equals("true")?1:0);
        dts[9]=""+(dts[9].equals("true")?1:0);
        dts[7]=Logica.OprsDts.transformatFcha(dts[7]);
        dts[8]=Logica.OprsDts.transformatFcha(dts[8]);
        if(!BaseDatos.InsUpdBD.nuevoExponente(dts)){
            sen="<html>Error al intentar guardar datos de fila: "+(fila+1)+"<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            BaseDatos.InsUpdBD.actualiza("delete from dtspers where clvdts="+intAux[0]+";");
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return null;
        }
        intAux[1]=BaseDatos.InsUpdBD.obtenClave();
        eve=(Evento)jtbTabla.getValueAt(fila,9);
        coms=new java.util.ArrayList<String>();
        coms.add("insert into ExpTiene values("+intAux[0]+","+intAux[1]+");");
        coms.add("insert into Participan values("+contenedor.getClave()+","+intAux[1]+");");
        if(eve.clave>0) coms.add("insert into ExpEve values("+eve.clave+","+intAux[1]+");");
        if(!BaseDatos.InsUpdBD.transaccion(coms)){
            BaseDatos.InsUpdBD.actualiza("delete from DtsPers where ClvDts="+intAux[0]+";");
            BaseDatos.InsUpdBD.actualiza("delete from Exponentes where ClvDts="+intAux[1]+";");
            sen="<html>Error al intentar guardar datos de fila: "+(fila+1)+"<br>"+BaseDatos.InsUpdBD.obtenError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return null;
        }
        return intAux;
    }
    
    /** Obtiene los datos de una fila de la tabla
     * @param fila numero de fila de la tabla de la cual obtener los datos
     * @param clasif donde: 0=todos, 1=solo personales (con clave) 
     *   2=solo de exponente (con clave), 3=personales (sin clave), 
     *   4=solo de exponente (sin clave)
     * @return los datos obtenidos segun fila y clasif
     */
    private String[] getDatos(int fila, int clasif){
        String[] datos=new String[(clasif==0?27:(clasif==1?12:(clasif==2?15:(clasif==3?11:14))))];
        int aux=0;
        for(int c=0;c<jtbTabla.getColumnCount();c++){
            if(clasif==1 && (c==1||(c>=5 && c<=19))) continue;
            else if(clasif==2 && (c==0||c==2||c==3||c==4||c>=20)) continue;
            else if(clasif==3 && (c<=1||(c>=5 && c<=19))) continue;
            else if(clasif==4 && (c<=4||c>=20)) continue;
            if(c==9) continue;
            if(jtbTabla.getValueAt(fila,c)!=null)
                datos[aux]=""+jtbTabla.getValueAt(fila,c);
            else datos[aux]="";
            aux++;
        }
        return datos;
    }
    
    /** Actualiza la lista de eventos del congreso actual
     */
    public void actualizaEventos(){
        String[][] eventos=getEventos();
        if(eventos==null) return;
        celdaEves.setLista(eventos);        
    }
    
    /** Obtiene la lista de eventos actules del congreso
     * @return la lista de eventos actules del congreso
     */
    private String[][] getEventos(){
        String[][] eventos=null;
        String sen="select eventos.clvEven,titEven,FechaYHora from eventos,planea where eventos.clveven=";
        sen+="planea.clveven and planea.clvcon="+contenedor.getClave()+" order by titeven;";
        eventos=BaseDatos.ConsultasBD.consultaArray(sen);
        if(eventos==null){
            sen="<html>Error al intentar consultar la lista de eventos"+BaseDatos.ConsultasBD.getError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return null;
        }
        if(eventos[0][0]==null) return null;
        return eventos;
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
        ModeloExp modelo2;
        String[][] eveRel=new String[1][1];
        java.util.Vector cols=new java.util.Vector();
        String sen="select dtspers.clvdts as 'clv1',exponentes.clvexp as 'clv2',Nombre,";
        sen+="appat as 'A Paterno',apmat as 'A Materno',tittrab as 'Titulo del trabajo',";
        sen+="cattrab as 'Categoria',tipotrab as 'Tipo de trabajo',Individual,'Evento',";
        sen+="econv as 'Convocatoria enviada',eofic as 'Oficio enviado',email as 'Correo";
        sen+=" enviado',fcharec as 'Recibido',fchaacep as 'Trabajo aceptado',confasis as ";
        sen+="'Asistencia confirmada',acrec as 'Acuse de recibo',ubenmem as 'Ubicacion en";
        sen+=" memorias',ubeninst as 'Ubicacion en instalaciones',obser as 'Observaciones'";
        sen+=",dir as 'Direccion',Ciudad,Estado,telcasa as 'Tel Casa',telofic as 'Tel ";
        sen+="Oficina',telmovil as 'Tel Movil',titulo as 'Titulo Profecional',correoe as ";
        sen+="'Correo Electronico' from dtspers,exponentes,exptiene,participan where ";
        sen+="exptiene.clvdts=dtspers.clvdts and exptiene.clvexp=exponentes.clvexp and ";
        sen+="exponentes.clvexp=participan.clvexp and participan.clvcon="+contenedor.getClave();
        sen+=" order by appat, apmat, nombre;";
        cols.add("clv1"); cols.add("clv2"); cols.add("Nombre"); cols.add("A Paterno"); cols.add("A Materno"); 
        cols.add("Titulo del trabajo"); cols.add("Categoria"); cols.add("Tipo de trabajo"); cols.add("Individual");
        cols.add("Evento"); cols.add("Convocatoria enviada"); cols.add("Oficio enviado"); cols.add("Correo enviado");
        cols.add("Recibido"); cols.add("Trabajo aceptado"); cols.add("Asistencia confirmada"); cols.add("Acuse de recibo");
        cols.add("Ubicacion en memorias"); cols.add("Ubicacion en instalaciones"); cols.add("Observaciones");
        cols.add("Direccion"); cols.add("Ciudad"); cols.add("Estado"); cols.add("Tel Casa"); cols.add("Tel Oficina");
        cols.add("Tel Movil"); cols.add("Titulo Profecional"); cols.add("Correo Electronico");
        modelo=BaseDatos.ConsultasBD.consTipoTable(sen);
        if(modelo==null){
            sen="<html>Error al intentar actualizar la tabla de exponentes<br>"+BaseDatos.ConsultasBD.getError()+"</html>";
            ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            return false;
        }
        modelo2 = new ModeloExp(modelo,cols);
        // indicar el evento relacionado
        eveRel[0][0]=getClausulaExpEve(modelo2);
        if(!eveRel[0][0].equals("()")){
            sen="select expeve.clvexp,eventos.clveven,titeven,FechaYHora from eventos,expeve,exponentes";
            sen+=",dtspers,exptiene,participan where eventos.clveven=expeve.clveven and ";
            sen+="exponentes.clvexp=expeve.clvexp and exptiene.clvdts=dtspers.clvdts and ";
            sen+="exptiene.clvexp=exponentes.clvexp and exponentes.clvexp=participan.clvexp";
            sen+=" and participan.clvcon="+contenedor.getClave()+" and "+eveRel[0][0];
            sen+=" order by appat, apmat, nombre;";
            eveRel=BaseDatos.ConsultasBD.consultaArray(sen);
            if(eveRel==null){
                sen="<html>Error al intentar consultar eventos relacionados<br>"+BaseDatos.ConsultasBD.getError()+"</html>";
                ((Ventana)getTopLevelAncestor()).message(sen,DialogMessages.ERROR_MESS);
            }
            else{
                for(int h=0,f=0;h<modelo2.getRowCount();h++){
                    if(eveRel[0][0]!=null){
                        if(f<eveRel.length){
                            if(eveRel[f][0].equals(""+modelo2.getValueAt(h,1))){
                                sen=eveRel[f][3].substring(0,10);
                                modelo2.setValueAt(new Evento(Integer.parseInt(eveRel[f][1]),eveRel[f][2],sen),h,9);
                                f++;
                            }
                            else modelo2.setValueAt(noEve,h,9);
                        }
                        else modelo2.setValueAt(noEve,h,9);
                    }
                    else modelo2.setValueAt(noEve,h,9);
                }
            }
        }
        modelo2.addTableModelListener(this);
        jtbTabla.setModel(modelo2);
        (jtbTabla.getTableHeader()).setReorderingAllowed(false);
        ocultaColumna("clv1"); ocultaColumna("clv2"); hayCambios=false;
        jtbTabla.getColumn("Nombre").setPreferredWidth(80);
        jtbTabla.getColumn("A Paterno").setPreferredWidth(80);
        jtbTabla.getColumn("A Materno").setPreferredWidth(80);
        jtbTabla.getColumn("Titulo del trabajo").setPreferredWidth(250);
        jtbTabla.getColumn("Categoria").setPreferredWidth(120);
        jtbTabla.getColumn("Tipo de trabajo").setPreferredWidth(120);
        jtbTabla.getColumn("Individual").setPreferredWidth(70);
        jtbTabla.getColumn("Evento").setPreferredWidth(160);
        jtbTabla.getColumn("Convocatoria enviada").setPreferredWidth(120);
        jtbTabla.getColumn("Oficio enviado").setPreferredWidth(100);
        jtbTabla.getColumn("Correo enviado").setPreferredWidth(100);
        jtbTabla.getColumn("Recibido").setPreferredWidth(80);
        jtbTabla.getColumn("Trabajo aceptado").setPreferredWidth(100);
        jtbTabla.getColumn("Asistencia confirmada").setPreferredWidth(120);
        jtbTabla.getColumn("Acuse de recibo").setPreferredWidth(100);
        jtbTabla.getColumn("Ubicacion en memorias").setPreferredWidth(150);
        jtbTabla.getColumn("Ubicacion en instalaciones").setPreferredWidth(160);
        jtbTabla.getColumn("Observaciones").setPreferredWidth(180);
        jtbTabla.getColumn("Direccion").setPreferredWidth(140);
        jtbTabla.getColumn("Ciudad").setPreferredWidth(80);
        jtbTabla.getColumn("Estado").setPreferredWidth(80);
        jtbTabla.getColumn("Tel Casa").setPreferredWidth(85);
        jtbTabla.getColumn("Tel Oficina").setPreferredWidth(85);
        jtbTabla.getColumn("Tel Movil").setPreferredWidth(85);
        jtbTabla.getColumn("Titulo Profecional").setPreferredWidth(120);
        jtbTabla.getColumn("Correo Electronico").setPreferredWidth(120);
        return true;
    }
    
    /** Obtiene la clausula de relacion expeve a utilizar en la actualizacion de la lista de datos
     * @param m El model de la tabla
     * @return la clausula de relacion expeve a utilizar en la actualizacion de la lista de datos
     */
    private String getClausulaExpEve(ModeloExp m){
        String sen="(";
        for(int h=0;h<m.getRowCount();h++){
            sen+="expeve.clvexp="+m.getValueAt(h,1);
            sen+=(h<(m.getRowCount()-1)?" or ":"");
        }
        return sen+")";
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
    
    public void setColor(Color back,Color titleBar,Color body,Color borderColor,Color btnVerColor,Color toolTip){
        setBackground(back);
        pnlNorth.setBackground(titleBar);
        pnlContainer.setBackground(body);
        btnDisplay.setBackground(btnVerColor);
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11),borderColor));
        this.createToolTip().setBackground(toolTip);
        btnDisplay.createToolTip().setBackground(toolTip);
    }
    
    /** Obtiene los comandos de borrado de registros para los datos de la tabla
     * @return los comandos de borrado de registros para los datos de la tabla
     */
    public java.util.ArrayList<String> getComsDelete(){
        java.util.ArrayList<String> coms;
        java.util.ArrayList<String> com;
        int clavePer;
        int claveExp;
        coms=new java.util.ArrayList<String>();
        for(int y=0;y<jtbTabla.getRowCount();y++){
            clavePer=Integer.parseInt(""+jtbTabla.getValueAt(y,0));
            claveExp=Integer.parseInt(""+jtbTabla.getValueAt(y,1));
            com=FunsComms.getComBorrarPersona(clavePer,2,claveExp);
            for(int g=0;g<com.size();g++) coms.add(com.get(g));
            coms.add("delete from participan where clvexp="+claveExp+";");
            coms.add("delete from exponentes where clvexp="+claveExp+";");
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
    private com.guis.SimpleButton btnCSV;
    private com.guis.SimpleButton btnGuarda;
    private com.guis.SimpleButton btnImportar;
    private com.guis.SimpleButton btnImprime;
    private com.guis.SimpleButton btnQuita;
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
    
    /** Clase para utilizar como editor de celda en la tabla para la columna eventos
     */
    private class CeldaEditorJCombo extends javax.swing.JComboBox implements TableCellEditor{
        
        private LinkedList suscriptores;
        
        public CeldaEditorJCombo(){
            suscriptores=new LinkedList();
            setEditable(false);
            setLista(null);
            setFocusable(true);
            addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e) {
                    editado(true);
                }
            });
            addFocusListener(new FocusListener(){
                public void focusGained (FocusEvent e){}
                public void focusLost (FocusEvent e){
                    editado (false);
                }
            });
        }
        
        /** Establece la lista de eventos actuales registrados
         * @param lista la lista de eventos actuales registrados
         */
        public void setLista(String[][] lista){
            removeAllItems();
            addItem(noEve);
            if(lista==null) return;
            for(int g=0;g<lista.length;g++){
                addItem(new Evento(Integer.parseInt(lista[g][0]),lista[g][1],lista[g][2].substring(0,10)));
            }
        }
        
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
            setSelectedItem(value);
            return this;
        }

        public Object getCellEditorValue() {
            return getSelectedItem();
        }

        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        public boolean stopCellEditing() {
            return true;
        }

        public void cancelCellEditing() {
        }

        public void addCellEditorListener(CellEditorListener l) {
            suscriptores.add(l);
        }

        public void removeCellEditorListener(CellEditorListener l) {
            suscriptores.remove(l);
        }
        
        protected void editado(boolean cambiado){
            ChangeEvent evento = new ChangeEvent(this);
            for (int i=0; i<suscriptores.size(); i++){
                CellEditorListener aux = (CellEditorListener)suscriptores.get(i);
                if(cambiado){
                    aux.editingStopped(evento);
                }
                else aux.editingCanceled(evento);
            }
        }
    }
    
    /** Clase que define un objeto evento para manejar los datos de un evento
     */ 
    private class Evento{
        public int clave;
        public String titulo;
        public String fecha;
        
        public Evento(int clv, String tit,String fch){
            clave=clv; titulo=tit; fecha=fch;
        }
        
        @Override
        public String toString(){
            return titulo;
        }
    }
    
    /** Clase con la definicion del modelo de datos de la tabla */
    private class ModeloExp extends DefaultTableModel{
        
        public ModeloExp(DefaultTableModel m,java.util.Vector cols){
            super(m.getDataVector(),cols);
        }
        
        @Override
        public Class getColumnClass(int columnIndex){
            if(columnIndex==8) return Boolean.class;
            if(columnIndex==9) return Evento.class;
            if(columnIndex==15) return Boolean.class;
            return String.class;
        }
        
        @Override
        public boolean isCellEditable(int row, int col){
            return (col>1);
        }
    }
    
}
