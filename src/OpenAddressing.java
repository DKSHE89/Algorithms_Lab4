import java.util.Iterator;


public class OpenAddressing<Key extends Comparable,Val> extends AbstractST<Key,Val>implements Iterable<Key>{

	private int N=0;
	private final int M= Constants.M;
	
private Val[] vals= (Val[])new Object[M];
private Key[] keys= (Key[])new Comparable[M];
private int hash(Key key){return(key.hashCode() & 0x7fffffff) %M;
}
@Override
public Boolean isEmpty() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void put(Key key, Val val) {
	 //omitted:	check whether array is full
	int i;
	for(i=hash(key);keys[i] !=null;i=(i+1)%M)
		if(key.equals(keys[i]))
			break;
	if(keys[i]==null)
		N++;
	vals[i] =val;
	keys[i] =key;
	
}
@Override
public Val get(Key key) {
	int i;
	for(i=hash(key);keys[i] !=null;i=(i+1)%M)
		if(key.equals(keys[i]))
	return vals[i];
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
