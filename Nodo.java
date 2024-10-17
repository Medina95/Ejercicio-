public class Nodo {
    boolean izquierdo;
    boolean Derecho;
    int valor; 


    public Nodo(int valor, boolean izquierdo, boolean Derecho){
        this.valor= valor;
        this.izquierdo= izquierdo;
        this.Derecho= Derecho; 
        
    }
    
    public int getvalor(){
        return valor;
    }
    public boolean getesizquierdo(){
        return izquierdo;
    }
    public boolean getesderecho(){
        return Derecho;
    }

    public void Setvalor(int valor) {
        this.valor = valor;
    }
   
    
}
