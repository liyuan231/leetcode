package designPattern.adapter2;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc. - " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
