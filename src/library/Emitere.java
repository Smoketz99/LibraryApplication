/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Emitere extends javax.swing.JFrame {
    
    public Emitere() {
        initComponents();
        Connect();
        Carti();
        Emitere_load();
        
        
        
    }
    
   
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Emitere.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Emitere.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public class CartiItem
    {
        int id;
        String nume;
        
        public CartiItem(int id, String nume)
        {
            this.id = id;
            this.nume = nume;
        }
        
        public String toString()
        {
            return nume;
        }
        
    }
    
    
    public void Carti()
    {
        
        try {
            pst = con.prepareStatement("select * from carti");
            rs = pst.executeQuery();
            txtcarti.removeAllItems();
            
            while(rs.next())
            {
                txtcarti.addItem(new CartiItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void Emitere_load()
    {
        int c;
        
        
        //creaza o interogare SQL care selecteaza datele din tabela creata in baza de date
        //executa interogarea
        try {
            pst = con.prepareStatement("select e.id, m.nume,c.Nume,e.data,e.returnare from Emitere e JOIN membrii m ON e.idmembru = m.ID JOIN carti c ON e.idcarti = c.id");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();//creaza un obiect care arata informatiile despre coloane
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            
            //se face un loop care ruleaza pentru coloane 
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i= 1; i<= c; i++)
                {
                    v2.add(rs.getString("e.id"));
                    v2.add(rs.getString("m.nume"));
                    v2.add(rs.getString("c.Nume"));
                    v2.add(rs.getString("e.data"));
                    v2.add(rs.getString("e.returnare"));
                  
                }
                
                d.addRow(v2);//adauga vectorul ca rand
                
            }
            
            //loop care ruleaza pentru fiecare rand
        } catch (SQLException ex) {
            Logger.getLogger(Emitere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
/**
 *
 * @author Cristian
 */
    
   
 
    
            
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcarti = new javax.swing.JComboBox();
        txtid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtmembru = new javax.swing.JTextField();
        txtemiteredata = new com.toedter.calendar.JDateChooser();
        txtrdata = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)), "Emitere", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(153, 0, 153))); // NOI18N

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("Sterge");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nume membru", "Carti", "Data", "Returnare"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Nume Membru");

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setText("Anuleaza");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ID Membru");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Adauga");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Data");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Carti");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Returnare");

        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtcarti, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtid, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtmembru, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtemiteredata, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtrdata, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(48, 48, 48)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtrdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmembru)
                                    .addComponent(txtcarti, 0, 238, Short.MAX_VALUE)
                                    .addComponent(txtemiteredata, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton4))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButton1)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtmembru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txtcarti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addComponent(txtemiteredata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtrdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //creaza un obiect si il seteaza pentru tabel
        //preia index-ul randului selectat din tabel si salveaza in variabila selectIndex
        
        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
     int selectIndex = jTable1.getSelectedRow();
     
     
     //preia valoarea din prima coloana a randului selectat din tabel
        //o converteste in int si salveaza in "id"
     int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        
        String mid = txtid.getText();
     CartiItem citem = (CartiItem) txtcarti.getSelectedItem();
     
     SimpleDateFormat data_format = new SimpleDateFormat("yyyy-MM-dd");
     String emiteredata = data_format.format(txtemiteredata.getDate());
     
     SimpleDateFormat data_format1 = new SimpleDateFormat("yyyy-MM-dd");
     String returnaredata = data_format.format(txtrdata.getDate());
     
        
//creaza o interogare care utilizeaza datele din tabel si le updateaza
        try {
            pst = con.prepareStatement("update emitere set idmembru = ?, idcarti = ?, data = ?, returnare = ? where id = ?");
            pst.setString(1,mid);
            pst.setInt(2,citem.id);
            
            pst.setString(3,emiteredata);
            pst.setString(4,returnaredata);
            pst.setInt(5,id);
            

            int k = pst.executeUpdate();

            
            //se verifica daca datele au fost actualizate cu succes
            if(k== 1)
            {
                JOptionPane.showMessageDialog(this,"Modificare efectuata!");

                txtid.setText("");
                txtcarti.setSelectedIndex(-1);
                txtmembru.setText("");
                Emitere_load();
                
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eroare");
            }
//preia exceptiile in cazul in care exista
        } catch (SQLException ex) {
            Logger.getLogger(Emitere.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     String mid = txtid.getText();
     CartiItem citem = (CartiItem) txtcarti.getSelectedItem();
     
     SimpleDateFormat data_format = new SimpleDateFormat("yyyy-MM-dd");
     String emiteredata = data_format.format(txtemiteredata.getDate());
     
     SimpleDateFormat data_format1 = new SimpleDateFormat("yyyy-MM-dd");
     String returnaredata = data_format.format(txtrdata.getDate());
     
        

        try {
            pst = con.prepareStatement("insert into emitere(idmembru,idcarti,data,returnare)values(?,?,?,?)");//se creaza o interogare SQL si insereaza datele din baza de date
            pst.setString(1,mid);
            pst.setInt(2,citem.id);
            
            pst.setString(3,emiteredata);
            pst.setString(4,returnaredata);
            

            int k = pst.executeUpdate();

            
            //afiseaza mesajul "categorie creata" daca a fost creat cu succes si "eroare" daca nu a fost creat
            if(k== 1)
            {
                JOptionPane.showMessageDialog(this,"Carte emisa!");

                txtid.setText("");
                txtcarti.setSelectedIndex(-1);
                txtmembru.setText("");
                txtid.requestFocus();
                Emitere_load();//reincarca in timp real datele din tabel
                
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eroare");
            }
//preia exceptiile in cazul in care exista
        } catch (SQLException ex) {
            Logger.getLogger(Emitere.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // se creaza un obiect, preia indexul randului din tabel selectat 
        //se preia valoarea din prima coloana a randului selectat
        
     DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
     int selectIndex = jTable1.getSelectedRow();
     
     
     int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());//preia valoarea din prima coloana a randului selectat din tabel si o converteste in int
     
     txtmembru.setText(d1.getValueAt(selectIndex,1).toString());
     txtcarti.setSelectedItem(d1.getValueAt(selectIndex,2).toString());//seteaza elementul selectat cu valoarea din a 2-a coloana a randului
     txtemiteredata.getCalendar();
     txtrdata.getCalendar();
     

        jButton1.setEnabled(false);//seteaza butonul dezactivat

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //creaza un obiect si il seteaza pentru tabel
        //preia index-ul randului selectat din tabel si salveaza in variabila selectIndex
        

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
     int selectIndex = jTable1.getSelectedRow();
     
     int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        

        try {
            pst = con.prepareStatement("delete from emitere where id = ?");//pregateste o interogare care sterge datele din tabel
            
            pst.setInt(1,id);
            

            int k = pst.executeUpdate();

            if(k== 1)
            {
                JOptionPane.showMessageDialog(this,"Sters!");

                txtid.setText("");
                txtcarti.setSelectedIndex(-1);
                txtmembru.setText("");
                Emitere_load();
                
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eroare");
            }
//preia exceptiile in cazul in care exista
        } catch (SQLException ex) {
            Logger.getLogger(Emitere.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        // TODO add your handling code here:
        //verifica daca un id membru introdus in baza de date si afiseaza numele membrului daca exista
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) //verifica daca tasta apasata este ENTER, daca este codul se executa normal
        {
            String mid = txtid.getText();
            
            try {
                pst = con.prepareStatement("select * from membrii where id = ?");//pregateste o declaratie SQL care va selecta toate coloanele din tabelul membrii unde mid = id
                pst.setString(1, mid);
                
                rs = pst.executeQuery(); //executa declaratia SQL
                
                //verifica daca exista un rand in rezultate
                if(rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this, "ID membru nu a fost gasit!");
                }
                else
                {
                    String numemembru = rs.getString("nume");
                    txtmembru.setText(numemembru.trim());
                }
                
                //preia exceptiile in cazul in care exista
            } catch (SQLException ex) {
                Logger.getLogger(Emitere.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }//GEN-LAST:event_txtidKeyPressed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Emitere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emitere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emitere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emitere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emitere().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtcarti;
    private com.toedter.calendar.JDateChooser txtemiteredata;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmembru;
    private com.toedter.calendar.JDateChooser txtrdata;
    // End of variables declaration//GEN-END:variables

    

    private static class con {

        public con() {
        }
    }
}
