/*
* Задание №4
*/
package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactAddNewTests extends TestBase {


    @Test
    public void testAddNewContact() {
        createOneGroupIfGroupsEmpty();

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goAddNewContact();
        ContactData contact = new ContactData("UserName1", "UserMidldleName1", "UserLastName1", "test", "User", "mr.", "Home", "ul. Lenina 1 kv.1", "+7 774 777 77", "+380972233311", "KGB", "+380972233311", "usermail@mail.ru");
        app.getContactHelper().fillNewContact(contact, true);
        app.getContactHelper().submitNewContact();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
