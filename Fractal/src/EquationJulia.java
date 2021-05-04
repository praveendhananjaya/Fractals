import java.awt.Color;

public class EquationJulia extends Thread implements Fact {
	
	public static int iterations;
    int x ;
    float real ;

    public EquationJulia(int x1, float real1) {                                 // EquationJulia construction
        x = x1 ;
        real = real1 ;
    }

    public  void run(){                                                         // calculation thread
        int i = 0 ;
        Color color ;

        for ( int y = 0 ; y < 800 ; y++ ) {                                     // y axis 800 pixel
            float imer = 1 - (float)(2) * y / 800 ;                            // -1 to 1 distribute 800 pixel
            Complex a = new Complex( real ,imer );                              // make complex object Z(0)
            i = 0 ;
            while ( i < iterations){                                            // iteration
                a = Julia(a) ;                                                  // Z(n+1) = Z(n) + C
                if( modsqr(a) > 4 ){                                            // abs Z(n+1)^2 > 4
                    break;
                }
                i++;
            }

            color = new Color(0xFFFFFF*(iterations-i)*255/iterations) ;         // color set
            Julia.image.setRGB(x,y,color.getRGB());                             // put into 2d pixel array
        }
    }


}
