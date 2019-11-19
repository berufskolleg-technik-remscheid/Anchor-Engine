package btr.engine.anchor.classloader.layer;

import java.io.*;
import java.util.HashMap;

public class LayerDescription {

    private String main;
    private String version;
    private String description;

    // Every value needs to be in the same row as the key is

    public LayerDescription(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        HashMap<String, String> lines = new HashMap<String, String>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.contains(":"))
                continue;
            String key = line.split(":")[0];
            String value = line.replaceFirst(key + ":", "");
            lines.put(key, value);
        }
        this.main = lines.get("main");
        this.version = lines.get("version");
        this.description = lines.get("description");
    }


    public String getMain() {
        return main;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }
}