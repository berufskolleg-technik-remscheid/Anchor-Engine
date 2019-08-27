package btr.anchor.editor;

import btr.anchor.editor.display.Editor;

public class Main {


    public static Editor editor;

    public static void main(String[] args) {
        editor = new Editor();
        editor.init();
    }
}