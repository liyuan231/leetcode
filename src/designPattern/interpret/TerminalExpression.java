package designPattern.interpret;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        set.addAll(Arrays.asList(data));
    }

    @Override
    public boolean interrupt(String info) {
        return set.contains(info);
    }
}
