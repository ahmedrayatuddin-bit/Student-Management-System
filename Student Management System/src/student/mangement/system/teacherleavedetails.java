
package student.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class teacherleavedetails extends JFrame implements ActionListener {
    Choice teacherid;
    JTable table;
    JButton search,print,cancel;
   
    teacherleavedetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Search By Teacher ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        teacherid=new Choice();
        teacherid.setBounds(180,20,150,20);
        add(teacherid);
        
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next()){
                teacherid.add(rs.getString("teacherID"));
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
            ResultSet rs=c.s.executeQuery("select * from teacherleave");
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
       
       cancel= new JButton ("cancel");
       cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
       add(cancel);
       
       
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "select * from teacherleave where teacherID = '"+teacherid.getSelectedItem()+"'";
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
    }else {
        setVisible(false);
    }
    }
    public static void main(String[] args) {
        new teacherleavedetails();
    }
}
