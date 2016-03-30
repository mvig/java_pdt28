/*
* Задание №4
*/
package my.test.solution.tests;

import my.test.solution.model.ContactData;
import my.test.solution.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import static com.google.common.base.Predicates.equalTo;

import java.io.File;

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
        //ContactData contact = new ContactData().withFirstname("UserName2").withMiddlename("UserMidldleName2").withLastname("UserLastName2").withGroup("test").withNickname("User2").withTitle_contact("mr.").withCompany("Home1").withAddress("ul. Lenina 1 kv.1").withMobile_phone("+380972233311").withHome_phone("+7 774 777 77").withFax_phone("+380972233311").withWhere_work("KGB").withEmail("usermail@mail.ru");
        File photo = new File("src/test/resources/photo.jpg");
        ContactData contact = new ContactData().withFirstname("UserName2").withMiddlename("UserMidldleName2").withLastname("UserLastName2").withGroup("test").withNickname("User2").withTitle_contact("mr.").withCompany("Home1").withMobile_phone("+380972233311").withHome_phone("+7 774 777 77").withFax_phone("+380972233311").withWorkPhone("+380(077)77333333").withEmail("email71@mail.ru").withEmail1("email72@mail.ru").withEmail2("email73@mail.ru").withAddress("Ukraine, ul. Vorova 177, kv. 57").withPhoto(photo);
        //ContactData contact = new ContactData().withFirstname("FirstnameNew").withLastname("LastnameNew").withMiddlename("MiddlenameNew").withGroup("test").withNickname("nicknameNew").withTitle_contact("mr.").withCompany("SUN").withMobile_phone("+380(077)77222222").withHome_phone("+380(077)77111111").withWhere_work("KGB")
        //        .withWhere_work("+380(077)77333333").withEmail("email71@mail.ru").withEmail1("email72@mail.ru").withEmail2("email73@mail.ru").withAddress("Ukraine, ul. Vorova 177, kv. 57");
        app.contact().create(contact);
        //app.contact().createSomeOne();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }



}
