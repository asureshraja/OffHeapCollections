import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Example
{
    static int length = 0x8FFFFFF; // 128 Mb

    public static void main(String[] args) throws Exception
    {
        MappedByteBuffer out = new RandomAccessFile("/tmp/offheap0.dat", "rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
//        for (int i = 0; i < 10; i++)
//        {
//             out.putInt(i*4,i);
//        }
//        System.out.println("Finished writing");
        for (int i = 0; i < 1000; i++)
        {
            System.out.println(out.getInt(i*4));
        }
        System.out.println("Finished reading");
    }
}