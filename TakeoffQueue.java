import java.util.EmptyStackException;

public class TakeoffQueue<T>
{
    private Node firstNode;
    private Node lastNode;
    private int counter;

    public TakeoffQueue()
    {
        firstNode = null;
        lastNode = null;
        counter = 0;
    }

    public void enqueue(T newEntry)
    {
        Node newNode = new Node(newEntry, null);
        if (isEmpty())
        {
            firstNode = newNode;
        } else
        {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        counter++;
    }

    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T data = firstNode.data;
        firstNode = firstNode.next;
        counter--;
        return data;
    }

    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException("No planes for takeoff");
        }
        return firstNode.getData();
    }

    public boolean isEmpty()
    {
        return firstNode == null;
    }

    public void clear()
    {
        firstNode = lastNode = null;
    }

    public int getSize()
    {
        return counter;
    }

    private class Node
    {
        private T data;
        private Node next;

        private Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        private T getData()
        {
            return data;
        }

        private Node getNextNode()
        {
            return next;
        }

        private void setNextNode(Node next)
        {
            this.next = next;
        }
    }
}
