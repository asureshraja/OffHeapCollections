package Arrays;

import Utils.OffHeapCollection;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;

/**
 * Created by suresh on 28/8/15.
 */
public class TwoDimLongArray {
    public ArrayList<MappedByteBuffer> mappedFileBuffers=new ArrayList<MappedByteBuffer>();
    private long rCapacity;
    private long cCapacity;
    private long maxCapacity;
    public TwoDimLongArray(ArrayList<MappedByteBuffer> mappedFileBuffers, Long rCapacity, Long cCapacity){
        this.mappedFileBuffers=mappedFileBuffers;
        this.cCapacity=cCapacity;
        this.rCapacity=rCapacity;
        this.maxCapacity=rCapacity*cCapacity;
    }
    public long get(long rindex,long cindex){
        long index=(rindex*cCapacity)+cindex;
        if(index<0&&index>=maxCapacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*8/(OffHeapCollection.fileLimit));
        return mappedFileBuffers.get(fileNumber).getLong((int) (index - (fileNumber * (OffHeapCollection.fileLimit/8))) * 8);
    }
    public void put(long rindex,long cindex,long value){
        long index=(rindex*cCapacity)+cindex;
        if(index<0&&index>=maxCapacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*8/(OffHeapCollection.fileLimit));
        mappedFileBuffers.get(fileNumber).putLong((int) (index - (fileNumber * (OffHeapCollection.fileLimit/8))) * 8, value);
    }
}
