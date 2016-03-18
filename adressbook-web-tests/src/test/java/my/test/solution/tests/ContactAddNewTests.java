/*
* Задание №4
*/
package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactAddNewTests extends TestBase {


    @Test
    public void testAddNewContact() {
        createOneGroupIfGroupsEmpty();
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().goAddNewContact();
        app.getContactHelper().fillNewContact(new ContactData("UserName1", "UserMidldleName1", "UserLastName1", "test", "User", "mr.", "Home", "ul. Lenina 1 kv.1", "+7 774 777 77", "+380972233311", "KGB", "+380972233311", "usermail@mail.ru"), true);
        app.getContactHelper().submitNewContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);

    }


}
