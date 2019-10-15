package btr.anchor.engine.shader;

import java.util.ArrayList;

public class ShaderHandler {


    private ArrayList<IShader> shaders = new ArrayList<IShader>();

    public void registerShader(IShader shader) {
        shaders.add(shader);
    }

    public void unregisterShader(IShader shader) {
        shaders.add(shader);
    }


}