package student.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class User1 extends JFrame implements ActionListener {
    
    JTextField tfstudentID, tfname, tffname, tfphone, tfdob;
    JButton check, update, cancel, logout;
    JLabel statusLabel;
    boolean recordFound = false;
    
        User1() {
        
        setSize(750, 600);
        setLocation(350, 80);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        // Heading
        JLabel heading = new JLabel("Student Data Update - User 1");
        heading.setBounds(200, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading.setForeground(new Color(13, 148, 136));
        add(heading);
        
        JLabel subheading = new JLabel("Update: Name, Father's Name, Phone, Date of Birth only");
        subheading.setBounds(190, 55, 400, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 12));
        subheading.setForeground(new Color(220, 20, 60));
        add(subheading);
        
        // Student ID - Search Field
        JLabel lblstudentID = new JLabel("Student ID *");
        lblstudentID.setBounds(100, 110, 150, 30);
        lblstudentID.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblstudentID);
        
        tfstudentID = new JTextField();
        tfstudentID.setBounds(250, 110, 250, 30);
        tfstudentID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfstudentID);
        
        // Check Button
        check = new JButton("Check ID");
        check.setBounds(520, 110, 120, 30);
        check.setBackground(new Color(245, 158, 11));
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Tahoma", Font.BOLD, 13));
        check.addActionListener(this);
        add(check);
        
        // Status Label
        statusLabel = new JLabel("");
        statusLabel.setBounds(250, 145, 400, 20);
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(statusLabel);
        
        // Name
        JLabel lblname = new JLabel("Name *");
        lblname.setBounds(100, 190, 150, 30);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(250, 190, 390, 30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfname.setEnabled(false);
        add(tfname);
        
        // Father's Name
        JLabel lblfname = new JLabel("Father's Name *");
        lblfname.setBounds(100, 240, 150, 30);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(250, 240, 390, 30);
        tffname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tffname.setEnabled(false);
        add(tffname);
        
        // Phone
        JLabel lblphone = new JLabel("Phone *");
        lblphone.setBounds(100, 290, 150, 30);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(250, 290, 390, 30);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfphone.setEnabled(false);
        add(tfphone);
        
        // Date of Birth
        JLabel lbldob = new JLabel("Date of Birth *");
        lbldob.setBounds(100, 340, 150, 30);
        lbldob.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldob);
        
        tfdob = new JTextField();
        tfdob.setBounds(250, 340, 390, 30);
        tfdob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfdob.setEnabled(false);
        add(tfdob);
        
        JLabel dobFormat = new JLabel("Any format accepted (e.g., Dec 3, 2025 or 2002-08-10)");
        dobFormat.setBounds(250, 372, 350, 15);
        dobFormat.setFont(new Font("Tahoma", Font.ITALIC, 11));
        dobFormat.setForeground(Color.GRAY);
        add(dobFormat);
        
        // Info Panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBounds(100, 410, 540, 65);
        infoPanel.setBackground(new Color(255, 250, 205));
        infoPanel.setBorder(BorderFactory.createLineBorder(new Color(245, 158, 11), 2));
        
        JLabel infoTitle = new JLabel("ℹ How to Use:");
        infoTitle.setBounds(10, 5, 150, 20);
        infoTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
        infoTitle.setForeground(new Color(245, 158, 11));
        infoPanel.add(infoTitle);
        
        JLabel info1 = new JLabel("1. Enter Student ID and click 'Check ID' to verify if record exists");
        info1.setBounds(10, 25, 500, 15);
        info1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        infoPanel.add(info1);
        
        JLabel info2 = new JLabel("2. If ID exists, you can update Name, Father's Name, Phone, and Date of Birth");
        info2.setBounds(10, 42, 500, 15);
        info2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        infoPanel.add(info2);
        
        add(infoPanel);
        
        // Update Button
        update = new JButton("Update Student");
        update.setBounds(170, 500, 150, 40);
        update.setBackground(new Color(13, 148, 136));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        update.setEnabled(false);
        update.addActionListener(this);
        add(update);
        
        // Cancel Button
        cancel = new JButton("Clear");
        cancel.setBounds(340, 500, 120, 40);
        cancel.setBackground(new Color(245, 158, 11));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        
        // Logout Button
        logout = new JButton("Logout");
        logout.setBounds(480, 500, 120, 40);
        logout.setBackground(new Color(220, 20, 60));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String studentID = tfstudentID.getText().trim();
            
            if (studentID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Student ID");
                return;
            }
            
            try {
                Conn conn = new Conn();
                
                // Check if Student ID exists in database
                String query = "SELECT * FROM student WHERE StudentID = '" + studentID + "'";
                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    // Record found - Load data and enable fields
                    recordFound = true;
                    statusLabel.setText("✓ Student ID found! You can now update the allowed fields.");
                    statusLabel.setForeground(new Color(0, 128, 0));
                    
                    // Load existing data
                    tfname.setText(rs.getString("name") != null ? rs.getString("name") : "");
                    tffname.setText(rs.getString("fname") != null ? rs.getString("fname") : "");
                    tfphone.setText(rs.getString("Phone") != null ? rs.getString("Phone") : "");
                    
                    // Handle DateOfBirth (get as string to handle any format)
                    String dobValue = rs.getString("DateOfBirth");
                    if (dobValue != null && !dobValue.isEmpty()) {
                        tfdob.setText(dobValue);
                    } else {
                        tfdob.setText("");
                    }
                    
                    // Enable fields for editing
                    tfname.setEnabled(true);
                    tffname.setEnabled(true);
                    tfphone.setEnabled(true);
                    tfdob.setEnabled(true);
                    update.setEnabled(true);
                    
                    tfstudentID.setEnabled(false); // Lock ID field
                    check.setEnabled(false);
                    
                } else {
                    // Record not found
                    recordFound = false;
                    statusLabel.setText("✗ Student ID not found! Only Admin can create records.");
                    statusLabel.setForeground(new Color(220, 20, 60));
                    
                    JOptionPane.showMessageDialog(null, 
                        "Student ID Not Found!\n\n" +
                        "The ID '" + studentID + "' does not exist in database.\n\n" +
                        "Only Admin can create new student records.\n" +
                        "You can only update existing records.");
                    
                    // Disable all fields
                    tfname.setEnabled(false);
                    tffname.setEnabled(false);
                    tfphone.setEnabled(false);
                    tfdob.setEnabled(false);
                    update.setEnabled(false);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            }
            
        } else if (ae.getSource() == update) {
            if (!recordFound) {
                JOptionPane.showMessageDialog(null, "Please check Student ID first!");
                return;
            }
            
            String studentID = tfstudentID.getText().trim();
            String name = tfname.getText().trim();
            String fname = tffname.getText().trim();
            String phone = tfphone.getText().trim();
            String dob = tfdob.getText().trim();
            
            if (name.isEmpty() || fname.isEmpty() || phone.isEmpty() || dob.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields!");
                return;
            }
            
            // Allow flexible date format - no strict validation
            // User can enter in any reasonable format
            
            try {
                Conn conn = new Conn();
                
                // Update only the allowed fields: name, fname, Phone, DateOfBirth
                String updateQuery = "UPDATE student SET " +
                                    "name = '" + name + "', " +
                                    "fname = '" + fname + "', " +
                                    "Phone = '" + phone + "', " +
                                    "DateOfBirth = '" + dob + "' " +
                                    "WHERE StudentID = '" + studentID + "'";
                
                int result = conn.s.executeUpdate(updateQuery);
                
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, 
                        "✓ Student Record Updated Successfully!\n\n" +
                        "Student ID: " + studentID + "\n" +
                        "Name: " + name + "\n" +
                        "Father's Name: " + fname + "\n" +
                        "Phone: " + phone + "\n" +
                        "Date of Birth: " + dob + "\n\n" +
                        "Updated by: User 1");
                    
                    // Reset form
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            
        } else if (ae.getSource() == cancel) {
            clearForm();
            
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new MultiUserLogin();
        }
    }
    
    private void clearForm() {
        tfstudentID.setText("");
        tfname.setText("");
        tffname.setText("");
        tfphone.setText("");
        tfdob.setText("");
        statusLabel.setText("");
        
        tfstudentID.setEnabled(true);
        check.setEnabled(true);
        tfname.setEnabled(false);
        tffname.setEnabled(false);
        tfphone.setEnabled(false);
        tfdob.setEnabled(false);
        update.setEnabled(false);
        
        recordFound = false;
    }
    
    public static void main(String[] args) {
        new User1();
    }
}