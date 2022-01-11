
import Helper.*;
import Model.Musteriler;
import Model.Satislar;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class CalisanEkranii extends javax.swing.JFrame {

   DBConnection conn=new DBConnection();
   Connection connection=null;
   Statement statement= null;
   ResultSet resultset;
   DefaultTableModel model;
   String id;
    public CalisanEkranii() {
        initComponents();
        setLocationRelativeTo(null);
        populateTable();
        populateTable2();
        
    }


     public ArrayList<Satislar> getSatislar() throws SQLException{
     ArrayList<Satislar> List=new ArrayList<>();
        
       try{        
        connection= conn.getConnection();
        statement= connection.createStatement();
        resultset= statement.executeQuery("SELECT* FROM SATISLAR"); 
        while(resultset.next()){
      
            List.add(new Satislar( resultset.getInt("SATIS_NO"),
                    resultset.getInt("URUN_NO"),
                    resultset.getInt("CALISAN_NO"),
                    resultset.getString("MUSTERİ_CARD_NO"),
                    resultset.getString("SATIS_TARIHI")));}}
            
       catch(SQLException exception){           
        conn.showErrorMessage(exception);}
       finally{
       connection.close();
       statement.close();
       resultset.close();}
       return List;
}
    
        public void populateTable(){
        model=(DefaultTableModel)tblS.getModel();
        model.setRowCount(0);
       
        try{
                ArrayList<Satislar> List=getSatislar();
                for(Satislar s: List){
                    Object[] row={s.getSatisNo(),s.getUrunNo(),s.getCalisanNo(),s.getMusteriKartNo(),s.getSatisTarihi()};
                    model.addRow(row);
                    }
        }
        catch(SQLException exception1){
        }
       
    }

       public ArrayList<Musteriler> getMusteriler() throws SQLException{
       ArrayList<Musteriler> List=new ArrayList<>();
        
       try{        
        connection= conn.getConnection();
        statement= connection.createStatement();
        resultset= statement.executeQuery("SELECT* FROM MUSTERILER"); 
        while(resultset.next()){
      
            List.add(new Musteriler( resultset.getString("MUSTERI_CARD_NO"),
                    resultset.getString("ISIM"),
                    resultset.getString("SOYISIM"),
                    resultset.getString("ADRES"),
                    resultset.getString("TELEFON"),
                    resultset.getString("CINSIYET"),
                    resultset.getString("KART_ALIM_TARIHI"),
                    resultset.getInt("TOPLAM_PUAN")));}}
            
       catch(SQLException exception){           
        conn.showErrorMessage(exception);}
       finally{
       connection.close();
       statement.close();
       resultset.close();}
       return List;
}
    
        public void populateTable2(){
        model=(DefaultTableModel)tblM.getModel();
        model.setRowCount(0);
       
        try{
                ArrayList<Musteriler> List=getMusteriler();
                for(Musteriler m: List){
                    Object[] row={m.getMusteriKartNo(),m.getIsim(),m.getSoyisim(),m.getAdres(),m.getTelefon(),m.getCinsiyet(),m.getKartAlimTarihi(),m.getToplamPuan()};
                    model.addRow(row);
                    }
        }
        catch(SQLException exception1){
        }
       
    }

    public void tableChange2(String no,String isim,String soyad,String adres,String telefon,String cinsiyet, int tpuan){
        PreparedStatement statement=null;
        try{
       connection= conn.getConnection();
       String sql="UPDATE MUSTERILER SET ISIM = ?,SOYISIM = ?, ADRES = ?, TELEFON = ?, CINSIYET = ?, TOPLAM_PUAN = ? WHERE MUSTERI_CARD_NO = ?";
       statement=connection.prepareStatement(sql);
       statement.setString(1, isim);
       statement.setString(2, soyad);
       statement.setString(3, adres);
       statement.setString(4, telefon);
       statement.setString(5, cinsiyet);
       statement.setInt(6, tpuan);
       statement.setString(7, no);
       int result=statement.executeUpdate();
       populateTable2(); 
       }catch(SQLException exception){
           conn.showErrorMessage(exception);}
       finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
               }
}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblS = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtUno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMKartNo = new javax.swing.JTextField();
        btnEkleS = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        txtAra2 = new javax.swing.JTextField();
        btnAraMusteri = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblM = new javax.swing.JTable();
        btnGetir2 = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        areT = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        areM = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        areC = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnEkleM = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        areS = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        areA = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        areI = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        btnGuncelle = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(210, 229, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Satış no", "Ürün no", "Çalışan no", "Müşteri kart no", "Satış tarihi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblS);
        if (tblS.getColumnModel().getColumnCount() > 0) {
            tblS.getColumnModel().getColumn(0).setResizable(false);
            tblS.getColumnModel().getColumn(1).setResizable(false);
            tblS.getColumnModel().getColumn(2).setResizable(false);
            tblS.getColumnModel().getColumn(3).setResizable(false);
            tblS.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel2.setText("Ürün no:");

        txtUno.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel3.setText("Çalışan no:");

        txtCno.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Müşteri kart no:");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtMKartNo.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N

        btnEkleS.setBackground(new java.awt.Color(255, 255, 0));
        btnEkleS.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnEkleS.setText("SATIŞ YAP");
        btnEkleS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMKartNo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEkleS, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtUno, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCno, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMKartNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnEkleS))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Satış", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel5.setText("Ürün no:");

        jTextField5.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N

        txtAra2.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N

        btnAraMusteri.setBackground(new java.awt.Color(255, 255, 0));
        btnAraMusteri.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnAraMusteri.setText("ARAMA");
        btnAraMusteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraMusteriActionPerformed(evt);
            }
        });

        tblM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Müşteri kart no", "İsim", "Soyisim", "Adres", "Telefon", "Cinsiyet", "Kart alım tarihi", "Toplam puan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblM);
        if (tblM.getColumnModel().getColumnCount() > 0) {
            tblM.getColumnModel().getColumn(0).setResizable(false);
            tblM.getColumnModel().getColumn(1).setResizable(false);
            tblM.getColumnModel().getColumn(2).setResizable(false);
            tblM.getColumnModel().getColumn(3).setResizable(false);
            tblM.getColumnModel().getColumn(4).setResizable(false);
            tblM.getColumnModel().getColumn(5).setResizable(false);
            tblM.getColumnModel().getColumn(6).setResizable(false);
            tblM.getColumnModel().getColumn(7).setResizable(false);
        }

        btnGetir2.setBackground(new java.awt.Color(255, 255, 0));
        btnGetir2.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnGetir2.setText("TABLOYU GETİR");
        btnGetir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetir2ActionPerformed(evt);
            }
        });

        btnSil.setBackground(new java.awt.Color(255, 255, 0));
        btnSil.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnSil.setText("SİL");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areT.setColumns(20);
        areT.setRows(5);
        jScrollPane10.setViewportView(areT);

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areM.setColumns(20);
        areM.setRows(5);
        jScrollPane4.setViewportView(areM);

        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areC.setColumns(20);
        areC.setRows(5);
        jScrollPane11.setViewportView(areC);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel11.setText("Cinsiyet");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel1.setText("Müşteri kart no");

        btnEkleM.setBackground(new java.awt.Color(255, 255, 0));
        btnEkleM.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnEkleM.setText("EKLE");
        btnEkleM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleMActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel12.setText("Telefon");

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areS.setColumns(20);
        areS.setRows(5);
        jScrollPane5.setViewportView(areS);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel6.setText("Soyisim");

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areA.setColumns(20);
        areA.setRows(5);
        jScrollPane6.setViewportView(areA);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel7.setText("Adres");

        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areI.setColumns(20);
        areI.setRows(5);
        jScrollPane7.setViewportView(areI);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel8.setText("İsim");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(108, 108, 108))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEkleM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEkleM)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel5);

        btnGuncelle.setBackground(new java.awt.Color(255, 255, 0));
        btnGuncelle.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnGuncelle.setText("GÜNCELLE");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("MÜŞTERİ EKLEME");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnAraMusteri)
                                    .addGap(45, 45, 45)
                                    .addComponent(txtAra2))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGap(626, 626, 626)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(btnSil, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(btnGetir2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAraMusteri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnGetir2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnSil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuncelle)))
                .addGap(2492, 2492, 2492)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 753, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Müşteri", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleSActionPerformed
          id=null;
           PreparedStatement statement=null;
        if(txtUno.getText().length()==0 ||txtCno.getText().length()==0
            ||txtMKartNo.getText().length()==0 ){
            Helper.showMsg("fill"); }
        else{try{
            SimpleDateFormat bicim=new SimpleDateFormat("dd/M/yyyy");
            Date tarih= new Date();
            connection= conn.getConnection();
            String sql="insert into SATISLAR(URUN_NO,CALISAN_NO,MUSTERI_CARD_NO,SATIS_TARIHI) values(?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.valueOf(txtUno.getText()));
            statement.setInt(2,Integer.valueOf(txtCno.getText()));
            statement.setString(3,txtMKartNo.getText());
            statement.setString(4,bicim.format(tarih));
            int result=statement.executeUpdate();
            populateTable();
            populateTable2();
        }catch(SQLException exception){
            conn.showErrorMessage(exception);}
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
        }
    }//GEN-LAST:event_btnEkleSActionPerformed

    private void btnEkleMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleMActionPerformed
              id=null;
            PreparedStatement statement=null;
        if(areM.getText().length()==0 ||areI.getText().length()==0 ||areS.getText().length()==0 ||areA.getText().length()==0
            ||areT.getText().length()==0 ||areC.getText().length()==0 ){
            Helper.showMsg("fill"); }
        else{try{
            SimpleDateFormat bicim=new SimpleDateFormat("dd/M/yyyy");
            Date tarih= new Date();
            connection= conn.getConnection();
            String sql="insert into MUSTERILER(MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values(?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,areM.getText());
            statement.setString(2,areI.getText());
            statement.setString(3,areS.getText());
            statement.setString(4,areA.getText());
            statement.setString(5,areT.getText());
            statement.setString(6,areC.getText());
            statement.setString(7,bicim.format(tarih));
            statement.setInt(8,0);
            int result=statement.executeUpdate();
            populateTable2();
        }catch(SQLException exception){
            conn.showErrorMessage(exception);}
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
        }
    }//GEN-LAST:event_btnEkleMActionPerformed

    private void btnAraMusteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraMusteriActionPerformed
            id=null;
            if(txtAra2.getText().length()!=0){
            String arama=txtAra2.getText();
            TableRowSorter<DefaultTableModel> tableRowSorter3= new TableRowSorter<DefaultTableModel>(model);
            tblM.setRowSorter(tableRowSorter3);
            tableRowSorter3.setRowFilter(RowFilter.regexFilter(arama));}
    }//GEN-LAST:event_btnAraMusteriActionPerformed

    private void btnGetir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetir2ActionPerformed
        id=null;
        String arama="";
        txtAra2.setText("");
        TableRowSorter<DefaultTableModel> tableRowSorter2= new TableRowSorter<DefaultTableModel>(model);
        tblM.setRowSorter(tableRowSorter2);
        tableRowSorter2.setRowFilter(RowFilter.regexFilter(arama));
    }//GEN-LAST:event_btnGetir2ActionPerformed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
             id=null;
            if(tblM.getSelectedRow()!=-1){
            model=(DefaultTableModel)tblM.getModel();
            int selectedRowIndex=tblM.getSelectedRow();
            String selectKartNo=model.getValueAt(selectedRowIndex, 0).toString();
            String selectIsim=model.getValueAt(selectedRowIndex, 1).toString();
            String selectSoyad=model.getValueAt(selectedRowIndex, 2).toString();
            String selectAdres=model.getValueAt(selectedRowIndex, 3).toString();
            String selectTelefon=model.getValueAt(selectedRowIndex, 4).toString();
            String selectCinsiyet=model.getValueAt(selectedRowIndex, 5).toString();
            String selectKATarihi=model.getValueAt(selectedRowIndex, 6).toString();
            int selectToplamPuan=Integer.parseInt(model.getValueAt(selectedRowIndex, 7).toString());

            String newIsim=JOptionPane.showInputDialog(null," Yeni müşteri ismi giriniz.",selectIsim);
            String newSoyad=JOptionPane.showInputDialog(null," Yeni müşteri soyadı giriniz.",selectSoyad);
            String newAdres=JOptionPane.showInputDialog(null," Yeni müşteri adresi giriniz.",selectAdres);
            String newTelefon=JOptionPane.showInputDialog(null," Yeni müşteri telefonu giriniz.",selectTelefon);
            String newCinsiyet=JOptionPane.showInputDialog(null," Yeni müşteri cinsiyeti giriniz.",selectCinsiyet);
            String newToplamPuan=JOptionPane.showInputDialog(null," Yeni müşteri puanı giriniz.",selectToplamPuan);
            if(newIsim.length()!=0 && newSoyad.length()!=0 && newAdres.length()!=0 && newTelefon.length()!=0 && newCinsiyet.length()!=0 && newToplamPuan.length()!=0){
                tableChange2(selectKartNo,newIsim,newSoyad,newAdres,newTelefon,newCinsiyet,Integer.parseInt(newToplamPuan));}
            else{
                Helper.showMsg("fill");}}
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void tblMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMMouseClicked
          tblM.getSelectionModel().addListSelectionListener(tblM);
          id=tblM.getValueAt(tblM.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_tblMMouseClicked

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        PreparedStatement statement=null;
        if(id==null){Helper.showMsg("Lütfen silmek istediğiniz kişiyi seçiniz.");}
        else{
            if(Helper.confirm("sure",id,"kart numarasına sahip müşteri silinecektir")){
                try{
                    connection= conn.getConnection();
                    String sql="DELETE FROM MUSTERILER WHERE MUSTERI_CARD_NO = ?";
                    statement=connection.prepareStatement(sql);
                    statement.setString(1,id);
                    int result=statement.executeUpdate();
                    populateTable2();
                }catch(SQLException exception){
                    conn.showErrorMessage(exception);}
                finally{
                    try {
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                    }
                }
            }}
    }//GEN-LAST:event_btnSilActionPerformed

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
            java.util.logging.Logger.getLogger(CalisanEkranii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalisanEkranii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalisanEkranii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalisanEkranii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalisanEkranii().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areA;
    private javax.swing.JTextArea areC;
    private javax.swing.JTextArea areI;
    private javax.swing.JTextArea areM;
    private javax.swing.JTextArea areS;
    private javax.swing.JTextArea areT;
    private javax.swing.JButton btnAraMusteri;
    private javax.swing.JButton btnEkleM;
    private javax.swing.JButton btnEkleS;
    private javax.swing.JButton btnGetir2;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblM;
    private javax.swing.JTable tblS;
    private javax.swing.JTextField txtAra2;
    private javax.swing.JTextField txtCno;
    private javax.swing.JTextField txtMKartNo;
    private javax.swing.JTextField txtUno;
    // End of variables declaration//GEN-END:variables
}
