public class Aritmetica {

    public static int calcularMDC(int x, int y) {
        if (x < y) {
            return calcularMDC(y, x);
        }

        int resto = x % y;
        if (resto == 0) {
            return y;
        }
        return calcularMDC(y, resto);// recursão , se o resto(1) de x/y for zero , o mdc é y , senão calcule o resto(2) de y/resto(1) , e assim continua
    }

    public static double calcularRaiz(double x) {
        return calcularRaiz(x, 2);  /* estamos usando overload (sobrecarga)
                                       para passar valores default */
    }

    public static double calcularRaiz(double x, int indice) {
        return Math.pow(x, 1.0/indice);
    }
}
