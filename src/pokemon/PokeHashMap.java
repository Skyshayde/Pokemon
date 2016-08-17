package pokemon;

import java.lang.reflect.Array;
 
public class PokeHashMap<K> {
	private Class<K> c;
	private K[] key;
	private int[] value;
	private String[] text;
	private int size;
	
	public PokeHashMap(Class<K> c) {
		this.c = c;
		@SuppressWarnings("unchecked")
		K[] key = (K[]) Array.newInstance(c, 50);
		this.key = key;
		value = new int[50];
		text = new String[50];
		size = 0;
	}
	
	public void extend(Class<K> c) {
		int length = key.length;
		K[] tempK = key;
		int[] tempV = value;
		String[] tempT = text;
		@SuppressWarnings("unchecked")
		K[] key = (K[]) Array.newInstance(c, length+50);
		this.key = key;
		value = new int[length+50];
		text = new String[length+50];
		for (int i = 0; i < length; i++) {
			this.key[i] = tempK[i];
			value[i] = tempV[i];
			text[i] = tempT[i];
		}
	}
	
	public K getKeyAt(int pos) {
		return key[pos];
	}
	
	public K getKeyFromText(String t) {
		for (int i = 0; i < size; i++) {
			if (t.equals(text[i])) return key[i];
		}
		return null;
	}
	
	public K[] getKeys() {
		return key;
	}
	
	public String getText(K k) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) return text[i];
		}
		return null;
	}
	
	public int getValue(K k) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) return value[i];
		}
		return 0;
	}
	
	public int put(K k, int v) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) {
				value[i] = value[i] + v;
				return value[i];
			}
		}
		int i = key.length;
		if (i%50 == 0) extend(c);
		key[size] = k;
		value[size] = v;
		size++;
		return value[size];
	}
	
	public String put(K k, String t) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) {
				text[i] = t;
				return text[i];
			}
		}
		int i = key.length;
		if (i%50 == 0) extend(c);
		key[size] = k;
		text[size] = t;
		size++;
		return text[size];
	}
	
	public int putOne(K k) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) {
				value[i] = value[i] + 1;
				return value[i];
			}
		}
		int i = key.length;
		if (i%50 == 0) extend(c);
		key[size] = k;
		value[size] = 1;
		size++;
		return value[size];
	}
	
	public void removeAll(Class<K> c) {
		@SuppressWarnings("unchecked")
		K[] key = (K[]) Array.newInstance(c, 50);
		this.key = key;
		value = new int[50];
		text = new String[50];
		size = 0;
	}
	
	public void removeAmount(K k, int amount) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) {
				if (value[i] <= amount) {
					int j;
					for (j = i; j < size-1; j++) {
						key[j] = key[j+1];
						value[j] = value[j+1];
					}
					key[j] = null;
					value[j] = 0;
					size--;
				}
				else {
					value[i] -= amount;
				}
				break;
			}
		}
	}
	
	public void removeText(String t) {
		for (int i = 0; i < size; i++) {
			if (text[i].equals(t)) {
				int j;
				for (j = i; j < size-1; j++) {
					key[j] = key[j+1];
					text[j] = text[j+1];
				}
				key[j] = null;
				text[j] = null;
				size--;
				break;
			}
		}
	}
	
	public void removeTextAt(K k) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) {
				int j;
				for (j = i; j < size-1; j++) {
					key[j] = key[j+1];
					text[j] = text[j+1];
				}
				key[j] = null;
				text[j] = null;
				size--;
				break;
			}
		}
	}
	
	public void removeValueAt(K k) {
		for (int i = 0; i < size; i++) {
			if (key[i].equals(k)) {
				int j;
				for (j = i; j < size-1; j++) {
					key[j] = key[j+1];
					value[j] = value[j+1];
				}
				key[j] = null;
				value[j] = 0;
				size--;
				break;
			}
		}
	}

	public void sortAlphabetically() {		
		int i, j, idx;
	    int n = key.length;
	    K tempK;
	    int tempV;
	    String tempT;
	    for (i = 0; i < n - 1; i++) {
	    	idx = i;
	    	for (j = i + 1; j < n; j++) {
	    		if (key[j] == null) break;
	    		if (key[j].toString().compareTo(key[idx].toString()) < 0) idx = j;
	    	}
	    	if (idx != i) {
	    		tempK = key[i];
	    		key[i] = key[idx];
	    		key[idx] = tempK;
	    		tempV = value[i];
	    		value[i] = value[idx];
	    		value[idx] = tempV;
	    		tempT = text[i];
	    		text[i] = text[idx];
	    		text[idx] = tempT;
	    	}
	    }
	}
}
