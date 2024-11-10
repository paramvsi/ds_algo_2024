package sheet.google.gpt_150.day_03;


import java.util.Stack;

public class D17SimplifyPath {

    public static void main(String[] args) {
        D17SimplifyPath solution = new D17SimplifyPath();

        String path1 = "/home/";
        System.out.println("Simplified path: " + solution.simplifyPath(path1)); // Output: "/home"

        String path2 = "/../";
        System.out.println("Simplified path: " + solution.simplifyPath(path2)); // Output: "/"

        String path3 = "/home//foo/";
        System.out.println("Simplified path: " + solution.simplifyPath(path3)); // Output: "/home/foo"

        String path4 = "/a/./b/../../c/";
        System.out.println("Simplified path: " + solution.simplifyPath(path4)); // Output: "/c"
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        // Split the path by '/' and process each part
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Ignore empty components or current directory reference (".")
                continue;
            } else if (component.equals("..")) {
                // Go up one directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // It's a valid directory name; add to the stack
                stack.push(component);
            }
        }

        // Rebuild the canonical path from the stack
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // If the stack was empty, return "/" (root directory)
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}

