package com.hariommaurya.interview.codingQuestions.array.searching.binarySearch;

import sun.dc.pr.PRError;

import java.util.*;

interface ISerach{
    int search(int arr[], int target);
}
class LinearSearch implements  ISerach{

    @Override
    public int search(int[] arr, int target) {
        return 0;
    }
}
class BinarySearch implements ISerach{
    private final boolean ALGOTYPE = true;
    /*
    1 = N / 2^k
    2^k = N
    log(2^k) = logN
    klog2 = logN
    k = logN / log2
    k = logN
    Number of comparison => k = logN

     */
    @Override
    public int search(int[] arr, int target) {
        return search(arr,target,ALGOTYPE);
    }

    private int search(int[] arr, int target,boolean algoType){
        if(algoType){
            return iterativeBinarySearch(arr,target);
        }
        return recursiveBinarySerach(arr,target,0,arr.length-1);
    }

    private int iterativeBinarySearch(int [] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    private int recursiveBinarySerach(int [] arr,int target,int start,int end){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(arr[mid] == target) return mid;
        if(arr[mid] < target){
            return recursiveBinarySerach(arr,target,mid+1,end);
        }else{
            return recursiveBinarySerach(arr,target,start,mid-1);
        }
    }
}
public class BinarySearchTest {
    public static void main(String[] args) {
        int arr[] = {24,11,2,52,208,203,249,43};
        System.out.print("Before Sorting : ");
        Arrays.stream(arr).forEach(i-> System.out.print(i+" "));
        Arrays.sort(arr);
        System.out.print("\nAfter Sorting  : ");
        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
        ISerach serach = new BinarySearch();
        System.out.println("\nindex : "+serach.search(arr,52));
    }
}
