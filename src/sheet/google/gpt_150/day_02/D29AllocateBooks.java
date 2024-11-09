package sheet.google.gpt_150.day_02;

public class D29AllocateBooks {

    public static void main(String[] args) {
        D29AllocateBooks solution = new D29AllocateBooks();

        int[] pages1 = {12, 34, 67, 90};
        int m1 = 2;
        System.out.println("Minimum of maximum pages: " + solution.findPages(pages1, m1)); // Output: 113

        int[] pages2 = {5, 17, 100, 11};
        int m2 = 4;
        System.out.println("Minimum of maximum pages: " + solution.findPages(pages2, m2)); // Output: 100
    }

    public int findPages(int[] pages, int m) {
        if (pages.length < m) {
            return -1; // Not enough books for each student to get at least one
        }

        int low = getMax(pages);  // Lower bound of binary search: max number of pages in a single book
        int high = getSum(pages); // Upper bound of binary search: sum of all pages
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(pages, m, mid)) {
                result = mid; // Possible solution, try for a smaller value
                high = mid - 1;
            } else {
                low = mid + 1; // Not possible, try for a larger value
            }
        }

        return result;
    }

    // Helper function to get the maximum number of pages in a single book
    private int getMax(int[] pages) {
        int max = 0;
        for (int page : pages) {
            max = Math.max(max, page);
        }
        return max;
    }

    // Helper function to get the sum of all pages
    private int getSum(int[] pages) {
        int sum = 0;
        for (int page : pages) {
            sum += page;
        }
        return sum;
    }

    // Function to check if we can allocate books such that no student reads more than `maxPages`
    private boolean canAllocate(int[] pages, int m, int maxPages) {
        int studentCount = 1;
        int currentPageSum = 0;

        for (int page : pages) {
            currentPageSum += page;

            // If adding this book exceeds maxPages, allocate to the next student
            if (currentPageSum > maxPages) {
                studentCount++;
                currentPageSum = page; // Start new allocation with this book

                // If we exceed the allowed number of students, allocation is not feasible
                if (studentCount > m) {
                    return false;
                }
            }
        }

        return true;
    }
}

