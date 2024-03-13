public class Array {

    private Node head = null;
    public void add(int value){
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currentNode = head;
        while(currentNode.getNext() != null){
         currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
    }
    public int get(int index){
        if(head == null){
           throw new ArrayIndexOutOfBoundsException();
        }
        int counter = 0;
        Node currentNode = head;

        while(counter != index){
            currentNode = currentNode.getNext();
            counter++;
        }
        return currentNode.getValue();
    }
}
