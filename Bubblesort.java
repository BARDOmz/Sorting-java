
/**
 * This class creates the Bubble sort alogrithim.
 * 
 */
public class Bubblesort
{
   public static void sort(int arr[])
   {
    int n = arr.length;
    
    for(int i=0; i <n-1;i++)
        for(int j=0; j <n-i-1;j++)
        if(arr[j] > arr[j+1]){
            ArrayUtil.swap(arr, j, j+1);
    }
  }
}
