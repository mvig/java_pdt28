package my.mantis.model;

/**
 * Created by Tirex on 17.04.2016.
 */
public class MailMessage {
    public String to;
    public String text;

    public MailMessage(String to,String text){
        this.to=to;
        this.text=text;
    }
}
