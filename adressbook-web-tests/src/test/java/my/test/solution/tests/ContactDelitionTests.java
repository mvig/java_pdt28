package my.test.solution.tests;

import org.testng.annotations.Test;



/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactDelitionTests extends TestBase {
    @Test
    public void testsContactDelition() {
        app.getContactHelper().selectContactForDelete();
        app.getContactHelper().deleteContact();

    }
}
