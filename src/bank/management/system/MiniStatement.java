
package bank.management.system;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    //JButton back;
    
    
    MiniStatement(String pinnumber){
        
        setLayout(null);
        setTitle("Mini Statemnt");
        
        JLabel mini=new JLabel();
        //text.setForeground(Color.WHITE);
        //text.setFont(new Font("System",Font.BOLD,16));
        mini.setBounds(20,140,400,200);
        add(mini);
        
        
        JLabel bank=new JLabel("Indian Bank");
        //text.setForeground(Color.WHITE);
        //bank.setFont(new Font("System",Font.BOLD,16));
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        //text.setForeground(Color.WHITE);
        //mini.setFont(new Font("System",Font.BOLD,16));
        card.setBounds(20,80,300,20);
        add(card);
        
          JLabel balance=new JLabel();
        //text.setForeground(Color.WHITE);
        //mini.setFont(new Font("System",Font.BOLD,16));
        balance.setBounds(20,400,300,20);
        add(balance);
       try{
           
           Conn conn=new Conn();
                      

              ResultSet rs= conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
               
               while(rs.next()){
                   card.setText("Card Number: "+ rs.getString("cardnumber").substring(0, 4) + "xxxxxxxx" + rs.getString("cardnumber").substring(12));
              
               
               
               }
               
               }catch (Exception e){
                       System.out.println(e);
                       }
        
        try{
           
           Conn conn=new Conn();
           int bal=0;
              ResultSet rs= conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               
               while(rs.next()){
               
                   

 mini.setText(mini.getText()+ "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                       bal +=Integer.parseInt(rs.getString("amount"));
                   }else{
                       bal-=Integer.parseInt(rs.getString("amount"));
                   }
               
               
               }
               balance.setText("Your Current account balance is Rs " + bal);
               }catch (Exception e){
                       System.out.println(e);
                       }
        
        
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(0,0,900,900);
//        add(image);
//        
//        back=new JButton("BACK");
//        back.setBounds(355,520,150,30);
//        back.addActionListener(this);
//        image.add(back);
        
          
//           
//               
//               JLabel text=new JLabel("Your Current Account balance is Rs: "+ blance);
//               
//                text.setForeground(Color.WHITE);
//        text.setFont(new Font("System",Font.BOLD,16));
//        text.setBounds(170,300,400,30);
//        image.add(text);
//               
//        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
        setVisible(true);
    }
//    
    
//    public void actionPerformed(ActionEvent ae){
//        
//        setVisible(false);
//        new Transaction(pinnumber).setVisible(true);
//    }
//    
    public static void main(String args[]){
        new MiniStatement("");
        
    }
    
    
    
    
}
