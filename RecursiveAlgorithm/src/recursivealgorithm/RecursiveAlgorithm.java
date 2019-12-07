/* Program that computes the avg and median of two arrays
 * with a complexity of O(n)
 */
package recursivealgorithm;

/**
 * @authors Sergio Vega     (43480752B)
 *          Andreas Korn    (X4890193W)
 */
public class RecursiveAlgorithm {

    private static float Average = 0;
    private static int Median = 0;
    
    public static <T extends Comparable> void main(String[] args) {
        Integer a[] = {1, 9, 1, 7, 7, 9, 3, 2, 7};
        Integer b[] = {2, 4, 1, 6, 8, 5, 3};
        mergeAndComputeAvg(a, b);
        System.out.println("* Average * = " + Average);
        System.out.println("* Median * = " + Median);
    }
    
    /** 
     * Method that computes the avg and median of two arrays
     */
    private static <T extends Comparable> void mergeAndComputeAvg(T[] a, T[] b){
        T[] c = (T[]) new Comparable[a.length + b.length];
        for(int i = 0; i < a.length || i < b.length; i++){
            if(i<a.length){
                c[i] = a[i];
                Average += (Integer) a[i];
            }
            if(i<b.length){
                c[i+a.length] = b[i];
                Average += (Integer) b[i];
            }
        }
        Average /= (a.length+b.length);
        Median = (Integer) recursiveArrayMedian(c, 0, c.length-1);
    }
    
    private static <T extends Comparable> T recursiveArrayMedian(T[] c, int l , int r){
        int m = (l+r)/2;
        if(l>=r) return c[l];
        int[] pi = partition(c, c[m], l, r);
        if(pi[1] == ((c.length-1)/2)){ // We take 1 because the index starts with 0
            return c[pi[1]];
        } else if(pi[1] > ((c.length-1)/2)){   // pi[0] is after the median
            return recursiveArrayMedian(c, l, pi[1]);
        } else {
            return recursiveArrayMedian(c, pi[0], r);
        }
        
    }
    
    private static <T extends Comparable> int[] partition(T c[], T pivot, int l, int r){
        int l1 = l;
        int r1 = r;
        while(l1 < r1){
            while(c[l1].compareTo(pivot) < 0){
                l1++;
            }
            while(c[r1].compareTo(pivot) > 0){
                r1--;
            }
            if(l1<r1){
                T aux = c[l1];
                c[l1]=c[r1];
                c[r1]=aux;
                l1++;
                r1--;
            }
        }
        return new int[]{l1,r1};
    }
}