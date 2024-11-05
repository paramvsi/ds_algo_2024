package sheet.google.stack;

import java.util.Arrays;
import java.util.Stack;

/*
The stock span problem is a financial problem where we
have a series of N daily price quotes for a stock and we need to calculate the
span of the stock’s price for all N days. The span Si of the stock’s price on a given
day i is defined as the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
*/
public class S02StockSpanProblem {

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        S02StockSpanProblem sp = new S02StockSpanProblem();

        System.out.println(Arrays.toString(sp.solveStockSpan(arr)));

        System.out.println(Arrays.toString(sp.solveStockSpanRef(arr)));
    }

    // How to solve?
    // It is variation of Nearest greater to left
    // So when we know which stock before current day was last greater than current day price
    // We calculate days span as current index - last greater index hence the solution
    // Instead of just storing nearest greater element to left store element, index
    private int[] solveStockSpan(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            while (!stack.empty() && current >= stack.peek().greaterElement) {
                stack.pop();
            }

            res[i] = stack.empty() ? i + 1 : i - stack.peek().greaterElementIndex;
            stack.push(new Pair(current, i));
        }

        return res;
    }

    // refactored code
    public int[] solveStockSpanRef(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return result;
    }

    class Pair {
        int greaterElement;
        int greaterElementIndex;

        public Pair(int gE, int gEI) {
            this.greaterElement = gE;
            this.greaterElementIndex = gEI;
        }
    }

}
