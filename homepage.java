/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.*;
import static medicine_management.Online_Vendors.l;

/**
 *
 * @author w-7
 */
public class homepage implements MouseListener{
   static JFrame f;
   static JPanel p,lp,up;
   static JButton q;
   static JLabel l[]=new JLabel[20]; 
   homepage(){
      
    Font f1=new Font("Magneto",20,20);           
    ImageIcon img=new ImageIcon(getClass().getResource("/photos/digital.png"));     
    ImageIcon img1=new ImageIcon(getClass().getResource("/photos/d9-13.jpg")); 
    f=new JFrame("Home Page");
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(640,480);
    f.setResizable(false);
    f.setLocationRelativeTo(null);
    
    p=new JPanel();
    
    l[1]=new JLabel(img);           
    q=new JButton(img1);
    q.setBounds(10, 5, 90, 90);    
    q.addMouseListener(this);
    l[3]=new JLabel("Name :- ");
    l[3].setBounds(120, 10, 50, 40);
    l[4]=new JLabel("ID :- ");
    l[4].setBounds(120, 55, 50, 40);
    l[5]=new JLabel("DOB :- ");
    l[5].setBounds(340, 10, 70, 40);
    l[6]=new JLabel("Contact :- ");
    l[6].setBounds(340, 55, 70, 40);
    l[7]=new JLabel("New Prescription");
    l[7].setBounds(20, 120, 200, 40);
    l[7].setFont(f1);
    l[7].addMouseListener(this);
    l[8]=new JLabel("Prescription");
    l[8].setBounds(20, 170, 300, 40);
    l[8].setFont(f1);
    l[8].addMouseListener(this);
    /*l[9]=new JLabel("Information about Medicines and Salts");
    l[9].setBounds(20, 220, 500, 40);
    l[9].setFont(f1);
    l[9].addMouseListener(this);*/
    l[10]=new JLabel("Online Vendors");
    l[10].setBounds(20, 220, 300, 40);
    l[10].setFont(f1);
    l[10].addMouseListener(this);
    l[11]=new JLabel("Logout");
    l[11].setBounds(540, 360, 100, 50);
    l[11].addMouseListener(this);
    l[12]=new JLabel(medi.fname+" "+medi.lname);
    l[12].setBounds(170, 10, 100, 40);
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
   lp.add(l[7]);
   lp.add(l[8]);
   //lp.add(l[9]);
   lp.add(l[10]);
   lp.add(l[11]);
   up.add(l[12]);
    up.add(l[13]);
    up.add(l[14]);
    up.add(l[15]);
   
   
   }
    public static void main(String[] args) {
     new homepage();   
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==l[7])
        {
         new symptoms();
        f.setVisible(false);
        f.dispose();
         }
        if(me.getSource()==l[8]){
        new prescription();
        f.setVisible(false);
        f.dispose();
        }
     /*   if(me.getSource()==l[9]){
        new info();
        f.setVisible(false);
        f.dispose();
        }*/
        if(me.getSource()==l[10]){
        new Online_Vendors();
        f.setVisible(false);
        f.dispose();
        }
        if(me.getSource()==l[11])
     {
        new login(); 
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
       /* if(me.getSource()==l[9]){
        l[9].setForeground(Color.BLUE);
        l[9].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }*/
        if(me.getSource()==l[10]){
        l[10].setForeground(Color.BLUE);
        l[10].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
          if(me.getSource()==l[11]){
        l[11].setForeground(Color.RED);
        l[11].setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        /*if(me.getSource()==l[9]){
        l[9].setForeground(Color.BLACK);
         }*/
        if(me.getSource()==l[10]){
        l[10].setForeground(Color.BLACK);
         }
        if(me.getSource()==l[11]){
        l[11].setForeground(Color.BLACK);
         }
    }
}
