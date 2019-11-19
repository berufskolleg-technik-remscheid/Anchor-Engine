package btr.engine.anchor.bridge.layer.audio;

public enum AudioLayer {

    OPENAL("/audio/openal");

    private String path;

    AudioLayer(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static AudioLayer getFromName(String name) {
        for (AudioLayer audioLayer : values()) {
            if (audioLayer.name().equalsIgnoreCase(name)) {
                return audioLayer;
            }
        }
        return null;
    }

}