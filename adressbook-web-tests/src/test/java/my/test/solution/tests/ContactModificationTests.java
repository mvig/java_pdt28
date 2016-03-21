package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.contact().isThereContact()) {
            createOneGroupIfGroupsEmpty();
            app.contact().createSomeOne();
        }
    }

    @Test
    public void testsContactEdition() {


        List<ContactData> before = app.contact().contacts();
        int index = before.size() - 1;
        int id = before.get(index).getId();
        ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("111FirstNameQQ").withLastname("111LastNameQQ");
        app.contact().modify(id,contact);
        List<ContactData> after = app.contact().contacts();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
