package designPattern.adapter2;

public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer(new MediaAdapter("mp4"));
        audioPlayer.play("vlc", "fileName");
    }
}
