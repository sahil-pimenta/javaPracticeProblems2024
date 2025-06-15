package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

	Map<String, TreeMap<Integer, String>> data;
	
    public TimeMap() {
        data= new HashMap<>();;
    }
    
    public void set(String key, String value, int timestamp) {

    	if(data.containsKey(key))
    	{
    		TreeMap<Integer, String> valMap = data.get(key);
    		valMap.put(timestamp, value);
    		data.put(key, valMap);
    	}
    	else
    	{
    		TreeMap<Integer, String> valMap = new TreeMap<Integer, String>();
    		valMap.put(timestamp, value);
    		data.put(key, valMap);
    	}    	
    }
    
    public String get(String key, int timestamp) {
        if(!data.containsKey(key))
        {
        	return "";
        }
        
        Map.Entry<Integer, String> entry = data.get(key).floorEntry(timestamp);
        if(entry!=null)
        {
        	return entry.getValue();
        }
        return "";
    }
}

public class LeetCode23TimeBasedKeyValueStore {
	
	public static void main(String args[])
	{
		TimeMap timeMap = new TimeMap();
		timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
		System.out.println(timeMap.get("alice", 1));           // return "happy"
		System.out.println(timeMap.get("alice", 2));          // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
		timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
		System.out.println(timeMap.get("alice", 3));           // return "sad"
	}
}
