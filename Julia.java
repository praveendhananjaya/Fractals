import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Julia {
	

    static float realcon        = -0.4f ;                                                                               // initial value set
    static float imrgcon        =  0.6f ;
    static int   iterations     =  1000 ;
    static BufferedImage image ;

    public static void setvalue(String[] agr) {                                                                      // set vale depend on arg 0 , 2 , 3 
        if( agr.length > 1 ) {
            realcon = Float.valueOf( agr[1] ) ;
            if( agr.length > 2 ) {
	            imrgcon = Float.valueOf( agr[2] ) ;
	            if( agr.length > 3 ) {
	                iterations = Integer.parseInt(agr[3]); ;
	            }
            }
        }
    }

    public static void calculate() {                                                                                    // calculate Julia 800 * 800

        EquationJulia.iterations = iterations ;
        try{
            image = new BufferedImage(800,800,BufferedImage.TYPE_BYTE_INDEXED);                            // 800*800 matrix 2d
            for ( int x = 0 ; x < 800 ; x ++ ){                                                                         // x axis 800 pixel
                float real = -1 + (float)(2) * x / 800 ;
                EquationJulia equa = new EquationJulia( x , real);
                equa.start();
                while (EquationJulia.activeCount() >400){}                                                              // maximum thread limit 400
            }

            while (EquationMandel.activeCount()>4){}                                                                    // thread wait time stop

            File output = new File("set.jpg");                                                                 // write pixel 800 * 800
            ImageIO.write(image,"jpg",output);

        }catch (Exception e){                                                                                           // if fail
            System.out.println("error");
        }

    }

}
