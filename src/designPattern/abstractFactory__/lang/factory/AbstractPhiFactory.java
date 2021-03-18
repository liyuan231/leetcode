package designPattern.abstractFactory__.lang.factory;

import designPattern.abstractFactory__.lang.AbstractFactory;
import designPattern.abstractFactory__.lang.service.AbbreviationService;
import designPattern.abstractFactory__.lang.service.UnknownWordService;
import designPattern.abstractFactory__.lang.service.lang.phi.PhiAbbreviationServiceImpl;
import designPattern.abstractFactory__.lang.service.lang.phi.PhiUnknownWordServiceImpl;

public class AbstractPhiFactory implements AbstractFactory {
    @Override
    public AbbreviationService getAbbreviationService() {
        return new PhiAbbreviationServiceImpl();
    }

    @Override
    public UnknownWordService getUnkownWordService() {
        return new PhiUnknownWordServiceImpl();
    }
}
