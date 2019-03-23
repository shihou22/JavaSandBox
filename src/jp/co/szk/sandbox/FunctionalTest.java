package jp.co.szk.sandbox;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FunctionalTest {

	public static void main(String[] args) {

		//		new FunctionalTest().LoopTest();
		//		new FunctionalTest().eightStream();
		new FunctionalTest().lambdaFizzBuzz();

	}

	private void lambdaFizzBuzz() {

		long count = IntStream.rangeClosed(0, 100)
				.mapToObj(i -> (i % 15 == 0) ? "FizzBuzz"
						: (i % 3 == 0) ? "Fizz"
								: (i % 5 == 0) ? "Buzz" : String.valueOf(i))
				.peek(res -> System.out.println(res)).filter(x -> "FizzBuzz".equals(x)).count();

		System.out.println(count);
	}

	/**
	 * sample
	 */
	private void lambdaFormula() {
		Arrays.stream("HOGEHOGE".split(" "))
				.filter(new Predicate<String>() {
					@Override
					public boolean test(String s) {
						return s.length() == 5;
					}
				})
				.forEach(new Consumer<String>() {
					@Override
					public void accept(String s) {
						System.out.println(s);
					}
				});
	}

	private void eightStream() {
		String[] wkA = new String[100];

		int res = 0;
		IntStream.range(0, wkA.length).forEach(i -> wkA[i] = Integer.toString(i));

		IntStream.range(0, wkA.length).forEach(i -> System.out.println(wkA[i]));

		boolean result = true;
		result = IntStream.range(0, wkA.length).anyMatch(i -> wkA[i].equals("1000"));
		System.out.println(result);

		boolean[] bWk = new boolean[100];
		Arrays.fill(bWk, true);
		bWk[2] = false;
		result = IntStream.range(0, bWk.length).anyMatch(i -> !bWk[i]);
		System.out.println(result);

	}

	private void LoopTest() {

		int num = 1;
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			cnt += i;
		}
		sysCntout(num++, cnt);

		cnt = 0;
		cnt = IntStream.range(0, 100).sum();
		sysCntout(num++, cnt);

		cnt = 0;
		cnt = IntStream.range(0, 100).reduce(0, (x, y) -> x + y);
		//		cnt = IntStream.range(0, 100).reduce(0, Integer::sum);
		sysCntout(num++, cnt);

		cnt = 0;
		for (int i = 0; i < 100; i++) {
			if (cnt % 2 == 0) {
				cnt += i;
			}
		}
		sysCntout(num++, cnt);

		cnt = 0;
		cnt = IntStream.range(0, 100).filter(i -> i % 2 == 0).sum();
		sysCntout(num++, cnt);

		cnt = 0;
		for (int i = 0; i < 100; i++) {
			cnt += i * 2;
		}
		sysCntout(num++, cnt);

		cnt = 0;
		cnt = IntStream.range(0, 100).map(i -> i * 2).sum();
		sysCntout(num++, cnt);

		cnt = 0;
		cnt = IntStream.range(0, 100).min().orElse(100);
		sysCntout(num++, cnt);

	}

	private void sysCntout(int num, int cnt) {
		System.out.println(num + ":" + cnt);
	}

}
