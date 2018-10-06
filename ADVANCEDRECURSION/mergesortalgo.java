import java.util.*;


/**
 * mergesortalgo
 */
public class mergesortalgo {

    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 2, 3, 4, 6, 8 };
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }
    
    public static void mergeSort(int[] input) {
        // Write your code here
        mergesort(input, 0, input.length-1);

    }

    public static void mergesort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergesort(input, start, middle);
        mergesort(input, middle + 1, end);
        merge(input, start, end,middle);
        

    }

    public static void merge(int[] a, int beg, int end,int mid) {
        // int middle=(start+end)/2;
        // int[] arr1 = new int[middle+2];
        // int[] arr2 = new int[middle + 1];
        // int i = start;
        // int m = 0;
        // for (; i <= middle; i++) {
        //     arr1[m] = input[i];
        //     m++;
        // }
        // arr1[m] = 999;
        // int l = 0;
        // int j = middle + 1;
        // for (; j <= end; j++) {
        //     arr2[l] = input[j];
        //     l++;
        // }
        // arr2[l] = 999;
        
        // int x=0, y=0, z = 0;;

        // while(z<input.length)
        // {
        //     if (arr1[x] <= arr2[y]) {
        //         input[z] = arr1[x];
        //         x++;
        //         z++;
        //     }
        //     else {
        //         input[z] = arr2[y];
        //         y++;
        //         z++;
        //     }
        // }
        
        
        int i=beg,j=mid+1,k,index = beg;  
        int[] temp = new int[a.length];
    while(i<=mid && j<=end)  
    {  
        if(a[i]<a[j])  
        {  
            temp[index] = a[i];  
            i = i+1;  
        }  
        else   
        {  
            temp[index] = a[j];  
            j = j+1;   
        }  
        index++;  
    }  
    if(i>mid)  
    {  
        while(j<=end)  
        {  
            temp[index] = a[j];  
            index++;  
            j++;  
        }  
    }  
    else   
    {  
        while(i<=mid)  
        {  
            temp[index] = a[i];  
            index++;  
            i++;  
        }  
    }  
    k = beg;  
    while(k<index)  
    {  
        a[k]=temp[k];  
        k++;  
    }  

        
        
    }
}