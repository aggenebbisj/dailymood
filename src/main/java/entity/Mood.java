package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Mood {

    @Id
    @GeneratedValue
    private Long id;
    private int value;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String ip;

    @ElementCollection
    private Set<String> tags;

    public Mood() {
        // Required by JAXB
    }
    
    public Mood(int value, Date date, String ip, Set<String> tags) {
        this.value = value;
        this.date = date;
        this.ip = ip;
        this.tags = tags;
    }

    public boolean isSad() {
        return value == 1;
    }
    
    public boolean isNeutral() {
        return value == 2;
    }
    
    public boolean isHappy() {
        return value == 3;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Mood{" + "value=" + value + ", date=" + date + ", ip=" + ip + '}';
    }

}
