
import java.util.*;
public class operaciones {
    

    public static ArrayList<Integer> AgregarElementos(int Integer ){
        ArrayList<Integer> Arbol = new ArrayList<Integer>();
        if(Arbol.isEmpty()){
            Arbol.add(Integer);
        }
   
        return Arbol; 
    }

    public void EliminarElementos(){

    }

    public void Buscarelementos(){

    }

    public static void main (String[] args) {

        ArrayList<Integer> Arbol =AgregarElementos(5);
        Iterator<Integer> it = Arbol.iterator();
        while(it.hasNext())
         System.out.println(it.next());
      }

}
