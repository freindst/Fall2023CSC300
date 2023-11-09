package pack;

public class MySinglyLinkedListList implements MyList {
	MyNode Header;
	int Size;
	
	public MySinglyLinkedListList(){
		this.Header = null;
		this.Size = 0;
	}
	
	@Override
	public boolean InsertAfter(int n, int o) {
		MyNode currNode = this.SearchNode(n);
		if (currNode == null) {
			return false;
		} else {
			MyNode newNode = new MyNode();
			newNode.Data = o;
			MyNode nextNode = currNode.NextNode;
			currNode.NextNode = newNode;
			newNode.NextNode = nextNode;
			this.Size++;
			return true;
		}
	}
	
	public boolean RemoveAfter(int n) {
		MyNode currNode = this.SearchNode(n);
		if (currNode == null) {
			return false;
		} else {
			MyNode nextNode = currNode.NextNode;
			if (nextNode == null) {
				return true;
			}
			MyNode nextNextNode = nextNode.NextNode;
			currNode.NextNode = nextNextNode;
			nextNode.NextNode = null;
			this.Size--;
			return true;
		}
	}
	
	//return the first node whose payload match the value we are searching
	//return null, when no node match the value
	public MyNode SearchNode(int n) {
		MyNode currNode = this.Header;
		while (currNode != null) {
			if (currNode.Data == n) {
				return currNode;
			} else {
				currNode = currNode.NextNode;
			}
		}
		return null;
	}
	@Override
	public void Append(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Prepend(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean Remove(int x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int Search(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Print() {
		// TODO Auto-generated method stub
		String output = "";
		output = output + 1;
	}

	@Override
	public void PrintReverse() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Sort() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean IsEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int GetLength() {
		// TODO Auto-generated method stub
		return 0;
	}

}
