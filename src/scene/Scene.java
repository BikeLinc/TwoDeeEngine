package scene;

import components.GameObject;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    
    private final int ID;
    private String title;
    
    private List<GameObject> gameObjects = new ArrayList<>();
    
    public Scene(int _ID, String _title) {
        ID = _ID;
        title = _title;
    }
    
    public void setup() {
        // Do Necesary Setup
    }
    
    public int getID() {
        return ID;
    } 

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void addGameObject(GameObject _gameObject) {
        gameObjects.add(_gameObject);
    }
    
    public GameObject getGameObject(GameObject _gameObject) {
        for (GameObject object : gameObjects) {
            if (object.getID() == _gameObject.getID()) {
                return object;
            }
        }
        return null;
    }
    
    public void deleteGameObject(GameObject _gameObject) {
        gameObjects.stream().filter((object) -> (object.getID() == _gameObject.getID())).forEachOrdered((object) -> {
            gameObjects.remove(object);
        });
    }
}
