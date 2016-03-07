package es.etsii.ull.DAA.Practica2;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {

	public static void main(String args[])
	{
		final int NTIMES = 100;
		final int NITEMS = 20;
		
		int arr[] = null;
		Mergesort ob = null;
		Map<Integer, String> mapMax = new TreeMap<Integer, String>();
		Map<Integer, String> mapMin = new TreeMap<Integer, String>();
		Scanner scan = new Scanner(System.in);
		// Ask for show steps
		System.out.println("\n¿Desea mostrar la traza?(y/n) :");
		String option = scan.next();
		if (option.contains("y")) {
			for (int i = 0; i < NTIMES; i++) {
				arr = getRandomArray(NITEMS);
				System.out.println("\nGiven Array " + i);
				printArray(arr);
				ob = new Mergesort();
				ob.sort(arr, 0, arr.length-1, true);
				System.out.println("\nSorted array " + i);
				printArray(arr);
				mapMax.put(ob.getMaximum(), "Array " + i);
				mapMin.put(ob.getMinimum(), "Array " + i);
			}
		}
		if (option.contains("n")) {
			for (int i = 0; i < NTIMES; i++) {
				arr = getRandomArray(NITEMS);
				System.out.println("\nGiven Array " + i);
				printArray(arr);
				ob = new Mergesort();
				ob.sort(arr, 0, arr.length-1, false);
				System.out.println("\nSorted array " + i);
				printArray(arr);
				mapMax.put(ob.getMaximum(), "Array " + i);
				mapMin.put(ob.getMinimum(), "Array " + i);
			}
		}

		// Print all stats
		System.out.println("\nnumero de comparaciones: " + ob.getTotal());
		System.out.println("\nnumero de comparaciones promedio: " + ob.getTotal() / NTIMES);
		System.out.println("\nnumero de comparaciones por array: ");
		Iterator it = mapMax.keySet().iterator();
		while(it.hasNext()){
			Integer key = (Integer) it.next();
			System.out.println(key + " -> comparaciones: " + mapMax.get(key));
		}

	}
	private static int[] getRandomArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] =  (int) (Math.random() * 100 + 1);
		}
		return arr;
	}
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
