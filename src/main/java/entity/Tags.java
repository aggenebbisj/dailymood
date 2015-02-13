package entity;

import java.util.HashSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tags {

    private Set<String> happyTags = new HashSet<>();
    private Set<String> neutralTags = new HashSet<>();
    private Set<String> sadTags = new HashSet<>();

    public Tags() {
        // Required by JAXB
    }

    public Tags(Set<String> happyTags, Set<String> neutralTags, Set<String> sadTags) {
        this.happyTags.addAll(happyTags);
        this.neutralTags.addAll(neutralTags);
        this.sadTags.addAll(sadTags);
    }

    public void add(Mood mood) {
        if (mood.isSad()) {
            sadTags.addAll(mood.getTags());
        } else if (mood.isNeutral()) {
            neutralTags.addAll(mood.getTags());
        } else if (mood.isHappy()) {
            happyTags.addAll(mood.getTags());
        }
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
