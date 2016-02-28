/*
* Задание №4
*/
package my.test.solution;

import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {


    @Test
    public void addNewTestContact() {

        goAddNewContact();
        fillNewContact(new NewContactData("UserName1", "UserMidldleName1", "UserLastName1", "User", "mr.", "Home", "ul. Lenina 1 kv.1", "+7 774 777 77", "+380972233311", "KGB", "+380972233311", "usermail@mail.ru"));
        submitNewContact();
    }


}
