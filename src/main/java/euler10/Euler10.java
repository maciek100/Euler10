package euler10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * it works ... but on old MacBook Air it runs for 11 minutes, it is an improvement from 35 with the previous
 * "edition". The "fastest" was would be to read all the primes from the file and add them all together...
 * And that is pretty simple ...
 * CORRECT ANSWER = 142913828922L
*/
public class Euler10 {

	private static Set<Long> primes = new HashSet<>();

	public static long sumOfPrimes(long limit) {
		primes.clear();
		primes.add(2L);
		long sum = 2L;
		for (long i = 3; i < limit; i += 2) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}

	private static boolean isPrime(long number) {
		if (number <= 1) {
			return false;
		}
		if (primes.stream()
				.noneMatch(p -> number % p == 0)) {
			primes.add(number);
			return true;
		} else
			return false;
	}

	@Test
	public void testEuler10() {
		long limit = 2_000_000L;
		long sumOfPrimes = 142913828922L;
		assertEquals("", sumOfPrimes, sumOfPrimes(limit));
	}

	@Test
	public void testSmall() {
		long limit = 100;
		long sumOfPrimes = 1060L; // sum of primes up to 100
		assertEquals("", sumOfPrimes, sumOfPrimes(limit));

	}

	@Test
	public void setTest() {
		primes.clear();
		primes.add(2L);
		for (long i = 3; i < 20L; i++) {
			final long x = i;
			if (primes.stream().filter(div -> x % div == 0).count() == 0) {
				primes.add(i);
			}
		}
		assertTrue("", 8 == primes.size());
	}
}
