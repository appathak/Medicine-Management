
package medicine_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
/**
 *
 * @author raj
 */
public class login implements ActionListener,MouseMotionListener,MouseListener {
    JFrame f;
    JPanel p1,p2;
    JTextField t1;
    JButton b1,b2;
    JLabel l,l1,l2,l3,l4;
    JPasswordField t2;
   String a,b,c,d,e1,e2;
    
    login()
    {
        //frame
        
        f=new JFrame("LOGIN PAGE");
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        
        
        //image and label and panel
        ImageIcon i;
        i=new ImageIcon(getClass().getResource("/photos/got.jpg"));
        l=new JLabel(i);
        l1=new JLabel("NAME              : ");
        l2=new JLabel("PASSWORD  :");
        l3=new JLabel("if new user, click here");
        l3.addMouseListener(this);
        l4=new JLabel("if admin, click here");
        l4.addMouseListener(this);
        
        t1=new JTextField();
        t2=new JPasswordField();
        b1=new JButton("LOGIN");
        b2=new JButton("CANCEL");
       
        l1.setBounds(500, 50, 90, 45);
        l2.setBounds(500, 100, 80, 45);
        l3.setBounds(600,400 , 150, 55);
        l4.setBounds(600,420 , 150, 55);
        t1.setBounds(700, 50, 130, 30);
        t2.setBounds(700, 100, 130, 29);
        b1.setBounds(500, 250, 90, 45);
        b1.addActionListener(this);
        b2.setBounds(740, 250, 90, 45);
        b2.addActionListener(this);
         
        p1=new JPanel();
 
        //add on frame and panel
        f.add(p1);
        p1.add(l);
        l.add(l1);
        l.add(l2);
        l.add(t1);
        l.add(t2);
        l.add(b1);
        l.add(b2);
        l.add(l3);
        l.add(l4);
        
        
    }
    public static void main(String s[])
    {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            String name=t1.getText();
            String password=t2.getText();
            
            Connection con = database.getConnection();
            try{
                PreparedStatement pst = con.prepareStatement("SELECT * FROM `registration` WHERE `first`=? AND `password`=?");
            pst.setString(1,name);
            pst.setString(2,password);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    f.setVisible(false);
                    f.dispose();
                    a=rs.getString(1);
                    b=rs.getString("last");
                    c=rs.getString("DOB");
                    d=rs.getString("emailid");
                    e1=rs.getString("contact");
                    e2=rs.getString("uniqueId");
                    medi.setFname(a);
                    medi.setLname(b);
                    medi.setDob(c);
                    medi.setId(d);
                    medi.setPhone(e1);
                    medi.setuid(e2);
                    EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new homepage();
                    JOptionPane.showMessageDialog(null, "Welcome" );
                                       
                }
            });
            }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Connectivity Error");
            } 
        }
        if(e.getSource()==b2)
        {
            f.setVisible(false);
            f.dispose();
        }
}
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == l3)
        {
            new Medicine_management();
            f.setVisible(false);
            f.dispose();
        }
        if(e.getSource() == l4)
        {
            new frame();
            f.setVisible(false);
            f.dispose();
        }
   }
    
    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(e.getSource()==l3)
   {
       l3.setForeground(Color.BLUE);
       l3.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
   }
    if(e.getSource() ==l4)
    {
        l4.setForeground(Color.BLUE);
        l4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   if(e.getSource()==l3)
   {
       l3.setForeground(Color.black);
   }
   if(e.getSource()==l4)
   {
       l4.setForeground(Color.black);
   }
   }
    
}