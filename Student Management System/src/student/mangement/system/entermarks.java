
package student.mangement.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class entermarks extends JFrame implements ActionListener{
    Choice studentid;
    JButton submit,cancel;
    JComboBox cbsemester;
    JTextField tfsubject1,tfsubject2,tfsubject3,tfsubject4,tfsubject5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    entermarks(){
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);
        
        JLabel heading=new JLabel("Enter Marks of Student");
         heading.setBounds(50,0,500,50);
       heading.setFont(new Font("Tahoma",Font.BOLD,20));
       add(heading);
    
        JLabel lblstudentid =new JLabel("Select Student ID");
        lblstudentid.setBounds(50,70,150,20);
        add(lblstudentid);
        
        studentid=new Choice();
        studentid.setBounds(200,70,150,20);
        add(studentid);
        
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                studentid.add(rs.getString("StudentID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblsemester =new JLabel("Select Semester");
        lblsemester.setBounds(50,110,150,20);
        add(lblsemester);
        
        String semester[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","8th Semester","9th Semester","10th Semester","11th Semester","12th Semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,110,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblsubject=new JLabel("Enter Subject");
        lblsubject.setBounds(100,150,200,40);
        add(lblsubject);
        
        JLabel lblentermarks =new JLabel("Enter Marks");
        lblentermarks.setBounds(320,150,200,40);
        add(lblentermarks);
        
        tfsubject1 = new JTextField();
        tfsubject1.setBounds(50,200,200,20);
        add(tfsubject1);
        
         tfsubject2= new JTextField();
        tfsubject2.setBounds(50,230,200,20);
        add(tfsubject2);
        
         tfsubject3 = new JTextField();
        tfsubject3.setBounds(50,260,200,20);
        add(tfsubject3);
        
         tfsubject4 = new JTextField();
        tfsubject4.setBounds(50,290,200,20);
        add(tfsubject4);
        
         tfsubject5 = new JTextField();
        tfsubject5.setBounds(50,320,200,20);
        add(tfsubject5);
        
            tfmarks1 = new JTextField();
        tfmarks1.setBounds(250,200,200,20);
        add(tfmarks1);
        
          tfmarks2 = new JTextField();
        tfmarks2.setBounds(250,230,200,20);
        add(tfmarks2);
          tfmarks3 = new JTextField();
        tfmarks3.setBounds(250,260,200,20);
        add(tfmarks3);
          tfmarks4 = new JTextField();
        tfmarks4.setBounds(250,290,200,20);
        add(tfmarks4);
          tfmarks5 = new JTextField();
        tfmarks5.setBounds(250,320,200,20);
        add(tfmarks5);
        
        submit= new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
    
        cancel= new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
        
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==submit){
           try{
               Conn c = new Conn();
               String query1 = "insert into subject values('"+studentid.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsubject1.getText()+"','"+tfsubject2.getText()+"','"+tfsubject3.getText()+"','"+tfsubject4.getText()+"','"+tfsubject5.getText()+"')";
               String query2 = "insert into marks values('"+studentid.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";
           

               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
               setVisible(false);
               
           }catch(Exception e){
               e.printStackTrace();
           }
       } else{
           setVisible(false);
       }
       
    }
    public static void main(String[] args) {
        new entermarks();
    }
}
