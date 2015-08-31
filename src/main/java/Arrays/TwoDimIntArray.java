package Arrays;

import Utils.OffHeapCollection;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;

/**
 * Created by suresh on 28/8/15.
 */
public class TwoDimIntArray {
    public ArrayList<MappedByteBuffer> mappedFileBuffers=new ArrayList<MappedByteBuffer>();
    private long rCapacity;
    private long cCapacity;
    private long maxCapacity;
    public TwoDimIntArray(ArrayList<MappedByteBuffer> mappedFileBuffers, Long rCapacity, Long cCapacity){
        this.mappedFileBuffers=mappedFileBuffers;
        this.cCapacity=cCapacity;
        this.rCapacity=rCapacity;
        this.maxCapacity=rCapacity*cCapacity;
    }
    public int get(long rindex,long cindex){
        long index=(rindex*cCapacity)+cindex;
        if(index<0&&index>=maxCapacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*4/(OffHeapCollection.fileLimit));
        return mappedFileBuffers.get(fileNumber).getInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit/4))) * 4);
    }
    public void put(long rindex,long cindex,int value){

        long index=(rindex*cCapacity)+cindex;
        if(index<0&&index>=maxCapacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*4/(OffHeapCollection.fileLimit));

        mappedFileBuffers.get(fileNumber).putInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit / 4))) * 4, value);

    }
}
