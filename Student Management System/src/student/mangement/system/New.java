
package student.mangement.system;
import java.awt.Image;
import  javax.swing.*;
public class New extends JFrame implements Runnable{
    Thread t;
    
    New(){
       ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/98_full.jpg"));
        JLabel image=new JLabel(i1);
        add(image);
        
        t = new Thread (this);
        t.start();
            setVisible(true);
            int x=1;
            for(int i=2;i<=600;i+=4,x+=1){
                setLocation(600 -((i+x)/2),350-(i/2));
                setSize(i+3*x,i+x/2);
                try {
                    Thread.sleep(2);
                    
                }catch (Exception e){}
                
            }            
            } 
    public void run(){
    
 try {
     Thread.sleep(7000);
     setVisible(false);
     //Next frame
     new Login();
  
}catch(Exception e){}
 
}
    
    public static void main(String[] args) {
        New aNew = new New();
    }
}

