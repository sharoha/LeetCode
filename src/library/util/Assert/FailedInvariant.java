package library.util.Assert;


class FailedInvariant extends FailedAssertion {
    final static long serialVersionUID = 0L;

    /**
     * Constructs an error indicating failure to meet an invariant
     *
     * @param reason String describing failed condition.
     * @post Constructs a new failed invariant error
     */
    public FailedInvariant(String reason) {
        super("\nInvariant that failed: " + reason);
    }
}

