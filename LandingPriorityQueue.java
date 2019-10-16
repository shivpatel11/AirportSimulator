public class LandingPriorityQueue<T extends Comparable<T> & Updatable>
{
    private Node firstNode = null;
    private int size=0;

    private class Node
    {
        T value;
        Node next = null;
        private Node(T c)
        {
            value = c;
        }
        public String toString()
        {
            return value.toString();
        }
    }

    public void add(T c)
    {
        Node newNode = new Node(c);
        if (firstNode == null)
        {
            firstNode = newNode;
            newNode.next = null;
            size++;
            return;
        }

        int compare = newNode.value.compareTo(firstNode.value);
        if (compare < 0)
        {
            newNode.next = firstNode;
            firstNode = newNode;
            size++;
            return;
        }

        for (Node iterator = firstNode;iterator != null;iterator = iterator.next)
        {
            if(iterator.next == null)
            {
                iterator.next = newNode;
                size++;
                return;
            }

            Node nextNode = iterator.next;
            if(nextNode.value.compareTo(newNode.value) > 0)
            {
                iterator.next = newNode;
                newNode.next = nextNode;
                size++;
                return;
            }
        }
    }

    public T remove()
    {
        if (isEmpty())
        {
            return null;
        }
        T data = firstNode.value;
        firstNode = firstNode.next;
        size--;
        return data;
    }

    public void updateValues()
    {
        for(Node iterator = firstNode;iterator != null;iterator = iterator.next)
        {
            iterator.value.update();
        }
    }

    public boolean isEmpty()
    {
        return size <= 0;
    }

    public T peek()
    {
        return firstNode.value;
    }

    public int getSize()
    {
        return size;
    }

    public void clear()
    {
        firstNode = null;
    }
}
