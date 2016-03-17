package my.test.solution.appmanager;

import my.test.solution.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.name("submit"));

    }

    public void fillNewContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

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

    public void gotoEditContact() {
        click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));

    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }


    public void selectContactForDelete() {
        click(By.id("logo"));
        click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
/*        if (!isElementPresent(By.id("MassCB")))
            click(By.id("logo"));
        if (!wd.findElement(By.id("MassCB")).isSelected()) {
            click(By.id("MassCB"));
        }*/

    }

    public void deleteContact() {


        click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();

    }

    public boolean isThereContact() {

        return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public void createContact() {
        click(By.linkText("add new"));
        fillNewContact(new ContactData("UserNameN", "UserMidldleName1", "UserLastName1", "test", "User", "mr.", "Home", "ul. Lenina 1 kv.1", "+7 774 777 77", "+380972233311", "KGB", "+380972233311", "usermail@mail.ru"), true);
        submitNewContact();
    }


    public int getContactCount() {
        return wd.findElements(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")).size();
    }
}
