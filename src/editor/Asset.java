package editor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Asset {
    int ID;
    File file;
    String pathname;
    BufferedImage image = null;
    
    public Asset(int ID, File file) {
        this.ID = ID;
        this.file = file;
        this.pathname = file.getAbsolutePath();
        if (pathname.contains(".png") || pathname.contains(".jpg") || pathname.contains(".gif")) {
            try {
                image = ImageIO.read(file);
                System.out.println("Asset Sucessfully Created: " + pathname);
            } catch (IOException ex) {
                Logger.getLogger(Asset.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
                System.out.println("Asset Not Created: " + pathname);
                System.out.println("Check File For Corruption Or Wrong File Type");
        }
    }

    public File getFile() {
        return file;
    }
    
    public String getFileName() {
        return file.getName();
    }

    public String getPathname() {
        return pathname;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    
}
