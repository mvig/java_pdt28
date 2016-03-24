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

public class ContactEmailTests extends TestBase {
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
                .map(ContactEmailTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String email) {
        return email.replaceAll("\\s", "").replaceAll("[-()]", "");

    }
}
