
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    JButton deposit,with,mini,pinchange,fastcash,blance,exit;
    String pinnumber;
    
    
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        
         with=new JButton("Cash Withdrawl");
        with.setBounds(355,415,150,30);
         with.addActionListener(this);
        image.add(with);
        
         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
        image.add(fastcash);
        
        
         mini=new JButton("Mini Statement");
        mini.setBounds(355,450,150,30);
         mini.addActionListener(this);
        image.add(mini);
        
         pinchange=new JButton("PIN Change");
        pinchange.setBounds(170,485,150,30);
         pinchange.addActionListener(this);
        image.add(pinchange);
        
        
         blance=new JButton("Blance Enquiry");
        blance.setBounds(355,485,150,30);
         blance.addActionListener(this);
        image.add(blance);
        
         exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
        image.add(exit);
        
        
         deposit=new JButton("Deposit");
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
            
            System.exit(0);
        }else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==with){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==blance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==mini){
           
            new MiniStatement(pinnumber).setVisible(true);
        }
        
        
    }
    public static void main(String args[]){
        new Transaction("");
    }
    
}
