import java.util.ArrayList;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList
{
    public static void main(String[] args)
    {
        Node head = null;
        head = insertSorted(head,1);
        head = insertSorted(head,3);
        head = insertSorted(head,2);
        head = insertSorted(head,2);
        head = insertSorted(head,4);
        head = insertSorted(head,4);
        head = insertSorted(head,5);
        head = insertSorted(head,4);
        printList(head);
        System.out.println();
        removedups(head);
        printList(head);
        System.out.println();
        // head = insertBegin(head,30);
        // head = insertBegin(head,20);
        // head = insertBegin(head,10);
        // head = insertEnd(head,40);
        // head = insertEnd(head,50);
        // head = insertEnd(head,60);
        // printList(head);
        // System.out.println();
        // rprintList(head);
        // System.out.println();

        // head = insert(head,7,99);
        // printList(head);
        // System.out.println();

        // head = remove(head,6);
        // printList(head);
        // System.out.println();
        // findMid(head);
        // nthNode(head,2);
        // head=revList1(head);
        // printList(head);
        // System.out.println();
        // head=revList2(head);
        // printList(head);
        // System.out.println();
        // head=reverse(head);
        // printList(head);
        // System.out.println();
        // head=reverser(head,null);
        // printList(head);
        // System.out.println();
        // head = insertSorted(head,1);
        // head = insertSorted(head,2);
        // head = insertSorted(head,3);
        // head = insertSorted(head,35);
        // head = insertSorted(head,45);
        // head = insertSorted(head,55);
        // head = insertSorted(head,0);
        // printList(head);
        // System.out.println();
        // head = removeFirst(head);
        // printList(head);
        // System.out.println();

        // head = removeLast(head);
        // printList(head);
        // System.out.println();

        // head = removeFirst(head);
        // printList(head);
        // System.out.println();

        // head = removeFirst(head);
        // printList(head);
        // System.out.println();
        
    }
    //method to remove the duplicates in a sorted linked list
    public static void removedups(Node head)
    {
        Node curr = head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.data==curr.next.data)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
    }
    //recursive reverse of linked list
    public static Node reverser(Node curr,Node prev)
    {
        if(curr == null) return prev;
        Node next = curr.next;
        curr.next = prev;
        return reverser(next,curr);
    }
    //reversing the linked list without using space
    public static Node reverse(Node head)
    {
        Node curr=head, prev = null, next = null;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //reversing the linked list using extra space
    public static Node revList1(Node head)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        for(Node curr = head; curr != null; curr = curr.next)
            arr.add(curr.data);
        for(Node curr = head; curr != null; curr = curr.next)
            curr.data = arr.remove(arr.size()-1);
        return head;
    }
    //reversing the list using extra nodes or space
    public static Node revList2(Node head)
    {
        Node newHead=null;
        for(Node curr=head; curr!=null;  curr=curr.next)
        {
            Node temp = new Node(curr.data);
            temp.next = newHead;
            newHead = temp;
        }
        head = null; //unlinking the original head of the linked list to clean the space
        return newHead;
    }
    //nth node from the end of the linked list
    public static void nthNode(Node head,int n)
    {
        if(head==null || n<=0) return;
        Node first = head;
        for(int i=0;i<n;i++)
        {
            if(first==null) return;
            first = first.next;
        }
        Node second = head;
        while(first!=null)
        {
            first = first.next;
            second = second.next;
        }
        System.out.println("Nth Node from End of the Linked List: "+second.data);
    }
    //find middle node value of linked list
    public static void findMid(Node head)
    {
        if(head==null) return;
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Node Value: "+slow.data);
    }
    //insert in a sorted form in linked list
    public static Node insertSorted(Node head, int data)
    {
        Node temp = new Node(data);
        if((head == null) || (head.data > data))
        {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        while(curr.next!=null && curr.next.data<data)
        {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
    //delete at position of linked list
    public static Node remove(Node head, int pos)
    {
        if(head==null)
        {
            return null;
        }
        else if(pos==1)
        {
            return head.next;
        }
        else if(pos<=0)
        {
            return head;
        }
        Node curr = head;
        for(int i=1;i<=pos-2 && curr!=null; i++)
        {
            curr = curr.next;
        }
        if(curr==null || curr.next==null) return head;
        Node nextNode = curr.next;
        curr.next = nextNode.next;
        return head;
    }
    //delete at start of linked list
    public static Node removeFirst(Node head)
    {
        if(head==null)
            return head;
        head = head.next;
        return head;
    }
    //delete at end of linked list
    public static Node removeLast(Node head)
    {
        if(head==null)
            return null;
        else if(head.next==null)
            return null;
        Node curr = head;
        while(curr.next.next!=null)
        {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
    //insert at given position
    public static Node insert(Node head, int pos, int data)
    {
        Node temp = new Node(data);
        if(pos==1)
        {
            temp.next = head;
            return temp;
        }
        else if(pos<=0)
        {
            return head;
        }
        Node curr = head;
        for(int i=1;i<=pos-2 && curr!=null;i++)
        {
            curr = curr.next;
        }
        if(curr==null)
            return insertEnd(head,data);
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
    //insert at end of linked list
    public static Node insertEnd(Node head, int element)
    {
        Node temp = new Node(element);
        if(head==null)
            return temp;
        Node curr = head;
        while(curr.next!=null)
        {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
    //insert at begining of linked list
    public static Node insertBegin(Node head, int element)
    {
        Node temp = new Node(element);
        temp.next = head;
        return temp;
    }
    //iterative method for searching item in linked list
    public static int search(Node head,int key)
    {
        Node curr = head;
        int pos = 1;
        while(curr!=null)
        {
            if(curr.data==key)
            {
                return pos;
            }
            curr = curr.next;
            pos++;
        }
        return -1;
    }
    //recursive method for searching item in linked list
    public static int rsearch(Node head, int key)
    {
        if(head == null)
            return -1;
        if(head.data == key)
            return 1;
        else
        {
            int res = rsearch(head.next,key);
            if(res == -1) return -1;
            else return res+1;
        }
    }
    //method for printing the linked list (iterative)
    public static void printList(Node head)
    {
        Node curr = head;
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
    //method for printing the linked list (recursive)
    public static void rprintList(Node head)
    {
        if(head==null)
            return;
        System.out.print(head.data+" ");
        rprintList(head.next);
    }
}
