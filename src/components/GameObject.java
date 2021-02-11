package components;

import modules.Module;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    
    private final int ID;
    private String name;
//    private final GameObjectType type;
    
    private int layer = 0;
    private Point position = new Point(0,0);
    
    private GameObject parent = null;
    private List<Module> modules = new ArrayList<>();
    private List<GameObject> gameObjects = new ArrayList<>();
    
    /* Constructor */
    
    public GameObject(int _ID, String _name) { 
        ID = _ID;
        name = _name;
//      type = _type;
    }
    
    /* Getters And Setters */

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public int getLayer() {
        return layer;
    }

    public GameObject getParent() {
        return parent;
    }

    public void setParentGameObject(GameObject _parent) {
        parent = _parent;
    }

    public List<GameObject> getChildrenGameObjects() {
        return gameObjects;
    }

    public void setChildrenGameObjects(List<GameObject> _gameObjects) {
        gameObjects = _gameObjects;
    }

    public void setLayer(int _layer) {
        layer = _layer;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point _position) {
        position = _position;
    }
    
    public void setPosition(int _x, int _y) {
        position = new Point(_x, _y);
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> _modules) {
       modules = _modules;
    }

//    public GameObjectType getType() {
//        return type;
//    }
}
