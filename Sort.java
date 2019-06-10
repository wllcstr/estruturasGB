// Grupo 7
// Gabriel Ely
// Jorge Medeiros
// William Azevedo de Castro

public class Sort {
	//heap sort
	public static <T extends Comparable<? super T>> void heapSort(T[] a) {
	   buildMaxHeap(a);
	   for (int i = a.length - 1; i > 0; i--) {
	      exchange(a, 0, i);
	      maxHeapify(a, 0, i); 
	   }
	}

	private static <T extends Comparable<? super T>> void buildMaxHeap(T[] a) {
	   for (int i = a.length / 2 - 1; i >= 0; i--) {
	      maxHeapify(a, i, a.length);
	   }
	}
	
	private static <T extends Comparable<? super T>> void maxHeapify(T[] a, int i, int n) {
	  int max = 2 * i + 1;
	  if (max + 1 < n && a[max].compareTo(a[max + 1]) < 0) max++;
	  if (max < n && a[max].compareTo(a[i]) > 0) {
	     exchange(a, i, max);
	     maxHeapify(a, max, n);
	  }
	}
	
	// shell sort
	public static <T extends Comparable<? super T>> void shellSort(T[] a) {
	   int h = 1;
	   while (3 * h + 1 < a.length) h = 3 * h + 1; //Baseado no h do Knuth
	   while (h > 0) {
	      for (int i = h; i < a.length; i++) {
	         for (int j = i; j >= h  && a[j - h].compareTo(a[j]) > 0; j -= h) {
	          exchange(a, j - h, j);
	         }
	      }
	      h /= 3;
	   }
	}


	// bubble sort
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

	// insertion
	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
	   for (int i = 1; i < a.length; i++) {
	      for (int j = i; j > 0 && a[j - 1].compareTo(a[j]) > 0; j--) {
	          exchange(a, j - 1, j);
	      }
	   }
	}

	// selection sort
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

	// merge sort
	public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
		  T[] aux = (T[]) new Comparable[a.length];
		  divide(a, aux, 0, a.length - 1);
		}

	private static <T extends Comparable<? super T>> void divide(T[] a, T[] aux, int low, int high) {
		  if (low >= high) return;

		  int middle = (low + high) / 2;
		  divide(a, aux, low, middle);
		  divide(a, aux, middle + 1, high);
		  conquer(a, aux, low, middle, high);
		}
	private static <T extends Comparable<? super T>> void conquer(T[] a, T[] aux, int low, int middle, int high) {
		  for (int k = low; k <= high; k++) {
		    aux[k] = a[k];
		  }
		  int i = low, j = middle + 1;
		  for (int k = low; k <= high; k++) {
		     if      (i > middle)                   a[k] = aux[j++];
		     else if (j > high)                     a[k] = aux[i++];
		     else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
		     else       			       a[k] = aux[i++];
		  }
	}
	
	// quick sort
	public static <T extends Comparable<? super T>> void quickSort(T[] a) {
	   sort(a, 0, a.length - 1);
	}
	
	private static <T extends Comparable<? super T>> void sort(T[] a, int low, int high) {
	   if (low >= high) return;
	   int p = partition(a, low, high);
	   sort(a, low, p - 1);
	   sort(a, p + 1, high);
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] a, int low, int high) {
	   T pivot = a[(high+low)/2]; 
	   // a[high] estava dando stackOverflow 
	   // no quick para 65k de chaves em ordena��o ascendente; 
	   int i = low - 1; 
	   for (int j = low; j < high; j++) {
	       if (a[j].compareTo(pivot) <= 0) {
	           exchange(a, ++i, j);
	       }
	   }
	   exchange(a, i + 1, high);
	   return i + 1;
	}


	

}
