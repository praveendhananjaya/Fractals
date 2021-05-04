import java.io.IOException;

public class Fractal extends Handle {

	public static void main(String[] args) {

        String type = 	args[0] ;											//scanner.next();

        define( args[0] );                               			//  window name set
        switch(type) {                                              // select the set
            case "Mandelbrot":
                MandelbrotSet(args);                                // Handel class method to control MandelbrotSet
                break;
            case "Julia":
                JuliaSet(args);                                     // Handel class method to control Juliaset
                break;
            default:
                System.out.println("Incorrect input");              // other input
                return;
        }
        try {
			display();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return;
		

	}

}
