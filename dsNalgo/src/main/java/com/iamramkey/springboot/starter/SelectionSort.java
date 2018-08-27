package com.iamramkey.springboot.starter;

public class SelectionSort {

	public static void main(String[] args) {
		System.out.println("Selection sort starts");
		Integer[] arr = { 12, 9, 8, 5, 2, 1 };
		arr = SelectionSort.getSortedArray1(arr);

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static Integer[] getSortedArray(Integer[] arr) {
		int arrayLength = arr.length;
		for (int i = 0; i < arrayLength; i++) {
			for (int j = i + 1; j < arrayLength; System.out.println(""), j++) {
				System.out.println("i : " + i + " j : " + j + " arr[i] : " + arr[i] + " arr[j]" + arr[j]);
				if (arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
				System.out.println("i : " + i + " j : " + j + " arr[i] : " + arr[i] + " arr[j]" + arr[j]);
			}
		}
		return arr;
	}

	public static Integer[] getSortedArray1(Integer[] arr) {
		int arrayLength = arr.length;
		for (int i = 0; i < arrayLength; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arrayLength; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

}
