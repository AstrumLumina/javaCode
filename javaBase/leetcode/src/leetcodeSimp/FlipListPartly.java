package leetcodeSimp;
/*
���������ͷ�ڵ� head ��ÿ?k?���ڵ�һ����з�ת�����㷵���޸ĺ������

k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��

�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����

 */
public class FlipListPartly {
    public static void main(String[] args) {

    }
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)
            return head;
        ListNode newhead=new ListNode();
        ListNode lastpart=newhead;
        int i;
        ListNode before;
        ListNode after;
        ListNode start;
        ListNode end = null;

        while(true){
            i=1;
            start=before=head;
            if(head==null){
               lastpart.next=null;//����ǰ��β�ڵ��ÿ�
                return newhead.next;
            }
            head=head.next;
            while(i<k){
                if(head==null){
                    break;
                }
                after=head.next;
                head.next=before;
                end=before=head;
                head=after;
                ++i;
            }
            if(i!=k){
                if(i==1){
                    end=start;//��ֹi=1��,endδ��ֵ��,��ʵ��end��ǰһ��ֵ
                }
                head=start=before=end;
                head=head.next;
                while(i>1){
                    after=head.next;
                    head.next=before;
                    end=before=head;
                    head=after;
                    --i;
                }
                lastpart.next=end;
                start.next=null;
                return newhead.next;
            }
            lastpart.next=end;
            lastpart=start;
        }
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }

     */
    }

