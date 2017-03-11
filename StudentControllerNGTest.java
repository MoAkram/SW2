/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defaultPackage;

import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Moe-
 */
public class StudentControllerNGTest {
    
    

    /**
     * Test of authenticate method, of class StudentController.
     */
    @Test
    public void testAuthenticateTrue() {
        System.out.println("authenticate");
        String name = "AhmedMohamed"; //User saved in database
        String password = "12345678";
        boolean expResult = true;
        boolean result = StudentController.authenticate(name, password);
        assertEquals(result, expResult);
    }
    public void testAuthenticateFalse() {
        System.out.println("authenticate");
        String name = "Ahmed"; //User doesn't exist
        String password = "12345678";
        boolean expResult = false;
        boolean result = StudentController.authenticate(name, password);
        assertEquals(result, expResult);
    }
    public void testAuthenticateMissing() {
        System.out.println("authenticate");
        String name = "";
        String password = "";
        boolean expResult = false;
        boolean result = StudentController.authenticate(name, password);
        assertEquals(result, expResult);
    }
	@DataProvider(name = "data")
    public static Object[][] stundent()
    {
        String sdate = "13/02/1996";
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = d.parse(sdate);
        } catch (ParseException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Object[][] { {2,"omarAshraf" ,date , "Male" , "mmm@yahoo.com", "Egypt" , "mypassword12322" } , {-1,"ashraf" ,date , "Male" , "mmmss@yahoo.com", "Egypt" , "mypassword1235" } };
    }

    @Test(dataProvider = "data")
    public void SignUp(int result , String name, Date birthdate, String gender, String mail, String country, String password) {
        Assert.assertEquals(result, StudentController.createAccount(name, birthdate, gender, mail, country, password));
    }
    
}
