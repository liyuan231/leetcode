package designPattern.adapter.computer;

import designPattern.adapter.sdCard.SDCard;

public interface Computer {
    String readSDCard(SDCard sdCard);
}
