/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tokostarmix;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Winda
 */
public class History extends javax.swing.JFrame {

    /**
     * Creates new form History
     */
    public History() {
        // cek session
        if(Session.session.getSession() == null){
            Login login = new Login();
            this.setVisible(false);
            login.setVisible(true);
        }else{
            setIcon();
            initComponents();
            setInputDate();
            showTabelHistory();
            lbl_banyakTransaksi.setText(banyakTransaksi+" Transaksi");
            setProfilToko();
        }
    }
    
    public int banyakTransaksi = 0;
    
    private DefaultTableModel tableModel;
    private ResultSet resultSet;
    public final void showTabelHistory(){
        try {
            Connection conn = Koneksi.ConnectDB();
            
            Object[] columnTitle = {"No.","ID","Nama","Total","Tanggal"};
            tableModel = new DefaultTableModel(null,columnTitle);
            TabelHistory.setModel(tableModel);
            Statement statement = conn.createStatement();
            tableModel.getDataVector().removeAllElements();

            resultSet = statement.executeQuery("SELECT * FROM tb_history WHERE id_user='"+Session.session.getSession()+"'");
            int i = 1;
            while(resultSet.next()){
                Object[] data = {
                    i++,
                    resultSet.getString("id"),
                    resultSet.getString("list_barang"),
                    "Rp "+RupiahFromat(Integer.parseInt(resultSet.getString("total_tagihan"))),
                    resultSet.getString("tanggal")
                };
                tableModel.addRow(data);
                banyakTransaksi++;
            }
            
        } catch (SQLException e) {
            System.out.println("Data barang Gagal di tampilkan...");
            System.out.println(e);
        }
    }
    
    public String RupiahFromat(int amount){
        Locale indonesia = new Locale("id", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(indonesia);
        String formattedAmount = formatter.format(amount);
        formattedAmount = formattedAmount.replace("Rp", "");
        formattedAmount = formattedAmount.replace(",00", "");
        return formattedAmount;
    }
    
    public final void setProfilToko(){
        try {
            Connection conn = Koneksi.ConnectDB();
            String query = "SELECT * FROM tb_users WHERE id='"+Session.session.getSession()+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String namaToko = "null";
            String pendapatan = "0";
            while(rs.next()){
                namaToko = rs.getString("nama_toko");
                pendapatan = rs.getString("pendapatan");
            }
            lbl_pendapatan.setText("Rp "+RupiahFromat(Integer.parseInt(pendapatan)));
            NamaToko_History.setText(namaToko);
            namaToko_struk.setText(namaToko);
                    
        } catch (SQLException e) {
            System.out.println("Data barang Gagal di tampilkan...");
            System.out.println(e);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NamaToko_History = new javax.swing.JLabel();
        btnLinkHome = new javax.swing.JButton();
        lblTanggalValue = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        namaToko_struk = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        nama_listStruk = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        harga_listStruk = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jumlah_listStruk = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelHistory = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        struk_TotalBayar = new javax.swing.JLabel();
        struk_JumlahUang = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        struk_KembalianUang = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FilterTabel = new javax.swing.JComboBox<>();
        lbl_banyakTransaksi = new javax.swing.JLabel();
        lbl_pendapatan = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnRefreshAdmin = new javax.swing.JButton();
        txtCari_idhistory = new javax.swing.JTextField();
        inputTanggal = new com.toedter.calendar.JDateChooser();
        ok = new javax.swing.JButton();
        history = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI TOKO STARMIX");
        getContentPane().setLayout(null);

        NamaToko_History.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        NamaToko_History.setForeground(new java.awt.Color(255, 255, 255));
        NamaToko_History.setText("Nama Toko");
        getContentPane().add(NamaToko_History);
        NamaToko_History.setBounds(160, 50, 540, 50);

        btnLinkHome.setBackground(new java.awt.Color(0, 0, 0));
        btnLinkHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-linkHome.png"))); // NOI18N
        btnLinkHome.setBorder(null);
        btnLinkHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLinkHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnLinkHome);
        btnLinkHome.setBounds(1020, 30, 100, 30);

        lblTanggalValue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTanggalValue.setText("0/0/0 ");
        getContentPane().add(lblTanggalValue);
        lblTanggalValue.setBounds(810, 270, 90, 30);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Tanggal   : ");
        getContentPane().add(jLabel39);
        jLabel39.setBounds(750, 270, 60, 30);

        namaToko_struk.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        namaToko_struk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaToko_struk.setText("Nama Toko");
        getContentPane().add(namaToko_struk);
        namaToko_struk.setBounds(800, 240, 240, 30);

        jScrollPane7.setBorder(null);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        nama_listStruk.setEditable(false);
        nama_listStruk.setBackground(new java.awt.Color(255, 255, 255));
        nama_listStruk.setColumns(7);
        nama_listStruk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nama_listStruk.setRows(7);
        nama_listStruk.setToolTipText("");
        nama_listStruk.setWrapStyleWord(true);
        nama_listStruk.setBorder(null);
        nama_listStruk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nama_listStruk.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        nama_listStruk.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(nama_listStruk);

        getContentPane().add(jScrollPane7);
        jScrollPane7.setBounds(820, 340, 130, 140);

        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        harga_listStruk.setEditable(false);
        harga_listStruk.setBackground(new java.awt.Color(255, 255, 255));
        harga_listStruk.setColumns(7);
        harga_listStruk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        harga_listStruk.setRows(7);
        harga_listStruk.setToolTipText("");
        harga_listStruk.setWrapStyleWord(true);
        harga_listStruk.setBorder(null);
        harga_listStruk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        harga_listStruk.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        harga_listStruk.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane6.setViewportView(harga_listStruk);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(960, 340, 80, 140);

        jScrollPane8.setBorder(null);
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jumlah_listStruk.setEditable(false);
        jumlah_listStruk.setBackground(new java.awt.Color(255, 255, 255));
        jumlah_listStruk.setColumns(7);
        jumlah_listStruk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlah_listStruk.setRows(7);
        jumlah_listStruk.setToolTipText("");
        jumlah_listStruk.setWrapStyleWord(true);
        jumlah_listStruk.setBorder(null);
        jumlah_listStruk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jumlah_listStruk.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jumlah_listStruk.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane8.setViewportView(jumlah_listStruk);

        getContentPane().add(jScrollPane8);
        jScrollPane8.setBounds(750, 340, 50, 140);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        TabelHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TabelHistory.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "No.", "ID", "Nama", "Total", "Tanggal"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        TabelHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabelHistory.setGridColor(new java.awt.Color(204, 204, 204));
        TabelHistory.setRowHeight(25);
        TabelHistory.setSelectionBackground(new java.awt.Color(204, 204, 204));
        TabelHistory.setSelectionForeground(new java.awt.Color(1, 1, 1));
        TabelHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabelHistoryMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TabelHistory);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 270, 580, 130);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cari ID    :");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(90, 420, 70, 20);

        struk_TotalBayar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        struk_TotalBayar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        struk_TotalBayar.setText("Rp 0");
        getContentPane().add(struk_TotalBayar);
        struk_TotalBayar.setBounds(950, 490, 90, 20);

        struk_JumlahUang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        struk_JumlahUang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        struk_JumlahUang.setText("Rp 0");
        getContentPane().add(struk_JumlahUang);
        struk_JumlahUang.setBounds(950, 510, 90, 30);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel41.setText("Jumlah Uang        : ");
        getContentPane().add(jLabel41);
        jLabel41.setBounds(750, 510, 120, 30);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel36.setText("Kembalian Uang   : ");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(750, 540, 120, 20);

        struk_KembalianUang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        struk_KembalianUang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        struk_KembalianUang.setText("Rp 0");
        getContentPane().add(struk_KembalianUang);
        struk_KembalianUang.setBounds(950, 540, 90, 20);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel40.setText("Total Bayar          : ");
        getContentPane().add(jLabel40);
        jLabel40.setBounds(750, 490, 120, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Banyak           :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 510, 110, 20);

        FilterTabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        FilterTabel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-", "Total Terbesar", "Total Terkecil", "Terbaru", "Terlama" }));
        FilterTabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FilterTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterTabelActionPerformed(evt);
            }
        });
        getContentPane().add(FilterTabel);
        FilterTabel.setBounds(170, 470, 160, 30);

        lbl_banyakTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_banyakTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_banyakTransaksi.setText("0 Transaksi");
        getContentPane().add(lbl_banyakTransaksi);
        lbl_banyakTransaksi.setBounds(520, 510, 130, 20);

        lbl_pendapatan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_pendapatan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pendapatan.setText("Rp 0");
        getContentPane().add(lbl_pendapatan);
        lbl_pendapatan.setBounds(520, 480, 130, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pendapatan   :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(410, 480, 110, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cari Tanggal Transaksi :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 570, 170, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Filter       :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(90, 470, 70, 20);

        btnRefreshAdmin.setBackground(new java.awt.Color(0, 0, 0));
        btnRefreshAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-refresh.png"))); // NOI18N
        btnRefreshAdmin.setBorder(null);
        btnRefreshAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshAdminMouseClicked(evt);
            }
        });
        btnRefreshAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefreshAdmin);
        btnRefreshAdmin.setBounds(620, 230, 50, 30);

        txtCari_idhistory.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtCari_idhistory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCari_idhistoryKeyPressed(evt);
            }
        });
        getContentPane().add(txtCari_idhistory);
        txtCari_idhistory.setBounds(170, 420, 160, 30);
        getContentPane().add(inputTanggal);
        inputTanggal.setBounds(90, 600, 160, 30);

        ok.setBackground(new java.awt.Color(0, 0, 0));
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-cari_1.png"))); // NOI18N
        ok.setBorder(null);
        ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(260, 600, 50, 30);

        history.setBackground(new java.awt.Color(0, 0, 0));
        history.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg-history.png"))); // NOI18N
        getContentPane().add(history);
        history.setBounds(0, 0, 1172, 715);

        getAccessibleContext().setAccessibleName("APLIKASI TOKO STARMIX");

        setSize(new java.awt.Dimension(1188, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void refreshStruk(){
        jumlah_listStruk.setText("");
        nama_listStruk.setText("");
        harga_listStruk.setText("");
        lblTanggalValue.setText("0/0/0 ");
        struk_TotalBayar.setText("Rp 0");
        struk_JumlahUang.setText("Rp 0");
        struk_KembalianUang.setText("Rp 0");
    }

    private void TabelHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelHistoryMousePressed
        // TODO add your handling code here:
        refreshStruk();
        DefaultTableModel model = (DefaultTableModel)TabelHistory.getModel();
        int selectedRowIndex = TabelHistory.getSelectedRow();
        String id_history = model.getValueAt(selectedRowIndex, 1).toString();
        String tanggal = model.getValueAt(selectedRowIndex, 4).toString();
        lblTanggalValue.setText(tanggal);

        // get id transaksi
        try {
            Connection conn = Koneksi.ConnectDB();
            String query = "SELECT * FROM tb_history WHERE id_user='"+Session.session.getSession()+"' AND id='"+id_history+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String idTransaksi = "";
            String totalBayar = "0";
            String jumlahUang = "0";
            String kembalianUang = "0";
            while(rs.next()){
                idTransaksi = rs.getString("id_transaksi");
                totalBayar = rs.getString("total_tagihan");
                jumlahUang = rs.getString("jumlah_uang");
                kembalianUang = rs.getString("kembalian_uang");
            }
            struk_TotalBayar.setText("Rp "+RupiahFromat(Integer.parseInt(totalBayar)));
            struk_JumlahUang.setText("Rp "+RupiahFromat(Integer.parseInt(jumlahUang)));
            struk_KembalianUang.setText("Rp "+RupiahFromat(Integer.parseInt(kembalianUang)));
