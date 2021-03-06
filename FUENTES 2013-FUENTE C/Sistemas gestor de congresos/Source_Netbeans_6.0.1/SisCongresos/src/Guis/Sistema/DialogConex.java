/*
 * DialogConex.java
 *   Dialogo para establecer la conexion con el servidor
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
public class DialogConex extends javax.swing.JDialog {
    
    private int xonscreen;
    private int yonscreen;
    private int xIni;
    private int yIni;
    
    /** Creates new form DialogConex */
    public DialogConex(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Thread.setDefaultUncaughtExceptionHandler(new Logica.CatchUnhandledErrors((Ventana)parent));
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Conexion al servidor");
        validateTree();
        xonscreen=getLocation().x;
        yonscreen=getLocation().y;
        btnClose.setFocusable(false);
        btnClose.setColors(new Color(205,226,252),new Color(180,205,243),new Color(155,255,255));
        btnConectar.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
    }
    
    @Override
    public void setTitle(String tit){
        super.setTitle(tit);
        lblTitle.setText(" "+tit);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAll = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnClose = new com.guis.SimpleButton();
        pnlContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnConectar = new com.guis.SimpleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        pnlAll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
        pnlAll.setLayout(new java.awt.BorderLayout());

        pnlNorth.setBackground(new java.awt.Color(205, 226, 252));
        pnlNorth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlNorthMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlNorthMouseReleased(evt);
            }
        });
        pnlNorth.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlNorthMouseDragged(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblTitle.setText(" Title");

        btnClose.setText("X");
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlAll.add(pnlNorth, java.awt.BorderLayout.NORTH);

        pnlContainer.setBackground(new java.awt.Color(223, 232, 254));

        jLabel1.setText("Direccion IP:");

        jLabel2.setText("Puerto:");

        jLabel3.setText("Usuario:");

        jLabel4.setText("Password:");

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlAll.add(pnlContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlAll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void pnlNorthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMousePressed
        xIni=evt.getXOnScreen();
        yIni=evt.getYOnScreen();
    }//GEN-LAST:event_pnlNorthMousePressed

    private void pnlNorthMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        int auxx=0;
        int auxy=0;
        if(xIni!=x){
            if(x>xIni) auxx=(xIni-x)*-1;
            else auxx=(x-xIni);
        }
        if(yIni!=y){
            if(y>yIni) auxy=(yIni-y)*-1;
            else auxy=(y-yIni);
        }
        setLocation(xonscreen+auxx,yonscreen+auxy);
    }//GEN-LAST:event_pnlNorthMouseDragged

    private void pnlNorthMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMouseReleased
        xonscreen=getLocation().x;
        yonscreen=getLocation().y;
    }//GEN-LAST:event_pnlNorthMouseReleased

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        int puerto=0;
        String ip=txtIP.getText().trim();
        String prto=txtPuerto.getText().trim();
        String user=txtUser.getText().trim();
        String pass=(new String(txtPass.getPassword())).trim();
        if(!valDirIP(ip)){ 
            ((Ventana)getParent()).message("<html>Direccion <b><font color=\"red\">IP</font></b> invalida</html>",DialogMessages.ERROR_MESS); 
            return;
        }
        try{ puerto=Integer.parseInt(prto); }
        catch(NumberFormatException nbfExc){ puerto=-1; }
        if(puerto<1024 || puerto>65536){ 
            ((Ventana)getParent()).message("<html>El <b><font color=\"red\">puerto</font></b> es invalido</html>",DialogMessages.ERROR_MESS);
            return; 
        }
        if(user.length()==0){ 
            ((Ventana)getParent()).message("<html>Especifique un <b><font color=\"red\">usuario</font></b></html>",DialogMessages.ERROR_MESS);
            return; 
        }
        if(BaseDatos.ConectaBD.hayConexion()){
            ((Ventana)getParent()).message("<html>Ya esta conectado al servidor</html>",DialogMessages.INF_MESS);
            return;
        }
        if(!BaseDatos.ConectaBD.conecta(ip,puerto,user,pass))
            ((Ventana)getParent()).message("<html>Ocurrio un fallo al conectar<br><font color=\"red\">"+BaseDatos.ConectaBD.obtenError()+"</font></html>",DialogMessages.ERROR_MESS);
        else{
            ((Ventana)getParent()).message("<html>Exito al conectar</html>",DialogMessages.INF_MESS);
            escribeBinFile("SisCongresos.d1",ip,prto,user,pass);
        }
    }//GEN-LAST:event_btnConectarActionPerformed
    
    /** Escribe a un archivo binario los datos recibidos en los parametros d
     *   (deben corresponder a los parametros de conexion ip, puerto, usuario y password)
     * @param filename El nombre del archivo a crear
     * @param d1 dato 1 ip
     * @param d2 dato 2 puerto
     * @param d3 dato 3 usuario
     * @param d4 dato 4 password
     * @return true si el archivo se creo correctamente false en caso contrario
     */
    public boolean escribeBinFile(String filename, String d1,String d2,String d3,String d4){
        String sep=java.io.File.separator;
        java.io.File file;
        java.io.ObjectOutputStream artOut;
        try{
            file = new java.io.File("lib"+sep+filename);
            artOut = new java.io.ObjectOutputStream(new java.io.FileOutputStream(file));
            artOut.writeObject(d1); artOut.writeObject(d2);
            artOut.writeObject(d3); artOut.writeObject(d4);
            artOut.close();
            return true;
        }
        catch(java.io.IOException ioExc){
            return false;
        }            
    }
    
    /** Valida que una cadena sea una correcta representacion de una direccion IP
     * @param dirIp La cadena a validar
     * @return true si la cadena es valida false en caso contrario
     */
    public boolean valDirIP(String dirIp){
        java.util.regex.Pattern ptrIp  = java.util.regex.Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
        java.util.regex.Matcher matcher = ptrIp.matcher(dirIp);
        return matcher.matches();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.guis.SimpleButton btnClose;
    private com.guis.SimpleButton btnConectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAll;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JTextField txtIP;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
    
}
