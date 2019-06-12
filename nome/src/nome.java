 public class nome{
     @SuppressWarnings("ImplicitArrayToString")
     public static void main(String[] args) {
    int vetor[] = new int [2];
    vetor[0]=5;
    vetor[1]=10;
    dobrovaloresVeto(vetor); 
         System.out.println(vetor);
    //vetor = dobrovaloresVeto(vetor);
 }
   
     //metodo dobro do vetor
     public static void (int v ){
         v[0]*=2;
         v[1]*=2;
         
         
     }
     
 public static int[]dobrovaloresVeto(int v) {
        v[0]*=2;
        v[1]*=2;
         return null;
 }

    private static void dobrovaloresVeto(int[] vetor) {
         vetor[0]*=2;
        vetor[1]*=2;
        System.out.println("valore"+dobrodovetor(vetor));
//       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int[] dobrovaloresVetor(int[] vetor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }