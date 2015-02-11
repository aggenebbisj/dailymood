
package boundary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MoodStats {
    private double average;
    private int happy;
    private int neutral;
    private int sad;
      
    public MoodStats() {
        // Required by JAXB
    }

    public MoodStats(double average, int happy, int neutral, int sad) {
        this.average = average;
        this.happy = happy;
        this.neutral = neutral;
        this.sad = sad;
    }
    
    @Override
    public String toString() {
        return "MoodStats{" + "average=" + average + '}';
    }
    
}
