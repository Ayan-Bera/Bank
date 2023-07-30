
package bank.management.system;


import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    

    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    
    
    JComboBox religion,category,ocu,education,income;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");  
       
    
        
         JLabel ad=new JLabel("PAGE 2: Additional Details");
        ad.setFont(new Font("Raleway",Font.BOLD,22));
        ad.setBounds(290,80,400,30);
        add(ad);
        
       
        
        
         JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
    String valre[]={"Hindu","Muslim","Sikh","Christan","Other"};
         religion = new JComboBox(valre);
         religion.setBounds(300,140,400,30);
         religion.setBackground(Color.WHITE);
        add(religion);
        
        
       
         JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        religion.setBackground(Color.WHITE);
        add(fname);
        
          String cat[]={"General","OBC","SC","ST","Other"};
         category = new JComboBox(cat);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
       
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        
          String inc[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
         income = new JComboBox(inc);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        
        
     
         JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
    
     
        
        JLabel email=new JLabel("Qualifications:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
         
          String edu[]={"Non Graduation","Graduate","Post Graduation","Doctrate","Others"};
         education = new JComboBox(edu);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        
        
        
        
        
        
        JLabel ms=new JLabel("Occupation:");
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        ms.setBounds(100,390,200,30);
        add(ms);
        
                String oc[]={"Salaried","Self Employed","Business","Student","Retired","Others"};
         ocu = new JComboBox(oc);
        ocu.setBounds(300,390,400,30);
        ocu.setBackground(Color.WHITE);
        add(ocu);
        
        
        
       

        
        
        JLabel address=new JLabel("Pan No:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        
         pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
       pan.setBounds(300,440,400,30);
        add(pan);
        
        
        JLabel city=new JLabel("Aadhar No:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        
         aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
            
         syes=new JRadioButton("Yes");
        syes.setBackground(Color.WHITE);
        syes.setBounds(300,540,100,30);
        add(syes);
     
        
         sno=new JRadioButton("No");
         sno.setBackground(Color.WHITE);
        sno.setBounds(450,540,100,30);
        add(sno);
        
           
     
        
        ButtonGroup ngp=new ButtonGroup();
        ngp.add(syes);
        ngp.add(sno);
      
        
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
      
             
         eyes=new JRadioButton("Yes");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300,590,100,30);
        add(eyes);
     
        
         eno=new JRadioButton("No");
         eno.setBackground(Color.WHITE);
        eno.setBounds(450,590,100,30);
        add(eno);
        
           
     
        
        ButtonGroup engp=new ButtonGroup();
        engp.add(eyes);
        engp.add(eno);
        
        
         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    
}
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String) religion.getSelectedItem();
;        String scategory= (String) category.getSelectedItem();
       String sincome= (String) income.getSelectedItem();
         String seducation= (String) education.getSelectedItem();
           String occu= (String) ocu.getSelectedItem();
         
         
       String sc=null;
       if(syes.isSelected())
       {
           sc="Yes";
       }else if(sno.isSelected()){
           sc ="No";
       }
    
       String ea=null;
       if(eyes.isSelected()){
           ea="Yes";
       }else if(eno.isSelected()){
           ea="No";
       }
       
       String span=pan.getText();
       String saadhar=aadhar.getText();
     
       try{
           
               Conn c=new Conn();
               String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+occu+"','"+span+"','"+saadhar+"','"+sc+"','"+ea+"')";
           c.s.executeUpdate(query);
           
           //signup 3
           setVisible(false);
           new SignupThree(formno).setVisible(true);
           
            }catch(Exception e){
           System.out.println(e);
       }
    }
    
    
    
    public static void main(String args[]){
        
           new SignupTwo("");
          

        
    }
 
}
