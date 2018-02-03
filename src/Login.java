//package Bursar_Student_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends JFrame {

    public Login() {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton Jb = new JButton("Login");
        JButton Jb2 = new JButton("Signup");
        JLabel lb = new JLabel("Username");
        lb.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel lb2 = new JLabel("Password");
        lb2.setFont(new Font("Arial", Font.BOLD, 15));
        lb.setForeground(new Color(0, 96, 169));
        lb2.setForeground(new Color(0, 96, 169));
        JTextField txt = new JTextField("username");
        JPasswordField txt2 = new JPasswordField(10);
        setTitle("LoginUser");
        setSize(900, 700);
        setLocation(250, 20);
        setLayout(null);
        txt.setBounds(340, 260, 200, 30);
        txt.setVisible(true);
        txt2.setBounds(340, 320, 200, 30);
        txt2.setVisible(true);
        lb.setBounds(240, 230, 100, 100);
        lb.setVisible(true);
        lb2.setBounds(240, 280, 100, 100);
        lb2.setVisible(true);
        Font f = new Font("SansSherif", Font.BOLD, 20);
        Jb.setBounds(440, 380, 100, 40);
        Jb.setVisible(true);
        Jb.setBackground(new Color(0, 96, 169));
        Jb.setFont(new Font("Arial", Font.BOLD, 15));
        URL url = getClass().getResource("login-system-icon-13.png");
        ImageIcon imageIcon = new ImageIcon("E:\\NetBeansProjects\\Bursar_Student_Management_System\\src\\login-system-icon-13.png");
        JLabel lb3 = new JLabel(imageIcon);
        setBackground(Color.WHITE);
        lb3.setBounds(280, 2, 300, 200);
        add(lb);
        add(txt);
        add(lb2);
        add(txt2);
        add(Jb);
        add(lb3);
        setVisible(true);
        Jb2.setVisible(false);
        Jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        txt.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txt.getText().trim().equals("username")) {
                    txt.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txt.getText().trim().equals("")) {
                    txt.setText("username");
                }
            }
        });
        Jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txt.getText().trim().equals("") && !txt.getText().trim().equals("username")
                        && !txt2.getText().trim().equals("")) {
                    if (txt.getText().equalsIgnoreCase("admin")) {
                        JOptionPane.showMessageDialog(null, "Successfully LoggedIn", "Success", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        dispose();
                        try {
                            Menu menu = new Menu();
                        } catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Eroor", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Fill all the TextFields", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

}
