package my.test.solution.tests;

import my.test.solution.model.ContactData;
import my.test.solution.model.GroupData;
import org.testng.annotations.Test;


/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testsContactEdition() {

        if (!app.getContactHelper().isThereContact()) {
            app.getNavigationHelper().gotoGroupPage();
            if (!app.getGroupHelper().isThereGroup())
                app.getGroupHelper().createGroup(new GroupData("test", "test2", "test3"));
            app.getNavigationHelper().goHome();
            app.getContactHelper().createContact();
        }
        app.getContactHelper().gotoEditContact();
        app.getContactHelper().fillNewContact(new ContactData("UserName", "UserMidldleName", "UserLastName", null, "User", "ms.", "Home", "ul. Kvita 55 kv.52", "+7 774 888 77", "+380972288311", "BP inc.", "+380972233332", "usermail@google.ru"), false);
        app.getContactHelper().submitContactModification();

    }
}
