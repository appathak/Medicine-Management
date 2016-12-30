
package medicine_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
class Medicine_management implements MouseMotionListener,ActionListener
{

    static JFrame f;
    JTextField tf,tf1,tf2,tf5,getv;
    JPasswordField tf3,tf4;
    JLabel ll,l,l1,l2,l3,l4,l5,l6,l7,l8,labreg;
    static JPanel pp,p;
    JButton b,b1,back;
    JComboBox date,month,year;
    Medicine_management()
    {
        //objects
        
    String year1[]={"Year","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013"};
    String date1[]={"Date","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String month1[]={"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
    f = new JFrame("Registration");
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(660, 500);
    f.setResizable(false); 
    f.setLocationRelativeTo(null);
    
    getv = new JTextField();
    getv.setEnabled(false);
    int gv=(int)(Math.random()*99999);
    getv.setText(""+gv);
    
    getv.setBounds(500, 250 , 50, 50);
    
    p = new JPanel(); 
    ImageIcon img=new ImageIcon(getClass().getResource("/photos/rtpa6.jpg"));
        ll = new JLabel(img);
        f.add(p);
        p.add(ll);
        
    ImageIcon img1=new ImageIcon(getClass().getResource("/photos/Register 2.png"));
        labreg = new JLabel(img1);
        ll.add(labreg);
    labreg.setBounds(90, 10, 300, 113);
    
    l = new JLabel("First Name:");
    l.setBounds(130, 100, 70, 30);
    
    date = new JComboBox(date1);
    date.setBounds(250, 190, 70, 30);
    
    month = new JComboBox(month1);
    month.setBounds(320, 190, 70, 30);
    
    year = new JComboBox(year1);
    year.setBounds(390, 190, 70, 30);
    
    l2 = new JLabel("Last name:");
    l2.setBounds(130, 140, 70, 30);
    
    l3 = new JLabel("D.O.B");
    l3.setBounds(130, 190, 70, 30);
    
    l4 = new JLabel("Email Id:");
    l4.setBounds(130, 230, 70, 30);
    
    l5 = new JLabel("Password:");
    l5.setBounds(130, 270, 70, 30);
    
    l6 = new JLabel("Confirm password:");
    l6.setBounds(130, 310, 120, 30);
    
    l8 = new JLabel("Contact no:");
    l8.setBounds(130, 350, 90, 30);
    
    tf = new JTextField();
    tf.setBounds(250,100,150,30);
    
    tf1 = new JTextField();
    tf1.setBounds(250,140,150,30);
    
    tf2 = new JTextField();
    tf2.setBounds(250,230,150,30);
    
    tf3 = new JPasswordField();
    tf3.setBounds(250,270,150,30);
    
    tf4 = new JPasswordField();
    tf4.setBounds(250,310,150,30);
    
    tf5 = new JTextField();
    tf5.setBounds(250,350,150,30);
    
    pp = new JPanel(new FlowLayout(FlowLayout.CENTER));
    l7 = new JLabel();
    l7.setBackground(Color.LIGHT_GRAY);

    b = new JButton("Submit");
    b.setBounds(100, 390, 100, 30);
    b.addActionListener(this);
    
    b1 = new JButton("Cancel");
    b1.setBounds(300, 390, 100, 30);
    b1.addActionListener(this);
    
    back=new JButton("BACK");
    back.setBounds(500,390,100,30);
    back.addActionListener(this);
    
    ll.add(back);
    ll.add(getv);
    ll.add(l6);
    ll.add(l8);
    ll.add(b);
    ll.add(b1);
    pp.add(l7);
    f.add(pp,BorderLayout.SOUTH);
    ll.add(l);
    ll.add(date);
    ll.add(month);
    ll.add(year);
    ll.add(l2);
    ll.add(l3);
    ll.add(l4);
    ll.add(l5);
    ll.add(tf);
    ll.add(tf1);
    ll.add(tf2);
    ll.add(tf3);
    ll.add(tf4);
    ll.add(tf5);
    }
    public static void main(String[] args) {
        Medicine_management Medicine_management = new Medicine_management(); /*medicine_management*/
    }   
    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    if(e.getSource()== p){
            l7.setText("x=>"+e.getX()+"y=>"+e.getY());
}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b)
       {
           if(tf.getText().equals("")||!tf3.getText().equals(tf4.getText())||tf3.getText().equals("")||tf5.getText().equals(""))
           {
            JOptionPane.showMessageDialog(null, "Enter Complete Information");
           }
           else{
           String first=tf.getText();//1
           String last=tf1.getText();//2
           String d1=(String) date.getModel().getSelectedItem();
           String m1=(String) month.getModel().getSelectedItem();
           String y1=(String) year.getModel().getSelectedItem();
           String dob=d1+"-"+m1+"-"+y1;//3
           String id=tf2.getText();//4
           String pass=tf3.getText();//5
           String conpass=tf4.getText();//6
          
           String contact=tf5.getText();//7.
           String uniqueid=getv.getText();//8
           
           
           Connection con=database.getConnection();
           try{
           PreparedStatement pst=con.prepareStatement("INSERT INTO `registration` VALUES(?,?,?,?,?,?,?,?)");
        pst.setString(1, first);//1
        pst.setString(2, last);//2
        pst.setString(3, dob);//3
        pst.setString(4, id);//4
        pst.setString(5, pass);//5
        pst.setString(6, conpass);//6
        pst.setString(7,contact); //7         
        pst.setString(8, uniqueid);//8
        int i=pst.executeUpdate();
        if(i==1)
        {
           JOptionPane.showMessageDialog(null, "Data added!");
            f.setVisible(false);
            f.dispose();
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                     JOptionPane.showMessageDialog(null,"Welcome"+" "+first+" "+last);
                    new login();
                }
            });
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Data not added!");
        }
           }
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(null,"Connectivity Error");
           }
           }
    }
       if(e.getSource() == b1)
       {
          f.setVisible(false);
          f.dispose();
       }
       if(e.getSource() == back)
       {
           new login();
           f.dispose();
       }
    }
}