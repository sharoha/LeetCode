package library.util.Assert;


public class Assert {
    /**
     * The current level of debugging; generally 0 upward.
     * A level of 0 is generally considered off.
     */
    protected static int debugLevel = 0;

    /**
     * @pre An Assert cannot be constructed
     */
    private Assert() {
        Assert.fail("Attempt to construct an Assert!?");
    }

    /**
     * Increase the verbosity of the debugging messages.
     *
     * @post debugging level is increased
     */
    public static void debugging() {
        debugLevel++;
    }

    /**
     * Explictly set the debugging level (0 = none)
     *
     * @param level the desired level of verosity
     * @return the old level
     * @pre level >= 0
     * @post the level of debugging is set to <code>level</code>
     */
    public static int debugLevel(int level) {
        int oldLevel = debugLevel;
        debugLevel = level;
        return oldLevel;
    }

    /**
     * Set up a level 1 debugging message.
     *
     * @param message a string to be printed if debugging level is 1 or more
     * @post prints message if the debugging level is 1 or more
     */
    public static void debug(String message) {
        debug(1, message);
    }

    /**
     * Set up a debugging message at a specific level.
     *
     * @param level   the level that triggers the printing of message
     * @param message the message to be printed at the desired level
     * @pre level >= 1 and message is non-null
     * @post prints message if debugging level is <code>level</code> or more
     */
    public static void debug(int level, String message) {
        if (level <= debugLevel) System.err.println(message);
    }

    /**
     * Test a precondition.  If the assertion fails the message
     * indicates that a precondition failed.  A precondition is something
     * you require to be true for the method to be executed correctly.
     *
     * @param test    A boolean expression describing precondition.
     * @param message A string describing precondition.
     * @pre Result of precondition test
     * @post Does nothing if test true, otherwise abort w/message
     */
    static public void pre(boolean test, String message) {
        if (!test) throw new FailedPreCondition(message);
    }

    /**
     * Test a postcondition.  If the assertion fails, the message
     * indicates that a postcondition failed.  A postcondition is
     * something expected to be true after a method invocation,
     * provided the preconditions are met.
     *
     * @param test    A boolean expression describing postcondition.
     * @param message A string describing postcondition.
     * @pre Result of postcondition test
     * @post Does nothing if test true, otherwise abort w/message
     */
    static public void post(boolean test, String message) {
        if (!test) {
            throw new FailedPostCondition(message);
        }
    }

    /**
     * Test a general condition.  If the assertion fails, the message
     * indicates that a general condition failed.  The condition may
     * be anything that needs to be verified during the course of program
     * execution.
     *
     * @param test    A boolean expression describing the condition.
     * @param message A string describing the condition.
     * @pre result of general condition test
     * @post does nothing if test true, otherwise abort w/message
     */
    static public void condition(boolean test, String message) {
        if (!test) throw new FailedAssertion(message);
    }

    /**
     * Test a loop invariant.  If the assertion fails, the message
     * indicates that an invariant failed.  The condition may
     * be anything that needs to be verified during the course of program
     * execution.
     *
     * @param test    A boolean expression describing the condition.
     * @param message A string describing the condition.
     * @pre result of an invariant test
     * @post does nothing if test true, otherwise abort w/message
     */
    static public void invariant(boolean test, String message) {
        if (!test) throw new FailedInvariant(message);
    }

    /**
     * Indicate certain failure.  Stops the program with a message
     * indicating why failure occurred.
     *
     * @param message A string describing the reason for failure.
     * @post Throws error with message
     */
    static public void fail(String message) {
        throw new FailedAssertion(message);
    }
}

