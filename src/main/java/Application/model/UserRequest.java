package Application.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private boolean isAnswered;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String text;
    @Column
    private String responseText;


    public UserRequest() {
    }

    public UserRequest(String text) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        this.date = dateFormat.format(now);
        this.time = timeFormat.format(now);
        this.text = text;
        this.isAnswered = false;
    }


    public long getId() {
        return id;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", isAnswered=" + isAnswered +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}