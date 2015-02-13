package boundary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tags {

    private Set<String> happyTags;
    private Set<String> neutralTags;
    private Set<String> sadTags;

    public Tags() {
    }

    public Tags(Set<String> happyTags, Set<String> neutralTags, Set<String> sadTags) {
        this.happyTags = happyTags;
        this.neutralTags = neutralTags;
        this.sadTags = sadTags;
    }

    public Set<String> getHappyTags() {
        return happyTags;
    }

    public Set<String> getNeutralTags() {
        return neutralTags;
    }

    public Set<String> getSadTags() {
        return sadTags;
    }
}
