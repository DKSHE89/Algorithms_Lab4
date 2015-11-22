import java.util.Iterator;

public class SeparateChaining<Key extends Comparable,Val>extends AbstractST<Key,Val>implements Iterable<Key>
{
private int N=0;
private final int M= Constants.M;

private Object[] st=new Object[M];
protected class Node{//inner class
	Key key;
	Val val;
	Node next;
	Node(Key key,Val val,Node next){
		this.key=key;
		this.val=val;
		this.next=next;
	}
}
private int hash(Key key){
	return (key.hashCode() & 0x7fffffff) %M; 
}

@Override
public Boolean isEmpty() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void put(Key key, Val val) {
	int i=hash(key);
	for(Node x=(Node)st[i];x!=null;x=x.next)
	if(key.equals(x.key)) {
		x.val=val;
		return;
	}
	N++;
	st[i] =new Node(key,val,(Node)st[i]);	
}
@Override
public Val get(Key key) {
	int i=hash(key);
	for(Node x=(Node)st[i];x!=null;x=x.next)
	if(key.equals(x.key))
		return(Val)x.val;
	return null;
}
@Override
public void delete(Key key) {
	// TODO Auto-generated method stub
	
}
@Override
public Iterator<Key> iterator() {
	// TODO Auto-generated method stub
	return null;
}
}