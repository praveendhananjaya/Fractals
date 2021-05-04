import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Mandelbrot {

    public static BufferedImage image;

    static float realstart  = -1.0f  ;                                          // set defualt value of Mandelbrot
    static float imrgstart  = -1.0f  ;
    static float realend    =  1.0f  ;
    static float imrgend    =  1.0f  ;
    static int   iterations =  1000  ;

    public static void setvalue(String[] arg ) {                              // argument

        if( arg.length > 4 ) {                                          	// zero argument
            realstart = Float.valueOf(arg[1]) ;
            realend   = Float.valueOf(arg[2]) ;
            imrgstart = Float.valueOf(arg[3]) ;
            imrgend   = Float.valueOf(arg[4]) ;
            if( arg.length > 5 ) {                                         // 4 argument
                iterations = Integer.parseInt(arg[5]);
            }
        }
    }

    public static void calculate() {                                            // calculate Mandelbrot set

        EquationMandel.iterations = iterations ;
        image = new BufferedImage(800,800,BufferedImage.TYPE_BYTE_INDEXED);

       try{
           for ( int x = 0 ; x < 800 ; x ++ ){                                  // x axis 800 pixel
               EquationMandel equa = new EquationMandel(x,realstart+(realend-realstart)*(x)/800);
               equa.start();                                                    // thread , construct x - axis point , constant real part
               while (EquationMandel.activeCount()>400){}                       // make maximum thread limit 4000
           }
           while (EquationMandel.activeCount()>3){}                             // stop thread limit wait until thread standard value

           File output = new File("set.jpg");                          // write data on output file
           ImageIO.write(image,"jpg",output);

       }catch (Exception e){
           System.out.println("error");                                         // file fail
       }
    }	
	
}
