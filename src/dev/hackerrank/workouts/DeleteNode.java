package dev.hackerrank.workouts;

import java.util.Scanner;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;
    public SinglyLinkedListNode ( int nodeData ) {
        this.data = nodeData;
        this.next = null;
    }
}
class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;
    public SinglyLinkedList () {
        this.head = null;
        this.tail = null;
    }
    public void insertNode ( int nodeData ) {
        SinglyLinkedListNode node = new SinglyLinkedListNode (nodeData);
        if (this.head == null) {
            this.head = node;
        }
        else {
            this.tail.next = node;
        }
        this.tail = node;
    }
}
public class DeleteNode {
    private static final Scanner scanner = new Scanner(System.in);
    public static SinglyLinkedListNode deleteNode( SinglyLinkedListNode llist, int position) {
        SinglyLinkedListNode sampleHead=null;
        SinglyLinkedListNode sampleTail=null;
        int index=0;
        while(llist!=null) {
            if(position!=index) {
                var node = new SinglyLinkedListNode (llist.data);
                if (sampleHead == null) {
                    sampleHead = node;
                }
                else {
                    sampleTail.next = node;
                }
                sampleTail = node;
            }
            llist=llist.next;
            index++;
        }
        return sampleHead;
    }
    public static void printSinglyLinkedList ( SinglyLinkedListNode node, String sep){
        while (node != null) {
            System.out.print(String.valueOf (node.data));
            node = node.next;
            if (node != null) {
                System.out.print(sep);
            }
        }
    }
    public static void main(String[] args){
        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            llist.insertNode(llistItem);
        }
        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        SinglyLinkedListNode llist1 = deleteNode(llist.head, position);
        printSinglyLinkedList(llist1, " ");
        scanner.close();
    }
}
