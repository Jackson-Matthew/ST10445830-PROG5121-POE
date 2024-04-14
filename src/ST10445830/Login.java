package ST10445830;

import javax.swing.JOptionPane;
import javax.swing.JPanel ;
import javax.swing.*;
import java.util.regex.Pattern;

/*
  @author Matthew Jackson 
  Student number: ST10445830
 */

// start of program //
public class Login {
    
   //these variables are private static outside of the methods so that they can be accessed independently 
   public static String username1;
   public static String password1;
   public static String wronguser;
   public static String name;
   public static String surname;
   
    public static void name_surname(){
        
        
         JTextField field1 = new JTextField();
         JTextField field2 = new JTextField();
               
         JPanel panel = new JPanel();
       
         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));     //indicates the format of the panel,(the orientation of the boxess )
       
         panel.add(new JLabel("Enter Name"));
         panel.add(field1);
       
         panel.add(new JLabel("Enter Surname"));
         panel.add(field2);
        
         JOptionPane.showConfirmDialog(null, panel,"Enter details",JOptionPane.OK_CANCEL_OPTION);
         
         name = field1.getText();
         surname = field2.getText();
   
    
    }
   public static boolean checkUserName(){
    
         boolean validusername;
        
     do{
           
         username1 = JOptionPane.showInputDialog(null,"""
          Create a Username that:                                          
          > Contains no more than 5 charcaters 
          > Has 1 underscore """
          ,"Username Creation", JOptionPane.QUESTION_MESSAGE );
          
        /* 
        > The if else stament outputs wheather the given parameters of a username has been entered correctly or not,
         so for example an error will be displayed if the user puts more than 5 digits, so the code checks 
         for input from the user that is equal to or no more than 5 digits.
        
        > The and(&&) operator states that all conditions must be true within the statment.
          Other code can also be added to include other conditions such as other special characters  
         */
        
         if (username1.length() <= 5 
             && username1.contains("_")) {      //username parameters
            JOptionPane.showMessageDialog(null,"Username succesfully captured");
            
            validusername = true;
            
        } 
         
         else {  
            JOptionPane.showMessageDialog(null,"""
            Username is not correclty formatted please ensure that your username contains:                                   
            > No more than 5 characters 
            > Has 1 underscore"""
            ,"Invaild username",JOptionPane.ERROR_MESSAGE );
            
            validusername = false;
            
          }
         
         }while (!validusername);  
     
     return validusername;
     
       } //end of username loop

   public static void checkPasswordComplexity(){
       
         boolean validpassword;
    
     do{
       
         password1 = JOptionPane.showInputDialog(null,"""
           Create a Password that has:                                         
           > Atleast 8 characters 
           > Contains a capital letter 
           > Contains a number 
           > Contains a special character """
           ,"Password Creation", JOptionPane.QUESTION_MESSAGE );
         
         if (password1.length() >= 8 //password parameters
             && Pattern.compile("[!@#$%^&*?_]").matcher(password1).find() 
             && Pattern.compile("[A-Z]").matcher(password1).find()
             && Pattern.compile("[0-9]").matcher(password1).find())
         {      
            JOptionPane.showMessageDialog(null,"Password succesfully captured");
            
            validpassword = false;
            
        } else {
            JOptionPane.showMessageDialog(null,"""
            Password is not correclty formatted, please ensure that your password contains: 
            > Atleast 8 charcaters  
            > A capital letter 
            > A number 
            > A special character """
            ,"Invaild password", JOptionPane.ERROR_MESSAGE );
            
            validpassword = true;
         }
         
         }while(validpassword);    
       } //end of password loop
    
   public static void loginUser(){
        
         boolean correctlogin;  
         String loginUsername;
         String loginPassword;

     do{
            
         JTextField field1 = new JTextField();
         JTextField field2 = new JTextField();
               
         JPanel panel = new JPanel();
       
         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));     //indicates the format of the panel,(the orientation of the boxess )
       
         panel.add(new JLabel("Enter Username"));
         panel.add(field1);
       
         panel.add(new JLabel("Enter Password"));
         panel.add(field2);
        
         JOptionPane.showConfirmDialog(null, panel,"Login",JOptionPane.OK_CANCEL_OPTION);
         
         //The Jpanel along with the JTextField allow for two input boxes withing the JOptionPane, this makes the login page alot simpler
           
         loginUsername = field1.getText();
         loginPassword = field2.getText();
          
         /* For each input within the JOptionPane the .get operator is used to obtain what the user has input into the dialog box, 
            this is then set to a variable, these variables are then tested in the if{}else{} statement if they equal the variables 
            username1 and password1, if they are equal then the code will display login successful otherwise the code will display 
            login failed and promt to re-enter details.
         */
          
         if(loginUsername.equals(username1) && loginPassword.equals(password1)){
            JOptionPane.showMessageDialog(null, "Login Succesful \nWelcome " + name + " " + surname + 
             " it is great to see you again! " 
            ,"Login", JOptionPane.INFORMATION_MESSAGE);
               
               correctlogin = false;
               
         }else{
            JOptionPane.showMessageDialog(null,"Login Failed \n > Incorrect Username or Password \nPlease try again"
            ,"Invalid Credentials", JOptionPane.ERROR_MESSAGE );
               
               correctlogin = true;
         }
               
               
         }while(correctlogin); // end of login loop
    }
}
// end of program //

