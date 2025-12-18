
package student.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Addteacher extends JFrame implements ActionListener{
    JTextField tfname,tffname,tfphone,tfadd,tfTeacherID,tfSemester,tfteacheremail;
    JLabel labelempID;
    JDateChooser dcdob;
    JComboBox cbcourse,cbdepartment;
    JButton submit,cancel;
    Random ran=new Random();
    long sixteen=Math.abs((ran.nextLong()%9000000000000L)+1000000000000L);
    
    Addteacher(){
    setSize(900,700);
    setLocation(350,50);
    setLayout(null);
    
    JLabel heading=new JLabel("New Teacher Details:");
    heading.setBounds(310,30,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
    
    JLabel lblName=new JLabel("Name");
    lblName.setBounds(50,150,100,30);
    lblName.setFont(new Font("serif",Font.BOLD,20));
    add(lblName);
    
    tfname=new JTextField();
    tfname.setBounds(200,150,150,30);
    add(tfname);
   
    
    JLabel lblfname =new JLabel("Father's Name");
    lblfname.setBounds(400,150,200,30);
    lblfname.setFont(new Font("serif",Font.BOLD,20));
    add(lblfname);
    
    tffname=new JTextField();
    tffname.setBounds(600,150,150,30);
    add(tffname);
    
    JLabel lblempID =new JLabel("Unique ID");
    lblempID.setBounds(50,200,200,30);
    lblempID.setFont(new Font("serif",Font.BOLD,20));
    add(lblempID);
    
    labelempID=new JLabel("011"+sixteen);
    labelempID.setBounds(190,200,200,30);
    labelempID.setFont(new Font("serif",Font.BOLD,20));
    add(labelempID);
    
    JLabel lbdob =new JLabel("Date Of Birth");
    lbdob.setBounds(400,200,200,30);
    lbdob.setFont(new Font("serif",Font.BOLD,20));
    add(lbdob);
    dcdob=new JDateChooser();
    dcdob.setBounds(600,200,150,30);
    add(dcdob);
    
    JLabel lbladd =new JLabel("Address");
    lbladd.setBounds(50,250,200,30);
    lbladd.setFont(new Font("serif",Font.BOLD,20));
    add(lbladd);
    
    tfadd=new JTextField();
    tfadd.setBounds(200,250,150,30);
    add(tfadd);
    
    JLabel lblphone =new JLabel("Phone Number");
    lblphone.setBounds(400,250,200,30);
    lblphone.setFont(new Font("serif",Font.BOLD,20));
    add(lblphone);
    
    tfphone = new JTextField();
    tfphone.setBounds(600,250,150,30);
    add(tfphone);
    
    JLabel lblteacherID =new JLabel("Teacher ID");
    lblteacherID.setBounds(50,300,200,30);
    lblteacherID.setFont(new Font("serif",Font.BOLD,20));
    add(lblteacherID);
    
    tfTeacherID = new JTextField();
    tfTeacherID.setBounds(200,300,150,30);
    add(tfTeacherID);
   
    
     JLabel lblcourse=new JLabel("Qualification");
    lblcourse.setBounds(50,350,200,30);
    lblcourse.setFont(new Font("serif",Font.BOLD,20));
    add(lblcourse);
    
    String  course[]={"Bsc","Msc","MBA","BBA","B.Pharm","M.Pharm","LLB"};
    cbcourse = new JComboBox(course);
    cbcourse.setBounds(200,350,150,30);
    cbcourse.setBackground(Color.WHITE);
    add(cbcourse);
  
    JLabel Department=new JLabel("Department");
    Department.setBounds(400,300,200,30);
    Department.setFont(new Font("serif",Font.BOLD,20));
    add(Department);
    
     JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(425,350,200,30);
    lblemail.setFont(new Font("serif",Font.BOLD,20));
    add(lblemail);
    
    tfteacheremail = new JTextField();
    tfteacheremail.setBounds(600,350,150,30);
    add(tfteacheremail);
    
    
    
    String department[]={"CSE","GEB","EEE","CIVIL","PHARMACY","LAW","SOCIOLOGY"};
    cbdepartment = new JComboBox(department);
    cbdepartment.setBounds(600,300,150,30);
    cbdepartment.setBackground(Color.WHITE);
    add(cbdepartment);
    
        submit= new JButton("Submit");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
    
        cancel= new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
    
   
 
    setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
        String name =tfname.getText();
        String fname=tffname.getText();
        String uniqueid=labelempID.getText();
        String dob =((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String address = tfadd.getText();
        String phone = tfphone.getText();
        String teacherid=tfTeacherID.getText();
        String course= (String)cbcourse.getSelectedItem();
        String department=(String)cbdepartment.getSelectedItem();
        String email = tfteacheremail.getText();
        
        try{
            String query="insert into teacher values('"+name+"','"+fname+"','"+uniqueid+"',"
                    + "'"+dob+"','"+address+"','"+phone+"','"+teacherid+"','"+course+"','"+department+"','"+email+"')";
            Conn con = new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Teacher details inserted Successfully");
            setVisible(false);
            
               
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Addteacher();
            
        }
    }


