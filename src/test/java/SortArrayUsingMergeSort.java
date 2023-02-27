
public class SortArrayUsingMergeSort {
    public static void main(String[] args){
        int[] givenArr = {5,7,9,112,34,56,432,4,0,-1};
        int[] givenTemp = new int[givenArr.length];
        int mid = (givenArr.length/2)-1;
        sortGivenArrayOfInegers(givenArr,0,givenTemp.length-1, givenTemp);
        for(int val : givenArr){
            System.out.println(val);
        }
    }

    public static void mergeGivenArray(int[] arr, int l, int m, int r, int[] temp) {
        int i = l, j = m + 1, k = l;
        //Comparision in sub array
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //Handling left sub array
        while (i <= m) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        //Handling right sub array
        while (j <= r) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        //This will basically copy the sorted array back to the original array
        for (i = l; i <= r; i++) {
            arr[i] = temp[i];
        }
    }
    public static void sortGivenArrayOfInegers(int[] arr, int l, int r, int[] tempArray) {
        if (l < r) {
            int m = (l + r) / 2;
            sortGivenArrayOfInegers(arr, l, m, tempArray); // Recursively sorting the left sub array
            sortGivenArrayOfInegers(arr, m + 1, r, tempArray); // Recursively sorting the right sub array
            mergeGivenArray(arr, l, m, r, tempArray); //Merging the sorted sub arrays
        }
    }

}
