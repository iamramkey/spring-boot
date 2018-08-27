package com.iamramkey.springboot.starter;

public class InsertionSort {
	public static void main(String[] args) {
		System.out.println("Insertion sort starts");
		Integer[] arr = { 12, 9, 8, 5, 2, 1 };
		arr = InsertionSort.getSortedArray(arr);

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static Integer[] getSortedArray(Integer[] arr) {
		int arrayLength = arr.length;
		for (int i = 0; i < arrayLength; i++) {
			int current = arr[i];
			int j = i - 1;
			while (j > -1 && arr[j] > current) {
				arr[j + 1] = arr[j--];
			}
			arr[j + 1] = current;
		}
		return arr;
	}
}
