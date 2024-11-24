package sheet.google.months_6._2;

//  https://leetcode.com/problems/bricks-falling-when-hit

import java.util.Arrays;

public class F16BrickFallingWhenHit {
    public static void main(String[] args) {
        F16BrickFallingWhenHit solution = new F16BrickFallingWhenHit();
        int[][] grid = {
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        };
        int[][] hits = {{1, 0}};
        System.out.println(Arrays.toString(solution.hitBricks(grid, hits))); // Output: [2]
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Mark bricks that will be hit
        for (int[] hit : hits) {
            int r = hit[0], c = hit[1];
            if (grid[r][c] == 1) {
                grid[r][c] = 2; // Mark as a "to-be-hit" brick
            }
        }

        // Union-Find setup
        UnionFind uf = new UnionFind(rows * cols + 1); // +1 for the virtual top node
        int top = rows * cols;

        // Connect all stable bricks (initially without hits)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    unionNeighbors(grid, uf, r, c, rows, cols, top);
                }
            }
        }

        // Reverse process the hits
        int[] result = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];
            if (grid[r][c] == 2) { // It was hit
                grid[r][c] = 1; // Add the brick back
                int before = uf.size(top); // Size of the connected top before adding this brick
                unionNeighbors(grid, uf, r, c, rows, cols, top);
                int after = uf.size(top); // Size after adding the brick
                result[i] = Math.max(0, after - before - 1); // Exclude the brick itself
            }
        }

        return result;
    }

    private void unionNeighbors(int[][] grid, UnionFind uf, int r, int c, int rows, int cols, int top) {
        int index = r * cols + c;
        if (r == 0) {
            uf.union(index, top); // Connect to the virtual top node
        }

        // Connect to valid neighbors
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                uf.union(index, nr * cols + nc);
            }
        }
    }

    // Union-Find class
    class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
            }
        }

        public int size(int x) {
            int rootX = find(x);
            return size[rootX];
        }
    }
}

