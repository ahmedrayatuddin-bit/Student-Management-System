
package student.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class studentleave extends JFrame implements ActionListener{
    Choice studentid,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    studentleave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading =new JLabel("Apply Leave Student");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblstudentid =new JLabel("Search By Student id");
        lblstudentid.setBounds(60,100,200,20);
        lblstudentid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblstudentid);
        
        studentid=new Choice();
        studentid.setBounds(60,130,200,20);
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
        
        JLabel lbldate =new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);
        
         dcdate=new JDateChooser();
         dcdate.setBounds(60,210,200,25);
         add(dcdate);
         
         JLabel lbltime =new JLabel("Time");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);
        
        ctime=new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit= new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
    
        cancel= new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);


     
        
        setVisible(true);
        
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String Studentid=studentid.getSelectedItem();
            String date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String query="insert into studentleave values('"+Studentid+"','"+date+"','"+duration+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
                
            }catch(Exception e ){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new studentleave();
    }
}
