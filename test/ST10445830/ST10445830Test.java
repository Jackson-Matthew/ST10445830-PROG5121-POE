/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ST10445830;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;



public class ST10445830Test {

    @Test  //this unit test checks if the CheckUserName method works
    
    public void testCheckUserName() {
        
        Login user = new Login();
        String Expected = "kyl_1";    // This will be a valid username
        user.checkUserName();
        String Actual = Login.username1;
        assertEquals(Expected,Actual);
        System.out.println("Valid username");
        
}
     @Test  
    
    public void testCheckUserName1() {
        
    Login user = new Login();
    String Expected = "kyle!!!!!!!!";
    user.checkUserName();
    String Actual = Login.username1;
    assertEquals(Expected,Actual);
    System.out.println("invalid username");
        
}
    
    @Test //this unit test checks if the checkPasswordComplexity method works
    
    public void testcheckPasswordComplexity() {
        
        String Expected = "Ch&&sec@ke99!";    // This will be a valid password
        Login.checkPasswordComplexity();
        String Actual = Login.password1;
        assertEquals(Expected,Actual);
}
   

    
    @Test // this unit test checks if the loginUser method works
    
    public void testloginUser(){
        
        String Expected = "kyl_1";    
        String Expected2 = "Ch&&sec@ke99!";
        Login.loginUser();
        String Actual = Login.username1;
        String Actual2 = Login.password1;
        assertEquals(Expected,Actual);
        assertEquals(Expected2,Actual2);
         
    }
    
}


