package btr.anchor.engine.util.loader.dataloader;

import java.io.File;
import java.io.FileNotFoundException;

public interface IDataLoader {

    default int[] loadData(String path) throws FileNotFoundException {
        return loadData(new File(path));
    }

    int[] loadData(File file) throws FileNotFoundException;


}