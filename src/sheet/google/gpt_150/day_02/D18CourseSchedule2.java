package sheet.google.gpt_150.day_02;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D18CourseSchedule2 {
    public static void main(String[] args) {
        D18CourseSchedule2 solution = new D18CourseSchedule2();

        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order1 = solution.findOrder(numCourses1, prerequisites1);
        System.out.print("Course order: ");
        for (int course : order1) {
            System.out.print(course + " ");
        }
        System.out.println();

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}};
        int[] order2 = solution.findOrder(numCourses2, prerequisites2);
        System.out.print("Course order: ");
        for (int course : order2) {
            System.out.print(course + " ");
        }
        System.out.println();
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialize adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and fill the in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
            inDegree[course]++;
        }

        // Queue for courses with no prerequisites (in-degree of 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // List to store the course order
        int[] order = new int[numCourses];
        int index = 0;

        // Process each course in the queue
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            // Reduce the in-degree of neighboring courses
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all courses are taken, return the order
        if (index == numCourses) {
            return order;
        } else {
            // Otherwise, return an empty array (cycle detected)
            return new int[0];
        }
    }
}

