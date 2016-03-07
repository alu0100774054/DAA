package es.etsii.ull.DAA.Practica2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Mergesort {
	private static int total = 0;
	private int minimum = 0;
	private int maximum = 0;
	private int average = 0;

	public static int getTotal() {
		return total;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getAverage() {
		return average;
	}

	public static void setTotal(int total) {
		Mergesort.total = total;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r, boolean showSteps)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int [n1];
		int R[] = new int [n2];

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i)
			L[i] = arr[l + i];
		for (int j=0; j<n2; ++j)
			R[j] = arr[m + 1+ j];


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		if (showSteps == true) {
			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2)
			{
				if (L[i] <= R[j])
				{
					System.out.println(L[i] + "<=" + R[j]);
					arr[k] = L[i];
					i++;
					total++;
					maximum++;
				}
				else
				{
					System.out.println(L[i] + ">" + R[j]);
					arr[k] = R[j];
					j++;
					total++;
					maximum++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1)
			{
				arr[k] = L[i];
				i++;
				k++;
				//total++;
			}

			/* Copy remaining elements of L[] if any */
			while (j < n2)
			{
				arr[k] = R[j];
				j++;
				k++;
				//total++;
			}
		} else {
			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2)
			{
				if (L[i] <= R[j])
				{
					arr[k] = L[i];
					i++;
					total++;
					maximum++;
				}
				else
				{
					arr[k] = R[j];
					j++;
					total++;
					maximum++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1)
			{
				arr[k] = L[i];
				i++;
				k++;
				//total++;
			}

			/* Copy remaining elements of L[] if any */
			while (j < n2)
			{
				arr[k] = R[j];
				j++;
				k++;
				//total++;
			}
		}

	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r, boolean showSteps)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l+r)/2;

			// Sort first and second halves
			sort(arr, l, m, showSteps);
			sort(arr , m+1, r, showSteps);

			// Merge the sorted halves
			merge(arr, l, m, r, showSteps);
		}
	}
}