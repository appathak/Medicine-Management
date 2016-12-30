/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import javafx.scene.control.Hyperlink;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static medicine_management.homepage.f;
import static medicine_management.homepage.l;

/**
 *
 * @author w-7
 */
public class Online_Vendors implements MouseListener{
static JFrame f;
   static JPanel p,lp,up;
   static JLabel l[]=new JLabel[20]; 
   static JButton q;
   Online_Vendors()
   {
     Font f1=new Font("Cooper Black", 10, 25);
     Font f2=new Font("Arial Black", 10, 15);
    ImageIcon img=new ImageIcon(getClass().getResource("/photos/digital.png"));     
    ImageIcon img1=new ImageIcon(getClass().getResource("/photos/d9-13.jpg")); 
    f=new JFrame("Home Page");
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(640,480);
    f.setResizable(false);
    f.setLocationRelativeTo(null);
    
    p=new JPanel();
    l[0]=new JLabel("Click to buy medicines online");
    l[0].setBounds(150, 80, 640, 50);
    l[0].setFont(f1);
    l[1]=new JLabel(img);           
    q=new JButton(img1);
    q.setBounds(10, 5, 90, 90);    
    q.addMouseListener(this);
    l[3]=new JLabel("Name :- ");
    l[3].setBounds(120, 10, 200, 40);    
    l[4]=new JLabel("ID :- ");
    l[4].setBounds(120, 55, 200, 40);
    l[5]=new JLabel("Age :- ");
    l[5].setBounds(340, 10, 100, 40);
    l[6]=new JLabel("Gender :- ");
    l[6].setBounds(340, 55, 100, 40);
    l[7]=new JLabel("https://www.buydrug.in");
    l[7].setBounds(10, 140,400, 50);
    l[7].setFont(f2);
    l[7].addMouseListener(this);    
    l[8]=new JLabel("http://www.merapharmacy.com");
    l[8].setBounds(10, 200,400, 50);
    l[8].setFont(f2);
    l[8].addMouseListener(this);
    l[9]=new JLabel("https://www.medidart.com");
    l[9].setBounds(10, 260,400, 50);
    l[9].setFont(f2);
    l[9].addMouseListener(this);
    l[10]=new JLabel("https://www.apollopharmacy.in");
    l[10].setBounds(10, 320,400, 50);
    l[10].setFont(f2);
    l[10].addMouseListener(this);
    l[11]=new JLabel("Logout");
    l[11].setBounds(540, 360, 100, 50);
    l[11].addMouseListener(this);
    l[12]=new JLabel("Back to Homepage");
    l[12].setBounds(10, 360, 200, 50);
    l[12].addMouseListener(this);       
    l[16]=new JLabel(medi.fname+" "+medi.lname);
    l[16].setBounds(170, 10, 100, 40);
    l[13]=new JLabel(medi.id);
    l[13].setBounds(170, 55, 150, 40);
    l[14]=new JLabel(medi.dob);
    l[14].setBounds(410, 10, 110, 40);
    l[15]=new JLabel(medi.phone);
    l[15].setBounds(410, 55, 110, 40);
    
    
    up=new JPanel(null);
    up.setOpaque(false);
    up.setSize(640, 100);
    up.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    
    lp=new JPanel(null);
    lp.setBounds(0, 10, 640, 420);
    lp.setOpaque(false);
    
    
    
    
    
    
   f.add(p);
   p.add(l[1]);
   l[1].add(up,BorderLayout.NORTH);
   l[1].add(lp);
   up.add(q);
   up.add(l[3]);
   up.add(l[4]);
   up.add(l[5]);
   up.add(l[6]);
   lp.add(l[0]);
   lp.add(l[7]);
   lp.add(l[8]);
   lp.add(l[9]);
   lp.add(l[10]);
   lp.add(l[11]);
   lp.add(l[12]);
   up.add(l[16]);
    up.add(l[13]);
    up.add(l[14]);
    up.add(l[15]);
   
   }
    public static void main(String[] args) {
     new Online_Vendors();   
    }    

    @Override
    public void mouseClicked(MouseEvent me) {
      if (me.getSource()==l[7]) {
          if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI("https://www.buydrug.in");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
          }
      }
       if (me.getSource()==l[8]) {
          if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI("http://www.merapharmacy.com");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
          }
       }
                if (me.getSource()==l[9]) {
          if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI("https://www.medidart.com");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
          }
                }
                if (me.getSource()==l[10]) {
          if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI("https://www.apollopharmacy.in");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
    }
      }
     if(me.getSource()==l[11])
     {
        new login(); 
        f.setVisible(false);
        f.dispose();
     }
     if(me.getSource()==l[12])
     {
        new homepage(); 
        f.setVisible(false);
        f.dispose();
     }
     if(me.getSource()==q)
     {
        new homepage(); 
        f.setVisible(false);
        f.dispose();
     }
    }
    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==l[7])
        {
        l[7].setForeground(Color.BLUE);
        l[7].setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
        if(me.getSource()==l[8]){
        l[8].setForeground(Color.BLUE);
        l[8].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(me.getSource()==l[9]){
        l[9].setForeground(Color.BLUE);
        l[9].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(me.getSource()==l[10]){
        l[10].setForeground(Color.BLUE);
        l[10].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(me.getSource()==l[11]){
        l[11].setForeground(Color.RED);
        l[11].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(me.getSource()==l[12]){
        l[12].setForeground(Color.RED);
        l[12].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
         if(me.getSource()==q){
        q.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
       if(me.getSource()==l[7])
        {
        l[7].setForeground(Color.BLACK);
         }
        if(me.getSource()==l[8]){
        l[8].setForeground(Color.BLACK);
         }
        if(me.getSource()==l[9]){
        l[9].setForeground(Color.BLACK);
         }
        if(me.getSource()==l[10]){
        l[10].setForeground(Color.BLACK);
         }
        if(me.getSource()==l[11]){
        l[11].setForeground(Color.BLACK);
         }
        if(me.getSource()==l[12]){
        l[12].setForeground(Color.BLACK);
         }
     }
}
