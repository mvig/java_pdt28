/*
* Задание №4
*/
package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactAddNewTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        createOneGroupIfGroupsEmpty();
    }

    @Test
    public void testAddNewContact() {


        List<ContactData> before = app.contact().contacts();
        ContactData contact = new ContactData().withFirstname("UserName2").withMiddlename("UserMidldleName2").withLastname("UserLastName2").withGroup("test").withNickname("User2").withTitle_contact("mr.").withCompany("Home1").withAddress("ul. Lenina 1 kv.1").withMobile_phone("+380972233311").withHome_phone("+7 774 777 77").withFax_phone("+380972233311").withWhere_work("KGB").withEmail_contact("usermail@mail.ru");
        app.contact().create(contact);

        List<ContactData> after = app.contact().contacts();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
