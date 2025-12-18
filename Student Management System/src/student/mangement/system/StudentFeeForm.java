
package student.mangement.system;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.*;


public class StudentFeeForm extends JFrame implements ActionListener{
    Choice studentid;
    JComboBox cbcourse,cbdepartment,cbsemester;
    JLabel labeltotal;
    JButton pay,update,back;
    StudentFeeForm(){
        setSize(600,500);
        setLocation(300,100);
        setLayout(null);
        
         JLabel lblstudentid =new JLabel("Select Student ID");
        lblstudentid.setBounds(40,60,150,20);
        lblstudentid.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblstudentid);
        
        studentid=new Choice();
        studentid.setBounds(230,60,150,20);
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
    lblName.setBounds(40,100,150,32);
    lblName.setFont(new Font("Tahoma",Font.BOLD,16));
    add(lblName);
    
    JLabel Labelname=new JLabel();
    Labelname.setBounds(200,100,150,20);
     Labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(Labelname);
   
    
    JLabel lblfname =new JLabel("Father's Name");
    lblfname.setBounds(40,140,150,20);
    lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
    add(lblfname);
    
    JLabel labelfname=new JLabel();
    labelfname.setBounds(200,140,150,20);
     labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(labelfname);
    
    
    
        try{
        Conn c = new Conn();
        String query="select * from student where StudentID='"+studentid.getSelectedItem()+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
            Labelname.setText(rs.getString("name"));
            labelfname.setText(rs.getString("fname"));
           
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
        }
    }catch(Exception e){
        e.printStackTrace();
    }
        }
    });
         
          JLabel lblcourse=new JLabel("Course");
    lblcourse.setBounds(40,180,150,20);
    lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
    add(lblcourse);
    
    String  course[]={"Bsc","Msc","MBA","BBA","B.Pharm","M.Pharm","LLB"};
    cbcourse = new JComboBox(course);
    cbcourse.setBounds(200,180,150,20);
    cbcourse.setBackground(Color.WHITE);
    add(cbcourse);
    
    
    JLabel Department=new JLabel("Department");
    Department.setBounds(40,220,150,20);
    Department.setFont(new Font("Tahoma",Font.BOLD,16));
    add(Department);
    
    String department[]={"CSE","GEB","EEE","CIVIL","PHARMACY","LAW","SOCIOLOGY"};
    cbdepartment = new JComboBox(department);
    cbdepartment.setBounds(200,220,150,20);
    cbdepartment.setBackground(Color.WHITE);
    add(cbdepartment);
    
    JLabel lblsemester =new JLabel("Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblsemester);
        
        String semester[]={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8","Semester9","Semester10","Semester11","Semester12"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal=new JLabel("Total Payable");
    lbltotal.setBounds(40,300,150,20);
    lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
    add(lbltotal);
    
    labeltotal=new JLabel();
    labeltotal.setBounds(240,300,150,20);
    labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(labeltotal);
    
    update= new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setFont(new Font("tahoma",Font.BOLD,16));
        add(update);
    
        pay= new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        pay.setFont(new Font("tahoma",Font.BOLD,16));
        add(pay);
        
         back= new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setFont(new Font("tahoma",Font.BOLD,16));
        add(back);
        
        
        
    setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String course=(String)cbdepartment.getSelectedItem();
            String semester=(String)cbsemester.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course='"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }
            }catch(Exception e ){
                e.printStackTrace();
            }
        }else if(ae.getSource()==pay){
        String Studentid=studentid.getSelectedItem();
         String course=(String)cbcourse.getSelectedItem();
            String semester=(String)cbsemester.getSelectedItem();
            String department=(String)cbdepartment.getSelectedItem();
            String total=labeltotal.getText();
            
             try{
                Conn c = new Conn();
                String query = "insert into varsityFee values ('"+Studentid+"','"+course+"','"+department+"','"+semester+"','"+total+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Course Pay Submitted Successfully");
                 setVisible(false);
                }
            catch(Exception e ){
                e.printStackTrace();
            }
        
        }else if(ae.getSource()==back){
            setVisible(false);
        }else 
            setVisible(false);
    }
    
    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
