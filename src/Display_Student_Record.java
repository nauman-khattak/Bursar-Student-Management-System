import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class Display_Student_Record extends JFrame {

    public Display_Student_Record() throws SQLException, ClassNotFoundException {
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();
        JPanel toppanel = new JPanel();
        JPanel btnpanel = new JPanel();
        JPanel labelpanel = new JPanel();
        toppanel.setLayout(new BorderLayout());
        JButton Jb2 = new JButton("Add Student");
        JButton Jb3 = new JButton("Search");
        JButton Jb5 = new JButton("Delete");
        JButton Jb6 = new JButton("Cancel");
        JButton Jb4 = new JButton("Update");
        // this set code is for count it will count the number of registered product are
        // inside the entire record of the database and appear on screen.//
        JLabel countsent = new JLabel("The Total Registered Students are: ");
        JLabel count = new JLabel();
        setTitle("Welcome to Student Fee Record Page");

        setSize(900, 700);
        setLocation(250, 20);
        getContentPane().setBackground(Color.lightGray);
        setVisible(true);
        // set set of code allows to set the button bond size
        //and  setvisible as true to ensure tha the button appear on screen//
        Jb3.setBounds(510, 570, 120, 30);
        Jb3.setVisible(true);
        Jb4.setBounds(510, 570, 120, 30);
        Jb4.setVisible(true);
        Jb5.setBounds(510, 570, 120, 30);
        Jb5.setVisible(true);
        Jb6.setBounds(510, 570, 120, 30);
        Jb6.setVisible(true);

        toppanel.setSize(850, 400);
        btnpanel.setSize(50, 590);
        labelpanel.setSize(50, 590);
        Border thickBorder = new LineBorder(Color.RED, 2);

        // sets the dimensions and the maximum size required for the program//
        Dimension d = new Dimension(130, 50);

        Jb3.setMaximumSize(d);
        Jb2.setMaximumSize(d);
        Jb4.setMaximumSize(d);
        Jb5.setMaximumSize(d);

        Font f = new Font("SansSherif", Font.BOLD, 20);
        count.setBorder(thickBorder);
        count.setFont(f);
        // background color for count label//
        count.setBackground(Color.WHITE);
        Jb2.setBackground(new Color(0, 96, 169));
        Jb3.setBackground(new Color(0, 96, 169));
        Jb4.setBackground(new Color(0, 96, 169));
        Jb5.setBackground(new Color(0, 96, 169));
        Jb6.setBackground(new Color(0, 96, 169));

        Jb2.setForeground(Color.BLACK);
        Jb3.setForeground(Color.BLACK);
        Jb4.setForeground(Color.BLACK);
        Jb5.setForeground(Color.BLACK);
        Jb6.setBackground(new Color(0, 96, 169));
        // this code below adds labls and button textboxes so that when the program
        // runs they all will appear on screen as a user interface//
        btnpanel.add(Jb2);
        btnpanel.add(Box.createRigidArea(new Dimension(20, 10)));
        btnpanel.add(Jb3);
        btnpanel.add(Box.createRigidArea(new Dimension(20, 10)));
        btnpanel.add(Jb4);
        btnpanel.add(Box.createRigidArea(new Dimension(20, 10)));
        btnpanel.add(Jb5);
        btnpanel.add(Box.createRigidArea(new Dimension(20, 10)));
        btnpanel.add(Jb6);
        labelpanel.add(count);
        count.setForeground(Color.RED);

        displayStudent(dataVector, columnNamesVector);
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
// below here are the settings for the tabble 
// example like background color layout settings table font size//
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(34, 640, 830, 400);
        scrollPane.setViewportView(table);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.getTableHeader().setBackground(new Color(0, 96, 169));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setDragEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(scrollPane.getWidth(), 89));
        table.getTableHeader().setReorderingAllowed(false);
        table.setFont(new Font("Tahoma", Font.BOLD, 10));
        table.setVisible(true);
        table.setRowHeight(0, 50);
        table.setRowMargin(5);
        TableColumnModel columnModel = table.getColumnModel();
        table.setRowHeight(20);
        table.getTableHeader().setColumnModel(columnModel);
        toppanel.add(scrollPane);
        add(labelpanel, BorderLayout.NORTH);
        add(toppanel, BorderLayout.CENTER);
        toppanel.add(btnpanel, BorderLayout.SOUTH);
        add(btnpanel, BorderLayout.SOUTH);

        revalidate();
        repaint();
        scrollPane.setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
// When X button is pressed the program will exit //
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // when button is pressed Mainmenu page will appear//
        Jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                dispose();

                try {
                    Menu menuu = new Menu();
                } catch (SQLException ex) {
                    Logger.getLogger(Display_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Display_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Display_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        // when button is pressed update dialog will appear//

        Jb4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int txt = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        "Enter the Student ID Number:",
                        "Input",
                        JOptionPane.PLAIN_MESSAGE));
                Update_Student_Record add = new Update_Student_Record(table, txt);
            }
        });

        Jb5.addActionListener(new ActionListener() {
// when button is pressed Search delete dialog will appear//
            @Override
            public void actionPerformed(ActionEvent ae) {
                int txt = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        "Enter the Student ID Number:",
                        "Input",
                        JOptionPane.INFORMATION_MESSAGE));

                try {
                    deleteStudentRecord(table, txt);
                } catch (SQLException ex) {
                    Logger.getLogger(Display_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Display_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Deleted Successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }

        });
        // when button is pressed Search product page will appear//
        Jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                dispose();
                Add_Student_Record add = new Add_Student_Record(table);
            }

        });

        Jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Search_Student_Record srch = new Search_Student_Record(table);
            }

        });

        // connection to the database will establish there after oos controller will ask oos model 
        // to count the number of records store inside the table in the database when the data is 
        //obtain the total number of registered product willl appear on screen./
    }

    public void displayStudent(Vector dataVector, Vector columnNamesVector) throws ClassNotFoundException {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/bdms?zeroDateTimeBehavior=convertToNull";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM student_info";

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
        try (Connection connection = DriverManager.getConnection(url, userid, password);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            //  Get row data
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount(); //number of column

            for (int i = 1; i <= count; i++) {
                columnNames.add(metaData.getColumnLabel(i));
            }

            while (rs.next()) {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesVector.add(columnNames.get(i));
        }
    }

    //This set of codes to add data into product database inside phpmyadmin //
    public void deleteStudentRecord(JTable table, int delete) throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/bdms?zeroDateTimeBehavior=convertToNull";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM student_info";

        Connection connection = DriverManager.getConnection(url, userid, password);
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("Delete From student_info where student_id =" + delete + ";");
        table.repaint();
        model.fireTableDataChanged();
        Display_Student_Record tb = new Display_Student_Record();
        connection.close();
    }

}
