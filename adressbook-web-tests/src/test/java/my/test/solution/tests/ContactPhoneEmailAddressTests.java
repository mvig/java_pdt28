package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tirex on 24.03.2016.
 */


public class ContactPhoneEmailAddressTests extends TestBase {
    @Test
    public void testContactPhones() {
        app.goTo().goHome();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
/*        System.out.println(contact.getAllPhones());
        System.out.println(mergePhones(contactInfoFromEditForm));*/
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));


    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHome_phone(), contact.getMobile_phone(), contact.getWork_phone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneEmailAddressTests::cleaned)
                .collect(Collectors.joining("\n"));

    }


    @Test
    public void testContactEmails() {
        app.goTo().goHome();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmail(), equalTo(mergeEmails(contactInfoFromEditForm)));


    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail1_contact(), contact.getEmail2_contact(), contact.getEmail3_contact())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));

    }
    @Test
    public void testContactAddress() {
        app.goTo().goHome();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));


    }



    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

    }
}
