/*
* Задание №4
*/
package my.test.solution.tests;

import my.test.solution.model.ContactData;
import my.test.solution.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import static com.google.common.base.Predicates.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ContactAddNewTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        createOneGroupIfGroupsEmpty();
    }

    @Test
    public void testAddNewContact() {


        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("UserName2").withMiddlename("UserMidldleName2").withLastname("UserLastName2").withGroup("test").withNickname("User2").withTitle_contact("mr.").withCompany("Home1").withAddress("ul. Lenina 1 kv.1").withMobile_phone("+380972233311").withHome_phone("+7 774 777 77").withFax_phone("+380972233311").withWhere_work("KGB").withEmail_contact("usermail@mail.ru");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}
