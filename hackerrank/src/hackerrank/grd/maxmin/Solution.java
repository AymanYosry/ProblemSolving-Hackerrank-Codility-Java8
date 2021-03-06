/**
 * 
 */
package hackerrank.grd.maxmin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase tst = readTestCase("02");
		printArray(tst.arr);
		System.out.println(maxMin(tst.k, tst.arr));
	}
	
	private static int maxMin(int k, int[] arr) 
	{
		Arrays.parallelSort(arr);
		int n = arr.length;
		printArray(arr);
		int minUnfairness = arr[k-1] - arr[0];
		int i, j;
		int dif = 0;

		for (i = 1, j = k; j < n; i++, j++)
		{
			dif = arr[j] - arr[i];
			if (dif < minUnfairness) 
				minUnfairness = dif;
		}
		return minUnfairness;
    }
	
	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/maxmin/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.k = Integer.valueOf(sampleInput[1]);
		input.arr = Stream.of(Arrays.copyOfRange(sampleInput, 2, sampleInput.length)).mapToInt(Integer::parseInt).toArray();
		return input;
	}

	private static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}
}
