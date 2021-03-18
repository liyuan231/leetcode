package designPattern.factoryMethod4.language;

import designPattern.factoryMethod4.AbbreviationService;
import designPattern.factoryMethod4.TaggingService;
import designPattern.factoryMethod4.UnknownWordService;
import designPattern.factoryMethod4.service.malay.AbbreviationServiceImpl;
import designPattern.factoryMethod4.service.malay.TaggingServiceImpl;
import designPattern.factoryMethod4.service.malay.UnknownWordServiceImpl;

public class LanguageMalay implements Language {
    @Override
    public AbbreviationService retrieveAbbreviationService() {
        return new AbbreviationServiceImpl();
    }

    @Override
    public UnknownWordService retrieveUnknownWordService() {
        return new UnknownWordServiceImpl();
    }

    @Override
    public TaggingService retrieveTaggingService() {
        return new TaggingServiceImpl();
    }
}
