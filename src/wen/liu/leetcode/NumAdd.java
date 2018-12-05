package wen.liu.leetcode;

/**
 * 两数相加
 */
public class NumAdd {
	public static void main(String[] args) {
		try{
			int num1 = 451;
			int num2 = 788;
			ListNode n1 = buildNode(num1);
			ListNode n2 = buildNode(num2);
			System.out.println(n1.toInt());
			System.out.println(n2.toInt());
			System.out.println(num1+num2);
			System.out.println(addTwoNumbers(n1, n2).toInt());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode node=null;
    	ListNode curr=null;
        ListNode n1 = l1;
        ListNode n2 = l2;
        boolean hasCarry = false;
        while(n1!=null || n2!=null || hasCarry){
        	int num = (n1!=null?n1.val:0) + (n2!=null?n2.val:0) + (hasCarry?1:0);
        	
        	if(node==null){
        		node = curr = new ListNode(num%10);
        	}else{
        		curr.next = new ListNode(num%10);
        		curr = curr.next;
        	}
        	
        	hasCarry = num>9;
        	n1 = n1!=null?n1.next:null;
        	n2 = n2!=null?n2.next:null;
        }
    	return node;
    }
    
    public static ListNode buildNode(int num){
    	ListNode node = null;
    	ListNode curr = null;
    	while(num>0){
    		if(node==null){
    			node = curr = new ListNode(num%10);
    		}else{
    			curr.next = new ListNode(num%10);
    			curr = curr.next;
    		}
    		num /= 10;
    	}
    	return node;
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	ListNode(int x, ListNode next) {
		val = x;
		this.next=next;
	}
	
	public int toInt(){
		int num=val;
		int pow=1;
		ListNode nextNode = next;
		while(nextNode!=null){
			num += Math.pow(10, pow++)*nextNode.val;
			nextNode = nextNode.next;
		}
		return num;
	}
}
