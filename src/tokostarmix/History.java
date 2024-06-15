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

