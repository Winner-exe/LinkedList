public class Node<E>
{
    private E obj;
    private Node<E> pointer;

    public Node(E obj)
    {
        this.obj = obj;
    }

    public Node<E> next()
    {
        return pointer;
    }

    public void setPointer(Node<E> pointer)
    {
        this.pointer = pointer;
    }
}