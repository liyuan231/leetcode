package designPattern.visitor2.staff;


import designPattern.visitor2.visit.Visitor;

import java.util.Random;

public abstract class Staff {
    private String name;
    private int kpi;

    public abstract void accept(Visitor visitor);

    public Staff(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKpi() {
        return kpi;
    }

    public void setKpi(int kpi) {
        this.kpi = kpi;
    }
}
