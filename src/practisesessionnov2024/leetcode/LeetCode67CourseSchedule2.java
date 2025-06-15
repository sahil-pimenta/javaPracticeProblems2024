package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode67CourseSchedule2 
{
	Map<Integer,List<Integer>> preMap = new HashMap<>();
    Set<Integer> takingCourse = new HashSet<>();
    Set<Integer> finishedCourse = new HashSet<>();
    List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        for(int i=0;i<numCourses;i++)
        {
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre:prerequisites)
        {
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int course=0;course<numCourses;course++)
        {
            if(!takeCourse(course))
            {
                return new int[]{};
            }
        }

        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
        	res[i]=order.get(i);
        }
        
        return res;
    }

    private boolean takeCourse(int course)
    {
        if(takingCourse.contains(course))return false;

        if(finishedCourse.contains(course))return true;

        takingCourse.add(course);

        for(int preCourse:preMap.get(course))
        {
            if(!takeCourse(preCourse))return false;
        }

        order.add(course);
        takingCourse.remove(course);
        finishedCourse.add(course);
        return true;
    }
	
	public static void main(String args[])
	{
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};
		
		System.out.println(Arrays.toString(new LeetCode67CourseSchedule2().findOrder(numCourses, prerequisites)));
	}
}
