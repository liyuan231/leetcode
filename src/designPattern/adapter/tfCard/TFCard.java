package designPattern.adapter.tfCard;

public interface TFCard {
    String readTF();
    int writeTF(String message);
}
