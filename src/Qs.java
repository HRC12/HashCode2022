import java.io.*;
import java.util.ArrayList;

public class Qs {
        // A utility function to swap two elements
        static void swap(ArrayList<Project> arr, int i, int j)
        {
            int temp = arr.get(i).deadline;
            arr.get(i).deadline = arr.get(j).deadline;
            arr.get(j).deadline = temp;
        }

        /* This function takes last element as pivot, places
           the pivot element at its correct position in sorted
           array, and places all smaller (smaller than pivot)
           to left of pivot and all greater elements to right
           of pivot */
        static int partition(ArrayList<Project> arr, int low, int high)
        {

            // pivot
            int pivot = arr.get(high).deadline;

            // Index of smaller element and
            // indicates the right position
            // of pivot found so far
            int i = (low - 1);

            for(int j = low; j <= high - 1; j++)
            {

                // If current element is smaller
                // than the pivot
                if (arr.get(j).deadline < pivot)
                {

                    // Increment index of
                    // smaller element
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return (i + 1);
        }

        /* The main function that implements QuickSort
                  arr[] --> Array to be sorted,
                  low --> Starting index,
                  high --> Ending index
         */
        static void quickSort(ArrayList<Project> arr, int low, int high)
        {
            if (low < high)
            {

                // pi is partitioning index, arr[p]
                // is now at right place
                int pi = partition(arr, low, high);

                // Separately sort elements before
                // partition and after partition
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
    }

// This code is contributed by Ayush Choudhary

