package designPattern.factoryMethod4.factory;

import designPattern.factoryMethod4.language.Language;
import designPattern.factoryMethod4.language.LanguageMalay;

public class MalayFactory implements AbstractFactory{
    @Override
    public Language newLanguage() {
        return new LanguageMalay();
    }
}
