package designPattern.abstractFactory__.lang.factory;


import designPattern.abstractFactory__.lang.AbstractFactory;
import designPattern.abstractFactory__.lang.service.AbbreviationService;
import designPattern.abstractFactory__.lang.service.UnknownWordService;
import designPattern.abstractFactory__.lang.service.lang.english.EnglishAbbreviationServiceImpl;
import designPattern.abstractFactory__.lang.service.lang.english.EnglishUnknownWordServiceImpl;

public class AbstractEnglishFactory implements AbstractFactory {
    @Override
    public AbbreviationService getAbbreviationService() {
        return new EnglishAbbreviationServiceImpl();
    }

    @Override
    public UnknownWordService getUnkownWordService() {
        return new EnglishUnknownWordServiceImpl();
    }
}
