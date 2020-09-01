package designPattern.adapter.tfCard;

public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        String message="TFCard is being read!";
        return message;
    }

    @Override
    public int writeTF(String message) {
        System.out.println("TFCard is being written->"+message);
        return 1;
    }
}
