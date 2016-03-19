package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


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
        //int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        List<ContactData> after = app.getContactHelper().getContactList();
        //int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after,before.size()-1);

        before.remove(before.size() - 1);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

    }
}
