package e4;

public enum Operaciones {

    SUM("+") {
        public float calcular(float a, float b) {
            return a+b;
        }
    },
    SUBTRACT("-") {
        public float calcular(float a, float b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        public float calcular(float a, float b) {
            return a*b;
        }
    },
    DIVIDE("/") {
        public float calcular(float a, float b) throws ArithmeticException {
            return a/b;
        }

    };
    public abstract float calcular(float a, float b);

    final String operador;
    Operaciones(String operador) {
        this.operador = operador;
    }

    //Añadimola pa despois porque nos vai ser util mais adiante
    public String getOperador() {
        return operador;
    }

}