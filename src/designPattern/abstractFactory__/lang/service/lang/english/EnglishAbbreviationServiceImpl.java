package designPattern.abstractFactory__.lang.service.lang.english;

import designPattern.abstractFactory__.lang.service.AbbreviationService;

public class EnglishAbbreviationServiceImpl implements AbbreviationService {
    @Override
    public String getAbbreviationById() {
        return "abbre-english";
    }
}
