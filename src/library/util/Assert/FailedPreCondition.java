package library.util.Assert;

class FailedPreCondition extends FailedAssertion
{
    final static long serialVersionUID = 0L;
    /**
     * Constructs an error indicating failure to meet a precondition.
     *
     * @post Constructs a new failed precondition
     *
     * @param reason String describing precondition.
     */
    public FailedPreCondition(String reason)
    {
        super("\nPre Condition: " + reason);
    }
}

