import org.junit.Test;

import static org.junit.Assert.*;

public class TimeValidatorTest {

   @Test
    public void testValidDate(){
        //we will test a valid date format
        String expectedValidDate = "12/12/2012 12:21";
        TimeValidator validDate = new TimeValidator(expectedValidDate);
        assertEquals(true, validDate.isValidDate(expectedValidDate));
    }


    @Test
    public void testNotValidDate(){
        //we will test a valid date format
        String expectedNotValidDate = "42/12/2012 332:21";
        TimeValidator validDate = new TimeValidator(expectedNotValidDate);

        assertEquals(false, validDate.isValidDate(expectedNotValidDate));
    }

}