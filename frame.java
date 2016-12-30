
package medicine_management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.*;
public class frame implements MouseMotionListener,ActionListener 
{
    static JFrame f;
    static JTextField tf1,tf2,getv;
    static JButton b1,b2;
    static JLabel l1,l2,l3,l4;
    static JPanel p1,p2;
    JPasswordField pf;
    Font f1;
    frame()
    {
        f = new JFrame("ADMIN Login");
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setSize(600,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f1 = new Font("Arial",Font.BOLD,12);
        p1 = new JPanel();
        
        ImageIcon img=new ImageIcon(getClass().getResource("/photos/computers technology mouse 1600x1200 wallpaper_www.wallpaperfo.com_10.jpg"));
        l1 = new JLabel(img);
        f.add(p1);
        p1.add(l1);
        l2 = new JLabel("Admin UserId:");
        l2.setBackground(Color.BLACK);
        l2.setBounds(400,100, 100, 40);
        l2.setFont(f1);
        
        l1.add(l2);
        
        tf1 = new JTextField();
        tf1.setBounds(500, 100, 100, 30);
        
        l1.add(tf1);
        
        pf = new JPasswordField();
        pf.setBounds(500, 150, 100, 30);
        
        l1.add(pf);
        
        l3 = new JLabel("Password:");
        l3.setBackground(Color.BLACK);
        l3.setBounds(400, 150, 70, 40);
        l3.setFont(f1);
        
        l1.add(l3);
        
        l4= new JLabel();
        l4.setBackground(Color.LIGHT_GRAY);
        p2 = new JPanel();
        
        b1= new JButton("Submit");
        b1.setBounds(400, 200, 80, 30);
        l1.add(b1);
        b1.addActionListener(this);
        
        b2= new JButton("Cancel");
        b2.setBounds(500, 200, 80, 30); 
        l1.add(b2);
        b2.addActionListener(this);
        
        getv = new JTextField();
        int gv=(int)(Math.random()*9999);
        getv.setText(""+gv);
        
    }
    public static void main(String[] args) {
        frame ff=new frame();
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    if(e.getSource()== l1){
            l4.setText("x=>"+e.getX()+"y=>"+e.getY());
}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1)
        {
        String userID=tf1.getText();
        String password=pf.getText();
       // String uniqueId=getv.getText();
        
        Connection con = database.getConnection();
       try{
           PreparedStatement pst=con.prepareStatement("SELECT * FROM `registration` WHERE `first`=? AND `password`=?");
           pst.setString(1, userID);
           pst.setString(2, password);
           ResultSet rs=pst.executeQuery();
           if(rs.next())
           {
               f.setVisible(false);
               f.dispose();
             
               
               //medi m=new medi();
             String a=rs.getString(1);
             String b=rs.getString("last");
             String c=rs.getString("dob");
             String d=rs.getString("emailid");
             String e1=rs.getString("password");
             String f=rs.getString("conpass");
             String g=rs.getString("contact");
             
               System.out.println(a);
                 System.out.println(b);
                   System.out.println(c);
                     System.out.println(d);
                       System.out.println(e1);
                        System.out.println(f);
                         System.out.println(g);
                
                   // symptoms.l3.setText(a);
                    EventQueue.invokeLater(new Runnable() {

                   @Override
                   public void run() 
                   {
                      
                      new symptoms();
                        JOptionPane.showMessageDialog(null,"WELCOME" + userID);
                      symptoms.l3.setText(a + "" + b);
                   }
               });
                       
           }
           else
        {
            JOptionPane.showMessageDialog(null, "Wrong Id and Password!");
        }
       }
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }
       
        }
        
        if(e.getSource() == b2)
        {
            f.setVisible(false);
            f.dispose();
        }
    }
}

