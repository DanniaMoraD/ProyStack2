import java.util.Stack;
public class Pila1 {
    private Stack<Character> pila;

    public Pila1() {
        pila=new Stack<Character>();

    }
    public void insertar(Character dato){
        pila.push(dato);
    }
    public Character eliminar() throws Exception{
        if(pila.isEmpty()){
            throw new Exception("***LA PILA ESTA VACIA***");
        }
        return pila.pop();
    }
    public Character elementotope() throws Exception{
        if(pila.isEmpty()){
            throw new Exception("***LA PILA ESTA VACIA***");
        }
        return pila.peek();

    }
    public boolean esVacia(){
        return pila.isEmpty();
    }
    @Override
    public String toString(){
        String resultado= "===Pila===\n";
        for (int i=pila.size()-1; i>=0; i--){
            resultado+=pila.get(i)+"\n";
        }
        return resultado;
    }
}
