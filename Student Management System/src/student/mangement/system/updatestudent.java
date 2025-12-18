
package student.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updatestudent extends JFrame implements ActionListener{
    JTextField tfcourse,tffname,tfphone,tfadd,tfstudentID,tfSemester,tfstudentmail,tfdepartment;
    JLabel UniqueID,labelstudentID;
    JButton submit,cancel,delete;
    Choice studentid;
   
    updatestudent(){
    setSize(900,700);
    setLocation(350,50);
    setLayout(null);
    
    JLabel heading=new JLabel("Update Student Details:");
    heading.setBounds(50,10,500,50);
    heading.setFont(new Font("Tahoma",Font.ITALIC,35));
    add(heading);
    
    JLabel lblstudentid =new JLabel("Select Student ID");
        lblstudentid.setBounds(50,100,200,20);
        lblstudentid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblstudentid);
        
        studentid=new Choice();
        studentid.setBounds(250,100,200,20);
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
    
    JLabel lblName=new JLabel("Name");
    lblName.setBounds(50,150,100,30);
    lblName.setFont(new Font("serif",Font.BOLD,20));
    add(lblName);
    
    JLabel Labelname=new JLabel();
    Labelname.setBounds(200,150,150,30);
     Labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(Labelname);
   
    
    JLabel lblfname =new JLabel("Father's Name");
    lblfname.setBounds(400,150,200,30);
    lblfname.setFont(new Font("serif",Font.BOLD,20));
    add(lblfname);
    
    JLabel labelfname=new JLabel();
    labelfname.setBounds(600,150,150,30);
     labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(labelfname);
    
    JLabel lbluid =new JLabel("Unique ID");
    lbluid.setBounds(50,200,200,30);
    lbluid.setFont(new Font("serif",Font.BOLD,20));
    add(lbluid);
    //"009"+sixteen
    UniqueID=new JLabel();
    UniqueID.setBounds(190,200,200,30);
    UniqueID.setFont(new Font("serif",Font.BOLD,20));
    add(UniqueID);
    
    JLabel lbdob =new JLabel("Date Of Birth");
    lbdob.setBounds(400,200,200,30);
    lbdob.setFont(new Font("serif",Font.BOLD,20));
    add(lbdob);
    
    //calander
    
    JLabel labeldcdob=new JLabel();
    labeldcdob.setBounds(600,200,150,30);
    labeldcdob.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(labeldcdob);
    
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
    
    labelstudentID = new JLabel();
    labelstudentID.setBounds(200,300,150,30);
    labelstudentID.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(labelstudentID);
    
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
    
    
    tfcourse = new JTextField();
    tfcourse.setBounds(200,350,150,30);
    add(tfcourse);
    
    JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(50,400,200,30);
    lblemail.setFont(new Font("serif",Font.BOLD,20));
    add(lblemail);
    
    JLabel labelstudentmail = new JLabel();
    labelstudentmail.setBounds(200,400,150,30);
    labelstudentmail.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(labelstudentmail);
    
  
    JLabel Department=new JLabel("Department");
    Department.setBounds(400,350,200,30);
    Department.setFont(new Font("serif",Font.BOLD,20));
    add(Department);
    
    
    tfdepartment = new JTextField();
    tfdepartment.setBounds(600,350,150,30);
    add(tfdepartment);
    
    try{
        Conn c = new Conn();
        String query="select * from student where StudentID='"+studentid.getSelectedItem()+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
            Labelname.setText(rs.getString("name"));
            labelfname.setText(rs.getString("fname"));
            UniqueID.setText(rs.getString("UniqueID"));
            labeldcdob.setText(rs.getString("DateofBirth"));
            tfadd.setText(rs.getString("Address"));
            tfphone.setText(rs.getString("Phone"));
            labelstudentID.setText(rs.getString("StudentID"));
            tfSemester.setText(rs.getString("Semester"));
            tfcourse.setText(rs.getString("Course"));
            labelstudentmail.setText(rs.getString("Email"));
            tfdepartment.setText(rs.getString("Department"));
         
            
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    studentid.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
             try{
        Conn c = new Conn();
        String query="select * from student where StudentID='"+studentid.getSelectedItem()+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
            Labelname.setText(rs.getString("name"));
            labelfname.setText(rs.getString("fname"));
            UniqueID.setText(rs.getString("UniqueID"));
            labeldcdob.setText(rs.getString("DateofBirth"));
            tfadd.setText(rs.getString("Address"));
            tfphone.setText(rs.getString("Phone"));
            labelstudentID.setText(rs.getString("StudentID"));
            tfSemester.setText(rs.getString("Semester"));
            tfcourse.setText(rs.getString("Course"));
            labelstudentmail.setText(rs.getString("Email"));
            tfdepartment.setText(rs.getString("Department"));
         
            
        }
    }catch(Exception e){
        e.printStackTrace();
    }
        }
    });
    
        submit= new JButton("Update");
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
        
        delete = new JButton("Delete");
        delete.setBounds(350, 500, 120, 30);
        delete.setBackground(Color.black); 
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        delete.setFont(new Font("tahoma", Font.BOLD, 16));
        add(delete);
   
 
    setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
        String address = tfadd.getText();
        String phone = tfphone.getText();
        String Studentid=labelstudentID.getText();
        String semester=tfSemester.getText();
        String course= tfcourse.getText();
        String department=tfdepartment.getText();
        
        try{
            String query="update student set Address='"+address+"',Phone='"+phone+"',StudentID='"+Studentid+"',Semester='"+semester+"',Course='"+course+"',Department='"+department+"'where StudentID='"+Studentid+"'";
            Conn con = new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
            setVisible(false);
            
               
        }catch(Exception e){
            e.printStackTrace();
        }
   
        
        }else if(ae.getSource() == delete) {
            String Studentid=labelstudentID.getText();
            try {
                    Conn con = new Conn();
                    String query = "delete from student where studentID='" + Studentid+ "'";
                    con.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Student Record Deleted Successfully");
                    setVisible(false);
                    
                } catch(Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error deleting student record: " + e.getMessage());
                }
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new updatestudent();
            
        }
    }

