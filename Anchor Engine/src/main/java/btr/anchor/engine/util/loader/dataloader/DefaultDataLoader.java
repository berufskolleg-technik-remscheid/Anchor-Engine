package btr.anchor.engine.util.loader.dataloader;

import java.io.*;

public class DefaultDataLoader implements IDataLoader {

    @Override
    public int[] loadData(File file) throws FileNotFoundException {
        int[] data = new int[(int) file.length()];
        FileReader reader = new FileReader(file);
        BufferedReader buf = new BufferedReader(reader);
        for (int i = 0; i < data.length; i++) {
            try {
                data[i] = buf.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
