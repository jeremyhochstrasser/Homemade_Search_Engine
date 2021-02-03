import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Date;
import java.util.*;
//work cited "Stack Overflow" helped me alot with this code

public class loginPage extends JFrame {
  JButton blogin;
  JPanel loginpanel;
  JTextField txuser;
  JTextField pass;
  JButton newUSer;
  JLabel username;
  JLabel password;
  JLabel port;
  JTextField txport;


  public loginPage(){
    super("Login Autentification");

    blogin = new JButton("Login");
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    pass = new JPasswordField(15);
    newUSer = new JButton("New User?");
    username = new JLabel("User - ");
    password = new JLabel("Pass - ");
    port = new JLabel("Port - ");
    txport = new JPasswordField(15);

    setSize(300,250);
    setLocation(500,280);
    loginpanel.setLayout (null); 


    txuser.setBounds(70,30,150,20);
    pass.setBounds(70,65,150,20);
    txport.setBounds(70,100,150,20);
    blogin.setBounds(110,135,80,20);
    
    username.setBounds(20,28,80,20);
    password.setBounds(20,63,80,20);
    port.setBounds(20,98,80,20);

    loginpanel.add(blogin);
    loginpanel.add(txuser);
    loginpanel.add(pass);
    loginpanel.add(port);
    loginpanel.add(txport);
    loginpanel.add(username);
    loginpanel.add(password);

    getContentPane().add(loginpanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    blogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
  		MySQLAccess test = new MySQLAccess();
          try {

        	test.readDataBase();

          	test.insertAbstract("This is a tester abstract");
          	test.insertAuthor("Hello, I am an Author");
          	Date dt = Date.valueOf("2020-11-01");
          	test.insertDate(dt);
          	test.insertContents("I'm a super interesting contents section for a paper.");
          	test.insertTitle("I'm a super interesting paper title!");
          	test.insertIndexVal(420.69);
          } catch(Exception e1) {
          	e1.printStackTrace();
          } 

      }
    });

//    newUSer.addActionListener(new ActionListener(){
//      public void actionPerformed(ActionEvent e) {
////        NewUser user = new NewUser();
////        dispose();
//
//      }
//    });
  } 

}