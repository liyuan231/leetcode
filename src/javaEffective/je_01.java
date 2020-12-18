package javaEffective;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class je_01 {
    public static void main(String[] args) {
        Map<javaEffective.PhoneNumber,String> map = new HashMap<>();
        map.put(new PhoneNumber("liyuan","123"),"LIYUAN");
        System.out.println(map.get(new PhoneNumber("liyuan", "123")));
    }
}


class PhoneNumber implements Cloneable{
    @Override
    public PhoneNumber clone() throws CloneNotSupportedException {
        try {
            return (PhoneNumber) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError(e.getMessage());
        }
    }

    private String name;
    private String mobile;

    public PhoneNumber(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(mobile, that.mobile);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobile);
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
