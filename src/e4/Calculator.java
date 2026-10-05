package e4;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private ArrayList<Operaciones> listaOperaciones;
    private ArrayList<Float> listaValores;


    private static Operaciones traductor (String text) throws IllegalArgumentException{
        int i;
        Operaciones[] x = Operaciones.values();
        for (i=0;i<x.length;i++) {
            Operaciones y = x[i];
            if (y.operador.equals(text)) {
                return y;
            }
        }

        throw new IllegalArgumentException();
    }


    /**
     * Public constructor of the calculator .
     */
    public Calculator () {
        this.listaOperaciones = new ArrayList<>();
        this.listaValores = new ArrayList<>();
    }
    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations () {
        listaValores.clear();
        listaOperaciones.clear();
    }
    /**
     * Add a new operation to the internal state of the calculator .
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands .
     * The rest of computations work with the accumulated value and only an extra
     * new operand . Second input value must be ignored if the operation does not
     * correspond to the first one .
     *
     * @param operation operation to add , as string , "+" , "-", "*" , "/".
     * @param values Operands of the new operation ( one or two operands ).
     * Uses the varargs feature .
     * https :// docs . oracle . com / javase /8/ docs / technotes / guides / language / varargs . html
     * @throws IllegalArgumentException If the operation does not exist .
     */
    public void addOperation ( String operation , float ... values ) throws IllegalArgumentException{
        if(listaOperaciones.isEmpty()){
            if(values.length==2){
                listaValores.add(values[0]);
                listaValores.add(values[1]);
            }else{
                throw new IllegalArgumentException("The operation does not exist");
            }
        }else{
            if(values.length>=1){
                listaValores.add(values[0]);
            }else{
                throw new IllegalArgumentException("The operation does not exist");
            }
        }

        listaOperaciones.add(traductor(operation));
    }
    /**
     * Execute the set of operations of the internal state of the calculator .
     * Once execution is finished , internal state ( operands and operations )
     * is restored ( EVEN if exception occurs ).
     * This calculator works with " Batches " of operations .
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     * ( division by zero )
     */
    public float executeOperations () throws ArithmeticException {
        float result=0;
        int i;
        Operaciones x;
        ArrayList<Float> listaValores2 = new ArrayList<>(listaValores);
        ArrayList<Operaciones> listaOperaciones2 = new ArrayList<>(listaOperaciones);
        for(i=0;i<listaOperaciones.size();i++){
            x = listaOperaciones.get(i);
            if(x.getOperador().equals("/") && listaValores.get(i+1)==0){

                listaValores=listaValores2;
                listaOperaciones=listaOperaciones2;

                throw new ArithmeticException("division by zero");
            }else{
                if(i==0){
                    result=x.calcular(listaValores.get(0),listaValores.get(1));
                }else{
                    result=x.calcular(result, listaValores.get(i+1));
                }
            }

        }
        listaValores=listaValores2;
        listaOperaciones=listaOperaciones2;

        return result;
    }
    /**
     * Current internal state of calculator is printed
     * FORMAT :
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES :
     * "[+]4.5 _6 .8[ -]3.1[/]6.0"
     * "[ -]3.7 _5 .8[*]4.8[/]2.0[+]2.04"
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString () {
        int i;
        Operaciones x;
        String result = "";
        for(i=0;i<listaOperaciones.size();i++){
            x=listaOperaciones.get(i);
            if(i==0){
                result=("["+x.getOperador()+"]"+listaValores.get(0)+"_"+listaValores.get(1));
            }else{
                result=result+("["+x.getOperador()+"]"+listaValores.get(i+1));
            }
        }
        return result;
    }
}