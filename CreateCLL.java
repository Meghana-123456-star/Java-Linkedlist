import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
class CircularLL
{
    Node head;
    Node tail;
    void insertFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            tail.next=head;
            return;
        }
        newNode.next=head;
        tail.next=newNode;
        head=newNode;
    }
    void insertLast(int data){
        Node newNode=new Node(data);
         if(head==null){
            head=tail=newNode;
            tail.next=head;
            return;
        }
       tail.next=newNode;
       newNode.next=head;
       tail=newNode;
    }
    void insertIndex(int data,int index){
        if(index==0){
            insertFirst(data);
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
           temp=temp.next;
        }
         if (temp == head) {
            System.out.println("Invalid Position");
            return;
        }
    Node newNode = new Node(data);
    newNode.next = temp.next;
    temp.next = newNode;
    // If inserted after tail, update tail
    if (temp == tail) {
        tail = newNode;
    }
    }

    void deleteFirst(){
        if(head==null){
            System.out.println("nothing to delete");
            return;
        }
         if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    void deleteLast(){
         if (head == null)
            return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    public void display() 
    {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }
}

public class CreateCLL {

    public static void main(String[] args) {

        CircularLL list = new CircularLL();

        list.insertFirst(20);
        list.insertFirst(10);

        list.insertLast(30);
        list.insertLast(40);

        list.display();
        list.insertIndex(50,3);

        list.display();

        list.deleteFirst();
        list.display();

        list.deleteLast();
        list.display();
    }
}
