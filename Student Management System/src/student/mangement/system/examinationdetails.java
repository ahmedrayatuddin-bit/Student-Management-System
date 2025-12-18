
package student.mangement.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class examinationdetails extends JFrame implements ActionListener {
    JTextField search;
    JButton submit,cancel;
    JTable table;
    examinationdetails(){
        setSize(1010,475);
        setLocation(300,100);
         setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
     JLabel heading=new JLabel("Check Result");
         heading.setBounds(80,15,400,50);
       heading.setFont(new Font("Tahoma",Font.BOLD,20));
       add(heading);
        
       search=new JTextField();
       search.setBounds(80,90,200,30);
       search.setFont(new Font("Tahoma",Font.PLAIN,18));
       add(search);
       
        submit= new JButton("Result");
        submit.setBounds(300,90,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
    
        cancel= new JButton("Back");
        cancel.setBounds(440,90,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
       
        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception ae){
            ae.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row= table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,6).toString());
            }
        } );
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            setVisible(false);
            new marks(search.getText());
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
         new examinationdetails();
    }
    
}
