package designPattern.abstractFactory__;

import designPattern.abstractFactory__.lang.AbstractFactory;
import designPattern.abstractFactory__.lang.factory.AbstractEnglishFactory;
import designPattern.abstractFactory__.lang.factory.AbstractMalayFactory;
import designPattern.abstractFactory__.lang.factory.AbstractPhiFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String language) {
        switch (language) {
            case "eng": {
                return new AbstractEnglishFactory();
            }
            case "malay": {
                return new AbstractMalayFactory();
            }
            case "phi":{
                return new AbstractPhiFactory();
            }
            default:
                throw new IllegalArgumentException(language);
        }
    }
}
