package io;

import java.io.IOException;
import java.nio.channels.Selector;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        Selector serverSeelctor = Selector.open();
        Selector clientSelector = Selector.open();
    }
}
