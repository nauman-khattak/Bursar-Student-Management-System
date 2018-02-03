import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.w3c.dom.events.DocumentEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SMART
 */
public class Search_Student_Record extends JFrame {

    public Search_Student_Record(JTable table) {
        JPanel p1 = new JPanel();
        setLocation(480, 330);
        setSize(500, 150);
        setVisible(true);
        setResizable(false);
        p1.setLayout(null);
        p1.setLayout(null);
        JLabel lb = new JLabel("Search Record");
        lb.setBounds(200, 2, 150, 30);
        lb.setForeground(new Color(0, 96, 169));
        lb.setVisible(true);
        JLabel lb2 = new JLabel("Enter the ID Number:");
        lb2.setBounds(30, 40, 160, 20);
        lb2.setForeground(new Color(0, 96, 169));
        lb.setVisible(true);
        JTextField txt = new JTextField();
        txt.setBounds(210, 35, 190, 25);
        JButton b = new JButton("Search");
        b.setBounds(130, 80, 80, 25);
        b.setBackground(new Color(0, 96, 169));
        getContentPane().add(p1);
        p1.add(lb);
        p1.add(lb2);
        p1.add(txt);
        p1.add(b);
        // when button is pressed the page will go back to mainmenu page//
        JButton c = new JButton("Cancel");
        c.setBackground(new Color(0, 96, 169));
        c.setBounds(250, 80, 80, 25);
        getContentPane().add(p1);
        p1.add(c);

        //sets  dialog site tittle//
        setTitle("Search Student Record");
        searchStudent(table, txt);

        // informs the user that record have been search successfully//
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Searched Successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }

        });
        // when button is pressed inside search dialog mainmenu page will appear on screen
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Menu menuu = new Menu();
                } catch (SQLException ex) {
                    Logger.getLogger(Search_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Search_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Search_Student_Record.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        // when cancel button is pressed it will return to mainmenu page//
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void searchStudent(JTable table, JTextField txt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<javax.swing.table.TableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);
        txt.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent de) {
                String text = txt.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                table.repaint();
                model.fireTableDataChanged();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent de) {
                String text = txt.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                table.repaint();
                model.fireTableDataChanged();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

}
