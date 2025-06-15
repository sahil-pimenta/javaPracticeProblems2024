package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.Map;

class Node3
{
	int key;
	int val;
	Node3 next;
	Node3 prev;
	
	Node3(int key, int val)
	{
		this.key=key;
		this.val=val;
		next=null;
		prev=null;
	}
}

class LRUCache 
{	
	int capacity;
	Map<Integer, Node3> map;
	Node3 left; //LRU
	Node3 right; //most recent
	
    public LRUCache(int capacity) {
    	this.capacity=capacity;
    	map=new HashMap<Integer, Node3>();
    	this.left=new Node3(0,0);
    	this.right=new Node3(0,0);
    	this.left.next=this.right;
    	this.right.prev=this.left;
    }
    
    public int get(int key) {
    	if(map.containsKey(key))
    	{
    		Node3 node=map.get(key);
    		remove(node);
    		insert(node);
    		return node.val;
    	}
    	return -1;
    }
    
    public void put(int key, int value) {
    	if(map.containsKey(key))
    	{
    		remove(map.get(key));
    		map.remove(key);
    	}
    	Node3 newNode = new Node3(key, value);
    	map.put(key, newNode);
    	insert(newNode);
    	
    	if(map.size()>capacity)
    	{
    		Node3 lru=this.left.next;
    		remove(lru);
    		map.remove(lru.key);
    	}
    }
    
    private void remove(Node3 node)
    {
    	Node3 prevN=node.prev;
    	Node3 nextN=node.next;
    	prevN.next=nextN;
    	nextN.prev=prevN;
    }
    
    private void insert(Node3 node)
    {
    	Node3 prevN=this.right.prev;
    	prevN.next=node;
    	node.prev=prevN;
    	this.right.prev=node;
    	node.next=this.right;
    }
}


public class LeetCode37LRUCache {

	public static void main(String args[])
	{
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1));    // return -1 (not found)
		System.out.println(lRUCache.get(3));    // return 3
		System.out.println(lRUCache.get(4));    // return 4
	}
}
