/* Program that computes the avg and median of two arrays
 * with a complexity of O(n)
 */
package recursivealgorithm;

/**
 * @authors Sergio Vega     (43480752B)
 *          Andreas Korn    (X4890193W)
 */
public class RecursiveAlgorithm {

    private static int Average = 0;
    private static int Median = 0;
    
    public static void main(String[] args) {
        Integer a[] = {1, 2, 3};
        Integer b[] = {3, 4, 5};
        ComputeArrayAvgMedian(a,b);
        System.out.println(Average);
        System.out.println(Median);
    }
    
    /** 
     * Method that computes the avg and median of two arrays
     */
    private static <T extends Comparable> void ComputeArrayAvgMedian(T[] a, T[] b){
        T[] c = (T[]) new Object[a.length + b.length];
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
        Average = Average/(a.length+b.length);
        RecursiveComputeArrayMedian(c, 0, a.length-1);
    }
    
    private static <T extends Comparable> void RecursiveComputeArrayMedian(T[] c, int l , int r){
        
    }
}
