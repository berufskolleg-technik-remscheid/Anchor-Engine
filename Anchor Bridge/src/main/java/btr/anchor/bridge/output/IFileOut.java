package btr.anchor.bridge.output;

import java.io.File;

public interface IFileOut extends IOut {

    void write(File file, String[] content);
}