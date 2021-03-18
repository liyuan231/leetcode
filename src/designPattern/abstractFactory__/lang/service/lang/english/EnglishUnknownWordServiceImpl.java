package designPattern.abstractFactory__.lang.service.lang.english;

import designPattern.abstractFactory__.lang.service.UnknownWordService;

public class EnglishUnknownWordServiceImpl implements UnknownWordService {
    @Override
    public String getUnknownWordById() {
        return "unknwonWord-eng";
    }
}
