package btr.engine.anchor.classloader.layer;

import btr.engine.anchor.bridge.layer.LayerType;
import btr.engine.anchor.bridge.layer.audio.AudioLayer;
import btr.engine.anchor.bridge.layer.render.RenderLayer;
import btr.engine.anchor.classloader.EngineClassLoader;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;

public class LayerLoader extends EngineClassLoader {

    LayerDescription description;

    private String layerName;
    private String layerPath;
    private URLClassLoader loader;

    public LayerLoader(LayerType layerType, Object layer) throws IOException, ClassNotFoundException {
        switch (layerType) {
            case AUDIO:
                if (!(layer instanceof AudioLayer)) {
                    break;
                }
                AudioLayer audioLayer = (AudioLayer) layer;
                layerName = audioLayer.name();
                layerPath = audioLayer.getPath();
                break;
            case RENDER:
                if (!(layer instanceof RenderLayer)) {
                    break;
                }
                RenderLayer renderLayer = (RenderLayer) layer;
                layerName = renderLayer.name();
                layerPath = renderLayer.getPath();
                break;
            default:
                break;
        }
        File dir = new File("./bin/" + layerPath + "/");
        File desc = new File(dir + "/layer.anchor");
        description = new LayerDescription(desc);
        loader = URLClassLoader.newInstance(new URL[]{new File(dir + "/" + layerName + ".jar").toURI().toURL()});
        load();
    }

    @Override
    public Class<?> load() throws ClassNotFoundException {
        Class<?> main = load(description.getMain());

        return main;
    }

    @Override
    protected Class<?> load(String s) throws ClassNotFoundException {
        return Class.forName(s, true, loader);
    }

}