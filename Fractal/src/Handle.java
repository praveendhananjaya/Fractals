
public class Handle extends GraphicsView {


    public static void MandelbrotSet(String[] args) {        // MandelbrotSet instruction
    	

        Mandelbrot.setvalue(args);                          //  set value
        Mandelbrot.calculate();                             //  do calculation

    }
    public static void JuliaSet(String[] args){              // Juliaset instruction

                      
        Julia.setvalue(args);                               // set vale
        Julia.calculate();                                  // do calculation

    }
    
}
