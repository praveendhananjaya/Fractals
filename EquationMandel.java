import java.awt.Color;

public class EquationMandel extends Thread implements Fact {

    static int iterations  ;
    int x ;
    float real ;

    public EquationMandel(int x1, float realpart ) {                                                    // constructor
        x = x1 ;
        real = realpart ;
    }
    public  void run(){                                                                                 //  thread funtion
        int i = 0 ;                                                                                     // number of iteration
        Color color ;
        for ( int y = 0 ; y < 800 ; y++ ) {                                                             // y axis 800 pixel
                Complex a = new Complex(0,0);
                float imer = Mandelbrot.imrgend-(Mandelbrot.imrgend-Mandelbrot.imrgstart)*y/800 ;     // c value imerpart
                i = 0 ;
                while ( i < iterations){                                                                // iterations
                    a = Mandelbrot(a,real,imer);                                                        // Z(n+1) = Z(n) + C
                    if(modsqr(a)>4){                                                                    // abs(Z(n+1)) > 4
                        break;
                    }
                    i++;
                }
                color = new Color( 0xFFFFFF*(iterations-i)*255/iterations ) ;                             // color maping
                Mandelbrot.image.setRGB(x,y,color.getRGB());                                            // put in to 2d pixel array
        }
    }
	
}
