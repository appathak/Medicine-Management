package medicine_management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class symptoms implements FocusListener,ActionListener,MouseListener {
JFrame f;
int k=0;
static JLabel l1,l2,img,l3,l4;
   public static String u;
   public static String w;
   public static String x;
JPanel p;
String sym[]={"Select","cold","nausea","fever","diarrhoea","headache","bodyache","itching","constipation","anxiety","cough"};
    JComboBox a,b,c;
    JTextField t;
    JButton b1,b2,b3;
    ImageIcon i;
    Font g,h;
    symptoms()
    {
        //objects
         i =new ImageIcon(getClass().getResource("/photos/Herbal-Medicine-Depositphotos_1074853_m - Copy.jpg"));  
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
     f=new JFrame("SYMPTOMS");
     f.setVisible(true);
     f.setResizable(false);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setSize(d);
   
      p=new JPanel();
  p.setBackground(Color.BLUE);
  h=new Font("Algerian", Font.BOLD, 26);
  l3=new JLabel();
  l3.setFont(h);
  l3.setBounds(250, 10, 250, 100);
  
  l4=new JLabel();
  l4.setFont(h);
  l4.setBounds(350, 10, 100, 100);
  l1=new JLabel("welcome "); 
  l1.setFont(h);
  l1.setBounds(40, 10, 200, 100);
 
  l2=new JLabel("SELECT YOUR SYMPTOMS");
  g=new Font("Copperplate Gothic Bold", Font.BOLD, 26);
  l2.setFont(g);
  l2.setBounds(40, 50, 450, 200);
  
  a=new JComboBox(sym);
  a.setBounds(50,250, 100, 36);

  b=new JComboBox(sym);
  b.setBounds(220,250, 100, 36);

  c=new JComboBox(sym);
  c.setBounds(400,250, 100, 36);

  t=new JTextField("others if not mentioned");
  t.addFocusListener(this);
  t.setBounds(580,250, 150, 36);

b1=new JButton("Submit");
b1.setBounds(580,400, 100, 24);
b1.addActionListener(this);

b2=new JButton("Cancel");
b2.setBounds(700,400, 100, 24);
b2.addActionListener(this);

b3=new JButton("Previous");
b3.setBounds(820,400, 100, 24);
b3.addActionListener(this);

img=new JLabel(i);
//img.setBounds(10,10,1000,700);

 f.add(p);
 p.add(img);
 img.add(l1);
 img.add(l2);
 img.add(a);    
 img.add(b);
 img.add(c);
 img.add(t);
 img.add(b1);
 img.add(b2);
 img.add(b3);
 img.add(l3); 
 img.add(l4);
}
    public static void main(String args[]) {
        new symptoms();
         }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == t){
        t.setText("");
        }
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b3){
            f.setVisible(false);
            f.dispose();
            new homepage();
        }
        if(e.getSource() == b2){
            f.setVisible(false);
            f.dispose();
            new homepage();
        }
        if(e.getSource() == b1){
            String str1=medi.uid;
            String str2 = (String)a.getModel().getSelectedItem();
            String str3 = (String)b.getModel().getSelectedItem();
            String str4 = (String)c.getModel().getSelectedItem();
            medi.setsym1(str2);
            medi.setsym2(str3);
            medi.setsym3(str4);
            Connection con = database.getConnection();
            try{
                PreparedStatement pst = con.prepareStatement("INSERT INTO symptoms(uniqueId,sym1,sym2,sym3) VALUES(?,?,?,?);");
                pst.setString(1, str1);
                pst.setString(2, str2);
                pst.setString(3, str3);
                pst.setString(4, str4);
                
                int k = pst.executeUpdate();
                if(k==1){
                    JOptionPane.showMessageDialog(null,"Symptoms updated");
                    f.dispose();
                    
                       EventQueue.invokeLater(new Runnable(){
                       @Override
                        public void run(){
                            JOptionPane.showMessageDialog(null,"YOUR QUERY WILL BE SOLVED IN A MOMENT");
                        }
                       });
                       
                }
                PreparedStatement pst1 = con.prepareStatement("SELECT mediname from medi WHERE symptom=?;");
                pst1.setString(1, str2);
                ResultSet ss1 = pst1.executeQuery();
                
                if(ss1.next()){
                u=ss1.getString("mediname");
                             } 
                PreparedStatement pst2 = con.prepareStatement("SELECT mediname from medi WHERE symptom=?;");
                pst2.setString(1, str3);
                ResultSet s2 = pst2.executeQuery();
                
                if(s2.next()){
                w=s2.getString("mediname");
                
                }
                PreparedStatement pst3 = con.prepareStatement("SELECT mediname from medi WHERE symptom=?;");
                pst3.setString(1, str4);
                ResultSet ss3 = pst3.executeQuery();
                
                if(ss3.next()){
                x=ss1.getString("mediname");
                
                }
                f.setVisible(false);
                    f.dispose();
                EventQueue.invokeLater(new Runnable(){
                       @Override
                        public void run(){
                           new prescription();
                        }
                       });
                
                   
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
