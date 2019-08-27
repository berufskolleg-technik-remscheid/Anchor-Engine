package btr.anchor.engine.sound;

import btr.anchor.engine.util.log.Logger;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import java.io.*;

public class Sound implements ISound {

    byte[] data;
    public AudioInputStream audioInputStream;
    AudioFormat format;
    ByteArrayInputStream bais;

    public Sound(byte[] data) {
        init(data);
    }

    public Sound(File file, AudioFileFormat.Type format) {
        if (format == AudioFileFormat.Type.WAVE) {
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                init(bis.readAllBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void init(byte[] data) {
        this.data = data;
        format = new AudioFormat(44100, 16, 2, true, false);
        bais = new ByteArrayInputStream(data);
        audioInputStream = new AudioInputStream(bais, format, data.length);
    }

    public void printData() {
        int index = 0;
        for (byte b : data) {
            Logger.debug.send("Byte " + index + ": " + b);
            index++;
        }
        Logger.debug.send("Size of Byte[] " + data.length);
    }
}