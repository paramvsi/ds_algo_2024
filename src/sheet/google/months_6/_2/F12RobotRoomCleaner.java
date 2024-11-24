package sheet.google.months_6._2;

//  https://leetcode.com/problems/robot-room-cleaner


import java.util.HashSet;
import java.util.Set;

// Interface provided by the problem
interface Robot {
    boolean move();

    void turnLeft();

    void turnRight();

    void clean();
}

public class F12RobotRoomCleaner {

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, 0, 0, 0, visited);
    }

    private void dfs(Robot robot, int row, int col, int dir, Set<String> visited) {
        // Mark the current cell as visited and clean it
        String position = row + "," + col;
        if (visited.contains(position)) {
            return;
        }
        visited.add(position);
        robot.clean();

        // Explore all four directions: up, right, down, left
        for (int i = 0; i < 4; i++) {
            // Check the new position
            if (robot.move()) {
                int newRow = row, newCol = col;
                switch (dir) {
                    case 0:
                        newRow -= 1;
                        break; // Moving up
                    case 1:
                        newCol += 1;
                        break; // Moving right
                    case 2:
                        newRow += 1;
                        break; // Moving down
                    case 3:
                        newCol -= 1;
                        break; // Moving left
                }

                // Recur for the next cell
                dfs(robot, newRow, newCol, dir, visited);

                // Backtrack: Move back to the previous cell
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }

            // Turn to the next direction
            robot.turnRight();
            dir = (dir + 1) % 4;
        }
    }
}



