package javaEffective;

public class je_20 {
}

interface Singer {
    default String test() {
        return "liyuanTest";
    }

    String sing();
}

interface SongWriter{
    String compose();
}
interface SingerSongWriter extends Singer,SongWriter{
}
