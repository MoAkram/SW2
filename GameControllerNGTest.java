/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defaultPackage;

import java.util.Vector;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Bassyouni
 */
public class GameControllerNGTest {
    
    
    
    public GameControllerNGTest() {
    }
    //String name, int level, String category, String teacherName, boolean confirmed, Vector<Question> questions
    
    @DataProvider(name = "data")
    public static Object[][] games()
    {
        return new Object[][] { {true,"BodyParts" } , {false,"koko"}  };
    }

    @Test(dataProvider = "data")
    public void GameFound(boolean result,String name) throws Exception {
        Assert.assertEquals(result, GameController.confirmGame(name));
    }
	@Test
    public void testCreateGameTrue() throws Exception {
        System.out.println("createGame");
        Question question = new Question();
        Vector<String> choices = new Vector();
        choices.add("a");choices.add("b");choices.add("c");
        question.setInfo(choices, QuestionType.MCQ, 1, "a or b or c?");
        String name = "a or b or c";
        int level = 1;
        String category = "Technology";
        String teacherName = "AhmedHussein";
        boolean confirmed = true;
        Vector<Question> questions = new Vector();
        questions.add(question);
        boolean expResult = true;
        boolean result = GameController.createGame(name, level, category, teacherName, confirmed, questions);
        assertEquals(result, expResult);
        
    }
    
    @Test
    public void testCreateGameFalse() throws Exception {
        System.out.println("createGame");
        Question question = new Question();
        Vector<String> choices = new Vector();
        choices.add("a");choices.add("b");
        question.setInfo(choices, QuestionType.MCQ, 1, "a or b?");
        String name = "DataTypes";
        int level = 1;
        String category = "abc";
        String teacherName = "AhmedHussein";
        boolean confirmed = false;
        Vector<Question> questions = new Vector();
        questions.add(question);
        boolean expResult = false;
        boolean result = GameController.createGame(name, level, category, teacherName, confirmed, questions);
        assertEquals(result, expResult);
        
    }
    
}
