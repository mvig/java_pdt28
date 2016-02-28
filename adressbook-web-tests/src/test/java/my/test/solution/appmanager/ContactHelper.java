package my.test.solution.appmanager;

import my.test.solution.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactHelper extends BaseHelper {


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.name("submit"));

    }

    public void fillNewContact(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle_contact());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome_phone());
        type(By.name("mobile"), contactData.getMobile_phone());
        type(By.name("work"), contactData.getWhere_work());
        type(By.name("fax"), contactData.getFax_phone());
        type(By.name("email"), contactData.getEmail_contact());

    }
}
