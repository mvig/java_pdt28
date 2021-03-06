package my.test.solution.tests;

import my.test.solution.model.ContactData;
import my.test.solution.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().isEmpty()) {
            if (app.db().groups().isEmpty()) {
                createOneGroupIfGroupsEmpty();
            }
            app.contact().createSomeOne();
        }
    }

    @Test
    public void testsContactDeletion() {

        Contacts before = app.db().contacts();
        ContactData deleteContact = before.iterator().next();
        app.contact().delete(deleteContact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deleteContact)));

    }
}
