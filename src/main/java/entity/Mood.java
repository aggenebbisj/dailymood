
package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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

    public Mood() {
        // Required by JAXB
    }
    
    public Mood(int value, Date date, String ip) {
        this.value = value;
        this.date = date;
        this.ip = ip;
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
    
    @Override
    public String toString() {
        return "Mood{" + "value=" + value + ", date=" + date + ", ip=" + ip + '}';
    }

}
