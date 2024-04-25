package sheet.recursion;


public class R08TowerOfHanoi {
    // Recursive function to solve Tower of Hanoi puzzle
    public static void solveTowerOfHanoi(int n, char sourceRod, char destinationRod, char auxiliaryRod) {
        if (n == 1) {
            // Base case: only one disk to move
            System.out.println("Move disk 1 from rod " + sourceRod + " to rod " + destinationRod);
            return;
        }

        // Move top n-1 disks from source to auxiliary, so they are out of the way
        solveTowerOfHanoi(n - 1, sourceRod, auxiliaryRod, destinationRod);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from rod " + sourceRod + " to rod " + destinationRod);

        // Move the n-1 disks that we left on auxiliary to destination
        solveTowerOfHanoi(n - 1, auxiliaryRod, destinationRod, sourceRod);
    }

    public static void main(String[] args) {
        int numberOfDisks = 5; // Number of disks
        solveTowerOfHanoi(numberOfDisks, 'A', 'C', 'B'); // A, B and C are names of the rods
    }
}

