import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class mhs {
    private JPanel Main;
    private JTextField textName;
    private JTextField txtNim;
    private JTextField txtIpk;
    private JTextField txtMatkul;
    private JTextField txtFoto;
    private JButton simpanButton;
    private JTable table1;
    private JButton hapusButton;
    private JButton updateButton;
    private JLabel nama;
    private JLabel nim;
    private JLabel ipk;
    private JLabel matkul;
    private JLabel foto;
    private JScrollPane tabel1;
    private JTextField txtid;
    private JButton cariButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("mhs");
        frame.setContentPane(new mhs().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    Connection con;
    PreparedStatement pst;

    public void connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mhs", "root","");
            System.out.println("Sukses!");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }


    }



    void table_load()
    {
        try
        {
            pst = con.prepareStatement( "select * from mhs");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }



    public mhs() {
        connect();
        table_load();
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama, nim, ipk, matkul, foto;

                nama = textName.getText();
                nim = txtNim.getText();
                ipk = txtIpk.getText();
                matkul = txtMatkul.getText();
                foto = txtFoto.getText();

                    try {
                        pst = con.prepareStatement( "insert into mhs(nama, nim, ipk, matkul, foto) values (?,?,?,?,?)");
                        pst.setString( 1, nama);
                        pst.setString( 2, nim);
                        pst.setString( 3, ipk);
                        pst.setString( 4, matkul);
                        pst.setString( 5, foto);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog( null, "Record ditambahkan!");
                        table_load();

                        textName.setText("");
                        txtNim.setText("");
                        txtIpk.setText("");
                        txtMatkul.setText("");
                        txtFoto.setText("");
                        textName.requestFocus();



                    }
                    catch (SQLException ex) {
                        ex.printStackTrace();
                    }


            }
        });

        cariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String mhsid= txtid.getText();
                    pst = con.prepareStatement( "select nama,nim,ipk,matkul,foto from mhs where id =?");
                    pst.setString( 1,mhsid);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()==true)
                    {
                        String mhsnama = rs.getString( 1);
                        String mhsnim = rs.getString( 2);
                        String mhsipk = rs.getString( 3);
                        String mhsmatkul = rs.getString( 4);
                        String mhsfoto = rs.getString( 5);

                        textName.setText(mhsnama);
                        txtNim.setText(mhsnim);
                        txtIpk.setText(mhsipk);
                        txtMatkul.setText(mhsmatkul);
                        txtFoto.setText(mhsfoto);
                    }
                    else
                    {
                        textName.setText("");
                        txtNim.setText("");
                        txtIpk.setText("");
                        txtMatkul.setText("");
                        txtFoto.setText("");
                        JOptionPane.showMessageDialog( null,"id tidak ditemukan");
                    }
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mhsid;
                mhsid = txtid.getText();
                try {
                    pst =con.prepareStatement("delete from mhs where id =?");
                    pst.setString(1,mhsid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"record telah di hapus");
                    table_load();

                    textName.setText("");
                    txtNim.setText("");
                    txtIpk.setText("");
                    txtMatkul.setText("");
                    txtFoto.setText("");
                    textName.requestFocus();


                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }


        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id,nama, nim, ipk, matkul, foto;

                id = txtid.getText();
                nama = textName.getText();
                nim = txtNim.getText();
                ipk = txtIpk.getText();
                matkul = txtMatkul.getText();
                foto = txtFoto.getText();

                try
                {
                    pst = con.prepareStatement( "update mhs set nama = ?, nim = ?, ipk = ?, matkul = ?, foto = ? where id = ?");
                    pst.setString( 1, nama);
                    pst.setString( 2, nim);
                    pst.setString( 3, ipk);
                    pst.setString( 4, matkul);
                    pst.setString( 5, foto);
                    pst.setString( 6, id);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog( null, "record telah diperbarui");
                    table_load();

                    textName.setText("");
                    txtNim.setText("");
                    txtIpk.setText("");
                    txtMatkul.setText("");
                    txtFoto.setText("");
                    textName.requestFocus();
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
