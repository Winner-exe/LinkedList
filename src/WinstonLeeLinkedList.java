public class WinstonLeeLinkedList<E>
{
    private Node<E> first;

    public boolean add(E e)
    {
        if (first == null)
        {
            first = new Node<E>(e);
            return true;
        }

        return false;
    }
}