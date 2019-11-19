package btr.engine.anchor.bridge.object;

import btr.engine.anchor.bridge.object.mesh.Mesh;

import java.util.UUID;

public abstract class AnchorObject {

    Mesh mesh;
    String name;
    private final String uuid;

    private AnchorObject[] childs;
    private ObjectComponent[] components;

    public AnchorObject(String name, Mesh mesh) {
        this.mesh = mesh;
        this.name = name;
        this.uuid = UUID.randomUUID().toString();
    }

    public AnchorObject(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID().toString();
    }

    public void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUUID() {
        return uuid;
    }

    public Mesh getMesh() {
        return mesh;
    }
}
