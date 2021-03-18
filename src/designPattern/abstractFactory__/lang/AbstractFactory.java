package designPattern.abstractFactory__.lang;


import designPattern.abstractFactory__.lang.service.AbbreviationService;
import designPattern.abstractFactory__.lang.service.UnknownWordService;

public interface AbstractFactory {

    public AbbreviationService getAbbreviationService();

    public UnknownWordService getUnkownWordService();


}
