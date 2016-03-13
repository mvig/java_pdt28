package my.test.solution.tests;

import org.testng.annotations.Test;


/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactDelitionTests extends TestBase {
    @Test
    public void testsContactDelition() {

        if (!app.getContactHelper().isThereContact()) {
            createOneGroupIfGroupsEmpty();
            app.getContactHelper().createContact();
        }
        app.getContactHelper().selectContactForDelete();
        app.getContactHelper().deleteContact();

    }
}
