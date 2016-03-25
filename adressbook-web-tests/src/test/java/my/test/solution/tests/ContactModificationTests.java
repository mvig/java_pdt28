package my.test.solution.tests;

import my.test.solution.model.ContactData;
import my.test.solution.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


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


        Contacts before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        //ContactData contact = new ContactData().withId(modifyContact.getId()).withFirstname("111FirstNameQQ").withLastname("111LastNameQQ");
        ContactData contact = new ContactData().withId(modifyContact.getId()).withFirstname("Firstname").withLastname("Lastname")
                .withNickname("nickname").withMiddlename("Middlename").withCompany("company")
                .withTitle_contact("title").withHome_phone("+380(091)11111111").withMobile_phone("+380(092)22222222")
                .withWorkPhone("+380(093)33333333").withEmail("email1@mail.ru")
                .withEmail1("email2@mail.ru").withEmail2("email3@mail.ru").withAddress("Ukraine, ul. Lenina 1, kv. 5");

        app.contact().modify(modifyContact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
        before.remove(modifyContact);
        before.add(contact);
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));

    }
}
