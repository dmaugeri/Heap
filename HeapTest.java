import java.util.*;

public class HeapTest
{
    public static final String SEPARATOR = "-------";
    public static void main(String[] args)
    {
        Heap<Integer> heap = new Heap<Integer>();
        heap.insertValue(4);
        heap.insertValue(6);
        heap.insertValue(3);
        heap.insertValue(10);
        heap.insertValue(2);
        heap.insertValue(9);
        heap.insertValue(9);
        heap.insertValue(8);
        heap.insertValue(15);
        heap.insertValue(12);
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
    }
}
