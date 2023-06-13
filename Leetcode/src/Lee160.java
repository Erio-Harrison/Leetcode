package src;

public class Lee160 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode point1=headA;
            ListNode point2=headB;
            int count1=0;
            int count2=0;
            while(point1!=null){
                count1+=1;
                point1=point1.next;
            }
            while(point2!=null){
                count2+=1;
                point2=point2.next;
            }
            point1=headA;
            point2=headB;
            if(count2>count1){
                int count=count2-count1;
                while(count>0){
                    point2=point2.next;
                    count--;
                }
            }
          if(count1>count2){
              int count=count1-count2;
              while(count>0){
                  point1=point1.next;
                  count--;
              }
          }
          while(point1!=null){
              if(point1==point2){
                  return point1;
              }else{
                  point1=point1.next;
                  point2=point2.next;
              }
          }
          return null;
      }

}
