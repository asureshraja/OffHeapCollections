package Arrays;

import Utils.OffHeapCollection;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by suresh on 26/8/15.
 */
public class IntArray   {
    private ArrayList<MappedByteBuffer> mappedFileBuffers=new ArrayList<MappedByteBuffer>();
    private long capacity;
    public IntArray(ArrayList<MappedByteBuffer> mappedFileBuffers, Long capacity){
        this.mappedFileBuffers=mappedFileBuffers;
        this.capacity=capacity;
    }
    public int get(long index){
        if(index<0&&index>=capacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*4/(OffHeapCollection.fileLimit));
        return mappedFileBuffers.get(fileNumber).getInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit/4))) * 4);
    }
    public void put(long index,int value){
        if(index<0&&index>=capacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        int fileNumber=(int)(index*4/(OffHeapCollection.fileLimit));
        mappedFileBuffers.get(fileNumber).putInt((int) (index - (fileNumber * (OffHeapCollection.fileLimit/4))) * 4, value);
    }
    public void iterate(Iterator iterator){

    }
}