import java.security.InvalidParameterException;

public class Fracao {

    public static final char separador = '/';

    private int numerador;   // sempre n�o-negativo
    private int denominador;  // sempre positivo
    private boolean positiva;  // indica o sinal da fra��o , por padrao positivo(true)

    float valorNumerico;
    Fracao fracaoIrredutivel;

    // metodo especial: o construtor da classe
    public Fracao() {
        // chama o outro construtor passando os valores default
        this(0, 1, true);
    }

    // outro construtor (overload)
    public Fracao(int numerador, int denominador, boolean sinal) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.positiva = sinal;
        atualizarValorNumerico();
    }

    /* estamos redeclarando um m�todo que j� existe
       numa classe ancestral */
    @Override
    public String toString() {
        String s = (this.positiva ? "" : "-") +
                this.numerador +
                (this.denominador == 1 ? "" :
                        separador + this.denominador);

        if (this.fracaoIrredutivel == this) {
            s += " (" + this.valorNumerico + ")";
        } else {
            //s += " = " + getFracaoIrredutivel().toString();
        }
         return s;
    }

    public int getNumerador() {
        return this.numerador;
    }

    public void setNumerador(int numerador) {
        // valida o valor que se deseja escrever
        if (numerador < 0) {
            throw new IllegalArgumentException(
                    "O numerador deve ser n�o-negativo");
        }
        this.numerador = numerador;
        atualizarValorNumerico();
        this.fracaoIrredutivel = null;  // invalida
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setDenominador(int denominador) {
        // valida o valor que se deseja escrever
        if (denominador <= 0) {
            throw new IllegalArgumentException(
                    "O denominador deve ser positivo");
        }
        this.denominador = denominador;
        atualizarValorNumerico();
        this.fracaoIrredutivel = null;  // invalida
    }

    public boolean isPositiva() {
        return positiva;
    }

    public void setPositiva(boolean positiva) {
        this.positiva = positiva;
        atualizarValorNumerico();
        this.fracaoIrredutivel = null;  // invalida
    }

    public float getValorNumerico() {
        return this.valorNumerico;
    }

    private void atualizarValorNumerico() {
        this.valorNumerico = 1.0f * this.numerador / this.denominador;
        if (!this.positiva) {
            this.valorNumerico *= -1; //se nao for positiva , valorNumerico recebe le mesmo negativo
        }
    }

    private void atualizarFracaoIrredutivel() {
        if (this.numerador == 0) {
            this.fracaoIrredutivel = this;
            return;
        }

        int mdc = Aritmetica.calcularMDC(
                this.numerador, this.denominador);

        if (mdc == 1) {
            this.fracaoIrredutivel = this;
            return;
        }

        int n = this.numerador / mdc;
        int d = this.denominador / mdc;
        this.fracaoIrredutivel = new Fracao(n, d, this.positiva); //lembrando que fracaoIrredutuvel � do tipo fracao , por isso o uso do construtor
    }

    public Fracao getFracaoIrredutivel() {
        if (this.fracaoIrredutivel == null) {
            atualizarFracaoIrredutivel();  // lazy instantiation
        }

        return this.fracaoIrredutivel;
    }
}