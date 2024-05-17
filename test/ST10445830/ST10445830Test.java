package ST10445830;

import org.junit.Test;
import static org.junit.Assert.*;

public class ST10445830Test {

    Login login = new Login();

    @Test
    public void testValidUsername() {
        boolean check;
        
        assertTrue(check = Login.isValidUsername("kyl_1"));
        System.out.println(check);
    }

    @Test
    public void testValidUsername2() {
        boolean check;
        assertFalse(check = Login.isValidUsername("kyle!!!!!!!!"));
        System.out.println(check);

    }

    @Test

    public void testValidPassword() {
        boolean check;
        assertTrue(check = Login.isValidPassword("Ch&&sec@ke99!"));
        System.out.println(check);
    }

    @Test
    public void testValidPassword2() {
        assertFalse(Login.isValidPassword("password"));
        System.out.println("false");
    }

}

