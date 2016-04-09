package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tirex on 25.03.2016.
 */
public class ContactInfoTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //if (!app.contact().isThereContact()) {
        if (app.db().contacts().isEmpty()) {
            if (app.db().groups().isEmpty()) {
                createOneGroupIfGroupsEmpty();
            }
            app.contact().createSomeOne();
        }
    }

    @Test
    public void testContactInfo() {
        app.goTo().goHome();
        ContactData contact = app.db().contacts().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        String contactInfoFromViewForm = app.contact().infoFromViewForm(contact);
        assertThat(mergeFromEditForm(contactInfoFromEditForm), equalTo(contactInfoFromViewForm));

    }

    private String mergeFromEditForm(ContactData contact) {

        String homePhone = contact.getHome_phone();
        String mobilePhone = contact.getMobile_phone();
        String workPhone = contact.getWork_phone();
        String faxPhone = contact.getFax_phone();

        if (homePhone != "") {
            homePhone = "H: " + homePhone;
        }
        if (mobilePhone != "") {
            mobilePhone = "M: " + mobilePhone;
        }
        if (workPhone != "") {
            workPhone = "W: " + workPhone;
        }
        if (faxPhone != "") {
            faxPhone = "F: " + faxPhone;
        }

/*        return asList(contact.getFio(), contact.getNickname(),contact.getTitle_contact()
                ,contact.getCompany(), contact.getAddress(), "", homePhone, mobilePhone
                , workPhone, faxPhone, "", contact.getEmail1_contact(), contact.getEmail2_contact()
                , contact.getEmail3_contact(), "\n\n").stream().collect(Collectors.joining("\n"));*/
        return asList(contact.getFio(), contact.getNickname(), contact.getTitle_contact()
                , contact.getCompany(), contact.getAddress(), "", homePhone, mobilePhone
                , workPhone, faxPhone, "", contact.getEmail1_contact(), contact.getEmail2_contact()
                , contact.getEmail3_contact()).stream().collect(Collectors.joining("\n"));

    }


}
