package designPattern.filter;

public class CriteriaFactory {
    public static Criteria female() {
        return new CriteriaFemale();
    }

    public static Criteria male() {
        return new CriteriaMale();
    }

    public static Criteria age(int age){
        return new CriteriaAge(age);
    }


}
