import java.util.Stack;
class IterativeQuickSort { 
    //Time complexity : O(nlogn)
    //Space complexity : O(1)
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable
	    if(arr[i]==arr[j]){
	        return;
	    }
	    arr[i]=arr[i]^arr[j];
	    arr[j]=arr[i]^arr[j];
	    arr[i]=arr[i]^arr[j];
	
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int p=arr[h];
        int pi=l-1;
        for(int i=l;i<h;i++){
            if(arr[i]<=p){
                pi++;
                swap(arr,i,pi);
            }
        }
        swap(arr,pi+1,h);
        return pi+1;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        Stack<Integer> st = new Stack<>();
        st.push(l);
        st.push(h);
        while(!st.empty()){
            h=st.pop();
            l=st.pop();
            int p=partition(arr,l,h);
            if(p-1>l){
                st.push(l);
                st.push(p-1);
            }
            if(p+1<h){
                st.push(p+1);
                st.push(h);
            }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 
