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
