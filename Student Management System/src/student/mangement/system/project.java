
package student.mangement.system;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
public class project extends JFrame implements ActionListener{

    public project() {
         setSize(1540,850);
         
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ewuu.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        //new information
        
        JMenuBar mb = new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        setJMenuBar(mb);
        
        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        setJMenuBar(mb);
        
      // details 
      
         
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem facultyDetails=new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        setJMenuBar(mb);
        
        JMenuItem studentDetails=new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        setJMenuBar(mb);
        
        //leave Details
        
         JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeaveDetails=new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);    
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        
        
        JMenuItem studentLeaveDetails=new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);    
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);
        
        
        //Exam
       
         JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.RED);
        mb.add(exam);
        
        JMenuItem examinationDetails=new JMenuItem("Examination Result");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);
        
        
        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        
        setJMenuBar(mb);
        setVisible(true);
        
        //leave 
        
         JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyLeave=new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
         facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        
        
        JMenuItem studentLeave=new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
         studentLeave.addActionListener(this);
        leave.add(studentLeave);
        
        
        setJMenuBar(mb);
        setVisible(true);
        
        //Update Info
       
         JMenu updateInfo= new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem updateFacultyInfo=new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.WHITE);
          updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);
        
        
        JMenuItem updateStudentInfo=new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
          updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);
        
        
        setJMenuBar(mb);
        setVisible(true);
        
        //Fee 
       
         JMenu fee= new JMenu("Fee details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
         feestructure.addActionListener(this);
        fee.add(feestructure);
        
        
        JMenuItem feeform=new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
              feeform.addActionListener(this);
        fee.add(feeform);
        
        
        setJMenuBar(mb);
        setVisible(true);
        
        //Utility
       
         JMenu Utility= new JMenu("Utility");
        Utility.setForeground(Color.RED);
        mb.add(Utility);
        
        JMenuItem calculator=new JMenuItem("calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        Utility.add(calculator);
        
        
        JMenuItem notepad=new JMenuItem("notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        Utility.add(notepad);
        
        
        setJMenuBar(mb);
        setVisible(true);
        
        //Exit
       
         JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
        
        JMenuItem ex=new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        String ms = ae.getActionCommand();
        if(ms.equals("Exit"))
            setVisible(false);
    
    else if(ms.equals("calculator")){
        try{
            Runtime.getRuntime().exec("calc.exe");
        }catch (Exception e){
            
        }
    }
         else if(ms.equals("notepad")){
        try{
            Runtime.getRuntime().exec("notepad.exe");
        }catch (Exception e){
            
        }
    }else if(ms.equals("New Faculty Information")){
        new Addteacher();
    }else if(ms.equals("New Student Information")){
        new Addstudent();
    }else if(ms.equals("View Faculty Details")){
        new teacherdetails();
        
    }else if(ms.equals("Faculty Leave")){
        new teacherleave();
    }else if(ms.equals("View Student Details")){
        new studentdetails();
    }else if(ms.equals("Student Leave")){
        new studentleave();
    }else if(ms.equals("Student Leave Details")){
        new studentleavedetails();
    }else if(ms.equals("Faculty Leave Details")){
        new teacherleavedetails();
    }
    else if(ms.equals("Update Faculty Details")){
        new updatefaculty();
    }else if(ms.equals("Update Student Details")){
        new updatestudentnew();
    }else if(ms.equals("Enter Marks")){
        new entermarks();
    }else if(ms.equals("Examination Result")){
        new examinationdetails();
    }else if(ms.equals("Fee Structure")){
        new FeeStructure();
    }else if(ms.equals("Student Fee Form")){
        new StudentFeeForm();
    }
    }
    public static void main(String[] args) {
        new project();
    }
    
}
