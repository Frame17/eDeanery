package Application.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class UserRequest {
    public static void main(String[] args) {
        System.out.println(new UserRequest("testRequest"));
    }

    private String date;
    private String text;

    public UserRequest() {
    }

    public UserRequest(String text) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.date = dateFormat.format(now);
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "date='" + date + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}