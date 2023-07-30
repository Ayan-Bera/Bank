
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton deposit,with,mini,pinchange,fastcash,blance,exit;
    String pinnumber;
    
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        
         with=new JButton("RS 500");
        with.setBounds(355,415,150,30);
         with.addActionListener(this);
        image.add(with);
        
         fastcash=new JButton("RS 1000");
        fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
        image.add(fastcash);
        
        
         mini=new JButton("RS 2000");
        mini.setBounds(355,450,150,30);
         mini.addActionListener(this);
        image.add(mini);
        
         pinchange=new JButton("RS 5000");
        pinchange.setBounds(170,485,150,30);
         pinchange.addActionListener(this);
        image.add(pinchange);
        
        
         blance=new JButton("RS 10000");
        blance.setBounds(355,485,150,30);
         blance.addActionListener(this);
        image.add(blance);
        
         exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
        image.add(exit);
        
        
         deposit=new JButton("RS 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            
          setVisible(false);
          new Transaction (pinnumber).setVisible(true);
        }else {
           String amount = ((JButton)ae.getSource()).getText().substring(3);
           Conn c=new Conn();
           
           try{
               ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               int blance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       blance +=Integer.parseInt(rs.getString("amount"));
                   }else{
                       blance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource() !=exit && blance< Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficent Blance");
                   return;
               }
               
               Date date=new Date();
               String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"RS "+ amount + " Debited Sucessfully");
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
                       
                       
                       
                       
                   
               
           }catch(Exception e){
               System.out.println(e);
           }
        }
        
    }
    public static void main(String args[]){
        new FastCash("");
    }
    
}
