import java.nio.MappedByteBuffer;
import java.util.ArrayList;

/**
 * Created by suresh on 26/8/15.
 */
public class LongArray {
    private ArrayList<MappedByteBuffer> mappedFileBuffers=new ArrayList<MappedByteBuffer>();
    private long capacity;
    LongArray(ArrayList<MappedByteBuffer> mappedFileBuffers, Long capacity){
        this.mappedFileBuffers=mappedFileBuffers;
        this.capacity=capacity;
    }

    public int get(long index){
        if(index<0&&index>=capacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*8/(OffHeapCollection.fileLimit));
        return mappedFileBuffers.get(fileNumber).getInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit / 8))) * 8);
    }

    public void put(long index,int value){
        if(index<0&&index>=capacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*8/(OffHeapCollection.fileLimit));
        mappedFileBuffers.get(fileNumber).putInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit / 8))) * 8, value);
    }

}
