package my.test.solution.tests;

import org.testng.Assert;
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
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContactForDelete();
        app.getContactHelper().deleteContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before-1);

    }
}
