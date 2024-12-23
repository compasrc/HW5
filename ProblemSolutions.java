/******************************************************************
 *
 *   Ryan Compas / COMP 272-001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // Create Hash Table
        Hashtable<Integer, Integer> ht = new Hashtable<>(list1.length);

        // Populate Hash Table with values from list1 using the array elements as keys
        for (int i = 0; i < list1.length; i++){
            ht.put(i, list1[i]);
        }
        //  Compare Hash Table to list2 using contains() method and if there are any values
        //  not in the table, return false
        for (int j = 0; j < list2.length; j++) {
            if (!ht.contains(list2[j])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add array elements to Priority Queue
        for (int i : array) {
            pq.add(i);

            // Any time the queue becomes larger than k, remove the head node
            if (pq.size() > k){
                pq.poll();
            }
        }
        // Once queue size is k, peek the head node since it must now be the Kth largest
        return pq.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Populate Priority Queue with arrays 1 and 2
        for (int i : array1){
            pq.add(i);
        }
        for (int j : array2){
            pq.add(j);
        }

        // Create array with size equal to the queue
        int [] sortedArray = new int[pq.size()];

        // Iterate through the queue and populate the array with elements pushed from the queue
        for (int x = 0; !pq.isEmpty(); x++){
            sortedArray[x] = pq.poll();
        }

        return sortedArray;
    }

}