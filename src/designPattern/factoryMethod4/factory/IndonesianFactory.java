package designPattern.factoryMethod4.factory;

import designPattern.factoryMethod4.language.Language;
import designPattern.factoryMethod4.language.LanguageIndonesian;

public class IndonesianFactory implements AbstractFactory {
    @Override
    public Language newLanguage() {
        return new LanguageIndonesian();
    }
}
