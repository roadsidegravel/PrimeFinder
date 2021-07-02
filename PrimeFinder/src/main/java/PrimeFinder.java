import java.util.LinkedList;

public class PrimeFinder {
   private Integer begin = 2;
   private LinkedList<Integer> primes = new LinkedList<Integer>();

   public void calculateNext(){
      if (primes.isEmpty()){
         primes.add(begin);
      }
      //do while not found divide without remainder by all previous primes
      //skip if there's a remainder
   }

   public LinkedList<Integer> getPrimes(){
      LinkedList<Integer> result = (LinkedList<Integer>) primes.clone();
      return result;
   }
}
