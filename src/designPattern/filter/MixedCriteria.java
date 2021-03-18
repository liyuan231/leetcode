package designPattern.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MixedCriteria implements Criteria {
    private List<Criteria> conditions;


    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        for (Criteria criterion : conditions) {
            persons = criterion.meetCriteria(persons);
        }
        return persons;
    }

    public MixedCriteria(Criteria... criteria) {
        this.conditions = new ArrayList<>();
        conditions.addAll(Arrays.asList(criteria));
    }
}
