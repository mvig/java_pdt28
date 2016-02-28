package my.test.solution.appmanager;

import my.test.solution.model.NewContactData;
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

    public void fillNewContact(NewContactData newContactData) {
        type(By.name("firstname"), newContactData.getFirstname());
        type(By.name("middlename"), newContactData.getMiddlename());
        type(By.name("lastname"), newContactData.getLastname());
        type(By.name("nickname"), newContactData.getNickname());
        type(By.name("title"), newContactData.getTitle_contact());
        type(By.name("company"), newContactData.getCompany());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("home"), newContactData.getHome_phone());
        type(By.name("mobile"), newContactData.getMobile_phone());
        type(By.name("work"), newContactData.getWhere_work());
        type(By.name("fax"), newContactData.getFax_phone());
        type(By.name("email"), newContactData.getEmail_contact());

    }
}
