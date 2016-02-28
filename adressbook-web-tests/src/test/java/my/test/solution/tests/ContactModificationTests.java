package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.annotations.Test;



/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testsContactEdition() {

        app.getContactHelper().gotoEditContact();
        app.getContactHelper().fillNewContact(new ContactData("UserName", "UserMidldleName", "UserLastName", "User", "ms.", "Home", "ul. Kvita 55 kv.52", "+7 774 888 77", "+380972288311", "BP inc.", "+380972233332", "usermail@google.ru"));
        app.getContactHelper().submitContactModification();

    }
}
