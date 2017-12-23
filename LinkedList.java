package acm;

import java.util.*;

/**
 * This class Written by prog.ghofran abdelwahab (LinkedList)
 *
 * @author GhofranAbdelwahab
 * @version 1.0
 */
public class LinkedList {

    Node Root;

    public LinkedList(Node n) {
        this.Root = n;
    }

    public void addFront(int val) {
        Node n = new Node(val);
        n.next = Root;
        Root = n;
    }

    public void addRear(int val) {
        Node n = new Node(val);
        Node start = Root;
        while (start.next != null) {
            start = start.next;
        }
        start.next = n;
    }

    public void addIdx(int val, int idx) {
        Node node = new Node(val);
        idx--;
        if (idx <= 0) {
            addFront(val);
            return;
        }
        Node start = Root;
        while (--idx != 0 && start.next != null) {
            start = start.next;
        }
        node.next = start.next;
        start.next = node;
    }

    public void printLinkedList() {
        Node start = Root;
        while (start != null) {
            System.out.print(start.value + "->");
            start = start.next;
        }
        System.out.println("NULL");
    }

    public void deleteFront() {
        Node start = Root;
        Root = Root.next;
        start = null;
    }

    public void deleteRear() {
        Node start = Root;
        while (start.next.next != null) {
            start = start.next;
        }
        Node node = start.next;
        start.next = null;
        node = null;
    }

    public int getRearDeleteRear() {
        Node start = Root;
        while (start.next.next != null) {
            start = start.next;
        }
        Node node = start.next;
        start.next = null;
        int val = node.value;
        //System.out.println(">>"+val);
        node = null;
        return val;

    }

    public void reversLinkedList() {
        Node start = Root;
        int idx = 1;
        while (start.next != null) {
            this.addIdx(this.getRearDeleteRear(), idx++);
        }
    }

    public int getNthNodeLinkedList(int idx) {
        int val = Integer.MIN_VALUE;
        Node start = Root;
        while (--idx != 0 && start.next != null) {
            start = start.next;

        }

        return val = start.value;
    }

    public void deleteMiddleNode() {
        //Cracking The Coding interview
        Node slow = Root;
        Node fast = Root;
        Node prevSlow = Root;
        while (fast.next != null && fast.next.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = slow.next;
        slow = null;
    }

    public void deleteDups() {//Cracking The Coding interview
        HashSet<Integer> set = new HashSet<Integer>();
        Node start = Root;
        Node prev = null;
        while (start != null) {
            if (set.contains(start.value)) {
                prev.next = start.next;
            } else {
                prev = start;
                set.add(start.value);
            }
            start = start.next;

        }
    }

    public boolean hasCycle(Node head) {

        Node slow= head;
        Node fast=head;
        while(head!=null&&fast.next!=null&&fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow== fast)
                return true;
        }
        System.out.println("");
        return false;
    }
void ReversePrint(Node head) {
  ArrayList<Integer> arr= new ArrayList<>();
  Node q = head;
  while(q!=null){
      arr.add(q.value);
      q=q.next;
  }
  Collections.reverse(arr);
    for(int i = 0 ; i< arr.size() ; i ++)
    {
        System.out.println(arr.get(i));
    }
        
}


//    public void deleteIdx(int idx)
//    {
//        Node start = Root;
//        
//    }
//    public void deleteFirstVal(int val)
//    {
//        
//    }
}
