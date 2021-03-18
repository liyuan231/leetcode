package designPattern.abstractFactory__.lang.service.lang.phi;

import designPattern.abstractFactory__.lang.service.UnknownWordService;

public class PhiUnknownWordServiceImpl implements UnknownWordService {
    @Override
    public String getUnknownWordById() {
        return "unkown->phi";
    }
}
