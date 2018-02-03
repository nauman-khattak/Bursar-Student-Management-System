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

public class Add_Due_Fees_Record extends JFrame {

    public Add_Due_Fees_Record(JTable table) {
        // creates a new Jpanel//
        JPanel p1 = new JPanel();
        setTitle("Add Due Fees Record");
        setSize(900, 700);
        setLocation(250, 20);
        setVisible(true);
        JButton Jb = new JButton("Confirm");
        JButton Jb2 = new JButton("Cancel");
        JLabel lb = new JLabel("Add Due Fees Record Page");
        JLabel lb1 = new JLabel("Fees ID");
        JLabel lb2 = new JLabel("Tuition Fee");
        JLabel lb3 = new JLabel("Pocket Money");
        JLabel lb4 = new JLabel("Caution Money");
        JLabel lb5 = new JLabel("Student ID");

        JTextField txt1 = new JTextField("Fees ID");
        JTextField txt2 = new JTextField("Tuition Fee");
        JTextField txt3 = new JTextField("Pocket Money");
        JTextField txt4 = new JTextField("Caution Money");
        JTextField txt5 = new JTextField("Student ID");
        p1.setLayout(null);
        lb.setBounds(340, 10, 450, 50);
        // creates font and bond size//
        Font f = new Font("Arial", Font.BOLD, 20);
        lb.setFont(f);
        lb.setForeground(new Color(0, 96, 169));
        lb1.setForeground(new Color(0, 96, 169));
        lb2.setForeground(new Color(0, 96, 169));
        lb3.setForeground(new Color(0, 96, 169));
        lb4.setForeground(new Color(0, 96, 169));
        lb5.setForeground(new Color(0, 96, 169));

        lb1.setBounds(230, 70, 130, 50);
        lb2.setBounds(230, 110, 150, 50);
        lb3.setBounds(230, 150, 150, 50);
        lb4.setBounds(230, 190, 150, 50);
        lb5.setBounds(230, 230, 150, 50);
        txt1.setBounds(400, 80, 160, 30);
        txt2.setBounds(400, 120, 230, 30);
        txt3.setBounds(400, 160, 160, 30);
        txt4.setBounds(400, 200, 160, 30);
        txt5.setBounds(400, 240, 160, 30);
        Jb.setBounds(400, 320, 80, 30);
        Jb.setVisible(true);
        Jb.setBackground(new Color(0, 96, 196));
        Jb2.setBounds(550, 320, 80, 30);
        Jb2.setVisible(true);
        Jb2.setBackground(new Color(0, 96, 196));
        getContentPane().add(p1);
        setTitle("Add Due Fees Record");
        // this set of codes get records from the textboxes
        // set means to set data in the textboxes and save the record to the database//
        txt1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt1.getText().trim().equals("Fees ID")) {
                    txt1.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt1.getText().trim().equals("")) {
                    txt1.setText("Fees ID");
                }
            }
        });

        txt2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt2.getText().trim().equals("Tuition Fee")) {
                    txt2.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt2.getText().trim().equals("")) {
                    txt2.setText("Tuition Fee");
                }
            }
        });
        txt3.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt3.getText().trim().equals("Pocket Money")) {
                    txt3.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt3.getText().trim().equals("")) {
                    txt3.setText("Pocket Money");
                }
            }
        });

        txt4.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt4.getText().trim().equals("Caution Money")) {
                    txt4.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt4.getText().trim().equals("")) {
                    txt4.setText("Caution Money");
                }
            }
        });
        txt5.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt5.getText().trim().equals("Student ID")) {
                    txt5.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt5.getText().trim().equals("")) {
                    txt5.setText("Student ID");
                }

            }
        });

        p1.add(lb);
        p1.add(lb1);
        p1.add(txt1);
        p1.add(txt2);
        p1.add(txt3);
        p1.add(txt4);
        p1.add(txt5);
        p1.add(lb2);
        p1.add(lb3);
        p1.add(lb4);
        p1.add(lb5);
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
            // gets all records into the textboxes and give it to the controller when connection to
            // database establishes cotroller will ask model to save the record to the database.
            // or eles
            // Text field is empty please re enter.//
            public void actionPerformed(ActionEvent ae) {
                if (!txt1.getText().equalsIgnoreCase("Product Name") && !txt2.getText().equalsIgnoreCase("{Product Registration")
                        && !txt3.getText().equalsIgnoreCase("Product Price") && !txt4.getText().equalsIgnoreCase("Product Qty")) {

                    try {
                        addStudentDue(txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(), txt5.getText(), table);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Add_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Add_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Added Successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    dispose();
                    table.repaint();

                } else {
                    JOptionPane.showMessageDialog(null, "Text Fields are Empty!!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void addStudentDue(String txt1, String txt2, String txt3, String txt4, String txt5, JTable table) throws ClassNotFoundException, SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/bdms?zeroDateTimeBehavior=convertToNull";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM student_info";

        Connection connection = DriverManager.getConnection(url, userid, password);
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO fees_due (feesdue_id,tuitionfee_due,pocketmoney_due,cautionmoney_due,student_id)"
                + " Values (" + txt1 + "," + txt2 + "," + txt3 + "," + txt4 + "," + txt5 + ")");
        Display_Due_Fees view = new Display_Due_Fees();
        connection.close();
    }

}
