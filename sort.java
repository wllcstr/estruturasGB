// Grupo 7
// Gabriel Ely
// Jorge Medeiros
// William Azevedo de Castro

public class sort {
	public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
	   boolean exchange;
	   do {
	      exchange = false;
	      for (int i = 0; i < a.length - 1; i++) {
	         if (a[i].compareTo(a[i + 1]) > 0) {
	            exchange(a, i, i + 1);
	            exchange = true;
	         }
	      }
	   } while (exchange);
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
	   for (int i = 1; i < a.length; i++) {
	      for (int j = i; j > 0 && a[j - 1].compareTo(a[j]) > 0; j--) {
	          exchange(a, j - 1, j);
	      }
	   }
	}

	public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
	   for (int min, i = 0; i < a.length; i++) {
	       min = i;
	       for (int j = i + 1; j < a.length; j++) {
	          if (a[j].compareTo(a[min]) < 0) {
	             min = j;
	          }
	       }
	       exchange(a, min, i);
	   }
	}
	
	
	private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
	   T tmp = a[i];
	   a[i] = a[j];
	   a[j] = tmp;
	}

	

}
