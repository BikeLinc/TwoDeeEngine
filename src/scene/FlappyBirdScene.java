package scene;

import components.SingleColorBlock;

public class FlappyBirdScene extends Scene {
    
    public FlappyBirdScene(int _ID) {
        super(_ID, "FlappyBirdScene");
    }
    
    @Override
    public void setup() {
        this.addGameObject(new SingleColorBlock(0,"block"));
    }
    
}
