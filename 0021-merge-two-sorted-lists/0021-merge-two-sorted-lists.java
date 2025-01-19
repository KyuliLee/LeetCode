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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        if(list1 == null && list2 != null) {
            return list2;
        }
        if(list1 != null && list2 == null) {
            return list1;
        }
        ListNode ans = new ListNode(); // 리턴할 노드
        // ans노드 초기화
        ListNode currNode1 = list1;
        ListNode currNode2 = list2;
        if(currNode1.val <= currNode2.val) {
            ans.val = currNode1.val;
        } else {
            ans.val = currNode2.val;
        }
        
        ListNode lastNode = ans; // 임시 노드

        // curr1 또는 curr2이 없을 때까지 반복
        while(true){
            if(currNode1 == null) {
                lastNode.next = currNode2;
                break;
            }
            if(currNode2 == null) {
                lastNode.next = currNode1;
                break;
            }
            int val1 = currNode1.val;
            int val2 = currNode2.val;
            if(val1 <= val2) {
                ListNode newNode = new ListNode(val1);
                lastNode.next = newNode;
                lastNode = lastNode.next;
                currNode1 = currNode1.next;
            } else {
                ListNode newNode = new ListNode(val2);
                lastNode.next = newNode;
                lastNode = lastNode.next;
                currNode2 = currNode2.next;
            }

        }
        ans = ans.next;
        return ans;
    }
}