package designPattern.abstractFactory__;

import designPattern.abstractFactory__.lang.AbstractFactory;
import designPattern.abstractFactory__.lang.service.AbbreviationService;
import designPattern.abstractFactory__.lang.service.UnknownWordService;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = FactoryProducer.getFactory("phi");
        AbbreviationService abbreviationService = factory.getAbbreviationService();
        UnknownWordService unkownWordService = factory.getUnkownWordService();
        System.out.println(abbreviationService.getAbbreviationById());
        System.out.println(unkownWordService.getUnknownWordById());
    }
}
