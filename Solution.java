/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
         ListNode currentNode = head; 
         ListNode prev = null;
        
        while(currentNode != null){
            ListNode nextNode =  currentNode.next;
            if(nextNode!=null){
                if(currentNode.val==nextNode.val){
                    ListNode temp = deleteSameNodes(currentNode);
                    if(prev==null)
                        head=temp;
                    else{
                        prev.next=temp;
                    }
                    currentNode = temp;
                    continue;
                    
                }
            }
            prev=currentNode;
            currentNode=currentNode.next;
            
        }
        return head;
    }
    public ListNode deleteSameNodes(ListNode currentNode)
    {
        ListNode next = currentNode.next;
        while(next!=null && currentNode.val==next.val){
            next=next.next;
        }
        return next;
    }
}
