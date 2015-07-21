public class reverseLinkedList
{
	public static LNode insert(int val, LNode head)
	{
		
		LNode newNode = new LNode(), temp = head;
		if (head.value == -1)
		{
			head.value = val;
			head.next = null;
			return head;
		}
		while (temp.next != null)
			temp = temp.next;
		newNode.value = val;
		temp.next = newNode;
		return head;
	}
	public static LNode reverse(LNode list)
	{
		LNode nHead = new LNode(), nTail = new LNode();
		LNode temp = list;
		boolean tail = false;
		
		if (temp != null)
		{
			while(temp.next != null)
			{
				if (tail == false)
				{
					tail = true;
					LNode tmp = new LNode();
					tmp.value = temp.value;
					tmp.next = null;
					nHead = nTail = tmp;
				}
				else
				{
					LNode tmp = new LNode();
					tmp.value = temp.value;
					tmp.next = nHead;
					nHead = tmp;
				}
				temp = temp.next;
			}
			LNode tmp = new LNode();
			tmp.value = temp.value;
			tmp.next = nHead;
			nHead = tmp;
		}
		return nHead;
	}
	public static LNode halfReverse(LNode list)
	{
		int rnCount = 0, count = 0, onCount = 0;
		LNode temp = list;
		// count the total length of list
		while (temp.next != null)
		{
			count++;
			temp = temp.next;
		}
		rnCount = (count + 1) / 2;
		onCount = count - rnCount;
		
		// copy first half as it is
		LNode nHead2 = new LNode(), nTail2 = new LNode();
		temp = list;
		while (onCount != 0)
		{
			if (nHead2.value == -1)
			{
				nHead2.value = temp.value;
				nHead2.next = null;
				nTail2 = nHead2;
			}
			else
			{
				LNode tmp = new LNode();
				tmp.value = temp.value;
				tmp.next = null;
				nTail2.next = tmp;
				nTail2 = tmp;
			}
			temp = temp.next;
			onCount -= 1;
		}
		
		//copy second half in reverse list. temp already point to third node
		LNode halfHead = new LNode();
		while (rnCount != 0)
		{
			if (halfHead.value == -1)
			{
				halfHead.value = temp.value;
				halfHead.next = null;			
			}
			else
			{
				LNode tmp = new LNode();
				tmp.value = temp.value;
				tmp.next = halfHead;
				halfHead = tmp;
			}
			rnCount--;
			temp = temp.next;
		}
		LNode tmp = new LNode();
		tmp.value = temp.value;
		tmp.next = halfHead;
		halfHead = tmp;		
		nTail2.next = halfHead;
		return nHead2;
	}
	
	public static void printList(LNode head)
	{
		LNode temp = head;
		System.out.println();
		if (temp != null)
		{
			while (temp.next != null)
			{
				System.out.print(temp.value + "\t");
				temp = temp.next;
			}
			System.out.print(temp.value + "\t");
		}
	}
}