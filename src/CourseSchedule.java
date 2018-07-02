import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> schedule = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            schedule.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int cur = prerequisites[i][0];
            schedule.get(pre).add(cur);
            indegree[cur]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for(int neighbor : schedule.get(course)) {
                indegree[neighbor]--;
                if(indegree[neighbor]==0) queue.offer(neighbor);
            }
        }
        return count==numCourses;
    }


}
