/**
 * Created by suresh on 26/8/15.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println( OffHeapCollection.fileLimit);
        IntArray testArray=OffHeapCollection.createIntArray(1000000000);
        for (long i = 0; i <= 1000000000; i++) {
            testArray.put(i,(int)i+50);
        }
        System.out.println("finished writing");
        for (long i = 0; i <= 1000000000; i++) {
            testArray.get(i);
        }
    }
}
