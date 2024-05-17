package sheet.trees.problems;

public class T37GivenNAppointmentsFindConflictingAppointments {
    // Function to insert a new appointment into the BST
    static TreeNode insert(TreeNode root, Appointment app, boolean[] isConflict) {
        if (root == null) {
            return new TreeNode(app);
        }

        // If there is an overlap, mark isConflict as true
        if (isOverlapping(app, root.app)) {
            isConflict[0] = true;
        }

        // Appointments are sorted by their start time in the BST
        if (app.start < root.app.start) {
            root.left = insert(root.left, app, isConflict);
        } else {
            root.right = insert(root.right, app, isConflict);
        }

        return root;
    }

    // Function to check if two appointments overlap
    static boolean isOverlapping(Appointment app1, Appointment app2) {
        return app1.start < app2.end && app2.start < app1.end;
    }

    // Function to find conflicting appointments
    static void findConflicts(Appointment[] appointments) {
        TreeNode root = null;
        boolean[] isConflict = new boolean[1]; // Array used to capture conflict status

        for (Appointment app : appointments) {
            isConflict[0] = false;
            root = insert(root, app, isConflict);

            if (isConflict[0]) {
                System.out.println("Conflict with appointment: (" + app.start + ", " + app.end + ")");
            }
        }
    }

    public static void main(String[] args) {
        Appointment[] appointments = {
                new Appointment(1, 5),
                new Appointment(3, 7),
                new Appointment(2, 6),
                new Appointment(10, 15),
                new Appointment(5, 6),
                new Appointment(4, 100)
        };

        findConflicts(appointments);
    }

    static class Appointment {
        int start;
        int end;

        Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class TreeNode {
        Appointment app;
        TreeNode left;
        TreeNode right;

        TreeNode(Appointment app) {
            this.app = app;
        }
    }
}

