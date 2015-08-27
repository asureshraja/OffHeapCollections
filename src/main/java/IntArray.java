import java.nio.MappedByteBuffer;
import java.util.ArrayList;

/**
 * Created by suresh on 26/8/15.
 */
public class IntArray {
    public ArrayList<MappedByteBuffer> mappedFileBuffers=new ArrayList<MappedByteBuffer>();
    private long capacity;
    IntArray(ArrayList<MappedByteBuffer> mappedFileBuffers,Long capacity){
        this.mappedFileBuffers=mappedFileBuffers;
        this.capacity=capacity;
    }
    public int get(long index){
        int fileNumber=(int)(index*4/(OffHeapCollection.fileLimit));
        return mappedFileBuffers.get(fileNumber).getInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit/4))) * 4);
    }
    public void put(long index,int value){
        int fileNumber=(int)(index*4/(OffHeapCollection.fileLimit));
        mappedFileBuffers.get(fileNumber).putInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit/4))) * 4, value);
    }
}