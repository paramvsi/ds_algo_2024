package sheet.graphs.problems;

import java.util.*;

public class G28WaterJugProblem {
    public static boolean canMeasureWater(int jug1, int jug2, int target) {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        // Initial state
        State start = new State(0, 0);
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // Check if current state is the target state
            if (current.x == target || current.y == target || current.x + current.y == target) {
                return true;
            }

            // Generate all possible states from current state
            List<State> nextStates = getNextStates(current, jug1, jug2);

            // Explore each state if not already visited
            for (State state : nextStates) {
                if (!visited.contains(state)) {
                    visited.add(state);
                    queue.add(state);
                }
            }
        }

        return false; // If no solution found
    }

    private static List<State> getNextStates(State current, int max1, int max2) {
        List<State> states = new ArrayList<>();
        int x = current.x;
        int y = current.y;

        // Fill first jug
        states.add(new State(max1, y));
        // Fill second jug
        states.add(new State(x, max2));
        // Empty first jug
        states.add(new State(0, y));
        // Empty second jug
        states.add(new State(x, 0));
        // Pour from first jug to second jug
        states.add(new State(x - Math.min(x, max2 - y), y + Math.min(x, max2 - y)));
        // Pour from second jug to first jug
        states.add(new State(x + Math.min(y, max1 - x), y - Math.min(y, max1 - x)));

        return states;
    }

    public static void main(String[] args) {
        int jug1 = 3, jug2 = 5, target = 4;
        if (canMeasureWater(jug1, jug2, target)) {
            System.out.println("It is possible to measure exactly " + target + " liters.");
        } else {
            System.out.println("It is not possible to measure exactly " + target + " liters.");
        }
    }

    static class State {
        int x, y;

        State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return x == state.x && y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
