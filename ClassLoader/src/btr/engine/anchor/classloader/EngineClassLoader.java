package btr.engine.anchor.classloader;

public class EngineClassLoader {

    private String clazz;
    private final transient ClassLoader loader;
    protected String path = "./";
    protected String extension = "class";

    public EngineClassLoader() {
        loader = Thread.currentThread().getContextClassLoader();
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Class<?> load() throws ClassNotFoundException {
        Class<?> clazz = load(this.clazz);
        assert clazz != null;
        return clazz;
    }

    protected Class<?> load(String s) throws ClassNotFoundException {
        Class<?> clazz = this.loader.loadClass(s);
        assert clazz != null;
        return clazz;
    }

}
