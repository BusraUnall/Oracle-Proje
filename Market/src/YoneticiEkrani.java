import Helper.*;
import Model.Calisanlar;
import Model.Stoklar;
import Model.Tedarikciler;
import Model.Urunler;
import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.CallableStatement;

public class YoneticiEkrani extends javax.swing.JFrame {

   DBConnection conn=new DBConnection();
   Connection connection=null;
   Statement statement= null;
   ResultSet resultset;
   DefaultTableModel model;
   String id;
   String arama="";
    public YoneticiEkrani() {
        initComponents();
        setLocationRelativeTo(null);
        populateTable();
        populateTable2();
        populateTable3();
        populateTable4();
    }

       public ArrayList<Calisanlar> getCalisanlar() throws SQLException{
       ArrayList<Calisanlar> List=new ArrayList<>(); 
       try{        
        connection= conn.getConnection();
        statement= connection.createStatement();
        resultset= statement.executeQuery("SELECT* FROM CALISANLAR"); 
        while(resultset.next()){
      
            List.add(new Calisanlar( resultset.getInt("CALISAN_NO"),
                    resultset.getString("ISIM"),
                    resultset.getString("SOYISIM"),
                    resultset.getString("DOGUM_TARIHI"),
                    resultset.getString("DOGUM_YERI"),
                    resultset.getString("ADRES"),
                    resultset.getString("TELEFON"),
                    resultset.getString("CINSIYET"),
                    resultset.getString("GOREV"),
                    resultset.getString("SIGORTA_NO"),
                    resultset.getString("BANKA_HESAP_NO"),
                    resultset.getInt("MAAS")));}}
            
       catch(SQLException exception){           
        conn.showErrorMessage(exception);}
       finally{
       connection.close();
       statement.close();
       resultset.close();}
       return List;
}

       public ArrayList<Tedarikciler> getTedarikciler() throws SQLException{
       ArrayList<Tedarikciler> List=new ArrayList<>(); 
       try{        
        connection= conn.getConnection();
        statement= connection.createStatement();
        resultset= statement.executeQuery("SELECT* FROM TEDARIKCILER"); 
        while(resultset.next()){
      
            List.add(new Tedarikciler( resultset.getInt("TEDARIKCI_NO"),
                    resultset.getString("FIRMA_ISMI"),
                    resultset.getString("ADRES"),
                    resultset.getString("TELEFON"),
                    resultset.getString("E_MAIL")));}}
            
       catch(SQLException exception){           
        conn.showErrorMessage(exception);}
       finally{
       connection.close();
       statement.close();
       resultset.close();}
       return List;
}

       public ArrayList<Stoklar> getStoklar() throws SQLException{
       ArrayList<Stoklar> List=new ArrayList<>(); 
       try{        
        connection= conn.getConnection();
        statement= connection.createStatement();
        resultset= statement.executeQuery("SELECT* FROM STOKLAR"); 
        while(resultset.next()){
      
            List.add(new Stoklar( resultset.getInt("STOK_NO"),
                    resultset.getInt("GRUP_NO"),
                    resultset.getInt("TEDARIKCI_NO"),
                    resultset.getInt("URUN_NO"),
                    resultset.getString("GIRIS_TARIHI"),
                    resultset.getInt("URUN_SAYISI"),
                    resultset.getInt("RAF_OMRU")));}}
            
       catch(SQLException exception){           
        conn.showErrorMessage(exception);}
       finally{
       connection.close();
       statement.close();
       resultset.close();}
       return List;
}

       public ArrayList<Urunler> getUrunler() throws SQLException{
       ArrayList<Urunler> List=new ArrayList<>(); 
       try{        
        connection= conn.getConnection();
        statement= connection.createStatement();
        resultset= statement.executeQuery("SELECT* FROM URUNLER"+arama); 
        while(resultset.next()){
      
            List.add(new Urunler( resultset.getInt("URUN_NO"),
                    resultset.getInt("GRUP_NO"),
                    resultset.getString("URUN_ISIM"),
                    resultset.getString("MARKA"),
                    resultset.getFloat("FIYAT"),
                    resultset.getInt("GRAMAJ")));}}
            
       catch(SQLException exception){           
        conn.showErrorMessage(exception);}
       finally{
       connection.close();
       statement.close();
       resultset.close();}
       return List;
}

    
        public void populateTable2(){
        model=(DefaultTableModel)tblC.getModel();
        model.setRowCount(0);
        try{
                ArrayList<Calisanlar> List=getCalisanlar();
                for(Calisanlar c: List){
                    Object[] row={c.getCalisanNo(),c.getIsim(),c.getSoyisim(),c.getDogumTarihi(),c.getDogumYeri(),c.getAdres(),c.getTelefon(),c.getCinsiyet(),
                                 c.getGorev(),c.getSigortaNo(),c.getBankaHesapNo(),c.getMaas()};
                    model.addRow(row);
                    }
        }
        catch(SQLException exception1){
        }    
    }
        public void populateTable(){
        model=(DefaultTableModel)tblT.getModel();
        model.setRowCount(0);
        try{
                ArrayList<Tedarikciler> List=getTedarikciler();
                for(Tedarikciler t: List){
                    Object[] row={t.getTedarikciNo(),t.getFirmaIsmi(),t.getAdres(),t.getTelefon(),t.getE_mail()};
                    model.addRow(row);
                    }
        }
        catch(SQLException exception1){
        }
    }
        public void populateTable3(){
        model=(DefaultTableModel)tblStok.getModel();
        model.setRowCount(0);
        try{
                ArrayList<Stoklar> List=getStoklar();
                for(Stoklar s: List){
                    Object[] row={s.getStokNo(),s.getGrupNo(),s.getTedarikciNo(),s.getUrunNo(),s.getGirisTarihi(),s.getUrunSayisi(),s.getRafOmru()};
                    model.addRow(row);
                    }
        }
        catch(SQLException exception1){
        }
    }
        public void populateTable4(){
        model=(DefaultTableModel)tblU.getModel();
        model.setRowCount(0);
        try{
                ArrayList<Urunler> List=getUrunler();
                for(Urunler u: List){
                    Object[] row={u.getUrunNo(),u.getGrupNo(),u.getUrunIsim(),u.getMarka(),u.getFiyat(),u.getGramaj()};
                    model.addRow(row);
                    }
        }
        catch(SQLException exception1){
        }
    }
    public void tableChange2(int no,String isim,String soyisim,String dTarihi,String dYeri,String adres,String telefon,String cinsiyet,String gorev,String sigortaNo,String bankaHesapNo, int maas){
        PreparedStatement statement=null;
        try{
       connection= conn.getConnection();
       String sql="UPDATE CALISANLAR SET ISIM = ?, SOYISIM = ?, DOGUM_TARIHI = ?, DOGUM_YERI = ?, ADRES = ?, TELEFON = ?, CINSIYET = ?, GOREV = ?, SIGORTA_NO = ?, BANKA_HESAP_NO = ?, MAAS = ? WHERE CALISAN_NO = ?";
       statement=connection.prepareStatement(sql);
       statement.setString(1, isim);
       statement.setString(2, soyisim);
       statement.setString(3, dTarihi);
       statement.setString(4, dYeri);
       statement.setString(5, adres);
       statement.setString(6, telefon);
       statement.setString(7, cinsiyet);
       statement.setString(8, gorev);
       statement.setString(9, sigortaNo);
       statement.setString(10, bankaHesapNo);
       statement.setInt(11, maas);
       statement.setInt(12, no);
       int result=statement.executeUpdate();
       populateTable2(); 
       }catch(SQLException exception){
           conn.showErrorMessage(exception);
   }
       finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
               }
}
    }

    public void toplamSayi(int a){
    try{
   connection= conn.getConnection();
    CallableStatement cstmt;
    cstmt=connection.prepareCall("CALL system.PRC_TOPLAM(?,?)");
    cstmt.setInt(1, a);    
    cstmt.registerOutParameter(2, Types.INTEGER);  
    cstmt.executeUpdate(); 
    String message=String.valueOf(cstmt.getInt(2));
    txtSayi.setText(message);
    cstmt.close();
}
    catch(SQLException exception){
    conn.showErrorMessage(exception);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblC = new javax.swing.JTable();
        btnSil = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        aredyeri = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        arecno = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        areadres = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnEkleM = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        aredtarihi = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        aresisim = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        areisim = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        aretelefon = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        aremaas = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        arecins = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        aresno = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        arebhno = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        aregorev = new javax.swing.JTextArea();
        btnGuncelle = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblU = new javax.swing.JTable();
        btnSKahvaltılık = new javax.swing.JButton();
        btnYemek = new javax.swing.JButton();
        btnETSarkuteri = new javax.swing.JButton();
        btnSKuruyemis = new javax.swing.JButton();
        btnUMamuller = new javax.swing.JButton();
        btnMSebze = new javax.swing.JButton();
        btnTemizlik = new javax.swing.JButton();
        btnIcecek = new javax.swing.JButton();
        btnKBurun = new javax.swing.JButton();
        btnTum = new javax.swing.JButton();
        txtSayi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblT = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblStok = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(201, 220, 241));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Çalışan no", "İsim", "Soyisim", "Doğum tarihi", "Doğum yeri", "Adres", "Telefon", "Cinsiyet", "Görev", "Sigorta No", "Banka hesap no", "Maaş"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblC);

        btnSil.setBackground(new java.awt.Color(0, 204, 0));
        btnSil.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnSil.setText("SİL");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aredyeri.setColumns(20);
        aredyeri.setRows(5);
        jScrollPane10.setViewportView(aredyeri);

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        arecno.setColumns(20);
        arecno.setRows(5);
        jScrollPane4.setViewportView(arecno);

        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areadres.setColumns(20);
        areadres.setRows(5);
        jScrollPane11.setViewportView(areadres);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel11.setText("Cinsiyet");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel1.setText("Çalışan no");

        btnEkleM.setBackground(new java.awt.Color(0, 204, 0));
        btnEkleM.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnEkleM.setText("EKLE");
        btnEkleM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleMActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel12.setText("Doğum yeri");

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aredtarihi.setColumns(20);
        aredtarihi.setRows(5);
        jScrollPane5.setViewportView(aredtarihi);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel6.setText("Soyisim");

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aresisim.setColumns(20);
        aresisim.setRows(5);
        jScrollPane6.setViewportView(aresisim);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel7.setText("Adres");

        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areisim.setColumns(20);
        areisim.setRows(5);
        jScrollPane7.setViewportView(areisim);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel8.setText("İsim");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel13.setText("Sigorta no");

        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aretelefon.setColumns(20);
        aretelefon.setRows(5);
        jScrollPane8.setViewportView(aretelefon);

        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aremaas.setColumns(20);
        aremaas.setRows(5);
        jScrollPane12.setViewportView(aremaas);

        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        arecins.setColumns(20);
        arecins.setRows(5);
        jScrollPane9.setViewportView(arecins);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel14.setText("Görev");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel15.setText("Banka hesap no");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel16.setText("Doğum tarihi");

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel17.setText("Telefon");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel18.setText("Maaş");

        jScrollPane14.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aresno.setColumns(20);
        aresno.setRows(5);
        jScrollPane14.setViewportView(aresno);

        jScrollPane15.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        arebhno.setColumns(20);
        arebhno.setRows(5);
        jScrollPane15.setViewportView(arebhno);

        jScrollPane16.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aregorev.setColumns(20);
        aregorev.setRows(5);
        jScrollPane16.setViewportView(aregorev);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(jLabel14))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel13)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEkleM, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEkleM)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel6);

        btnGuncelle.setBackground(new java.awt.Color(0, 204, 0));
        btnGuncelle.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnGuncelle.setText("GÜNCELLE");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 204, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("MÜŞTERİ EKLEME");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(btnSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 72, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuncelle))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(709, 709, 709))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 767, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Çalışan", jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün no", "Grup no", "Ürün ismi", "Marka", "Fiyat", "Gramaj"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(tblU);
        if (tblU.getColumnModel().getColumnCount() > 0) {
            tblU.getColumnModel().getColumn(0).setResizable(false);
            tblU.getColumnModel().getColumn(1).setResizable(false);
            tblU.getColumnModel().getColumn(2).setResizable(false);
            tblU.getColumnModel().getColumn(3).setResizable(false);
            tblU.getColumnModel().getColumn(5).setResizable(false);
        }

        btnSKahvaltılık.setBackground(new java.awt.Color(0, 204, 0));
        btnSKahvaltılık.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnSKahvaltılık.setText("Süt-Kahvaltılık");
        btnSKahvaltılık.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSKahvaltılıkActionPerformed(evt);
            }
        });

        btnYemek.setBackground(new java.awt.Color(0, 204, 0));
        btnYemek.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnYemek.setText("Gıda-Yemek Ürünleri"); // NOI18N
        btnYemek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYemekActionPerformed(evt);
            }
        });

        btnETSarkuteri.setBackground(new java.awt.Color(0, 204, 0));
        btnETSarkuteri.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnETSarkuteri.setText("Et-Tavuk-Şarküteri");
        btnETSarkuteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnETSarkuteriActionPerformed(evt);
            }
        });

        btnSKuruyemis.setBackground(new java.awt.Color(0, 204, 0));
        btnSKuruyemis.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnSKuruyemis.setText("Şekerleme-Kuruyemiş");
        btnSKuruyemis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSKuruyemisActionPerformed(evt);
            }
        });

        btnUMamuller.setBackground(new java.awt.Color(0, 204, 0));
        btnUMamuller.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnUMamuller.setText("Unlu mamüller");
        btnUMamuller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUMamullerActionPerformed(evt);
            }
        });

        btnMSebze.setBackground(new java.awt.Color(0, 204, 0));
        btnMSebze.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnMSebze.setText("Meyve Sebze");
        btnMSebze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSebzeActionPerformed(evt);
            }
        });

        btnTemizlik.setBackground(new java.awt.Color(0, 204, 0));
        btnTemizlik.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnTemizlik.setText("Temizlik");
        btnTemizlik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizlikActionPerformed(evt);
            }
        });

        btnIcecek.setBackground(new java.awt.Color(0, 204, 0));
        btnIcecek.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnIcecek.setText("İçecek");
        btnIcecek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcecekActionPerformed(evt);
            }
        });

        btnKBurun.setBackground(new java.awt.Color(0, 204, 0));
        btnKBurun.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnKBurun.setText("Kişisel Bakım Ürünleri");
        btnKBurun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKBurunActionPerformed(evt);
            }
        });

        btnTum.setBackground(new java.awt.Color(255, 51, 51));
        btnTum.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnTum.setText("Tüm Ürünler");
        btnTum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTumActionPerformed(evt);
            }
        });

        txtSayi.setBackground(new java.awt.Color(255, 153, 255));
        txtSayi.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtSayi.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Ürün sayısı:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSayi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMSebze, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnETSarkuteri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSKuruyemis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIcecek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMamuller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTemizlik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKBurun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnYemek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSKahvaltılık, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnYemek, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSKahvaltılık, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSKuruyemis, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnETSarkuteri, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMSebze, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnUMamuller, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnIcecek, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                                        .addGap(79, 79, 79)
                                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                                .addGap(79, 79, 79)
                                                                .addComponent(btnKBurun, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(btnTemizlik, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSayi, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ürünler", jPanel9);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tedarikçi no", "Firma ismi", "Adres", "Telefon", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tblT);
        if (tblT.getColumnModel().getColumnCount() > 0) {
            tblT.getColumnModel().getColumn(0).setResizable(false);
            tblT.getColumnModel().getColumn(1).setResizable(false);
            tblT.getColumnModel().getColumn(2).setResizable(false);
            tblT.getColumnModel().getColumn(3).setResizable(false);
            tblT.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tedarikçiler", jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblStok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stok no", "Grup no", "Tedarikçi no", "Ürün no", "Giriş tarihi", "Ürün sayısı", "Raf ömrü"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(tblStok);
        if (tblStok.getColumnModel().getColumnCount() > 0) {
            tblStok.getColumnModel().getColumn(0).setResizable(false);
            tblStok.getColumnModel().getColumn(1).setResizable(false);
            tblStok.getColumnModel().getColumn(2).setResizable(false);
            tblStok.getColumnModel().getColumn(3).setResizable(false);
            tblStok.getColumnModel().getColumn(4).setResizable(false);
            tblStok.getColumnModel().getColumn(5).setResizable(false);
            tblStok.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Stoklar", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        id=null;
        if(tblC.getSelectedRow()!=-1){
            model=(DefaultTableModel)tblC.getModel();
            int selectedRowIndex=tblC.getSelectedRow();
            int selectCalisanNo=Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
            String selectIsim=model.getValueAt(selectedRowIndex, 1).toString();
            String selectSoyisim=model.getValueAt(selectedRowIndex, 2).toString();
            String selectDogumTarihi=model.getValueAt(selectedRowIndex, 3).toString();
            String selectDogumYeri=model.getValueAt(selectedRowIndex, 4).toString();
            String selectAdres=model.getValueAt(selectedRowIndex, 5).toString();
            String selectTelefon=model.getValueAt(selectedRowIndex, 6).toString();
            String selectCinsiyet=model.getValueAt(selectedRowIndex, 7).toString();
            String selectGorev=model.getValueAt(selectedRowIndex, 8).toString();
            String selectSigortaNo=model.getValueAt(selectedRowIndex, 9).toString();
            String selectBankaHesapNo=model.getValueAt(selectedRowIndex, 10).toString();
            int selectMaas=Integer.parseInt(model.getValueAt(selectedRowIndex, 11).toString());

            String newIsim=JOptionPane.showInputDialog(null," Yeni çalışan ismi giriniz.",selectIsim);
            String newSoyisim=JOptionPane.showInputDialog(null," Yeni çalışan soyadı giriniz.",selectSoyisim);
            String newDogumTarihi=JOptionPane.showInputDialog(null," Yeni çalışan doğum tarihi giriniz.",selectDogumTarihi);
            String newDogumYeri=JOptionPane.showInputDialog(null," Yeni çalışan doğum yeri giriniz.",selectDogumYeri);
            String newAdres=JOptionPane.showInputDialog(null," Yeni çalışan adresi giriniz.",selectAdres);
            String newTelefon=JOptionPane.showInputDialog(null," Yeni çalışan telefon numarası giriniz.",selectTelefon);
            String newCinsiyet=JOptionPane.showInputDialog(null," Yeni çalışan cinsiyeti giriniz.",selectCinsiyet);
            String newGorev=JOptionPane.showInputDialog(null," Yeni çalışan görevi giriniz.",selectGorev);
            String newSigortaNo=JOptionPane.showInputDialog(null," Yeni çalışan sigorta no'su giriniz.",selectSigortaNo);
            String newBankaHesapNo=JOptionPane.showInputDialog(null," Yeni çalışan banka hesap no'su giriniz.",selectBankaHesapNo);
            String newMaas=JOptionPane.showInputDialog(null," Yeni çalışan maaşı giriniz.",selectMaas);
            if(newIsim.length()!=0 && newSoyisim.length()!=0 && newDogumTarihi.length()!=0&& newDogumYeri.length()!=0&& newAdres.length()!=0 && newTelefon.length()!=0 &&
                newCinsiyet.length()!=0&& newGorev.length()!=0&& newSigortaNo.length()!=0&& newBankaHesapNo.length()!=0&& newMaas.length()!=0){
                tableChange2(selectCalisanNo,newIsim,newSoyisim,newDogumTarihi,newDogumYeri,newAdres,newTelefon,newCinsiyet,newGorev,newSigortaNo,newBankaHesapNo,Integer.parseInt(newMaas));
            }
            else{
                Helper.showMsg("fill");}}
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void btnEkleMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleMActionPerformed
        id=null;
        PreparedStatement statement=null;
        if(arecno.getText().length()==0 ||areisim.getText().length()==0 ||aredtarihi.getText().length()==0 ||aresisim.getText().length()==0
            ||aredyeri.getText().length()==0 ||areadres.getText().length()==0 ||aretelefon.getText().length()==0 ||arecins.getText().length()==0
            ||aregorev.getText().length()==0 ||aresno.getText().length()==0 ||arebhno.getText().length()==0 ||aremaas.getText().length()==0){
            Helper.showMsg("fill"); }
        else{try{
            Date tarih= new Date();
            connection= conn.getConnection();
            String sql="insert into CALISANLAR(CALISAN_NO,ISIM,SOYISIM,DOGUM_TARIHI,DOGUM_YERI,ADRES,TELEFON,CINSIYET,GOREV,SIGORTA_NO,BANKA_HESAP_NO,MAAS) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.valueOf(arecno.getText()));
            statement.setString(2,areisim.getText());
            statement.setString(3,aresisim.getText());
            statement.setString(4,aredtarihi.getText());
            statement.setString(5,aredyeri.getText());
            statement.setString(6,areadres.getText());
            statement.setString(7,aretelefon.getText());
            statement.setString(8,arecins.getText());
            statement.setString(9,aregorev.getText());
            statement.setString(10,aresno.getText());
            statement.setString(11,arebhno.getText());
            statement.setInt(12,Integer.valueOf(aremaas.getText()));
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

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        PreparedStatement statement=null;
        if(id==null){Helper.showMsg("Lütfen silmek istediğiniz kişiyi seçiniz.");}
        else{
            if(Helper.confirm("sure",id,"çalışan no'suna sahip çalışan silinecektir")){
                try{
                    connection= conn.getConnection();
                    String sql="DELETE FROM CALISANLAR WHERE CALISAN_NO = ?";
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

    private void tblCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCMouseClicked
        tblC.getSelectionModel().addListSelectionListener(tblC);
        id=tblC.getValueAt(tblC.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_tblCMouseClicked

    private void btnTumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTumActionPerformed
        arama="";
        try{
            connection= conn.getConnection();
            statement= connection.createStatement();
            resultset= statement.executeQuery("SELECT COUNT(*)AS TOPLAM FROM URUNLER");
            resultset.next();
            txtSayi.setText(resultset.getString(1));
        }catch(SQLException exception){
            conn.showErrorMessage(exception);}
        populateTable4();
    }//GEN-LAST:event_btnTumActionPerformed

    private void btnYemekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYemekActionPerformed
        arama=" WHERE GRUP_NO=239";
        toplamSayi(239);
        populateTable4();
        
    }//GEN-LAST:event_btnYemekActionPerformed

    private void btnSKahvaltılıkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSKahvaltılıkActionPerformed
        arama=" WHERE GRUP_NO=124";
        toplamSayi(124);
        populateTable4();        
    }//GEN-LAST:event_btnSKahvaltılıkActionPerformed

    private void btnSKuruyemisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSKuruyemisActionPerformed
        arama=" WHERE GRUP_NO=304";
        toplamSayi(304);
        populateTable4();
    }//GEN-LAST:event_btnSKuruyemisActionPerformed

    private void btnETSarkuteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnETSarkuteriActionPerformed
        arama=" WHERE GRUP_NO=36";
        toplamSayi(36);
        populateTable4();
    }//GEN-LAST:event_btnETSarkuteriActionPerformed

    private void btnMSebzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMSebzeActionPerformed
        arama=" WHERE GRUP_NO=294";
        toplamSayi(294);
        populateTable4();
    }//GEN-LAST:event_btnMSebzeActionPerformed

    private void btnUMamullerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUMamullerActionPerformed
        arama=" WHERE GRUP_NO=438";
        toplamSayi(438);
        populateTable4();
    }//GEN-LAST:event_btnUMamullerActionPerformed

    private void btnIcecekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcecekActionPerformed
        arama=" WHERE GRUP_NO=582";
        toplamSayi(582);
        populateTable4();
    }//GEN-LAST:event_btnIcecekActionPerformed

    private void btnTemizlikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizlikActionPerformed
        arama=" WHERE GRUP_NO=637";
        toplamSayi(637);
        populateTable4();
    }//GEN-LAST:event_btnTemizlikActionPerformed

    private void btnKBurunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKBurunActionPerformed
        arama=" WHERE GRUP_NO=190";
        toplamSayi(190);
        populateTable4();
    }//GEN-LAST:event_btnKBurunActionPerformed

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
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticiEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areadres;
    private javax.swing.JTextArea arebhno;
    private javax.swing.JTextArea arecins;
    private javax.swing.JTextArea arecno;
    private javax.swing.JTextArea aredtarihi;
    private javax.swing.JTextArea aredyeri;
    private javax.swing.JTextArea aregorev;
    private javax.swing.JTextArea areisim;
    private javax.swing.JTextArea aremaas;
    private javax.swing.JTextArea aresisim;
    private javax.swing.JTextArea aresno;
    private javax.swing.JTextArea aretelefon;
    private javax.swing.JButton btnETSarkuteri;
    private javax.swing.JButton btnEkleM;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnIcecek;
    private javax.swing.JButton btnKBurun;
    private javax.swing.JButton btnMSebze;
    private javax.swing.JButton btnSKahvaltılık;
    private javax.swing.JButton btnSKuruyemis;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnTemizlik;
    private javax.swing.JButton btnTum;
    private javax.swing.JButton btnUMamuller;
    private javax.swing.JButton btnYemek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblC;
    private javax.swing.JTable tblStok;
    private javax.swing.JTable tblT;
    private javax.swing.JTable tblU;
    private javax.swing.JTextField txtSayi;
    // End of variables declaration//GEN-END:variables
}
