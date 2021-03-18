package designPattern.abstractFactory__.lang.service.lang.malay;

import designPattern.abstractFactory__.lang.service.UnknownWordService;

public class MalayUnknownWordServiceImpl implements UnknownWordService {
    @Override
    public String getUnknownWordById() {
        return "unknownWord";
    }
}
