package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode66CourseSchedule {

	Map<Integer, List<Integer>> preMap = new HashMap<>();
	
	Set<Integer> visited = new HashSet<>();
	
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        for(int i=0;i<numCourses;i++)
        {
        	preMap.put(i,new ArrayList<>());
        }
        
        for(int[] pre: prerequisites)
        {
        	preMap.get(pre[0]).add(pre[1]);
        }
        
        for(int course=0;course<numCourses;course++)
        {
        	if(!checkCourse(course))return false;
        }
        
        return true;
    }
    
    private boolean checkCourse(int course)
    {
    	if(visited.contains(course))return false;
    	
    	if(preMap.get(course).isEmpty())return true;
    	
    	visited.add(course);
    	
    	for(int pre : preMap.get(course))
    	{
    		if(!checkCourse(pre))
    		{
    			return false;
    		}
    	}
    	
    	visited.remove(course);
    	preMap.put(course, new ArrayList<>());
    	return true;
    }
	
	public static void main(String args[])
	{
		int numCourses = 2;
		int[][] prerequisites = {{0,1},{1,0}};
		
		System.out.println(new LeetCode66CourseSchedule().canFinish(numCourses, prerequisites));
	}
}
