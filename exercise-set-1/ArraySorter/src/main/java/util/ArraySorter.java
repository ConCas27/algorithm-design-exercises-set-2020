package util;

/**
 * Sorts arrays of comparable objects using a variety of options.
 *
 * @author aguirre
 *
 * @param <E> is the type of the elements of the array.
 */
public class ArraySorter<E extends Comparable<E>> {

	/**
	 * The array to sort.
	 */
	private E[] array;

	/**
	 * The algorithm to use for sorting.
	 */
	private SortAlgorithm algorithm = SortAlgorithm.INSERTIONSORT;

	/**
	 * Default constructor. Sets the array to sort and sorting algorithm to INSERTION SORT.
	 * @param array is the array to sort.
	 */
	public ArraySorter(E[] array) {
		if (array == null) throw new IllegalArgumentException("array must be non-null");
		this.array = array;
	}

	/**
	 * Constructor that sets array and sorting algorithm.
	 * @param array is the array to sort.
	 * @param algorithm is the algorithm to use for sorting.
	 */
	public ArraySorter(E[] array, SortAlgorithm algorithm) {
		if (array == null) throw new IllegalArgumentException("array must be non-null");
		this.array = array;
		this.algorithm = algorithm;
	}

	/**
	 * Sets the algorithm to use for sorting.
	 * @param algorithm is the algorithm to set for sorting.
	 */
	public void setAlgorithm(SortAlgorithm algorithm) {
		if (algorithm == null) throw new IllegalArgumentException("algorithm can't be null");
		this.algorithm = algorithm;
	}

	/**
	 * Retrieves the (sorted or yet unsorted) array within the ArraySorter.
	 * @return the array stored within the ArraySorter object.
	 */
	public E[] getArray() {
		return this.array;
	}

	/**
	 * Sets the array to be sorted.
	 * @param array is the new array to sort.
	 */
	public void setArray(E[] array) {
		throw new UnsupportedOperationException("method not yet implemented");
	}

	/**
	 * Sorts the array.
	 * The array can then be retrieved using getArray() method.
	 */
	public void sort() {
		switch (this.algorithm) {
		case INSERTIONSORT:
			insertionSort(array);
			break;
		case BUBBLESORT:
			bubbleSort(array);
			break;
		case MERGESORT:
			mergeSort(array);
			break;
		case SELECTIONSORT:
			selectionSort(array);
			break;
		default:
            throw new UnsupportedOperationException("sorting method not yet implemented");
		}
	}

	/**
	 * Sorts an array. Implements the selection sort algorithm.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be sorted.
	 */
	private static <T extends Comparable<T>> void selectionSort(T[] array) {
		if (array == null) throw new IllegalArgumentException("array is null, can't sort");
		int i = 0;
		while (i < array.length) {
			T min, aux;
			int minIndex, j;
			min = array[i];
			minIndex = i;
			j = i;
			while (j < array.length) {
				if (array[j].compareTo(min) < 0) {
					min = array[j];
					minIndex = j;
				}
				j++;
			}
			aux = array[i];
			array[i] = array[minIndex];
			array[minIndex] = aux;
			i++;
		}
	}

	/**
	 * Sorts an array. Implements the mergesort sort algorithm.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be sorted.
	 */
	private static <T extends Comparable<T>> T[] mergeSort(T[] array) {
		if (array == null) throw new IllegalArgumentException("array is null, can't sort");
		T[] left = null;
		T[] right = null;
		T[] result = null;
		int middle = array.length/2;
		if (array.length == 1){
			return array;
		}else{
			for (int i = 0; i < middle; i++){
				left[i] = array[i];
			}
			for (int i = middle; i < array.length; i++){
				right[i] = array[i];
			}
			left = mergeSort(left);
			right = mergeSort(right);
			if ((left[left.length - 1].compareTo(right[0])==-1) || (left[left.length - 1].compareTo(right[0])==0)){
				for (int i = left.length; i < right.length; i++){
					left[i] = right[i];
				}
				return left;
			}
			result = merge(left, right);
			return result;
		}
	}

		private static <T extends Comparable<T>> T[] merge(T[] left, T[] right){
			T[] result = null;
			int relleno = 0;
			while ((left.length > 0) && (right.length > 0)){
				if ((left[0].compareTo(right[0])==-1) || (left[0].compareTo(right[0])==0)){
					result[relleno] = left[0];
					relleno = relleno++;
					for (int i = 1; i < left.length; i++){
						left[i-1] = left[i];
					}
				} else {
					result[relleno] = right[0];
					relleno = relleno++;
					for (int i = 1; i < right.length; i++){
						right[i-1] = right[i];
				}
			}
		}
			if (left.length > 0){
				for (int i=0; i < left.length; i++){
					result[relleno] = left[i];
					relleno++;
				}
			}
			if (right.length > 0){
				for (int i=0; i < right.length; i++){
					result[relleno] = right[i];
					relleno++;
				}
			}
			return result;
	}

	/**
	 * Sorts an array. Implements the bubblesort sort algorithm.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be sorted.
	 */
	private static <T extends Comparable<T>> void bubbleSort(T[] array) {
		throw new UnsupportedOperationException("method not yet implemented");
	}

	/**
	 * Sorts an array. Implements the insertion sort algorithm.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be sorted.
	 */
	private static <T extends Comparable<T>> void insertionSort(T[] array) {
		throw new UnsupportedOperationException("method not yet implemented");
	}

	/**
	 * Checks if a given array is sorted.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be checked for sortedness.
	 * @return true iff the array is sorted.
	 */
	public static <T extends Comparable<T>> boolean isSorted(T[] array) {
		throw new UnsupportedOperationException("method not yet implemented");
	}

}
