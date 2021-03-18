package designPattern.adapter2;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter adapter;


    public AudioPlayer(MediaAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void play(String audioType, String fileName) {
        switch (audioType) {
            case "mp3": {
                System.out.println("Playing mp3!");
                break;
            }
            case "vlc": {
                adapter.play("vlc", fileName);
                break;
            }
            case "mp4": {
                adapter.play("mp4", fileName);
                break;
            }
            default:
                throw new UnsupportedOperationException(audioType);
        }
    }
}
