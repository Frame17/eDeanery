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
    private String requestDate;
    @Column(nullable = false)
    private String requestTime;
    @Column
    private String requestTopic;
    @Column(nullable = false)
    private String text;
    @Column
    private String responseText;


    private UserRequest() {
    }

    public UserRequest(String text, String requestTopic) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        this.requestDate = dateFormat.format(now);
        this.requestTime = timeFormat.format(now);
        this.text = text;
        this.requestTopic = requestTopic;
    }


    public String getRequestTopic() {
        return requestTopic;
    }

    public long getId() {
        return id;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getRequestTime() {
        return requestTime;
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

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", date='" + requestDate + '\'' +
                ", time='" + requestTime + '\'' +
                ", text='" + text + '\'' +
                ", responseText='" + responseText + '\'' +
                '}';
    }
}