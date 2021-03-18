package interview;

import java.util.*;

public class TestComparator {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("original:" + Arrays.toString(arrayList.toArray()));
        Collections.reverse(arrayList);
        System.out.println("reversed:" + Arrays.toString(arrayList.toArray()));
        Collections.sort(arrayList);
        System.out.println("sort:" + Arrays.toString(arrayList.toArray()));
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("customized sort:" + Arrays.toString(arrayList.toArray()));


        ArrayList<Person> persons = new ArrayList<>();
        TreeSet<Person> treeSet = new TreeSet<>();
        persons.add(new Person("name1", 19));
        persons.add(new Person("name2", 20));
        persons.add(new Person("name3", 98));
        persons.add(new Person("name4", 32));
        persons.add(new Person("name5", 50));
        persons.add(new Person("name6", 89));

//        Collections.sort(persons);

        for (Person person : persons) {
            treeSet.add(person);
//            System.out.println(person);
        }
        for (Person person : treeSet) {
            System.out.println(person);
        }


    }

    private static class Person implements Comparable<Person> {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }
}
