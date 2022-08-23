package leetcodeSimp;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *题目数据保证链表已经按升序 排列
 */


public class LInklistdel {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode before=head;
        ListNode located=head;
        if(located!=null){
            located=located.next;
            while(located!=null){
                if(before.val==located.val){
                      before.next=located.next;
                } else{
                    before=before.next;
                }
                located=located.next;
            }
        }
        return head;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }