
package student.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class studentdetails extends JFrame implements ActionListener {
    Choice studentid;
    JTable table;
    JButton search,print,update,add,cancel;
   
    studentdetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Search By Student ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        studentid=new Choice();
        studentid.setBounds(180,20,150,20);
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
       table = new JTable();
       
       JScrollPane jsp = new JScrollPane(table);
       jsp.setBounds(0,100,900,600);
       add(jsp);
       
       try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

       search = new JButton ("search");
       search.setBounds(20,70,80,20);
       search.addActionListener(this);
       add(search);
       
       print = new JButton ("print");
       print.setBounds(120,70,80,20);
        print.addActionListener(this);
       add(print);
       
       add = new JButton ("add ");
       add.setBounds(220,70,80,20);
        add.addActionListener(this);
       add(add);
       
       update = new JButton ("update");
       update.setBounds(320,70,80,20);
        update.addActionListener(this);
       add(update);
       
       cancel= new JButton ("cancel");
       cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
       add(cancel);
       
       
        setSize(915,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "select * from student where StudentID = '"+studentid.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs =c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
    }else if(ae.getSource()==print){
        try{
            table.print();
        }catch(Exception e){
           e.printStackTrace();
        }
    }else if(ae.getSource()==add){
        setVisible(false);
        new Addstudent();
        
    }else if(ae.getSource()==update){
        setVisible(false);
        new updatestudentnew();
    }else {
        setVisible(false);
    }
    }
    public static void main(String[] args) {
        new studentdetails();
    }
}
