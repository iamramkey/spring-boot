package com.iamramkey.springboot.starter;

public class BubbleSort {

	public static void main(String[] args) {
		System.out.println("Bubble sort starts");
		Integer[] arr = { 12, 9, 8, 5, 2, 1 };
		arr = BubbleSort.getSortedArray(arr);

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static Integer[] getSortedArray(Integer[] arr) {
		int arrayLength = arr.length - 1;
		for (int i = 0; i < arrayLength; i++) {
			for (int j = 0; j < arrayLength - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

}
