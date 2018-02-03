import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Update_Paid_Fees_Record extends JFrame {

    int ID;

    public Update_Paid_Fees_Record(JTable table, int txt) {
        this.ID = txt;
        JPanel p1 = new JPanel();
        setTitle("Update Paid Fee Record");
        setSize(900, 700);
        setLocation(250, 20);
        setVisible(true);

        JButton Jb = new JButton("Confirm");
        JButton Jb2 = new JButton("Cancel");
        JLabel lb = new JLabel("Update Paid Fee Record Page");
        JLabel lb4 = new JLabel("Tuition Fee");
        JLabel lb5 = new JLabel("Pocket Money");
        JLabel lb6 = new JLabel("Caution Money");
        JLabel lb7 = new JLabel("Student ID");
        JTextField txt4 = new JTextField("Tuition Fee");
        JTextField txt5 = new JTextField("Pocket Money");
        JTextField txt6 = new JTextField("Caution Money");
        JTextField txt7 = new JTextField("Student ID");
        // JTextField txt5 = new JTextField("Type");
        p1.setLayout(null);
        lb.setBounds(340, 10, 450, 50);
        // creates font and bond size//
        Font f = new Font("Arial", Font.BOLD, 20);
        lb.setFont(f);
        lb.setForeground(new Color(0, 96, 169));
        lb4.setForeground(new Color(0, 96, 169));
        lb5.setForeground(new Color(0, 96, 169));
        lb6.setForeground(new Color(0, 96, 169));
        lb7.setForeground(new Color(0, 96, 169));
        lb4.setBounds(230, 190, 150, 50);
        lb5.setBounds(230, 230, 150, 50);
        lb6.setBounds(230, 270, 150, 50);
        lb7.setBounds(230, 310, 150, 50);
        txt4.setBounds(400, 200, 160, 30);
        txt5.setBounds(400, 240, 160, 30);
        txt6.setBounds(400, 280, 160, 30);
        txt7.setBounds(400, 320, 200, 30);
        Jb.setBounds(400, 400, 80, 30);
        Jb.setVisible(true);
        Jb.setBackground(new Color(0, 96, 196));
        Jb2.setBounds(550, 400, 80, 30);
        Jb2.setVisible(true);
        Jb2.setBackground(new Color(0, 96, 196));
        getContentPane().add(p1);
        setTitle("Update Record");

        txt4.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt4.getText().trim().equals("Tuition Fee")) {
                    txt4.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt4.getText().trim().equals("")) {
                    txt4.setText("Tuition Fee");
                }
            }
        });
        txt5.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt5.getText().trim().equals("Pocket Money")) {
                    txt5.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt5.getText().trim().equals("")) {
                    txt5.setText("Pocket Money");
                }

            }
        });

        txt6.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt6.getText().trim().equals("Caution Money")) {
                    txt6.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt6.getText().trim().equals("")) {
                    txt6.setText("Caution Money");
                }

            }
        });

        txt7.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt7.getText().trim().equals("Student ID")) {
                    txt7.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt7.getText().trim().equals("")) {
                    txt7.setText("Student ID");
                }

            }
        });
         // this code below adds labls and button textboxes so that when the program
        // runs they all will appear on screen as a user interface// 
        p1.add(lb);
        p1.add(txt4);
        p1.add(txt5);
        p1.add(txt6);
        p1.add(txt7);
        p1.add(lb4);
        p1.add(lb5);
        p1.add(lb6);
        p1.add(lb7);
        p1.add(Jb);
        p1.add(Jb2);
        Border thickBorder = new LineBorder(Color.RED, 2);
        Jb2.addActionListener(new ActionListener() {
            // when button is pressed Mainmenu page will appear on screen// 
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                try {
                    Menu menu = new Menu();
                } catch (SQLException ex) {
                    Logger.getLogger(Add_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Add_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Add_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Jb.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {
                if (!txt4.getText().equalsIgnoreCase("Tuition Fees") && !txt5.getText().equalsIgnoreCase("Pocket Money")
                        && !txt6.getText().equalsIgnoreCase("Caution Money")
                        && !txt7.getText().equalsIgnoreCase("Student ID")) {

                    try {
                        updateDueFeeRecord(txt4.getText(), txt5.getText(), txt6.getText(), txt7.getText(), txt, table);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Add_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Add_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "ID " + txt + " Updated Successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    dispose();
                    table.repaint();

                } else {
                    JOptionPane.showMessageDialog(null, "Text Fields are Empty!!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });
// when button is pressed on The X icon system will exit//
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void updateDueFeeRecord(String txt2, String txt3, String txt4, String txt5, int txt6, JTable table) throws ClassNotFoundException, SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/bdms?zeroDateTimeBehavior=convertToNull";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM fees_paid";

        Connection connection = DriverManager.getConnection(url, userid, password);
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE fees_paid "
                + " SET tutionfee_paid = "
                + "'" + txt2 + "' ," + " pocketmoney_paid = '" + txt3 + "'," + " cautionmoney_paid = '" + txt4 + "'," + " student_id = " + txt5 + " Where paid_id = " + txt6 + ";");
        Display_Paid_Fee paid = new Display_Paid_Fee();
        connection.close();
    }
}
