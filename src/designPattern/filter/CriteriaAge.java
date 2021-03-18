package designPattern.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaAge implements Criteria {
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public CriteriaAge(int age) {
        this.age = age;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        ArrayList<Person> ps = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() <= age) {
                ps.add(person);
            }
        }
        return ps;
    }
}
