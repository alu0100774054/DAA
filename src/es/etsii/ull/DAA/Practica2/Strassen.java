/**
 * Programa que calcula la multipliacion típica de matrices con el algoritmo de Strassen.
 * @author erikbv99421
 */
package es.etsii.ull.DAA.Practica2;
import java.util.*;

public class Strassen {
	final static int ROWS = 3;
	final static int COLS = 3;
	Random r, r1;

	private static int[][] a = new int[ROWS][COLS];
	private static int[][] b = new int[ROWS][COLS];
	private static int[][] c = new int[ROWS][COLS];
	
	/**
	 * Multplica típicamente matrices de n x n
	 * @param a Matriz A
	 * @param b	Matriz B
	 */
	public static void multiply(int[][] a, int[][] b)
	{
		int i,j;

		for(i=0;i<a.length;i++)
		{
			for(j =0; j<a.length;j++)
			{   c[i][j]=0;
			for(int k = 0;k<a.length;k++)
			{
				c[i][j] += a[i][k] * b[k][j];
			}
			}
		}
		System.out.println("Matrix multiplication by regular method : ");
		System.out.println();
		for(i=0;i<a.length;i++)
		{
			for(j =0; j<a.length;j++)
			{
				System.out.print(c[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/**
	 * Aplica el algoritmo de Strassen para multiplicar matrices de n x n.
	 * @param a Matriz A
	 * @param b Matriz B
	 * @return Retorna la matriz C con la solución.
	 */
	public static int [][] strassen(int [][] a, int [][] b)
	{
		// Set dimension of the matrix C
		int n = a.length;
		int [][] result = new int[n][n];

		if((n%2 != 0 ) && (n !=1))
		{
			int[][] a1, b1, c1;
			int n1 = n+1;
			a1 = new int[n1][n1];
			b1 = new int[n1][n1];
			c1 = new int[n1][n1];

			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
				{
					a1[i][j] =a[i][j];
					b1[i][j] =b[i][j];
				}
			c1 = strassen(a1, b1);
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					result[i][j] =c1[i][j];
			return result;
		}

		if(n == 1)
		{
			result[0][0] = a[0][0] * b[0][0];
		}
		else
		{
			int [][] A11 = new int[n/2][n/2];
			int [][] A12 = new int[n/2][n/2];
			int [][] A21 = new int[n/2][n/2];
			int [][] A22 = new int[n/2][n/2];

			int [][] B11 = new int[n/2][n/2];
			int [][] B12 = new int[n/2][n/2];
			int [][] B21 = new int[n/2][n/2];
			int [][] B22 = new int[n/2][n/2];

			divide(a, A11, 0 , 0);			// First quarter
			divide(a, A12, 0 , n/2);		// Second quarter
			divide(a, A21, n/2, 0);			// Third quarter
			divide(a, A22, n/2, n/2);		// Four quarter

			divide(b, B11, 0 , 0);			// First quarter
			divide(b, B12, 0 , n/2);		// Second quarter
			divide(b, B21, n/2, 0);			// Third quarter
			divide(b, B22, n/2, n/2);		// Four quarter

			int [][] P1 = strassen(add(A11, A22), add(B11, B22));	// (a + d) (e + h)
			int [][] P2 = strassen(add(A21, A22), B11);				// (c + d) e
			int [][] P3 = strassen(A11, sub(B12, B22));				// a (f -h)
			int [][] P4 = strassen(A22, sub(B21, B11));				// d (g - e)
			int [][] P5 = strassen(add(A11, A12), B22);				// (a + b) h
			int [][] P6 = strassen(sub(A21, A11), add(B11, B12));	// (c - a)(e + f)
			int [][] P7 = strassen(sub(A12, A22), add(B21, B22));	// (b - d)(g + h)

			int [][] C11 = add(sub(add(P1, P4), P5), P7);			// P1 + P4 - P5 + P7
			int [][] C12 = add(P3, P5);								// P3 + P5
			int [][] C21 = add(P2, P4);								// P2 + P4
			int [][] C22 = add(sub(add(P1, P3), P2), P6);			// P1 - P2 + P3 + P6

			copy(C11, result, 0 , 0);
			copy(C12, result, 0 , n/2);
			copy(C21, result, n/2, 0);
			copy(C22, result, n/2, n/2);
		}
		return result;
	}
	/**
	 * Suma matrices de n x n.
	 * @param A Matriz A
	 * @param B Matriz B
	 * @return Retorna la matriz solución.
	 */
	public static int [][] add(int [][] A, int [][] B)
	{
		int n = A.length;

		int [][] result = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				result[i][j] = A[i][j] + B[i][j];

		return result;
	}
	/**
	 * Resta matrices de n x n.
	 * @param A Matriz A
	 * @param B Matriz B
	 * @return Retorna la matriz solución.
	 */
	public static int [][] sub(int [][] A, int [][] B)
	{
		int n = A.length;

		int [][] result = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				result[i][j] = A[i][j] - B[i][j];

		return result;
	}
	/**
	 * Divide matrices de n x n.
	 * @param A Matriz A
	 * @param B Matriz B
	 * @return Retorna la matriz solución.
	 */
	public static void divide(int[][] p1, int[][] c1, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
			{
				c1[i1][j1] = p1[i2][j2];
			}
	}
	/**
	 * Copia matrices de n x n.
	 * @param A Matriz A
	 * @param B Matriz B
	 * @return Retorna la matriz solución.
	 */
	public static void copy(int[][] c1, int[][] p1, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
			{
				p1[i2][j2] = c1[i1][j1];
			}
	}

	/**
	 * Imprime matrices.
	 * @param array Matriz que queremos imprimir.
	 */
	public static void print(int [][] array)
	{
		int n = array.length;

		System.out.println();
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		//final int ROWS = 10;
		//final int COLS = 10;
		Random r = new Random(100);
		Random r1 = new Random(100);
		int[][] arr = new int[ROWS][COLS];
		int i,j;
		for(i=0;i<ROWS;i++)
		{
			for(j =0; j<COLS;j++)
			{
				a[i][j] = r.nextInt(100);
				b[i][j] = r1.nextInt(100);
			}
		}
		arr = strassen(a,b);
		print(arr);
		multiply(a,b);

	}

}
