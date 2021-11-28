/*
 * DialogAbout.java
 *   Dialog acerca del sistema
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
public class DialogAbout extends javax.swing.JDialog {
    
    private int xonscreen;
    private int yonscreen;
    private int xIni;
    private int yIni;
    
    /** Creates new form DialogAbout */
    public DialogAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Thread.setDefaultUncaughtExceptionHandler(new Logica.CatchUnhandledErrors((Ventana)parent));
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Acerca de");
        validateTree();
        xonscreen=getLocation().x;
        yonscreen=getLocation().y;
        btnClose.setFocusable(false);
        btnClose.setColors(new Color(205,226,252),new Color(180,205,243),new Color(155,255,255));
        btnCerrar.setColors(new Color(223,232,254),new Color(108,155,254),new Color(155,255,255));
        lblIcon.setText("");
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/congresos.png")));
        pack();
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
        btnCerrar = new com.guis.SimpleButton();
        lblVersion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        lblInfo = new javax.swing.JLabel();
        lblLicencia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
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

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblVersion.setText("<html>Version: 0.035 (<i>Febrero 2010</i>)</html>");

        jLabel3.setText("Análisis y Desarrollo: Pedro Cardoso Rodríguez");

        jLabel4.setText("Correo electrónico:");

        txtMail.setEditable(false);
        txtMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMail.setText(" cardp_2004@yahoo.com.mx");

        lblInfo.setText("<html><b>Manejador de datos de congresos</b> tiene como prop&oacute;sito servir<br>de herramienta auxiliar en el control de datos (personal, eventos,<br>ponentes y asistentes) sobre congresos.</html>");

        lblLicencia.setText("<html><b>Copyright © 2010 Pedro Cardoso Rodríguez</b> Software proporcionado bajo los terminos de la<br>licencia <b>GNU GENERAL PUBLIC LICENSE</b> Para mas detalles consulte el archivo: LicenciaGPL.txt o<br>visite el sitio: http://www.gnu.org/licenses/<br><b>El software incluye las siguientes librerias:</b><br>commons-beanutils-1.8.0.jar, commons-collections-2.1.jar commons-digester-1.7.jar, commons-logging-1.0.2.jar<br>desarrollo de <em>Apache Software Foundation</em> (http://www.apache.org/) bajo la licencia: <br><b>The Apache Software License, Version 1.1</b> (vea el archivo LICENSE.commons.txt)<br>jasperreports-3.5.2.jar bajo licencia <b>LGPL Version 2.1</b> (vea el archivo licenseLGPL.txt)</html>");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manejador de datos de congresos");

        lblIcon.setText("Icono");

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVersion)
                                    .addGroup(pnlContainerLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3)))))
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblInfo))))
                    .addComponent(lblLicencia))
                .addContainerGap())
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(lblVersion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(lblInfo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLicencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void pnlNorthMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMouseReleased
        xonscreen=getLocation().x;
        yonscreen=getLocation().y;
    }//GEN-LAST:event_pnlNorthMouseReleased

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

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCerrarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.guis.SimpleButton btnCerrar;
    private com.guis.SimpleButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLicencia;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel pnlAll;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JTextField txtMail;
    // End of variables declaration//GEN-END:variables
    
}