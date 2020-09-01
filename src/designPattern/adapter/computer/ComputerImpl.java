package designPattern.adapter.computer;

import designPattern.adapter.sdCard.SDCard;

public class ComputerImpl implements Computer {
    @Override
    public String readSDCard(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("SDCard should not be null!");
        }
        return sdCard.readSD();
    }
}
