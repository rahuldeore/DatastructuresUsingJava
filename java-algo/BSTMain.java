class BSTMain
{
	public static void main(String args[])
	{
		BSTree tree = new BSTree();
		tree.insert(50);
		tree.insert(45);
		tree.insert(55);
		tree.insert(90);
		tree.insert(25);
		tree.insert(10);
		tree.insert(101);
		tree.insert(75);
		tree.insert(67);
		tree.insert(19);
		tree.insert(1);
		tree.insert(22);
		tree.insert(79);
		tree .insert(22)
			 .insert(33);
		tree.sort();
		System.out.println("Done.");
	}
}