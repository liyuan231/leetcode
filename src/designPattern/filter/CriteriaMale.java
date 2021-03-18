package designPattern.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        ArrayList<Person> ps = new ArrayList<>();
        for (Person person : persons) {
            if ("male".equals(person.getGender())) {
                ps.add(person);
            }
        }
        return ps;
    }
}
