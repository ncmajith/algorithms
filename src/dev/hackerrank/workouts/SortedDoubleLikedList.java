package dev.hackerrank.workouts;

import java.util.Scanner;

public class SortedDoubleLikedList {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }
    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;
        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }
            this.tail = node;
        }
    }
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode current;
        DoublyLinkedListNode newNode=new DoublyLinkedListNode (data);
        if (llist == null)
            llist = newNode;
        else if (llist.data >= newNode.data) {
            newNode.next = llist;
            newNode.next.prev = newNode;
            llist = newNode;
        }
        else {
            current = llist;
            while (current.next != null &&
                    current.next.data < newNode.data)
                current = current.next;
            newNode.next = current.next;
            if (current.next != null)
                newNode.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
        }
        return llist;
    }
    public static void printDoublyLinkedList(DoublyLinkedListNode node){
        while (node != null) {
            System.out.println (String.valueOf(node.data));
            node = node.next;
        }
    }
    private static final Scanner scanner = new Scanner (System.in);
    public static void main(String[] args){
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();
            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                llist.insertNode(llistItem);
            }
            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);
            printDoublyLinkedList(llist1);
        }
        scanner.close();
    }
}
