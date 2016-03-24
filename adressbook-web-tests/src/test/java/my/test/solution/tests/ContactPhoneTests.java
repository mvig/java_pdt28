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


public class ContactPhoneTests extends TestBase {
    @Test
    public void testContactPhones() {
        app.goTo().goHome();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));


    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHome_phone(), contact.getMobile_phone(), contact.getWork_phone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

    }

}
