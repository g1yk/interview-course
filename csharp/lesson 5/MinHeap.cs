public class MinHeap
{
    private int[] items;
    private int count;

    public MinHeap(int capacity)
    {
        items = new int[capacity + 1];
    }

    public int Size()
    {
        return count;
    }

    public void Add(int key)
    {
        count++;
        items[count] = key;
        Swim (count);
    }

    public int Poll()
    {
        var result = items[1];
        Swap(1, count);
        count--;
        Sink(1);
        return result;
    }

    private void Swim(int k)
    {
        while (k > 1 && Greater(k / 2, k))
        {
            Swap(k / 2, k);
            k = k / 2;
        }
    }

    private void Sink(int k)
    {
        while (2 * k <= count)
        {
            var j = 2 * k;
            if (j < count && Greater(j, j + 1))
            {
                j++;
            }

            if (!Greater(k, j))
            {
                break;
            }

            Swap (k, j);
            k = j;
        }
    }

    private void Swap(int i, int j)
    {
        var temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private bool Greater(int i, int j)
    {
        return items[i] > items[j];
    }
}
