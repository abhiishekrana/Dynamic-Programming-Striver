
//Linear search is applicable only when small size of data
import java.util.*;
public class Main{
	public static void main(String[] args){
	int[] arr = {10,50,60,80};
	int skey = 60;
	boolean flag=false;
	int index=-1;
	for(int i=0;i<arr.length;i++){
		if(arr[i]==skey){
			flag=true;
			index = i;

		}
	}
	System.out.print("flag->"+flag+"index->"+index);
	}
}

//Binary search
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 40, 60, 80, 70, 90, 110};
        int skey = 50;
        int left = 0;
        boolean flag = false;
        int index = -1;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // Mid should be recalculated in each iteration
            if (arr[mid] == skey) {
                flag = true;
                index = mid;
                break; // Exit the loop once the key is found
            } else if (arr[mid] > skey) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.print("flag->" + flag + " index->" + index);
    }
}




