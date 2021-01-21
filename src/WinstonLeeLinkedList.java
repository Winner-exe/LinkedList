import java.util.Iterator;

@SuppressWarnings("UnusedReturnValue")
public class WinstonLeeLinkedList<E> implements Iterable<E>
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
        if (index > 0 && index < size())
        {
            Node<E> cursor = head;
            int count = 0;

            //Transverse to node at position (index-1)
            while (count < index - 1) {
                cursor = cursor.next;
                count += 1;
            }

            Node<E> insert = new Node<>(e);
            insert.next = cursor.next;
            cursor.next = insert;
        }
        else if (index == 0)
            add(e);
        else
            throw new IndexOutOfBoundsException();
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
        while (cursor != null && cursor.next != null)
            cursor = cursor.next;

        assert cursor != null;
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
        while (cursor != null && cursor.next != null)
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
            while (count < index)
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
        while (cursor != null && cursor.next != null)
            cursor = cursor.next;

        assert cursor != null;
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
        if (index > 0 && index < size())
        {
            int count = 0;
            Node<E> cursor = head;

            //Transverse to specified index - 1
            while (count < index - 1)
            {
                cursor = cursor.next;
                count++;
            }

            E obj = cursor.next.obj;
            cursor.next = cursor.next.next;

            return obj;
        }
        else if (index == 0)
            return remove();
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
        if (index > 0 && index < size())
        {
            int count = 0;
            Node<E> cursor = head;

            //Transverse to specified index - 1
            while (count < index - 1)
            {
                cursor = cursor.next;
                count++;
            }

            E obj = cursor.next.obj;

            Node<E> insert = new Node<>(e);
            insert.next = cursor.next.next;
            cursor.next = insert;

            return obj;
        }
        else if (index == 0)
        {
            E obj = head.obj;

            Node<E> insert = new Node<>(e);
            insert.next = head.next;
            head = insert;

            return obj;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public int size()
    {
        if (head == null)
            return 0;

        int count = 1;
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
    public Iterator<E> iterator() {
        return new NodeIterator();
    }

    protected class NodeIterator implements Iterator<E>
    {
        private Node<E> cursor;

        public NodeIterator()
        {
            cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            Node<E> current = cursor;
            cursor = cursor.next;
            return current.obj;
        }
    }
}