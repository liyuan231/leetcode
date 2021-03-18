package designPattern.abstractFactory__.lang.factory;

import designPattern.abstractFactory__.lang.AbstractFactory;
import designPattern.abstractFactory__.lang.service.AbbreviationService;
import designPattern.abstractFactory__.lang.service.UnknownWordService;
import designPattern.abstractFactory__.lang.service.lang.malay.MalayAbbreviationServiceImpl;
import designPattern.abstractFactory__.lang.service.lang.malay.MalayUnknownWordServiceImpl;


public class AbstractMalayFactory implements AbstractFactory {
    @Override
    public AbbreviationService getAbbreviationService() {
        return new MalayAbbreviationServiceImpl();
    }

    @Override
    public UnknownWordService getUnkownWordService() {
        return new MalayUnknownWordServiceImpl();
    }
}
