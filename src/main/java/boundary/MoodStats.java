
package boundary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MoodStats {
    private double average;

    public MoodStats() {
        // Required by JAXB
    }

    public MoodStats(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "MoodStats{" + "average=" + average + '}';
    }
    
}
