package designPattern.interpret;

public class AndExpression implements Expression {
    private Expression city = null;
    private Expression person = null;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interrupt(String info) {
        String[] s = info.split("的");
        return city.interrupt(s[0]) && person.interrupt(s[1]);
    }
}
