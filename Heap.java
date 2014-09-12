import java.util.*;

public class Heap<T extends Comparable<T>>
{
    private ArrayList<T> heap;

    public Heap()
    {
        heap = new ArrayList<T>();
    }

    public void insertValue(T value)
    {
        heap.add(value);
        siftUp();
    }

    public T delete()
    {
        if (heap.isEmpty())
            return null;

        T value = heap.get(0);
        T newTemporaryRoot = heap.get(heap.size() - 1);
        heap.set(0, newTemporaryRoot);
        heap.remove(heap.size() - 1);
        siftDown();
        return value;
    }

    private void siftDown()
    {
        int currentRootElementIndex = 0; 
        int size = heap.size();

        int leftChildIndex = (currentRootElementIndex * 2) + 1;
        int rightChildIndex = (currentRootElementIndex * 2) + 2;

        while (currentRootElementIndex < size && leftChildIndex < size && rightChildIndex < size)
        {
            T currentRootElement = heap.get(currentRootElementIndex);
            T leftChild = heap.get(leftChildIndex);
            T rightChild = heap.get(rightChildIndex);

            if (leftChild.compareTo(rightChild) > 0)
            {
                if (leftChild.compareTo(currentRootElement) > 0)
                {
                    swapPositionsInHeap(leftChildIndex, currentRootElementIndex);
                    currentRootElementIndex = leftChildIndex;
                }
                else
                    break;
            }
            else if (leftChild.compareTo(rightChild) < 0)
            {
                if (rightChild.compareTo(currentRootElement) > 0)
                {
                    swapPositionsInHeap(rightChildIndex,currentRootElementIndex);
                    currentRootElementIndex = rightChildIndex;
                }
                else
                    break;
            }
            else if (leftChild.compareTo(rightChild) == 0)
            {
                if (leftChild.compareTo(currentRootElement) > 0)
                {
                    swapPositionsInHeap(leftChildIndex,currentRootElementIndex);
                    currentRootElementIndex = leftChildIndex;
                }
                else
                    break;
            }
            leftChildIndex = (currentRootElementIndex * 2) + 1;
            rightChildIndex = (currentRootElementIndex * 2) + 2;
        }
    }

    private void siftUp()
    {
        int newItemIndex = heap.size() - 1;
        while (newItemIndex > 0)
        {
            int parentIndex = (newItemIndex - 1) / 2;
            T parentElement = heap.get(parentIndex);
            T currentElement = heap.get(newItemIndex);

            if (currentElement.compareTo(parentElement) > 0)
            {
                swapPositionsInHeap(newItemIndex, parentIndex);
                newItemIndex = parentIndex;
            }
            else
                break;
        }
    }

    private void swapPositionsInHeap(int firstIndex, int secondIndex)
    {
        T tmp = heap.get(firstIndex);

        heap.set(firstIndex, heap.get(secondIndex));
        heap.set(secondIndex, tmp);
    }
    
    public String toString()
    {
        return heap.toString();
    }
}
