package io.agileintelligence.fullstackfactorypattern.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/*
  I think this would be best to put the common attributes in an abstract class.  You would probably also just put the getters/setters in the abstract class, as well.  This would remove any duplication.
This is okay, but from a design standpoint, an interface should define
*behavior* and not the accessor/mutators. More like:

public interface Schedulable{

public void schedule(Task t);

public void reschedule(Task t);
//@Data is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
...
 */
@Data
@NoArgsConstructor
@Entity
public class Bug extends BacklogItem {


    private int timeEstimateMinutes;

    public Bug(String issueType, String summary, String description, String status, int timeEstimateMinutes) {
        super(issueType, summary, description, status);
        this.timeEstimateMinutes = timeEstimateMinutes;
    }
}
