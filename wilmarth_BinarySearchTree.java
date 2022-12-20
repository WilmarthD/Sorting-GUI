

public class wilmarth_BinarySearchTree implements BinarySearchTreeFunctions
{
	private Node root;
	
	public wilmarth_BinarySearchTree()
	{
		root = null;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void setRoot(Node root)
	{
		if(root != null)
		{
			root.setParent(null);
		}
		this.root = root;
	}
	
	public void insertNode(Node z)
	{
		Node currentNode = this.getRoot();
		Node previousNode = null;
			
		while (currentNode != null)
		{
			//Save node location incase current is null
			previousNode = currentNode;
			
			if(z.getKey() < currentNode.getKey())
			{
				currentNode = currentNode.getLeft();
			}
			else if(z.getKey() > currentNode.getKey())
			{
				currentNode = currentNode.getRight();
			}
		}//end while loop
		z.setParent(previousNode);
		
		//Check if node is new
		if(previousNode == null)
		{
			//Set node to root
			this.setRoot(z);
		}
		else
		{	
			if(z.getKey() < previousNode.getKey())
			{
				//Set new node as child
				previousNode.setLeft(z);
			}
			else
			{
				//Set new node as child
				previousNode.setRight(z);
			}
		}

	}
	
	public void updateNode(Node z)
	{
		Node currentNode = this.getRoot();
	
		//If insert node exists
		if(z != null)
		{
			while ((currentNode != null) && (z.getKey() != currentNode.getKey()))
			{
				if(z.getKey() < currentNode.getKey())
				{
					currentNode = currentNode.getLeft();
				}
				else if(z.getKey() > currentNode.getKey())
				{
					currentNode = currentNode.getRight();
				}
			}
			//Check if node is new and not null
			if(z.getKey() == currentNode.getKey())
			{
				//update data
				currentNode.setData(z.getData());
				
			}
			else
			{
				//Node not found in tree to update
				System.out.println("node reading as non-existant");
			}
		}
		else
		{
			//Node inserted doesn't exist/is null
			System.out.println("new node reading as null");
		}
	}
	
	public void preOrderWalk(Node x)
	{
		if( x != null )
		{
			System.out.println(x.toString());
			preOrderWalk(x.getLeft());
			preOrderWalk(x.getRight());
		}
	}
	
	public void preOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null )
		{
			list.add(x.toString());
			preOrderWalk(x.getLeft(), list);
			preOrderWalk(x.getRight(), list);
		}
	}
	
	public void preOrderWalk(Node x, String id, java.util.ArrayList<String> result)
	{
		if( x != null )
		{
			System.out.println(x.toString() + " " + id);
			result.add(x.getKey() + " " + id);
			preOrderWalk(x.getLeft(), "0"+id, result);
			preOrderWalk(x.getRight(), "1"+id, result);
		}
	}
	
	public void inOrderWalk(Node x)
	{
		if (x != null)
		{
			inOrderWalk(x.getLeft());
			//Add node
			System.out.println(x.toString());
			//Now show the other side some love
			inOrderWalk(x.getRight());
		}
	}
	
	public void inOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if (x != null)
		{
			inOrderWalk(x.getLeft(), list);
			//Add node
			list.add(x.toString());
			//Now show the other side some love
			inOrderWalk(x.getRight(),list);
		}
	}
	
	public void postOrderWalk(Node x)
	{
		if(x != null)
		{
			postOrderWalk(x.getLeft());
			postOrderWalk(x.getRight());
			//Add node at end
			System.out.println(x.toString());
		}
	}
	
	public void postOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if(x != null)
		{
			postOrderWalk(x.getLeft(), list);
			postOrderWalk(x.getRight(), list);
			//Add node at end
			list.add(x.toString());
		}
	}
		
	public Node getMax(Node x)
	{
		Node currentNode = x;
		
		while (currentNode.getRight() != null)
		{
			currentNode = currentNode.getRight();
		}
		return currentNode; 
	}
	
	public Node getMin(Node x)
	{
		Node currentNode = x;
		
		while (currentNode.getLeft() != null)
		{
			currentNode = currentNode.getLeft();
		}
		return currentNode;
	}
	//Smallest node greater than the given node
	public Node getSuccessor(Node x)
	{
		Node successor = x;
		Node parentNode;

		if(successor.getRight() != null)
		{
			return getMin(successor.getRight());
		}
		parentNode = successor.getParent();
		
		//No predecessor exists
		while((parentNode != null) && (successor == parentNode.getRight()))
		{
			successor = parentNode;
			parentNode = parentNode.getParent();
			
		}
		return parentNode;
	}
	//Biggest node smaller than the given node
	public Node getPredecessor(Node x)
	{
		Node predecessor = x;
		Node parentNode;

		if(predecessor.getLeft() != null)
		{			
			return getMax(predecessor.getLeft());
		}
		parentNode = predecessor.getParent();
		
		//No predecessor exists
		while((parentNode != null) && (predecessor == parentNode.getLeft()))
		{
			predecessor = parentNode;
			parentNode = parentNode.getParent();
			
		}
		return parentNode;
	}
	
	public Node getNode(Node x, int key)
	{
		if(x == null || key == x.getKey())
		{
			return x;
		}
		if(key < x.getKey())
		{
			return getNode(x.getLeft(), key);
		}
		else
		{
			return getNode(x.getRight(), key);
		}
	}
	///Get height of a given node
	public int getHeight(Node x)
	{
		if(x == null) {return -1;}
		
		int leftHeight = getHeight(x.getLeft());
		int rightHeight = getHeight(x.getRight());
		
		if(leftHeight > rightHeight)
		{
			return leftHeight +1;
		}
		else
		{
		return rightHeight + 1;
		}
	}
	
	public void shiftNode(Node u, Node v)
	{
		if(u.getKey() == this.getRoot().getKey())
		{
			this.setRoot(v);
			v.setParent(u.getParent());
		}
		else
		{
			//If u is right child
			if(u.getKey() > u.getParent().getKey())
			{
				u.getParent().setRight(v);
			}
			else
			{
				u.getParent().setLeft(v);
			}
			if(v != null) {v.setParent(u.getParent());}
		}
	}
	
	public void deleteNode(Node z)
	{
		//If no left child
		if(z.getLeft() == null)
		{
			shiftNode(z,z.getRight());
		}
		else
		{
			//If no right child
			if(z.getRight() == null)
			{
				shiftNode(z,z.getLeft());
			}
			else
			{
				//There are 2 children
				Node succ = getSuccessor(z);
				if(succ.getParent() != z)
				{
					//Update z's old right child
					shiftNode(succ, succ.getRight());
					succ.setRight(z.getRight());
					succ.getRight().setParent(succ);
				}
				//Update z's old left child
				shiftNode(z, succ);
				succ.setLeft(z.getLeft());
				succ.getLeft().setParent(succ);
			}
		}
	}
}
