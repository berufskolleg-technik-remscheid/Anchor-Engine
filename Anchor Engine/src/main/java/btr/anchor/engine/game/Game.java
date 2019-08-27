package btr.anchor.engine.game;

import btr.anchor.engine.util.objects.GameObject;

import java.util.ArrayList;

public class Game {

    ArrayList<GameObject> gameObjects;

    public Game() {
        gameObjects = new ArrayList<>();
    }

    public void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }
}
