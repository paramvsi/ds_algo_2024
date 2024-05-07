package sheet.searching_and_sorting;

// The Book Allocation Problem involves distributing books among students
// in such a way that the maximum number of pages assigned to any student is minimized.
// This problem can be solved using binary search.

public class S17BookAllocationProblem {

    public static int minPages(int[] books, int students) {
        int totalBooks = books.length;
        if (totalBooks < students) {
            return -1; // Not enough books for each student
        }

        int low = 0; // Minimum possible pages assigned to a student
        int high = 0; // Maximum possible pages assigned to a student

        // Calculate the maximum and sum of pages of all books
        for (int book : books) {
            high += book;
        }

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(books, students, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean isValid(int[] books, int students, int maxPages) {
        int studentsRequired = 1;
        int currentPageCount = 0;

        for (int i = 0; i < books.length; i++) {
            if (books[i] > maxPages) {
                return false; // Impossible to assign maxPages to any student
            }
            if (currentPageCount + books[i] > maxPages) {
                studentsRequired++;
                currentPageCount = books[i];
            } else {
                currentPageCount += books[i];
            }
        }

        return studentsRequired <= students;
    }

    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println("Minimum pages assigned to any student: " + minPages(books, students));
    }
}

