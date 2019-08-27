package btr.anchor.engine.util.debug;

import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.util.exception.AnchorEngineException;

import java.util.Random;

public class DebugHelper {

    static Random random = new Random();

    final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜabcdefghijklmnopqrstuvwxyzäöü";

    public static String generateRandomString(int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return s.toString();
    }

    public static DisplayImage generateRandomNoiseImage(int width, int height) {
        if (height <= 0 || width <= 0) {
            throw new AnchorEngineException();
        }
        DisplayImage image = new DisplayImage(width, height);
        int arraySize = width * height;
        int[] colors = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            colors[i] = random.nextInt(16777215);
        }
        image.setColors(colors);
        return image;
    }

    public static int randomInt(int max) {
        return random.nextInt(max);
    }

    public static float randomFloat() {
        return random.nextFloat();
    }

    public static double randomDouble() {
        return random.nextDouble();
    }

    public static char randomChar() {
        int slength = randomInt(50);
        return generateRandomString(slength).charAt(randomInt(slength - 1));
    }
}