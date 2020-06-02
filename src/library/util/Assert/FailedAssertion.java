package library.util.Assert;

class FailedAssertion extends Error {
    final static long serialVersionUID = 0L;

    /**
     * Constructs an error indicating failure to meet condition.
     *
     * @param reason String describing failed condition.
     * Constructs a new failed assertion error
     */
     FailedAssertion(String reason) {
        super("\nAssertion that failed: " + reason);
    }
}