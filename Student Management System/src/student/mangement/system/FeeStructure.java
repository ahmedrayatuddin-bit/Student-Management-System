
package student.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
    FeeStructure(){
        setSize(1014,700);
        setLocation(250,50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel heading = new JLabel("Fee Structure");
         heading.setBounds(380,10,400,30);
         heading.setFont(new Font("Tahoma",Font.BOLD,30));
         add(heading); 
         JTable table = new JTable();
         JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }
}
