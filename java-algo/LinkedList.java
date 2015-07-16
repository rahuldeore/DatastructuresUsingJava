class LinkedList
{
	public static void main(String args[])
	{
		LNode head = new LNode();
		reverseLinkedList list = new reverseLinkedList();
		head = list.insert(1, head);
		head = list.insert(2, head);
		head = list.insert(3, head);
		head = list.insert(4, head);
		head = list.insert(5, head);
		list.printList(head);
		
		LNode rHead = new LNode();
		rHead = list.reverse(head);
		list.printList(rHead);
		
		LNode hrHead = new LNode();
		hrHead = list.halfReverse(head);
		list.printList(hrHead);
		System.out.println("\nProgram Completed...");
	}
}