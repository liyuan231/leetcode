package designPattern.adapter;

import designPattern.adapter.computer.Computer;
import designPattern.adapter.computer.ComputerImpl;
import designPattern.adapter.sdCard.SDCard;
import designPattern.adapter.sdCard.SDCardImpl;
import designPattern.adapter.tfCard.TFCard;
import designPattern.adapter.tfCard.TFCardImpl;

public class test {
    public static void main(String[] args) {
        Computer computer = new ComputerImpl();
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.readSDCard(sdCard));

        System.out.println("+++++++++++++++++++++++++++++++++++++");
        TFCard tfCard = new TFCardImpl();
        SDCard sdCardAdapter = new SDAdapterTF(tfCard);
        System.out.println(computer.readSDCard(sdCardAdapter));
    }
}
