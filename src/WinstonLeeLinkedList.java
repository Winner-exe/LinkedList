import java.util.Iterator;

public class WinstonLeeLinkedList<E> implements Iterable<Node<E>>
{
    private Node<E> head;

    public boolean add(E e)
    {
        if (head == null) {
            head = new Node<>(e);
        }
        else
        {
            Node<E> cursor = head;

            //Transverse to tail
            while (cursor.next != null)
                cursor = cursor.next;

            cursor.next = new Node<>(e);
        }
        return true;
    }

    public void add(int index, E e)
    {
        Node<E> cursor = head;
        int cursorIndex = 0;

        //Transverse to node at position (index-1)
        while (cursorIndex != index - 1)
        {
            cursor = cursor.next;
            cursorIndex += 1;
        }

        Node<E> insert = new Node<>(e);
        insert.next = cursor.next;
        cursor.next = insert;
    }

    public void addFirst(E e)
    {
        Node<E> insert = new Node<>(e);
        insert.next = head;
        head = insert;
    }

    public void addLast(E e)
    {
        Node<E> cursor = head;

        //Transverse to tail
        while (cursor.next != null)
            cursor = cursor.next;

        cursor.next = new Node<>(e);
    }

    public void clear()
    {
        head = null;
    }

    public boolean contains(Object o)
    {
        Node<E> cursor = head;

        //Transverse to tail
        while (cursor.next != null)
        {
            if (o.equals(cursor.obj))
                return true;
            cursor = cursor.next;
        }

        return false;
    }

    public E get(int index) throws IndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
        {
            int count = 0;
            Node<E> cursor = head;

            //Transverse to specified index
            while (count != index)
            {
                cursor = cursor.next;
                count++;
            }

            return cursor.obj;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public E getFirst()
    {
        return head.obj;
    }

    public E getLast()
    {
        Node<E> cursor = head;

        //Transverse to tail
        while (cursor.next != null)
            cursor = cursor.next;

        return cursor.obj;
    }

    public int indexOf(Object o)
    {
        int index = 0;
        Node<E> cursor = head;

        //Transverse to tail
        while (cursor.next != null)
        {
            if (o.equals(cursor.obj))
                return index;

            cursor = cursor.next;
            index++;
        }

        return -1;
    }

    public E remove()
    {
        E obj = head.obj;
        head = head.next;
        return obj;
    }

    public E remove(int index)
    {
        if (index >= 0 && index < size())
        {
            int count = 0;
            Node<E> cursor = head;

            //Transverse to specified index - 1
            while (count != index - 1)
            {
                cursor = cursor.next;
                count++;
            }

            E obj = cursor.next.obj;
            cursor.next = cursor.next.next;

            return obj;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public E removeFirst()
    {
        E obj = head.obj;
        head = head.next;
        return obj;
    }

    public E set(int index, E e)
    {
        if (index >= 0 && index < size())
        {
            int count = 0;
            Node<E> cursor = head;

            //Transverse to specified index - 1
            while (count != index - 1)
            {
                cursor = cursor.next;
                count++;
            }

            E obj = cursor.obj;

            Node<E> insert = new Node<>(e);
            insert.next = cursor.next.next;
            cursor.next = insert;

            return obj;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public int size()
    {
        int count = 0;
        Node<E> cursor = head;

        //Transverse to tail
        while (cursor.next != null)
        {
            cursor = cursor.next;
            count++;
        }

        return count;
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return new NodeIterator();
    }

    protected class NodeIterator implements Iterator<Node<E>>
    {
        private Node<E> cursor;

        public NodeIterator()
        {
            cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public Node<E> next() {
            Node<E> current = cursor;
            cursor = cursor.next;
            return current;
        }
    }
}