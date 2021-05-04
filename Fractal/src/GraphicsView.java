import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GraphicsView {

    static JFrame frame ;                                                           // global variable frame
    public static void define(String name ){

        frame = new JFrame( name );                                                 // create a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);                                        // set the size

    }
    public static void display() throws IOException {
        String pic = "set.jpg" ;                                                    // set a name
        File file = new File(pic);                                                  // loacal file access
        BufferedImage image = ImageIO.read(file);                                   // make a pixel array 2d
        JLabel label = new JLabel(new ImageIcon(image));                            // set a jlable
        frame.getContentPane().add(label);                                          // visible on
        frame.setVisible(true);
    }

	
}
