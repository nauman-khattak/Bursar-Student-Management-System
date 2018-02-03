import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

public class Menu extends JFrame {

    String fee_id;
    String Class_name;

    public Menu() throws SQLException, ClassNotFoundException, IOException {
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();
        JPanel toppanel = new JPanel();
        JPanel btnpanel = new JPanel();
        toppanel.setLayout(new BorderLayout());
        btnpanel.setLayout(new FlowLayout());
        toppanel.setLayout(new BorderLayout());
        btnpanel.setLayout(new BoxLayout(btnpanel, BoxLayout.Y_AXIS));

        // list the button address name for exapmle Jb1
        //and it creates a new button for conviences you can put a button name
        // for example "Add customer"//
        JButton Jb2 = new JButton("Student Record");
        JButton Jb3 = new JButton("Fees Paid Record");
        JButton Jb4 = new JButton("Fees Due Record");
        JButton Jb5 = new JButton("Generate Invoice via Student ID");
        JButton Jb6 = new JButton("Generate Invoice via Class");
        JButton Jb7 = new JButton("Logout");

        // this set of code allows me to set the program dialog size
        //set the tittle that will appear at the top left and to set 
        // visible as true so that when a user clicks on Add customer the program will 
        //appear on screen and start running.//
        setSize(900, 700);
        setLocation(250, 20);
        setTitle("Welcome to Bursar Management System");
        getContentPane().setBackground(Color.lightGray);
        setVisible(true);
        URL url = getClass().getResource("Menu.png");
        //BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\SMART\\Documents\\NetBeansProjects\\Bursar_Student_Management_System\\Images\\Menu.png"));
        BufferedImage myPicture = ImageIO.read(new File("E:\\NetBeansProjects\\Bursar_Student_Management_System\\src\\Menu.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        // set set of code allows to set the button bond size
        //and  setvisible as true to ensure tha the button appear on screen//Menu
        Jb2.setBounds(370, 570, 120, 30);
        Jb2.setVisible(true);
        Jb3.setBounds(510, 570, 120, 30);
        Jb3.setVisible(true);
        Jb4.setBounds(650, 570, 120, 30);
        Jb4.setVisible(true);
        Jb5.setBounds(650, 570, 120, 30);
        Jb5.setVisible(true);
        // This code allows to Setaligmentx for example I set to Center//
        toppanel.setSize(850, 400);
        btnpanel.setSize(230, 590);
        Border thickBorder = new LineBorder(Color.RED, 2);
        //  Jb1.setAlignmentX(Component.CENTER_ALIGNMENT);
        picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Jb2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Jb3.setAlignmentX(Component.CENTER_ALIGNMENT);
        Jb4.setAlignmentX(Component.CENTER_ALIGNMENT);
        Jb5.setAlignmentX(Component.CENTER_ALIGNMENT);
        Jb6.setAlignmentX(Component.CENTER_ALIGNMENT);
        Jb7.setAlignmentX(Component.CENTER_ALIGNMENT);
        // This sets of code below set the Dimensions of width button size//
        Dimension d = new Dimension(250, 50);
        Dimension d1 = new Dimension(350, 50);

        Dimension d2 = new Dimension(480, 200);
        // Jb1.setMaximumSize(d);
        picLabel.setMaximumSize(d2);
        Jb2.setMaximumSize(d);
        Jb3.setMaximumSize(d);
        Jb4.setMaximumSize(d);
        Jb5.setMaximumSize(d1);
        Jb6.setMaximumSize(d1);
        Jb7.setMaximumSize(d);

        // This code allows me to select my fontsize type of font to be used
        // features like Bold italic underline features are also available//        
        Font f = new Font("Arial", Font.BOLD, 20);

        // Inorder for my buttons to appear inside The Jpanel when my program is running
        // for example
        //btnpanel.add means using ur existing Jpanel to add a new button feature inside your program
        // than add the dimension size//
        btnpanel.add(picLabel);
        btnpanel.add(Box.createRigidArea(new Dimension(20, 10)));
        btnpanel.add(Jb2);
        Jb2.setBackground(new Color(0, 96, 169));
        Jb2.setFont(f);
        Jb2.setForeground(Color.BLACK);
        btnpanel.add(Box.createRigidArea(new Dimension(30, 20)));
        btnpanel.add(Jb3);
        Jb3.setBackground(new Color(0, 96, 169));
        Jb3.setFont(f);
        Jb3.setForeground(Color.BLACK);
        btnpanel.add(Box.createRigidArea(new Dimension(30, 20)));
        btnpanel.add(Jb4);
        Jb4.setBackground(new Color(0, 96, 169));
        Jb4.setFont(f);
        Jb4.setForeground(Color.BLACK);
        btnpanel.add(Box.createRigidArea(new Dimension(30, 20)));
        btnpanel.add(Jb5);
        Jb5.setBackground(new Color(0, 96, 169));
        Jb5.setFont(f);
        Jb5.setForeground(Color.BLACK);
        btnpanel.add(Box.createRigidArea(new Dimension(30, 20)));
        btnpanel.add(Jb6);
        Jb6.setBackground(new Color(0, 96, 169));
        Jb6.setFont(f);
        Jb6.setForeground(Color.BLACK);
        btnpanel.add(Box.createRigidArea(new Dimension(30, 20)));
        btnpanel.add(Jb7);
        Jb7.setBackground(new Color(0, 96, 169));
        Jb7.setFont(f);
        Jb7.setForeground(Color.BLACK);

        //  btnpanel.add(Jb5);
        // program will not be able to resize as it is currently set to false//
        setResizable(false);
        // this set of code are for Label inside my mainmenu page//
        JLabel lb = new JLabel("Welcome to the Bursar Management System");
        lb.setBounds(130, 40, 130, 50);
        toppanel.add(lb);
        JLabel lc = new JLabel("MainMenu Page");
        lb.setBounds(130, 40, 130, 50);
        toppanel.add(lc);

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
        // This set of records fetch oos controller and model data
        // inside controller the program will look for dataVector n columnName vector
        // when is all right program will proceed to fetch data connection from the database//
        // OOSController model=new OOSController();
        //model.Adddata(dataVector, columnNamesVector);
        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector) {
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(34, 640, 830, 400);
        scrollPane.setViewportView(table);

        //add(scrollPane, BorderLayout.CENTER);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.getTableHeader().setBackground(Color.DARK_GRAY);
        table.getTableHeader().setForeground(Color.white);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setDragEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(scrollPane.getWidth(), 89));

        //table.repaint();
        // toppanel.add(btnpanel,BorderLayout.SOUTH);
        add(btnpanel, BorderLayout.CENTER);
        revalidate();
        repaint();
        scrollPane.setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);

        // when user clciks on the X button on the upper right hand of the window  
        // system will exit and will be terminated//
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Jb4.addActionListener(new ActionListener() {
// When Butoon is pressed Addproduct Screen will appear//
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                dispose();
                try {
                    Display_Due_Fees obj2 = new Display_Due_Fees();

                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Jb3.addActionListener(new ActionListener() {
// When button is pressed Displayproduct Screen will appear//
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Display_Paid_Fee paid = new Display_Paid_Fee();
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Jb2.addActionListener(new ActionListener() {
// When button is pressed Displaycustomer Screen will appear//
            @Override
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                dispose();
                try {
                    Display_Student_Record obj1 = new Display_Student_Record();

                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // When Exit button is pressed on Mainmenu Page Exit button 
        // system will exit the program and will be terminated//

        Jb5.addActionListener(new ActionListener() {
            // system.exit//
            @Override
            public void actionPerformed(ActionEvent ae) {

                JFrame std_id = new JFrame();
                JPanel p1 = new JPanel();
                std_id.setLocation(480, 330);
                std_id.setSize(500, 150);
                std_id.setVisible(true);
                std_id.setResizable(false);
                p1.setLayout(null);
                JLabel lb = new JLabel("Fee Invoice via fee ID");
                lb.setBounds(200, 2, 150, 30);
                lb.setForeground(new Color(0, 96, 169));
                lb.setVisible(true);
                JLabel lb2 = new JLabel("Enter the ID Number:");
                lb2.setBounds(30, 40, 160, 20);
                lb2.setForeground(new Color(0, 96, 169));
                lb.setVisible(true);
                JTextField txt = new JTextField();
                txt.setBounds(210, 35, 190, 25);
                JButton b = new JButton("Print");
                b.setBounds(210, 80, 80, 25);
                b.setBackground(new Color(0, 96, 169));
                b.setVisible(true);
                getContentPane().add(p1);
                p1.add(lb);
                p1.setVisible(true);
                p1.add(lb2);
                p1.add(txt);
                p1.add(b);

                std_id.getContentPane().add(p1);
                addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        fee_id = txt.getText();
                        try {
                            PDF(fee_id);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                // when button is pressed the page will go back to mainmenu page//

            }
        });

        Jb6.addActionListener(new ActionListener() {
            // system.exit//
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame class_frame = new JFrame();
                JPanel p1 = new JPanel();
                class_frame.setLocation(480, 330);
                class_frame.setSize(500, 150);
                class_frame.setVisible(true);
                class_frame.setResizable(false);
                p1.setLayout(null);
                JLabel lb = new JLabel("Fee Invoice via Class");
                lb.setBounds(200, 2, 150, 30);
                lb.setForeground(new Color(0, 96, 169));
                lb.setVisible(true);
                JLabel lb2 = new JLabel("Enter the Class Name:");
                lb2.setBounds(30, 40, 160, 20);
                lb2.setForeground(new Color(0, 96, 169));
                lb.setVisible(true);
                JTextField txt2 = new JTextField();
                txt2.setBounds(210, 35, 190, 25);
                JButton b = new JButton("Print");
                b.setBounds(210, 80, 80, 25);
                b.setBackground(new Color(0, 96, 169));
                b.setVisible(true);
                getContentPane().add(p1);
                p1.add(lb);
                p1.setVisible(true);
                p1.add(lb2);
                p1.add(txt2);
                p1.add(b);

                class_frame.getContentPane().add(p1);
                addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Class_name = txt2.getText();
                        try {
                            PDF_Via_ClassName(Class_name);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                // when button is pressed the page will go back to mainmenu page//
                //JButton c=new JButton("Cancel");
                //c.setBackground(new Color(0,96,169));
                //c.setBounds(250, 80, 80, 25);
                //getContentPane().add(p1);
                //p1.add(c);

            }
        });

        Jb7.addActionListener(new ActionListener() {
            // system.exit//
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

    // JPanel buttonPanel = new JPanel();
    // getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    public void PDF(String fee_id) throws ClassNotFoundException, SQLException, DocumentException, FileNotFoundException {

        String Student_id = "";
        String Student_Name = "";
        String Tuition_fee = "";
        String Pocket_fee = "";
        String Caution_fee = "";
        int std_id;
        int tu_fee;
        int po_fee;
        int ca_fee;

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/bdms?zeroDateTimeBehavior=convertToNull";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM fees_due";

        Connection connection = DriverManager.getConnection(url, userid, password);
        Statement stmt = connection.createStatement();
        String Command = "Select d.student_id,s.name,d.tuitionfee_due,d.pocketmoney_due,d.cautionmoney_due From fees_due as d "
                + "inner join student_info as s "
                + "on d.student_id=s.student_id "
                + " where d.feesdue_id = " + fee_id + ";";
        ResultSet rs = stmt.executeQuery(Command);
        while (rs.next()) {
            Student_id = rs.getString("student_id");

            Student_Name = rs.getString("name");
            Tuition_fee = rs.getString("tuitionfee_due");
            Pocket_fee = rs.getString("pocketmoney_due");
            Caution_fee = rs.getString("cautionmoney_due");
        }
        std_id = Integer.parseInt(Student_id);
        tu_fee = Integer.parseInt(Tuition_fee);
        po_fee = Integer.parseInt(Pocket_fee);
        ca_fee = Integer.parseInt(Caution_fee);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("" + Student_id + " Fee Invoice.pdf"));
        document.open();
        com.itextpdf.text.Font blue = FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, new CMYKColor(90, 255, 0, 0));
        Paragraph p4 = new Paragraph(Student_id + " Fee Invoice \n _______________________ \n \n", blue);
        p4.setAlignment(Element.ALIGN_CENTER);
        document.add(p4);
        int total = tu_fee + po_fee + ca_fee;
        Paragraph p5 = new Paragraph("Student Name: " + Student_Name + "\nStudent ID: " + std_id + "\nTuition Fee Due: " + tu_fee
                + "\nPocket Fee Due: " + po_fee + "\nCaution Fee Due: " + ca_fee + "\n_________________________\nTotal:     " + total + "\n \n");
        p5.setAlignment(Element.ALIGN_CENTER);
        document.add(p5);
        document.close();
        try {

            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                // here you have to give path of your projects directory where the pdfs are generated..
                //it will be different at your end...
                desktop.open(new File("C:\\Users\\SMART\\Documents\\NetBeansProjects\\Bursar_Student_Management_System\\" + Student_id + " Fee Invoice.pdf"));
            } else {
                System.out.println("Open is not supported");
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Fee invoice generated and saved in your directory", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

    public void PDF_Via_ClassName(String class_name) throws ClassNotFoundException, SQLException, DocumentException, FileNotFoundException {
        List<String> id = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<String> tuition = new ArrayList<>();
        List<String> pocket = new ArrayList<>();
        List<String> caution = new ArrayList<>();
        String Student_id = "";
        String Student_Name = "";
        String Tuition_fee = "";
        String Pocket_fee = "";
        String Caution_fee = "";
        int std_id;
        int tu_fee;
        int po_fee;
        int ca_fee;

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/bdms?zeroDateTimeBehavior=convertToNull";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM fees_due";

        Connection connection = DriverManager.getConnection(url, userid, password);
        Statement stmt = connection.createStatement();
        String Command = "Select d.student_id,s.name,d.tuitionfee_due,d.pocketmoney_due,d.cautionmoney_due From fees_due as d "
                + "inner join student_info as s "
                + "on d.student_id=s.student_id "
                + " where s.class = '" + class_name + "';";
        ResultSet rs = stmt.executeQuery(Command);
        while (rs.next()) {
            id.add(rs.getString("student_id"));
            name.add(rs.getString("name"));
            tuition.add(rs.getString("tuitionfee_due"));
            pocket.add(rs.getString("pocketmoney_due"));
            caution.add(rs.getString("cautionmoney_due"));
        }

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("" + class_name + " Fee Invoice.pdf"));
        document.open();
        com.itextpdf.text.Font redFont = FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, new CMYKColor(0, 0, 0, 255));
        Paragraph p0 = new Paragraph(class_name + " Fee Invoice \n ________________________ \n \n", redFont);
        p0.setAlignment(Element.ALIGN_CENTER);
        document.add(p0);
        int length = id.size();
        for (int i = 0; i < length; i++) {

            int tu_fee2 = Integer.parseInt(tuition.get(i));
            int po_fee2 = Integer.parseInt(pocket.get(i));
            int ca_fee2 = Integer.parseInt(caution.get(i));
            int sum = tu_fee2 + po_fee2 + ca_fee2;
            Paragraph p = new Paragraph("Student Name: " + name.get(i) + "\nStudent ID: " + id.get(i) + "\nTuition Fee Due: " + tuition.get(i)
                    + "\nPocket Fee Due: " + pocket.get(i) + "\nCaution Fee Due: " + caution.get(i) + "\n_______________________\nTotal:   " + sum + "\n\n");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

        }
        document.close();
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(new File("C:\\Users\\SMART\\Documents\\NetBeansProjects\\Bursar_Student_Management_System\\" + class_name + " Fee Invoice.pdf"));
                // here you have to give path of your projects directory where the pdfs are generated..
                //it will be different at your end...
            } else {
                System.out.println("Open is not supported");
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Fee invoice generated and saved in your directory", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

}
