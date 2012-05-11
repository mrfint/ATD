
package utils;

public class MyArrays {
    public static void sortBubble(int[] a){
        int c;
        for (int i = 0; i < a.length; i++) 
        {   for (int j = i+1; j < a.length; j++){
                if(a[i]>a[j]) {  c=a[i];  a[i]=a[j];   a[j]=c;  }
            }
        }
    }
    
    public static void sortSelection(int[] a){
        int c;  int min;
        for(int i=0; i<a.length-1; i++){
            min=i;
            for(int j=i+1; j<a.length; j++){
                if( a[j]< a[min])      min=j;
            }
            if (min!=i) {  c=a[i];  a[i]=a[min];   a[min]=c;  }
        }

    }
    
    public static void sortInsert(int[] a){
        int c;
        for ( int i=0; i < a.length; i++) {
        c = a[i];
        for ( int j=i-1; j>=0 && a[j] > c; j--){
            a[j+1] = a[j];
            a[j+1] = c;
        }
       }
    }
    
    public static void sortShell(int[] a){
        int i, j, k, h, m=0, b=a.length;
        int[] d =  { 1, 4, 10, 23, 57, 145 };
        while (d[m] < b) ++m;
        while (--m >= 0){
            k = d[m];
            for (i=k; i<b; i++){     // k-сортировка
                j=i;
                h=a[i];
                while ((j >= k) && (a[j-k] > h)){  
                    a[j]=a[j-k];
                    j =  j-k;
                }
                a[j] = h;
            }
        }
     
    }
    public static void sortQuick(int[] items){
        qs(items, 0, items.length-1);
    }

    private static void qs(int[] items, int left, int right) {
        int i, j;
        int x, y;
        
        i = left;  j = right;
        x = items[(left + right)/2];
        
        do {
            while( (items[i] < x ) && (i < right)) i++;
            while( (x < items[j] ) && (j > left)) j--;
            
            if (i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++; j--;
            }
        } while (i <= j);
        
        if(left < j)  qs(items, left, j);
        if(i < right) qs(items, i, right);
        
    }
   
    public void sortMerge(int a[]){
	//
    }

}
