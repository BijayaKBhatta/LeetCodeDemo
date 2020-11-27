/*Intuition

The main idea is to delete the duplicate element. We need to travese the linked list and if you find elements are dupplicate then move the previous pointer to next value which is not repeating 

Algorithm

We start from begining of the list and take a previous pointer initially pointing to null. Once you found repeated value we will update the next pointer of previous node to non repeating node.
*/
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
