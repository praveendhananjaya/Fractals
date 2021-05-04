interface Fact {

    default Complex squr( Complex a ){ return new Complex( a.real*a.real - a.imer*a.imer , 2*a.real*a.imer ); }         // complex numbers squared

    default float modsqr(Complex a){ return  a.real*a.real + a.imer*a.imer  ; }                                         // complex numbers modulus squared

    default Complex Mandelbrot(Complex a, float real, float imer){                                                      // Z(n+1) = Z(n) + C  , c change
        a = squr(a) ;
        a = new Complex(a.real+real,a.imer+imer) ;
        return a ;
    }

    default Complex Julia(Complex a) {                                                                                  // Z(n+1) = Z(n) + C ,  c constant , Z(0) change
        a = squr(a) ;
        a = new Complex( a.real + Julia.realcon , a.imer + Julia.imrgcon );
        return a ;
    }
	
}
