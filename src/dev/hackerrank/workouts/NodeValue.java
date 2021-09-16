package dev.hackerrank.workouts;

import java.util.Scanner;

public class NodeValue {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep){
        while (node != null) {
            System.out.println (String.valueOf(node.data));
            node = node.next;
            if (node != null) {
                System.out.println (sep);
            }
        }
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        int pos=getPosition(llist)-positionFromTail;
        int num=1;
        while (llist != null) {
            if(pos==num) {
                return llist.data;
            }
            llist = llist.next;
            num++;
        }
        return 0;
    }

    public static int getPosition(SinglyLinkedListNode llist){
        SinglyLinkedListNode temp=llist;
        int pos=0;
        while(temp!=null){
            pos++;
            temp=temp.next;
        }
        return pos;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testsItr = 0; testsItr < tests; testsItr++) {
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
            int result = getNode(llist.head, position);
            System.out.println (String.valueOf(result));
        }
        scanner.close();
    }
}
