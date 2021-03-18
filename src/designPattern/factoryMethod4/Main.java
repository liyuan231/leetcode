package designPattern.factoryMethod4;

import designPattern.factoryMethod4.factory.AbstractFactory;
import designPattern.factoryMethod4.factory.Factory;
import designPattern.factoryMethod4.language.Language;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = Factory.retrieveAbstractFactory("malay");
        Language language = factory.newLanguage();
        AbbreviationService abbreviationService = language.retrieveAbbreviationService();


    }
}
