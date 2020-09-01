package designPattern.adapter.sdCard;

public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String message = "SDCard is being read!";
        return message;
    }

    @Override
    public int writeSD(String message) {
        System.out.println("SDCard is being written!->"+message);
        return 1;
    }
}
