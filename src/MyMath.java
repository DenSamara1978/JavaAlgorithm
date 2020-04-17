final public class MyMath {
    public static int pow ( int arg, int pow ) {
        if ( pow < 0 ) throw new ArithmeticException("Incorrect pow");
        else if ( pow == 0 ) return 1;
        else return pow ( arg, pow - 1) * arg;
    }
}
