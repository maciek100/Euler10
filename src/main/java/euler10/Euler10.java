package euler10;

import org.junit.Test;

import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
// it works ... but on old MacBook Air it runs for 35 minutes
// One possible improvement would be to store all the prime numbers in a Set
// and divide 'every' next candidate by just the primes!
//CORRECT ANSWER = 142913828922L

public class Euler10 {

	public static long sumOfPrimes(long limit) {
		return		2 + LongStream.iterate(1, e -> e + 2)
			   		   .limit(limit/2)
			           .filter(Euler10::isPrime)
			           .reduce(0, (x,y) -> x + y);
	}
	
	private static boolean isPrime(long number) {
		return number > 1 &&
			   LongStream.range(2, number)
			   			 .noneMatch(i -> number % i == 0);
	}

	@Test
	public void testEuler10 () {
		long limit = 2_000_000L;
		long sumOfPrimes = 142913828922L;
		assertEquals("", sumOfPrimes, sumOfPrimes(limit));
	}

	@Test
	public void testSmall () {
		long limit = 100;
		long sumOfPrimes = 1060L; // primes up to 100
		assertEquals("", sumOfPrimes, sumOfPrimes(limit));

	}

}
