package sheet.stack_and_queue;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class P19FirstCircularTourThatVisitAllPetrolPump {

    // Function to find the starting petrol pump index from which the truck can complete a circular tour
    public static int firstCircularTour(PetrolPump[] pumps) {
        int totalSurplus = 0; // Total surplus of petrol after completing the tour
        int currentSurplus = 0; // Current surplus at each petrol pump
        int start = 0; // Starting petrol pump index

        for (int i = 0; i < pumps.length; i++) {
            totalSurplus += pumps[i].petrol - pumps[i].distance;
            currentSurplus += pumps[i].petrol - pumps[i].distance;

            // If current surplus is negative, we cannot start from 'start' or any pump reached so far
            if (currentSurplus < 0) {
                start = i + 1; // Move the start index to the next pump
                currentSurplus = 0; // Reset current surplus
            }
        }

        // If total surplus is negative, then tour is not possible
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int start = firstCircularTour(pumps);
        if (start != -1) {
            System.out.println("Start the tour from petrol pump index: " + start);
        } else {
            System.out.println("No solution (tour not possible)");
        }
    }
}
