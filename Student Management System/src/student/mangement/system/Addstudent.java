
package student.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Addstudent extends JFrame implements ActionListener{
    JTextField tfname,tffname,tfphone,tfadd,tfstudentID,tfSemester,tfstudentmail;
    JLabel UniqueID;
    JDateChooser dcdob;
    JComboBox cbcourse,cbdepartment;
    JButton submit,cancel;
    Random ran=new Random();
    long sixteen=Math.abs((ran.nextLong()%9000000000000L)+1000000000000L);
    
    Addstudent(){
    setSize(900,700);
    setLocation(350,50);
    setLayout(null);
    
    JLabel heading=new JLabel("New Student Details:");
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
    
    JLabel lbluid =new JLabel("Unique ID");
    lbluid.setBounds(50,200,200,30);
    lbluid.setFont(new Font("serif",Font.BOLD,20));
    add(lbluid);
    
    UniqueID=new JLabel("009"+sixteen);
    UniqueID.setBounds(190,200,200,30);
    UniqueID.setFont(new Font("serif",Font.BOLD,20));
    add(UniqueID);
    
    JLabel lbdob =new JLabel("Date Of Birth");
    lbdob.setBounds(400,200,200,30);
    lbdob.setFont(new Font("serif",Font.BOLD,20));
    add(lbdob);
    
    //calander
    
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
    
    JLabel lblstudentID =new JLabel("Student ID");
    lblstudentID.setBounds(50,300,200,30);
    lblstudentID.setFont(new Font("serif",Font.BOLD,20));
    add(lblstudentID);
    
    tfstudentID = new JTextField();
    tfstudentID.setBounds(200,300,150,30);
    add(tfstudentID);
    
    JLabel lblsemester =new JLabel("Semester");
    lblsemester.setBounds(400,300,200,30);
    lblsemester.setFont(new Font("serif",Font.BOLD,20));
    add(lblsemester);
    
    tfSemester = new JTextField();
    tfSemester.setBounds(600,300,150,30);
    add(tfSemester);
    
     JLabel lblcourse=new JLabel("Course");
    lblcourse.setBounds(50,350,200,30);
    lblcourse.setFont(new Font("serif",Font.BOLD,20));
    add(lblcourse);
    
    String  course[]={"Bsc","Msc","MBA","BBA","B.Pharm","M.Pharm","LLB"};
    cbcourse = new JComboBox(course);
    cbcourse.setBounds(200,350,150,30);
    cbcourse.setBackground(Color.WHITE);
    add(cbcourse);
    
    JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(50,400,200,30);
    lblemail.setFont(new Font("serif",Font.BOLD,20));
    add(lblemail);
    
    tfstudentmail = new JTextField();
    tfstudentmail.setBounds(200,400,150,30);
    add(tfstudentmail);
    
  
    JLabel Department=new JLabel("Department");
    Department.setBounds(400,350,200,30);
    Department.setFont(new Font("serif",Font.BOLD,20));
    add(Department);
    
    String department[]={"CSE","GEB","EEE","CIVIL","PHARMACY","LAW","SOCIOLOGY"};
    cbdepartment = new JComboBox(department);
    cbdepartment.setBounds(600,350,150,30);
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
        String uniqueid=UniqueID.getText();
        String dob =((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String address = tfadd.getText();
        String phone = tfphone.getText();
        String studentid=tfstudentID.getText();
        String semester=tfSemester.getText();
        String course= (String)cbcourse.getSelectedItem();
        String email = tfstudentmail.getText();
        String department=(String)cbdepartment.getSelectedItem();
        
        try{
            String query="insert into student values('"+name+"','"+fname+"','"+uniqueid+"',"
                    + "'"+dob+"','"+address+"','"+phone+"','"+studentid+"','"+semester+"','"+course+"','"+email+"','"+department+"')";
            Conn con = new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Student details inserted Successfully");
            setVisible(false);
            
               
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Addstudent();
            
        }
    }

