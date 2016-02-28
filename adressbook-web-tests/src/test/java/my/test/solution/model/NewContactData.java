/*
* Данные для заполнения формы нового контакта.
*/
package my.test.solution.model;

public class NewContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title_contact;
    private final String company;
    private final String address;
    private final String home_phone;
    private final String mobile_phone;
    private final String where_work;
    private final String fax_phone;
    private final String email_contact;

    public NewContactData(String firstname, String middlename, String lastname, String nickname, String title_contact, String company, String address, String home_phone, String mobile_phone, String where_work, String fax_phone, String email_contact) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title_contact = title_contact;
        this.company = company;
        this.address = address;
        this.home_phone = home_phone;
        this.mobile_phone = mobile_phone;
        this.where_work = where_work;
        this.fax_phone = fax_phone;
        this.email_contact = email_contact;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle_contact() {
        return title_contact;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public String getWhere_work() {
        return where_work;
    }

    public String getFax_phone() {
        return fax_phone;
    }

    public String getEmail_contact() {
        return email_contact;
    }
}
