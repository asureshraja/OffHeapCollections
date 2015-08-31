package Utils;

import Arrays.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * Created by suresh on 26/8/15.
 */
public class OffHeapCollection {
    private static String tempFolder="/tmp/";
    public static int fileLimit= 134217728+16; // 128 Mb + 16 bytes because it guarantees to prevent index max overflow for ArrayTypes.IntArray,ArrayTypes.LongArray,ArrayTypes.DoubleArray
    private static long count=0;
    public static IntArray createIntArray(long capacity){
        MappedByteBuffer buffer;
        ArrayList<MappedByteBuffer> mappedFileBuffers;
        mappedFileBuffers=new ArrayList<MappedByteBuffer>();
        try {
            Long numOfFilesToCreate=new Long(capacity*4/fileLimit)+1;
            System.out.println("num of files to create="+numOfFilesToCreate);
            for(int i=0;i<numOfFilesToCreate;i++){
                buffer = new RandomAccessFile(tempFolder+"offheap"+(count++)+".dat", "rw")
                        .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLimit);
                mappedFileBuffers.add(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new IntArray(mappedFileBuffers,capacity);
    }

    /*duplicated to customize in future for this data types */

    public static LongArray createLongArray(long capacity){
        MappedByteBuffer buffer;
        ArrayList<MappedByteBuffer> mappedFileBuffers;
        mappedFileBuffers=new ArrayList<MappedByteBuffer>();
        try {
            Long numOfFilesToCreate=new Long(capacity*8/fileLimit)+1;

            for(int i=0;i<numOfFilesToCreate;i++){
                buffer = new RandomAccessFile(tempFolder+"offheap"+(count++)+".dat", "rw")
                        .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLimit);
                mappedFileBuffers.add(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new LongArray(mappedFileBuffers,capacity);
    }

    /*duplicated to customize in future for this data types */
    public static DoubleArray createDoubleArray(long capacity){
        MappedByteBuffer buffer;
        ArrayList<MappedByteBuffer> mappedFileBuffers;
        mappedFileBuffers=new ArrayList<MappedByteBuffer>();
        try {
            Long numOfFilesToCreate=new Long(capacity*4/fileLimit)+1;
            for(int i=0;i<numOfFilesToCreate;i++){
                buffer = new RandomAccessFile(tempFolder+"offheap"+(count++)+".dat", "rw")
                        .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLimit);
                mappedFileBuffers.add(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new DoubleArray(mappedFileBuffers,capacity);
    }


    /*duplicated to customize in future for this data types */
    public static TwoDimIntArray createTwoDimIntArray(long rcapacity,long ccapacity){
        long capacity=rcapacity*ccapacity;
        MappedByteBuffer buffer;
        ArrayList<MappedByteBuffer> mappedFileBuffers;
        mappedFileBuffers=new ArrayList<MappedByteBuffer>();
        try {
            Long numOfFilesToCreate=new Long(capacity*8/fileLimit)+1;
            for(int i=0;i<numOfFilesToCreate;i++){
                buffer = new RandomAccessFile(tempFolder+"offheap"+(count++)+".dat", "rw")
                        .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLimit);
                mappedFileBuffers.add(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TwoDimIntArray(mappedFileBuffers,rcapacity,ccapacity);
    }

    /*duplicated to customize in future for this data types */
    public static TwoDimDoubleArray createTwoDimDoubleArray(long rcapacity,long ccapacity){
        long capacity=rcapacity*ccapacity;
        MappedByteBuffer buffer;
        ArrayList<MappedByteBuffer> mappedFileBuffers;
        mappedFileBuffers=new ArrayList<MappedByteBuffer>();
        try {
            Long numOfFilesToCreate=new Long(capacity*8/fileLimit)+1;
            for(int i=0;i<numOfFilesToCreate;i++){
                buffer = new RandomAccessFile(tempFolder+"offheap"+(count++)+".dat", "rw")
                        .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLimit);
                mappedFileBuffers.add(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TwoDimDoubleArray(mappedFileBuffers,rcapacity,ccapacity);
    }

    /*duplicated to customize in future for this data types */
    public static TwoDimLongArray createTwoDimLongArray(long rcapacity,long ccapacity){
        long capacity=rcapacity*ccapacity;
        MappedByteBuffer buffer;
        ArrayList<MappedByteBuffer> mappedFileBuffers;
        mappedFileBuffers=new ArrayList<MappedByteBuffer>();
        try {
            Long numOfFilesToCreate=new Long(capacity*8/fileLimit)+1;
            for(int i=0;i<numOfFilesToCreate;i++){
                buffer = new RandomAccessFile(tempFolder+"offheap"+(count++)+".dat", "rw")
                        .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLimit);
                mappedFileBuffers.add(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TwoDimLongArray(mappedFileBuffers,rcapacity,ccapacity);
    }
}
