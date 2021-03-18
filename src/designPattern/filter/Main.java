package designPattern.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> ps = new ArrayList<>();
        Person p1 = new Person("liyuan", "male", 15);
        Person p2 = new Person("yuanxi", "male", 20);
        Person p3 = new Person("abc", "female", 17);
        Person p4 = new Person("bcd", "female", 70);
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);

        MixedCriteria filter = new MixedCriteria(CriteriaFactory.female(),CriteriaFactory.age(20));
        List<Person> people = filter.meetCriteria(ps);
        System.out.println(Arrays.toString(people.toArray()));

    }
}
