package javaEffective;

import java.util.Hashtable;

public class je_02 {
    public static void main(String[] args) throws CloneNotSupportedException {
        PhoneNumber phoneNumber = new PhoneNumber("liyuan", "123456");
        PhoneNumber clone = phoneNumber.clone();

        System.out.println(phoneNumber.hashCode());
        System.out.println(phoneNumber.toString());
        phoneNumber.setName("YUANXI");
        System.out.println("@@@@@@@@@@@@@@@@@@@@");
        System.out.println(clone.getClass().hashCode());
        System.out.println(clone.toString());


        System.out.println(phoneNumber.equals(clone));
        System.out.println(phoneNumber == clone);


        System.out.println("@@@@@@@@@@@@@@@@");

        AList aList = new AList();
        System.out.println(aList.elements);
        AList clone1 = (AList) aList.clone();
        System.out.println(clone1.elements);
        System.out.println(aList == clone1);

//        Hashtable
    }
}


class AList implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        AList clone = (AList) super.clone();
        clone.elements = elements.clone();
        return clone;
    }

    Object[] elements;

    public AList() {
        this.elements = new Object[10];
    }
}
