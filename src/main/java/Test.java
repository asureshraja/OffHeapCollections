import java.util.ArrayList;

/**
 * Created by suresh on 26/8/15.
 */
public class Test {
    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {

            int[] tempArray = new int[10000001];
            int temp = 0;
            IntArray testArray = OffHeapCollection.createIntArray(10000000);
            System.out.println("special=" + System.currentTimeMillis());
            for (int i = 0; i <= 10000000; i++) {
                testArray.put(i, (int) i + 50);
            }
            System.out.println("special=" + System.currentTimeMillis());
            System.out.println("finished writing");
            for (int i = 0; i <= 10000000; i++) {
                temp = testArray.get(i);
            }
            System.out.println("special=" + System.currentTimeMillis());


        }
    }
}