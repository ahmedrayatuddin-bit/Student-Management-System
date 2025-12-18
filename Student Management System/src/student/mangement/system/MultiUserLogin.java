package student.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MultiUserLogin extends JFrame implements ActionListener {
    
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton login, cancel;
    JComboBox<String> userType;
    
    MultiUserLogin() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Heading
        JLabel heading = new JLabel("University Management System");
        heading.setBounds(80, 30, 500, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        heading.setForeground(new Color(13, 148, 136));
        add(heading);
        
        JLabel subheading = new JLabel("Multi-User Login Portal");
        subheading.setBounds(230, 75, 200, 25);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 18));
        subheading.setForeground(new Color(17, 94, 89));
        add(subheading);
        
        // User Type Label
        JLabel lblusertype = new JLabel("Login As");
        lblusertype.setBounds(120, 140, 100, 30);
        lblusertype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblusertype);
        
        // User Type Dropdown
        String[] types = {"Admin", "User 1(student)", "User 2(teacher)"};
        userType = new JComboBox<>(types);
        userType.setBounds(250, 140, 250, 35);
        userType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userType.setBackground(Color.WHITE);
        add(userType);
        
        // Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(120, 200, 100, 30);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblusername);
        
        // Username TextField
        tfusername = new JTextField();
        tfusername.setBounds(250, 200, 250, 35);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfusername);
        
        // Password Label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(120, 260, 100, 30);
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblpassword);
        
        // Password Field
        tfpassword = new JPasswordField();
        tfpassword.setBounds(250, 260, 250, 35);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfpassword);
        
        // Login Button
        login = new JButton("Login");
        login.setBounds(180, 330, 120, 40);
        login.setBackground(new Color(13, 148, 136));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        login.addActionListener(this);
        add(login);
        
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(340, 330, 120, 40);
        cancel.setBackground(new Color(220, 20, 60));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);
        
   
        setSize(650, 480);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());
            String role = (String) userType.getSelectedItem();
            
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both username and password");
                return;
            }
            
            try {
                Conn c = new Conn();
                
                if (role.equals("Admin")) {
                    // Admin login from login table
                    String query = "SELECT * FROM login WHERE username='" + username + 
                                   "' AND password='" + password + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Welcome Admin! Full Access Granted");
                        setVisible(false);
                        new project();
                        // Open your original admin system here
                        // new Project(); // Replace with YOUR main class name
                        // Example: new UniversityManagement(); or new Main(); etc.
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Admin Credentials");
                    }
                    
                } else if (role.equals("User 1(student)")) {
                    // User 1 login (hardcoded credentials)
                    if (username.equals("user1") && password.equals("pass1")) {
                        JOptionPane.showMessageDialog(null, "Welcome User 1! Limited Access Granted");
                        setVisible(false);
                        new User1();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid User 1 Credentials\nUse: user1/pass1");
                    }
                    
                } else if (role.equals("User 2(teacher)")) {
                    // User 2 login (hardcoded credentials)
                    if (username.equals("user2") && password.equals("pass2")) {
                        JOptionPane.showMessageDialog(null, "Welcome User 2! Limited Access Granted");
                        setVisible(false);
                        new User2();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid User 2 Credentials\nUse: user2/pass2");
                    }
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            }
            
        } else {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new MultiUserLogin();
    }
}