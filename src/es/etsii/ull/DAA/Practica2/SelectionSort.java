package es.etsii.ull.DAA.Practica2;

public class SelectionSort {
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
		SelectionSort.total = total;
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

	void sort(int arr[], boolean showSteps)
	{
		if (showSteps == true) {
			int n = arr.length;

			// One by one move boundary of unsorted subarray
			for (int i = 0; i < n-1; i++)
			{
				// Find the minimum element in unsorted array
				int min_idx = i;
				for (int j = i+1; j < n; j++)
					if (arr[j] < arr[min_idx]) {
						min_idx = j;
						System.out.println(arr[j] + " < " + arr[min_idx]);
						total++;
						maximum++;
					}

				// Swap the found minimum element with the first
				// element
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
		} else {
			int n = arr.length;

			// One by one move boundary of unsorted subarray
			for (int i = 0; i < n-1; i++)
			{
				// Find the minimum element in unsorted array
				int min_idx = i;
				for (int j = i+1; j < n; j++)
					if (arr[j] < arr[min_idx]) {
						min_idx = j;
						total++;
						maximum++;
					}

				// Swap the found minimum element with the first
				// element
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
		}
	}

	// Prints the array
	void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
