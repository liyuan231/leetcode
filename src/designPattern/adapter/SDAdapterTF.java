package designPattern.adapter;

import designPattern.adapter.sdCard.SDCard;
import designPattern.adapter.tfCard.TFCard;

public class SDAdapterTF implements SDCard {
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("Adapter read TF Card!");
        return tfCard.readTF();
    }

    @Override
    public int writeSD(String message) {
        System.out.println("Adapter write TF Card!");
        return tfCard.writeTF(message);
    }
}
