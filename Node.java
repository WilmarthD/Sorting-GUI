

public class Node implements NodeFunctions
{
	private final int key;
	private Node parent;
	private Node left;
	private Node right;
	private Object data;
	
	public Node(int key, Object data)
	{
		this.key = key;
		parent = null;
		left = null;
		right = null;
		this.data = data;
	}
	
	public Node(int key)
	{
		this(key, null);
	}
	
	public int getKey()
	{
		return key;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setLeft(Node n)
	{
		left = n;
	}
	
	public void setRight(Node n)
	{
		right = n;
	}
	
	public void setParent(Node n)
	{
		parent = n;
	}
	
	public String toString()
	{
		String x = "(";
		x += "" + key + ",";
		if(this.getParent() != null)
		{
			x += "" +this.getParent().getKey();
		}
		x+= ",";
		if (this.getLeft() != null)
		{
			x += "" +this.getLeft().getKey();
		}
		x+= ",";
		if(this.getRight() != null)
		{
			x += "" +this.getRight().getKey();
		}
		x += ")";
		
		return x;
		/*
		StringBuilder ret = new StringBuilder();
		ret.append("(" + key );
		//Comment out if testing testBinarySearchTree
		
		if(this.getParent() != null)
		{
			ret.append("," + this.getParent() + "," );
		}
		if (this.getLeft() != null)
		{
			ret.append("," + this.getLeft() + "," );
		}
		if(this.getRight() != null)
		{
			ret.append("," + this.getRight() + "," );
		}
		
		ret.append(")");
		
		return ret.toString();
	*/
	}
	
	public boolean equals(Object o)
	{		
		if(o == null)
		{
			return false;
		}	
		if(this == o)
		{
			return true;
		}
		if(getClass() == o.getClass())
		{
			//Not so sure about this line
			if(key == ((Node) o).getKey());
			return true;
		}
		
		return false;
	}
	
	public Object getData()
	{
		return this.data;
	}
	
	public void setData(Object o)
	{
		this.data = o;
	}
}
