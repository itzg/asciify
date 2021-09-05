package me.itzg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Asciify {
    public static void main(String[] args) throws IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream(1024);
        int b;
        while ((b = System.in.read()) >= 0) {
            buffer.write(b);
        }

        final String asUtf8 = new String(buffer.toByteArray(), StandardCharsets.UTF_8);

        for (int i = 0; i < asUtf8.length(); ++i) {
            final char c = asUtf8.charAt(i);
            if (c > 0x7f) {
                System.out.print(String.format("\\u%04x", (int)c));
            }
            else {
                System.out.print(c);
            }
        }
        System.out.flush();
    }
}
