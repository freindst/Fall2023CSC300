package pack;

public class BinarySearchTree {
	public Node Root;
	
	public BinarySearchTree() {
		this.Root = null;
	}
	
	public Node Search(int value) {
		//Go to root node
		Node node = this.Root;
		//iterate step 2
		while (node != null) {
		//Compare the value of the node
			//matches, return the node
			if (node.Data == value) {
				return node;
			} else if (value < node.Data) {
				//searching value is greater than the node, compare the left child
				node = node.leftNode;
			} else {
				//searching value is less than the node, compare the right child
				node = node.rightNode;
			}
		}
		return null;
	}
	
	public void Insert(int value) {
		Node newNode = new Node(value);
		Node node = this.Root;
		while (node != null) {
			if (node.Data == value) {
				if (node.leftNode == null) {
					node.leftNode = newNode;
					newNode.parentNode = node;
					return;
				} else if (node.rightNode == null) {
					node.rightNode = newNode;
					newNode.parentNode = node;
					return;
				} else {
					node = node.leftNode;
				}
			} else if (value < node.Data) {
				if (node.leftNode == null) {
					node.leftNode = newNode;
					newNode.parentNode = node;
					return;
				}
				node = node.leftNode;
			} else {
				if (node.rightNode == null) {
					node.rightNode = newNode;
					newNode.parentNode = node;
					return;
				}
				node =  node.rightNode;
			}
		}
		if (node == null) {
			this.Root = newNode;
		}
	}
	
	public Boolean Remove(int data) {
		Node node = this.Search(data);
		if (node == null) {
			return false;
		} else {
			if (node.leftNode == null && node.rightNode == null) {
				if (node.parentNode == null) {
					this.Root = null;
					return true;
				}
				Node parent = node.parentNode;
				if (parent.leftNode == node) {
					parent.leftNode = null;
				} else if (parent.rightNode == node) {
					parent.rightNode = null;
				}
				node.parentNode = null;
				return true;
			} else if (node.leftNode == null) {
				if (node.parentNode == null) {
					this.Root = node.rightNode;
					node.rightNode.parentNode = null;
					node.rightNode = null;
					return true;
				}
				Node parent = node.parentNode;
				if (parent.leftNode == node) {
					parent.leftNode = node.rightNode;
				} else {
					parent.rightNode = node.rightNode;
				}
				node.rightNode.parentNode = parent;
				node.parentNode = null;
				node.rightNode = null;
				return true;
			} else if (node.rightNode == null) {
				if (node.parentNode == null) {
					this.Root = node.leftNode;
					node.leftNode.parentNode = null;
					node.leftNode = null;
					return true;
				}
				Node parent = node.parentNode;
				if (parent.leftNode == node) {
					parent.leftNode = node.rightNode;
				} else {
					parent.rightNode = node.rightNode;
				}
				node.leftNode.parentNode = parent;
				node.parentNode = null;
				node.leftNode = null;
				return true;
			} else {
				if (node.rightNode.leftNode != null) {
					node.Data = node.rightNode.leftNode.Data;
					while (node != null) {
						node = RemoveNode(node.rightNode.leftNode);
					}
					return true;
				} else {
					if (node.parentNode == null) {
						this.Root = node.rightNode;
						node.rightNode.parentNode = null;
						node.rightNode.leftNode = node.leftNode;
						if (node.leftNode != null) {
							node.leftNode.parentNode = node.rightNode;
						}
						node.rightNode = null;
						node.leftNode = null;
						node.parentNode = null;
						return true;
					} else {
						Node parent = node.parentNode;
						if (parent.leftNode == node) {
							parent.leftNode = node.rightNode;
						} else {
							parent.rightNode = node.rightNode;
						}
						node.rightNode.leftNode = node.leftNode;
						node.leftNode.parentNode = node.rightNode;
						node.rightNode = null;
						node.leftNode = null;
						node.parentNode = null;
						return true;
					}
				}
			}
		}
		//to do on Friday
	}
	
	public Node RemoveNode(Node toBeRemoved) {
		if (toBeRemoved.rightNode == null) {
			if (toBeRemoved.parentNode.leftNode == toBeRemoved) {
				toBeRemoved.parentNode.leftNode = toBeRemoved.leftNode;
			} else {
				toBeRemoved.parentNode.rightNode = toBeRemoved.leftNode;
			}
			toBeRemoved.leftNode.parentNode = toBeRemoved.parentNode;
			toBeRemoved.Delete();
			return null;
		} else if (toBeRemoved.rightNode.leftNode == null) {
			toBeRemoved.Data = toBeRemoved.rightNode.rightNode.Data;
			return toBeRemoved.rightNode;
		} else {
			toBeRemoved.Data = toBeRemoved.rightNode.leftNode.Data;
			return toBeRemoved.leftNode;
		}
	}
}
