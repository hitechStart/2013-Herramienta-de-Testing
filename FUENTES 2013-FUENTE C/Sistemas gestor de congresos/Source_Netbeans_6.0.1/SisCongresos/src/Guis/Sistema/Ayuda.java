/*
 * Ayuda.java
 *   Ventana de manual de usuario del sistema
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
import javax.swing.event.HyperlinkEvent;

/**
 * @author  Pedro Cardoso Rodriguez
 */
public class Ayuda extends javax.swing.JFrame {
    
    private int xonscreen;
    private int yonscreen;
    private int xIni;
    private int yIni;
    private java.awt.Dimension dim;
    private java.awt.Point lugar;
    private boolean maximizado;
    private java.awt.Dimension dimt;
    private Ventana vent;
    
    /** Creates new form Ayuda */
    public Ayuda(Ventana vent) {
        initComponents();
        this.vent=vent;
        Thread.setDefaultUncaughtExceptionHandler(new Logica.CatchUnhandledErrors(vent));
        setSize(740,605);
        setLocationRelativeTo(null);
        setTitle("Ayuda");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Iconos/congresos.png")).getImage());
        validateTree();
        xonscreen=getLocation().x;
        yonscreen=getLocation().y;
        dim=getSize();
        lugar=getLocation();
        maximizado=false;
        dimt=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        btnClose.setFocusable(false);
        btnMaxi.setFocusable(false);
        btnMini.setFocusable(false);
        btnMini.setColors(new Color(180,205,243),new Color(223,232,254),new Color(170,220,249));
        btnMaxi.setColors(new Color(180,205,243),new Color(223,232,254),new Color(170,220,249));
        btnClose.setColors(new Color(180,205,243),new Color(223,232,254),new Color(170,220,249));
        cargaPagina("file:///"+cambiaDiag(System.getProperty("user.dir"))+"/Ayuda/index.html");
    }
    
    /** Carga un archivo html en el control jepCaja
     * @param pag La url del html a cargar
     */
    private void cargaPagina(String pag){
        try {
            jepCaja.setPage(pag);
        }
        catch(java.io.IOException excIO) {
            vent.message("<html>Ocurrio un error al cargar el tema de ayuda<br>"+excIO.getMessage()+"</html>",1);
        }
    }
    
    /** Cambia las diagonales de \ a / de una cadena para que la cadena sea reconocidas como url
     * @param src la cadena original
     * @return la cadena con los cambios
     */
    private String cambiaDiag(String src){
        String cmb="";
        for(int g=0;g<src.length();g++){
            char c=src.charAt(g);            
            cmb+=""+(c=='\\'?c='/':c);
        }
        return cmb;
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
        btnMaxi = new com.guis.SimpleButton();
        btnMini = new com.guis.SimpleButton();
        pnlContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jepCaja = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        pnlAll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
        pnlAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlAllMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlAllMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlAllMouseReleased(evt);
            }
        });
        pnlAll.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlAllMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlAllMouseMoved(evt);
            }
        });
        pnlAll.setLayout(new java.awt.BorderLayout());

        pnlNorth.setBackground(new java.awt.Color(180, 205, 243));
        pnlNorth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNorthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlNorthMouseEntered(evt);
            }
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

        btnClose.setMnemonic('X');
        btnClose.setText("X");
        btnClose.setToolTipText("Cerrar Alt+X");
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnMaxi.setText("[ ]");
        btnMaxi.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnMaxi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxiActionPerformed(evt);
            }
        });

        btnMini.setText("_");
        btnMini.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnMini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnMaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlAll.add(pnlNorth, java.awt.BorderLayout.NORTH);

        pnlContainer.setBackground(new java.awt.Color(170, 215, 253));
        pnlContainer.setLayout(new java.awt.BorderLayout());

        jepCaja.setEditable(false);
        jepCaja.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                jepCajaHyperlinkUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(jepCaja);

        pnlContainer.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlAll.add(pnlContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlAll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        salir();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMaxiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxiActionPerformed
        maximiza();
    }//GEN-LAST:event_btnMaxiActionPerformed

    private void btnMiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniActionPerformed
        minimiza();
    }//GEN-LAST:event_btnMiniActionPerformed

    private void pnlNorthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMouseClicked
        if(evt.getClickCount()==2) maximiza();
    }//GEN-LAST:event_pnlNorthMouseClicked

    private void pnlNorthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMouseEntered
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_pnlNorthMouseEntered

    private void pnlNorthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMousePressed
        xIni=evt.getXOnScreen();
        yIni=evt.getYOnScreen();
    }//GEN-LAST:event_pnlNorthMousePressed

    private void pnlNorthMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMouseReleased
        xonscreen=getLocation().x;
        yonscreen=getLocation().y;
        if(getLocation().x!=0&&getLocation().y!=0) lugar=getLocation();
    }//GEN-LAST:event_pnlNorthMouseReleased

    private void pnlNorthMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNorthMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        int auxx=0;
        int auxy=0;
        if(dimt.equals(getSize())) return;
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

    private void pnlAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAllMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_pnlAllMouseExited

    private void pnlAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAllMousePressed
        xIni=evt.getXOnScreen();
        yIni=evt.getYOnScreen();
    }//GEN-LAST:event_pnlAllMousePressed

    private void pnlAllMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAllMouseReleased
        dim=getSize();
    }//GEN-LAST:event_pnlAllMouseReleased

    private void pnlAllMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAllMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        int auxx=0;
        int auxy=0;
        if(x!=xIni){
            if(x>xIni) auxx=(x-xIni);
            else auxx=(xIni-x)*-1;
        }
        if(y!=yIni){
            if(y>yIni) auxy=(y-yIni);
            else auxy=(yIni-y)*-1;
        }
        auxx+=getSize().width; auxy+=getSize().height;
        setSize((auxx>210?auxx:210),(auxy>35?auxy:35));
        xIni=(x>210?x:xIni); yIni=(y>35?y:yIni);
    }//GEN-LAST:event_pnlAllMouseDragged

    private void pnlAllMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAllMouseMoved
        int x=evt.getX();
        int y=evt.getY();
        if(x>=(getSize().width-3)){
            setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            return;
        } else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        if(y>=(getSize().height-3)) setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_pnlAllMouseMoved

    private void jepCajaHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_jepCajaHyperlinkUpdate
        if ( evt.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
            cargaPagina(evt.getURL().toString());
    }//GEN-LAST:event_jepCajaHyperlinkUpdate
    
    @Override
    public void setTitle(String tit){
        super.setTitle(tit);
        lblTitle.setText(" "+tit);
    }
    
    public void minimiza(){ setState(java.awt.Frame.ICONIFIED); }
    
    public void maximiza(){
        if(maximizado){
            setLocation(lugar);
            setSize(dim);
            maximizado=false;
            xonscreen=getLocation().x;
            yonscreen=getLocation().y;
        }
        else{
            setLocation(0,0);
            setSize(dimt);
            maximizado=true;
            xonscreen=0;
            yonscreen=0;
        }
    }
    
    public void salir(){
        setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.guis.SimpleButton btnClose;
    private com.guis.SimpleButton btnMaxi;
    private com.guis.SimpleButton btnMini;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane jepCaja;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAll;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlNorth;
    // End of variables declaration//GEN-END:variables
    
}
