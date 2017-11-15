
package quizkampen;


public class Quizkampen {

    
    public static void main(String[] args) {
        
        Kategori k = new Kategori();
        
        System.out.println(k.getValdKat());
        
        
        
        if(!k.getValdKat().equals("")){
            System.out.println("Hej");
            GUIquiz quiz = new GUIquiz();
        }
        
        
        
    }
    
}
