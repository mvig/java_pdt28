/*
* Задание №4
*/
package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {


    @Test
    public void testAddNewContact() {

        app.getNavigationHelper().goAddNewContact();
        app.getContactHelper().fillNewContact(new ContactData("UserName1", "UserMidldleName1", "UserLastName1", "User", "mr.", "Home", "ul. Lenina 1 kv.1", "+7 774 777 77", "+380972233311", "KGB", "+380972233311", "usermail@mail.ru"));
        app.getContactHelper().submitNewContact();
    }


}
