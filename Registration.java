import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
    
class Registration extends JFrame implements ActionListener {
     
    // textfield to enter 
    JTextField namee=null, gender=null, fathernamee=null, cityy=null ,emaill=null;
    JPasswordField  password=null,cpassword=null;
    // panel
    JFrame p=new JFrame("Registration");
    JComboBox cb;
    // constructor
    Registration()
    {
        super("Registration");
        p.getContentPane().setBackground(Color.magenta);
        // p.setBackground(Color.yellow);
        // create textfield
        String[] optionsToChoose = {"Male", "Female"};
        cb  = new JComboBox(optionsToChoose);
        cb.setBounds(200, 60, 200, 30);
        p.add(cb);

        namee = new JTextField(3);
        fathernamee = new JTextField(3);
        password = new JPasswordField(3);
        cpassword = new JPasswordField(3);
        cityy = new JTextField(3);
        emaill = new JTextField(3);
        
        namee.setBounds(200,10, 200,30);  
        fathernamee.setBounds(200,110, 200,30);  
        password.setBounds(200,160, 200,30);  
        cpassword.setBounds(200,210, 200,30);  
        cityy.setBounds(200,260, 200,30);  
        emaill.setBounds(200,310, 200,30);  

        p.add(namee);
        p.add(fathernamee);
        p.add(password);
        p.add(cpassword);
        p.add(cityy);
        p.add(emaill);
        // create labels
        JLabel nameJLabel= new JLabel("NAME");
        JLabel genderJLabel= new JLabel("GENDER");
        JLabel fathernameJLabel= new JLabel("FATHERNAME");
        JLabel passwordJLabel= new JLabel("PASSWORD");
        JLabel cpasswordJLabel= new JLabel("CONFIRM PASSWORD");
        JLabel cityJLabel= new JLabel("CITY");
        JLabel emailJLabel= new JLabel("Email");
        JLabel emailJLabe= new JLabel("");

        // set location
		nameJLabel.setBounds(10, 10, 150, 30);
		genderJLabel.setBounds(10, 60, 150, 30);
		fathernameJLabel.setBounds(10, 110, 150, 30);
		passwordJLabel.setBounds(10, 160, 150, 30);
		cpasswordJLabel.setBounds(10, 210, 150, 30);
		cityJLabel.setBounds(10, 260, 150, 30);
		emailJLabel.setBounds(10, 310, 150, 30);
		emailJLabe.setBounds(10, 310, 150, 30);

        p.add(nameJLabel);
        p.add(genderJLabel);
        p.add(fathernameJLabel);
        p.add(passwordJLabel);
        p.add(cpasswordJLabel);
        p.add(cityJLabel);
        p.add(emailJLabel);
        p.add(emailJLabe);
     
        // create a panel
        
        // create button
        JButton b = new JButton("REGISTER");
        JButton b1 = new JButton("RESET");
        b.setBounds(100, 400,100,30);
        b1.setBounds(300, 400,100,30);
        // add ActionListener
        p.add(b);
        p.add(b1);
        b.addActionListener(this);
        b1.addActionListener(this);
        
        // setSize(800, 800);
        // add(p);  
        p.setLayout(null);  
        p.setVisible(true);
        p.setSize(600, 500);
    }
     
    // if button is pressed
    public void actionPerformed(ActionEvent evt)
    {
        String s = evt.getActionCommand();
        String password1 = password.getText();
        String password2 = cpassword.getText();
        String name = namee.getText();
        String fathername = fathernamee.getText();
        String city = cityy.getText();
        String email = emaill.getText();
        String gender = (String)cb.getSelectedItem();
        if (s.equals("REGISTER")) 
        {
            JFrame f;
            if(name.equals("")||fathername.equals("")||city.equals("")||email.equals("")||gender.equals("")|| password1.equals("")|| password2.equals(""))
            {
                f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Enter all details");  
            }
            else if(password1.equals(password2))
            {
                f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Data Registered Successfully");  
                try
                {
                    FileOutputStream filee = new FileOutputStream("Out.txt",true);
                    String in = "Name: "+name+"\nGender: "+gender+"\nFather name: "+fathername+"\nPassword: "+password1+"\nCity: "+city+"\nEmail: "+email;
                    char ch[] =in.toCharArray();
                    for(int i=0;i<in.length();i++)
                    {
                        filee.write(ch[i]);
                    }
                    filee.close();
                }
                catch(Exception e){}
            }
            else
            {
                f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Password did not match");  
            }
        }
        else if(s.equals("RESET"))
        {
            namee.setText("");
            fathernamee.setText("");
            password.setText("");
            cpassword.setText("");
            emaill.setText("");
            cityy.setText("");
        }
    }
     
    // Main Method
    public static void main(String args[])
    {
        Registration r = new Registration();
    }
}
