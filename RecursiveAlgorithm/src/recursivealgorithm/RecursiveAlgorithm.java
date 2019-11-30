/* Program that computes the avg and median of two arrays
 * with a complexity of O(n)
 */
package recursivealgorithm;

/**
 * @authors Sergio Vega     (43480752B)
 *          Andreas Korn    (X4890193W)
 */
public class RecursiveAlgorithm {

    private static Integer Average = 0;
    private static Integer Median = 0;
    
    public static <T extends Comparable> void main(String[] args) {
        Integer a[] = {10, 9, 1, 7, 7, 9, 3, 2, 7};
        Integer b[] = {2, 4, 1, 6, 8, 5, 3};
        computeArrayAvgMedian(a, b);
        System.out.println("* Average * = " + Average);
        System.out.println("* Median * = " + Median);
    }
    
    /** 
     * Method that computes the avg and median of two arrays
     */
    private static <T extends Comparable> void computeArrayAvgMedian(T[] a, T[] b){
        T[] c = (T[]) new Comparable[a.length + b.length];
        int i = 0;
        while (i<a.length){
            c[i] = a[i];
            Average += (Integer) a[i];
            i++;
        }
        while (i<a.length){
            c[i] = b[i];
            Average += (Integer) a[i];
            i++;
        }
        Average /= (a.length+b.length);
        Median = (Integer) recursiveComputeArrayMedian(c, 0, a.length-1);
    }
    
    private static <T extends Comparable> T recursiveComputeArrayMedian(T[] a, int l , int r){
        int m = (l+r)/2;
        if(l<=r) return a[l];
        int[] pi = partition(a, a[m], l, r);
        if((pi[0]-l) > (r-pi[1])){  // Median is on the biger partition, in this case the left partition
            return recursiveComputeArrayMedian(a, l, pi[0]);
        } else {
            return recursiveComputeArrayMedian(a, pi[1], r);
        }
        
    }
    
    private static <T extends Comparable> int[] partition(T a[], T pivot, int l, int r){
        int l1 = l;
        int r1 = r;
        while(l1 <= r1){
            while(a[l1].compareTo(pivot) < 0){
                l1++;
            }
            while(a[r1].compareTo(pivot) > 0){
                r1--;
            }
            if(l1<=r1){
                T aux = a[l1];
                a[l1]=a[r1];
                a[r1]=aux;
                l1++;
                r1--;
            }
        }
        return new int[]{l1,r1};
    }
}