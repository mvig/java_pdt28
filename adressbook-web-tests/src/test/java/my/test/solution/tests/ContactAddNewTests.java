/*
* Задание №4
*/
package my.test.solution.tests;

import my.test.solution.model.ContactData;
import my.test.solution.model.GroupData;
import org.testng.annotations.Test;

public class ContactAddNewTests extends TestBase {


    @Test
    public void testAddNewContact() {
        createOneGroupIfGroupsEmpty();
        app.getNavigationHelper().goAddNewContact();
        app.getContactHelper().fillNewContact(new ContactData("UserName1", "UserMidldleName1", "UserLastName1", "test", "User", "mr.", "Home", "ul. Lenina 1 kv.1", "+7 774 777 77", "+380972233311", "KGB", "+380972233311", "usermail@mail.ru"), true);
        app.getContactHelper().submitNewContact();

    }

    public void createOneGroupIfGroupsEmpty() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) app.getGroupHelper().createGroup(new GroupData("test", "test2", "test3"));
        app.getNavigationHelper().goHome();
    }


}
