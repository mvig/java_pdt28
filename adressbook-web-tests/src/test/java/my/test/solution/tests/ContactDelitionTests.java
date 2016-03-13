package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.annotations.Test;


/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactDelitionTests extends TestBase {
    @Test
    public void testsContactDelition() {

        if (!app.getContactHelper().isThereContact()) {
            app.getNavigationHelper().gotoGroupPage();
            if (!app.getGroupHelper().isThereGroup())
                app.getGroupHelper().createGroup(new GroupData("test", "test2", "test3"));
            app.getNavigationHelper().goHome();
            app.getContactHelper().createContact();
        }
        app.getContactHelper().selectContactForDelete();
        app.getContactHelper().deleteContact();

    }
}
