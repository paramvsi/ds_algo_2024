package sheet.google.months_6;

//  https://leetcode.com/problems/logger-rate-limiter

// The "Logger Rate Limiter" problem typically involves implementing a system that regulates logging messages based on their timestamp.
// Here's a detailed explanation:
/*
You need to design a Logger class with the following methods:

Logger():

Initializes the logger object.
bool shouldPrintMessage(int timestamp, String message):

Returns true if a given message can be printed at timestamp.
Returns false if the message has already been printed in the last 10 seconds.
*/


import java.util.HashMap;

public class F07LoggerRateLimit {
    private final HashMap<String, Integer> messageMap;

    /**
     *
     * Initialize the logger object
     */
    public F07LoggerRateLimit() {
        messageMap = new HashMap<>();
    }

    public static void main(String[] args) {
        F07LoggerRateLimit logger = new F07LoggerRateLimit();

        // Test cases
        System.out.println(logger.shouldPrintMessage(1, "foo")); // true
        System.out.println(logger.shouldPrintMessage(2, "bar")); // true
        System.out.println(logger.shouldPrintMessage(3, "foo")); // false
        System.out.println(logger.shouldPrintMessage(8, "bar")); // false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // true
    }

    /**
     * Returns true if the message should be printed at the given timestamp,
     * otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageMap.containsKey(message)) {
            // Message not in the map, allow printing
            messageMap.put(message, timestamp);
            return true;
        }

        // Get the last timestamp for this message
        int lastTimestamp = messageMap.get(message);

        if (timestamp - lastTimestamp >= 10) {
            // Update the timestamp and allow printing
            messageMap.put(message, timestamp);
            return true;
        }

        // Message was logged less than 10 seconds ago, disallow printing
        return false;
    }
}

