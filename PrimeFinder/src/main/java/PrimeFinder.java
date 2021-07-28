import java.util.LinkedList;

public class PrimeFinder {
   private Integer begin = 2;
   private LinkedList<Integer> primes = new LinkedList<Integer>();

   public void calculateNext() {
      if (primes.isEmpty()) {
         primes.add(begin);
      } else {
         //do while not found divide without remainder by all previous primes
         //skip if there's a remainder
         Integer nextCandidate = primes.getLast();
         Boolean isPrime;
         do {
            nextCandidate++;
            Boolean candidateAccepted = true;
            for (Integer previousPrime : primes) {
               if (nextCandidate % previousPrime == 0) {
                  candidateAccepted = false;
                  break;
               }
            }
            isPrime = candidateAccepted;
         } while (isPrime == false);
         primes.add(nextCandidate);
      }
   }

   public LinkedList<Integer> getPrimes(){
      LinkedList<Integer> result = (LinkedList<Integer>) primes.clone();
      return result;
   }

   public LinkedList<Integer> findFirstXPrimes(){
      return getPrimes();
   }

   public LinkedList<Integer> findFirstXPrimes(Integer request){
      Integer currentCount = getPrimes().size();
      Integer difference = request-currentCount;
      if (difference >= 0) {
         for (Integer i = 0; i < difference; i++) {
            calculateNext();
         }
      }
      LinkedList<Integer> result = getPrimes();
      if (difference < 0){
      for (Integer i = 0; i < Math.abs(difference) ; i++) {
            result.removeLast();
         }
      }
      return result;
   }
}
