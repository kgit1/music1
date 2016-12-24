package project;

public class ProjectArrayTests {

}


//merge sort

//public class Mergesort {
//private int[] numbers;
//private int[] helper;
//
//private int number;
//
//public void sort(int[] values) {
//this.numbers = values;
//number = values.length;
//this.helper = new int[number];
//mergesort(0, number - 1);
//}
//
//private void mergesort(int low, int high) {
//// check if low is smaller then high, if not then the array is sorted
//if (low < high) {
//// Get the index of the element which is in the middle
//int middle = low + (high - low) / 2;
//// Sort the left side of the array
//mergesort(low, middle);
//// Sort the right side of the array
//mergesort(middle + 1, high);
//// Combine them both
//merge(low, middle, high);
//}
//}
//
//private void merge(int low, int middle, int high) {
//
//// Copy both parts into the helper array
//for (int i = low; i <= high; i++) {
//helper[i] = numbers[i];
//}
//
//int i = low;
//int j = middle + 1;
//int k = low;
//// Copy the smallest values from either the left or the right side back
//// to the original array
//while (i <= middle && j <= high) {
//if (helper[i] <= helper[j]) {
//numbers[k] = helper[i];
//i++;
//} else {
//numbers[k] = helper[j];
//j++;
//}
//k++;
//}
//// Copy the rest of the left side of the array into the target array
//while (i <= middle) {
//numbers[k] = helper[i];
//k++;
//i++;
//}
//
//}
//}

//shellsort

//class Shellsort {
//public static void main(String args[]) {
//int[] array = new int[] { 3, 2, 5, 4, 1 };
//
//int i1, i, j, increment, temp, number_of_elements = array.length;
///* Shell Sort Program */
//for (increment = number_of_elements / 2; increment > 0; increment /= 2)
//{
//for (i = increment; i < number_of_elements; i++)
//{
//temp = array[i];
//for (j = i; j >= increment; j -= increment)
//{
//if (temp < array[j - increment]) {
//array[j] = array[j - increment];
//} else {
//break;
//}
//}
//array[j] = temp;
//}
//}
//System.out.println("After Sorting:");
//for (i1 = 0; i1 < 5; i1++) {
//System.out.println(array[i1]);
//}
//}
//}

/// **
//* Shellsort, using a sequence suggested by Gonnet.
//* @param a an array of Comparable items.
//*/
//public static void shellsort( Comparable [ ] a )
//{
//for( int gap = a.length / 2; gap > 0;
//gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
//for( int i = gap; i < a.length; i++ )
//{
//Comparable tmp = a[ i ];
//int j = i;
//
//for( ; j >= gap && tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
//a[ j ] = a[ j - gap ];
//a[ j ] = tmp;
//}
//}

//public class ShellSort {
//private long[] data;
//
//private int len;
//
//public ShellSort(int max) {
//data = new long[max];
//len = 0;
//}
//
//public void insert(long value){
//data[len] = value;
//len++;
//}
//
//public void display() {
//System.out.print("Data:");
//for (int j = 0; j < len; j++)
//System.out.print(data[j] + " ");
//System.out.println("");
//}
//
//public void shellSort() {
//int inner, outer;
//long temp;
////find initial value of h
//int h = 1;
//while (h <= len / 3)
//h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
//
//while (h > 0) // decreasing h, until h=1
//{
//// h-sort the file
//for (outer = h; outer < len; outer++) {
//temp = data[outer];
//inner = outer;
//// one subpass (eg 0, 4, 8)
//while (inner > h - 1 && data[inner - h] >= temp) {
//data[inner] = data[inner - h];
//inner -= h;
//}
//data[inner] = temp;
//}
//h = (h - 1) / 3; // decrease h
//}
//}
//
//public static void main(String[] args) {
//int maxSize = 10;
//ShellSort arr = new ShellSort(maxSize);
//
//for (int j = 0; j < maxSize; j++) {
//long n = (int) (java.lang.Math.random() * 99);
//arr.insert(n);
//}
//arr.display();
//arr.shellSort();
//arr.display();
//}
//}

//private static void shellsort() {
//int[] theArray = {44,5,33,22,765,43,53,12,57,97};
//
////first section gets the Knuth's interval sequence (very efficient)
//int h=1;
//while(h<= theArray.length/3){
//h = 3*h + 1; //h is equal to highest sequence of h<=length/3 (1,4,13,40...)
//}
//
////next section
//while(h>0){ //for array of length 10, h=4
//
////similar to insertion sort below
//for(int i=0; i<theArray.length; i++){
//
//int temp = theArray[i];
//int j;
//
//for(j=i; j>h-1 && theArray[j-h] >= temp; j=j-h){
//a[j] = a[j-h];
//}
//a[j] = temp;
//}
//h = (h-1)/3;
//}
//}

//comb sort

//The basic idea is to eliminate turtles, or small values near the end of the
//list, since in a bubble
//sort these slow the sorting down tremendously.Rabbits, large values around
//the
//beginning of the list,do not pose a problem in bubble sort. In bubble sort,
//when any two elements are compared, they always have
//
//a gap (distance from each other) of 1. The basic idea of comb sort is that
//the gap can be much more than 1. The inner loop of bubble sort, which does
//the actual swap, is modified such that gap between swapped elements goes down
//(for each iteration of outer loop) in steps of a "shrink factor" k: [ n/k,
//n/k2, n/k3, ..., 1 ].
//
//The gap starts out as the length of the list n being sorted divided by the
//shrink factor k (generally 1.3; see below) and one pass of the aforementioned
//modified bubble sort is applied with that gap. Then the gap is divided by the
//shrink factor again, the list is sorted with this new gap, and the process
//repeats until the gap is 1. At this point, comb sort continues using a gap of
//1 until the list is fully sorted. The final stage of the sort is thus
//equivalent to a bubble sort, but by this time most turtles have been dealt
//with, so a bubble sort will be efficient.
//
//The shrink factor has a great effect on the efficiency of comb sort. k = 1.3
//has been suggested as an ideal shrink factor by the authors of the original
//article after empirical testing on over 200,000 random lists. A value too
//small slows the algorithm down by making unnecessarily many comparisons,
//whereas a value too large fails to effectively deal with turtles.
//
//The pattern of repeated sorting passes with decreasing gaps is similar to
//Shellsort, but in Shellsort the array is sorted completely each pass before
//going on to the next-smallest gap. Comb sort's passes do not completely sort
//the elements. This is the reason that Shellsort gap sequences have a larger
//optimal shrink factor of about 2.2.

//public static <E extends Comparable<? super E>> void sort(E[] input) {
//int gap = input.length;
//boolean swapped = true;
//while (gap > 1 || swapped) {
//if (gap > 1) {
//gap = (int) (gap / 1.3);
//}
//swapped = false;
//for (int i = 0; i + gap < input.length; i++) {
//if (input[i].compareTo(input[i + gap]) > 0) {
//E t = input[i];
//input[i] = input[i + gap];
//input[i + gap] = t;
//swapped = true;
//}
//}
//}
//}

//public class CombSort {
//
//public static void sort(int[] array, int size) {
///*
//* This function sorts a list in-place using CombSort11. It works
//* exactly like BubbleSort except that instead of looking at i and i+1
//* when iterating, it looks at i and i+gap. This helps reposition small
//* values stuck at the end of the array.
//*/
//
//int gap = size; // The distance between elements being compared
//boolean swapped = true;
//int i; // Our index
//
//// keep looping until you make
//// a complete pass without swapping
//while (gap > 1 || swapped) {
//
//// 1.3 is the shrink factor.
//// I found it to be the fastest.
//// A gap can not be smaller than 1,
//// hence the "if (gap > 1)"
//if (gap > 1) {
//gap = (int) (gap / 1.3);
//}
//
//// This is why it is CombSort11
//// instead of CombSort. I find
//// doing this increases the speed
//// by a few milliseconds.
//if (gap == 9 || gap == 10) {
//gap = 11;
//}
//
//i = 0;
//swapped = false;
//
//// Loop through comparing numbers a gap-length apart.
//// If the first number is bigger than the second, swap them.
//while (i + gap < size) {
//if (array[i] > array[i + gap]) {
//swap(array, i, i + gap);
//swapped = true;
//}
//i++;
//}
//}
//}
//
//public static void swap(int[] list, int i, int j) {
///*
//* This method simply takes an array and swaps its values at index i and
//* j
//*/
//
//int temp = list[i];
//list[i] = list[j];
//list[j] = temp;
//}
//
//public static String input(String s) {
///*
//* input() simplifies the process of asking for input and getting input
//* at the same time. Takes string s, prints it. Gets users input,
//* returns it.
//*/
//
//System.out.print(s);
//Scanner scan = new Scanner(System.in);
//return scan.next();
//}
//
//public static void main(String[] args) {
///*
//* Ask the user how many numbers of what range should be sorted by the
//* algorithm and if they want to see the array
//*/
//
//int ammount = Integer
//.parseInt(input("How many numbers shall be generated? "));
//int min = Integer.parseInt(input("Min value of numbers: "));
//int max = Integer.parseInt(input("Max value of numbers: "));
//boolean show_array = input(
//"Would you like to see the sorted and unsorted list?(y/n) ")
//.equals("y");
//
//int[] numbers = new int[ammount];
//
//// This generates the randomly populated array using
//// numbers between min and max
//Random rand = new Random();
//for (int n = 0; n < ammount; n++) {
//numbers[n] = rand.nextInt(max - min + 1) + min;
//}
//
//if (show_array) {
//System.out.println("__UNSORTED ARRAY__");
//System.out.println(Arrays.toString(numbers));
//}
//
//sort(numbers, ammount);
//
//if (show_array) {
//System.out.println("__SORTED ARRAY__");
//System.out.println(Arrays.toString(numbers));
//}
//
//}
//}

/////// insertion sort ///////////////////////////////////////////

//Insertion sort is a simple sorting algorithm that builds the final sorted
/////// array (or list) one item at a time. It is much less efficient on large
/////// lists than more advanced algorithms such as quicksort, heapsort, or
/////// merge sort. However, insertion sort provides several advantages:
//
//Simple implementation: Bentley shows a three-line C version, and a five-line
/////// optimized version[1]:116
//Efficient for (quite) small data sets, much like other quadratic sorting
/////// algorithms
//More efficient in practice than most other simple quadratic (i.e., O(n2))
/////// algorithms such as selection sort or bubble sort
//Adaptive, i.e., efficient for data sets that are already substantially
/////// sorted: the time complexity is O(nk) when each element in the input is
/////// no more than k places away from its sorted position
//Stable; i.e., does not change the relative order of elements with equal keys
//In-place; i.e., only requires a constant amount O(1) of additional memory
/////// space
//Online; i.e., can sort a list as it receives it
//When people manually sort cards in a bridge hand, most use a method that is
/////// similar to insertion sort.[2]

//Insertion Sort Method for Descending Order
//public static void InsertionSort( int [ ] num)
//{
//int j; // the number of items sorted so far
//int key; // the item to be inserted
//int i;
//
//for (j = 1; j < num.length; j++) // Start with 1 (not 0)
//{
//key = num[ j ];
//for(i = j - 1; (i >= 0) && (num[ i ] < key); i--) // Smaller values are
//moving up
//{
//num[ i+1 ] = num[ i ];
//}
//num[ i+1 ] = key; // Put the key in its proper location
//}
//}

//package com.java2novice.algos;
//
//public class MyInsertionSort {
//
//public static void main(String a[]){
//int[] arr1 = {10,34,2,56,7,67,88,42};
//int[] arr2 = doInsertionSort(arr1);
//for(int i:arr2){
//System.out.print(i);
//System.out.print(", ");
//}
//}
//
//public static int[] doInsertionSort(int[] input){
//
//int temp;
//for (int i = 1; i < input.length; i++) {
//for(int j = i ; j > 0 ; j--){
//if(input[j] < input[j-1]){
//temp = input[j];
//input[j] = input[j-1];
//input[j-1] = temp;
//}
//}
//}
//return input;
//}
//}
//- See more at:
//http://www.java2novice.com/java-sorting-algorithms/insertion-sort/#sthash.RUZ7zvn1.dpuf