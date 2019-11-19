package btr.engine.anchor.bridge.layer.render;

import btr.engine.anchor.bridge.layer.audio.AudioLayer;

public enum RenderLayer {

    OPENGL("render/opengl/"), VULKAN("render/vulkan/"), EXTERN("render/extern/");

    private String path;

    RenderLayer(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static RenderLayer getFromName(String name) {
        for (RenderLayer renderLayer : values()) {
            if (renderLayer.name().equalsIgnoreCase(name)) {
                return renderLayer;
            }
        }
        return null;
    }

}