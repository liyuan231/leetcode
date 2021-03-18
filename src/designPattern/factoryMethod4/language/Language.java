package designPattern.factoryMethod4.language;

import designPattern.factoryMethod4.AbbreviationService;
import designPattern.factoryMethod4.TaggingService;
import designPattern.factoryMethod4.UnknownWordService;

public interface Language {

    public AbbreviationService retrieveAbbreviationService();

    public UnknownWordService retrieveUnknownWordService();

    public TaggingService retrieveTaggingService();
}
