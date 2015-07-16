public class BSTree
{
	public Node root;
	public BSTree()
	{
		//default constructor
		System.out.println("Binary Search Tree Initialized.\n");
	}
	public BSTree insert(int value)
	{
		Node node = new Node(value);
		if (root == null)
		{
			root = node;
			return this;
		}
		insertRecord(root, node);
		return this;
	}
	public void insertRecord(Node latestRoot, Node newNode)
	{
		if (latestRoot.value > newNode.value)
		{
			if (latestRoot.left == null)
			{
				latestRoot.left = newNode;
				return;
			}
			else
				insertRecord(latestRoot.left, newNode);
		}
		else
		{
			if (latestRoot.right == null)
			{
				latestRoot.right = newNode;
				return;
			}
			else
				insertRecord(latestRoot.right, newNode);
		}
	}
	public void sort()
	{
		if (root == null)
			return;
		traverseInorder(root);
		System.out.println("");
	}
	public void traverseInorder(Node latestRoot)
	{
		if (latestRoot.left != null)
			traverseInorder(latestRoot.left);
		
		System.out.print(latestRoot.value + "\t");
		
		if (latestRoot.right != null)
			traverseInorder(latestRoot.right);
			

		/*if (latestRoot == null)
			return;
		traverseInorder(latestRoot.left);
		System.out.print(latestRoot.value + "\t");
		traverseInorder(latestRoot.right);*/
	}
}