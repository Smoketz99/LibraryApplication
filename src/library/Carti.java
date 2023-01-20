/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Carti extends javax.swing.JFrame {
    
    public Carti() {
        initComponents();
        Connect();
        Categorie();
        Autor();
        Editura();
        Carti_load();
        
    }
    
    public class CategorieItem
    {
        int id;
        String nume;
        
        
        public CategorieItem(int id,String nume)
        {
            this.id = id;
            this.nume = nume;
        }
        
        public String toString()
        {
            return nume;
        }
    }
    
    public class AutorItem
    {
        int id;
        String nume;
        
        
        public AutorItem(int id,String nume)
        {
            this.id = id;
            this.nume = nume;
        }
        
        public String toString()
        {
            return nume;
        }
    }
    
    
    
     public class EdituraItem
    {
        int id;
        String nume;
        
        
        public EdituraItem(int id,String nume)
        {
            this.id = id;
            this.nume = nume;
        }
        
        public String toString()
        {
            return nume;
        }
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
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Categorie()
    {
        try {
            pst = con.prepareStatement("select * from categorie");//creaza o interogare SQL care selecteaza datele din tabela creata in baza de date
            rs = pst.executeQuery();//executa interogarea
            txtcategorie.removeAllItems();
            
            while(rs.next())
            {
                txtcategorie.addItem(new CategorieItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Autor()
    {
        try {
            pst = con.prepareStatement("select * from autor");
            rs = pst.executeQuery();
            txtautor.removeAllItems();
            
            while(rs.next())
            {
                txtautor.addItem(new AutorItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void Editura()
    {
        try {
            pst = con.prepareStatement("select * from editura");
            rs = pst.executeQuery();
            txteditura.removeAllItems();
            
            while(rs.next())
            {
                txteditura.addItem(new EdituraItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void Carti_load()
    {
        int c;
        //creaza o interogare SQL care selecteaza datele din tabela creata in baza de date
        //executa interogarea
        try {
            pst = con.prepareStatement("select b.id,b.nume,c.Nume,a.nume,p.nume,b.continut,b.pagini,b.editia from carti b JOIN categorie c On b.Categorie = c.id JOIN autor a On b.autor = a.id JOIN editura p On b.editura = p.id");
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
                    v2.add(rs.getString("b.id"));
                    v2.add(rs.getString("b.nume"));
                    v2.add(rs.getString("c.Nume"));
                    v2.add(rs.getString("a.nume"));
                    v2.add(rs.getString("p.nume"));
                    v2.add(rs.getString("b.continut"));
                    v2.add(rs.getString("b.pagini"));
                    v2.add(rs.getString("b.editia"));
                }
                
                d.addRow(v2);//adauga vectorul ca rand
                
            }
            
            //loop care ruleaza pentru fiecare rand
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
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
        txtcontinut = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtautor = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txteditura = new javax.swing.JComboBox();
        txtcategorie = new javax.swing.JComboBox();
        txtname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnumar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txteditia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)), "Carti", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(153, 0, 153))); // NOI18N

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
                "ID", "Nume carte", "Categorie", "Autor", "Editura", "Continut", "Pagini", "Editia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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
        jLabel2.setText("Categorie");

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setText("Anuleaza");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Nume");

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
        jLabel4.setText("Autor");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Editura");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Continut");

        txtcategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategorieActionPerformed(evt);
            }
        });

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Numar de pagini");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Editia");

        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtcontinut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtautor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txteditura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtcategorie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtnumar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txteditia, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txteditia, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(txtnumar)))))
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(txtcategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(txtcontinut, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txteditura, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButton1)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtcategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txteditura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtcontinut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(txtnumar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(15, 15, 15)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txteditia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
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
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        
        String Nume = txtname.getText();
       CategorieItem citem = (CategorieItem)txtcategorie.getSelectedItem();
       AutorItem aitem = (AutorItem)txtautor.getSelectedItem();
       EdituraItem pitem = (EdituraItem)txteditura.getSelectedItem();
       
       String continut = txtcontinut.getText();
       String pagini = txtnumar.getText();
       String editia = txteditia.getText();
        
//creaza o interogare care utilizeaza datele din tabel si le updateaza
        try {
            pst = con.prepareStatement("update carti set Nume = ?, Categorie = ?, Autor = ?, Editura = ?, Continut = ?, Pagini = ?, Editia = ? where id = ?");
            pst.setString(1,Nume);
            pst.setInt(2,citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5,continut);
            pst.setString(6,pagini);
            pst.setString(7,editia);
            pst.setInt(8, id);

            int k = pst.executeUpdate();

            //se verifica daca datele au fost actualizate cu succes
            if(k== 1)
            {
                JOptionPane.showMessageDialog(this,"Carte modificata!");

                txtname.setText("");
                txtcategorie.setSelectedIndex(-1);
                txtautor.setSelectedIndex(-1);
                txteditura.setSelectedIndex(-1);
                txtcontinut.setText("");
                txtnumar.setText("");
                txteditia.setText("");
                jButton1.setEnabled(true);//butonul poate sa fie apasat
                
                txtname.requestFocus();
                Carti_load();
    
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eroare");
            }
//preia exceptiile in cazul in care exista
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String Nume = txtname.getText();
       CategorieItem citem = (CategorieItem)txtcategorie.getSelectedItem();
       AutorItem aitem = (AutorItem)txtautor.getSelectedItem();
       EdituraItem pitem = (EdituraItem)txteditura.getSelectedItem();
       
       String continut = txtcontinut.getText();
       String pagini = txtnumar.getText();
       String editia = txteditia.getText();
        
        
        

        try {
            pst = con.prepareStatement("insert into carti(Nume,Categorie,Autor,Editura,Continut,Pagini,Editia)values(?,?,?,?,?,?,?)");//se creaza o interogare SQL si insereaza datele din baza de date
            pst.setString(1,Nume);
            pst.setInt(2,citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5,continut);
            pst.setString(6,pagini);
            pst.setString(7,editia);

            int k = pst.executeUpdate();

            //afiseaza mesajul "categorie creata" daca a fost creat cu succes si "eroare" daca nu a fost creat
            if(k== 1)
            {
                JOptionPane.showMessageDialog(this,"Carte creata!");

                txtname.setText("");
                txtcategorie.setSelectedIndex(-1);
                txtautor.setSelectedIndex(-1);
                txteditura.setSelectedIndex(-1);
                txtcontinut.setText("");
                txtnumar.setText("");
                txteditia.setText("");
                
                txtname.requestFocus();
                Carti_load();//reincarca in timp real datele din tabel
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eroare");
            }

//preia exceptiile in cazul in care exista
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
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
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()); //preia valoarea din prima coloana a randului selectat din tabel si o converteste in int
        
        
            String Nume = txtname.getText();
       CategorieItem citem = (CategorieItem)txtcategorie.getSelectedItem(); //preia elementul selectat din combobox si il salveaza in variabila citem 
       AutorItem aitem = (AutorItem)txtautor.getSelectedItem();
       EdituraItem pitem = (EdituraItem)txteditura.getSelectedItem();
       
       String continut = txtcontinut.getText();//preia textul din camp-ul txtcontinut si il salveaza in variabila continut
       String numar = txtnumar.getText();
       String editia = txteditia.getText();
       

        jButton1.setEnabled(false);//seteaza butonul dezactivat

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //creaza un obiect si il seteaza pentru tabel
        //preia index-ul randului selectat din tabel si salveaza in variabila selectIndex
        

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        

        try {
            pst = con.prepareStatement("delete from carti where id = ?");//pregateste o interogare care sterge datele din tabel
            
            pst.setInt(1, id);

            int k = pst.executeUpdate();

            if(k== 1)
            {
                JOptionPane.showMessageDialog(this,"Carte stearsa!");

                txtname.setText("");
                txtcategorie.setSelectedIndex(-1);
                txtautor.setSelectedIndex(-1);
                txteditura.setSelectedIndex(-1);
                txtcontinut.setText("");
                txtnumar.setText("");
                txteditia.setText("");
                jButton1.setEnabled(true);//butonul poate sa fie apasat
                
                txtname.requestFocus();
                Carti_load();
    
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eroare");
            }
//preia exceptiile in cazul in care exista
        } catch (SQLException ex) {
            Logger.getLogger(Carti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtcategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategorieActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Carti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Carti().setVisible(true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtautor;
    private javax.swing.JComboBox txtcategorie;
    private javax.swing.JTextField txtcontinut;
    private javax.swing.JTextField txteditia;
    private javax.swing.JComboBox txteditura;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnumar;
    // End of variables declaration//GEN-END:variables

    

    private static class con {

        public con() {
        }
    }
}
