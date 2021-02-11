package modules;

public class Module {
    private final int ID;
    private final String title;
    
    /* Constructor */
    
    public Module(int _ID, String _title) {
        ID = _ID;
        title = _title;
    }
    
    /* Getters and Setters */
    
    public int getID() {
        return ID;
    }
    
    public String getTitle() {
        return title;
    }
}
