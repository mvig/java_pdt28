package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testsContactEdition() {

        if (!app.getContactHelper().isThereContact()) {
            createOneGroupIfGroupsEmpty();
            app.getContactHelper().createContact();
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("dQQ", "LastdQQ");
        app.getContactHelper().modify(before.size(), contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
