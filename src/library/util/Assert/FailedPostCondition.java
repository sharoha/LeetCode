package library.util.Assert;

class FailedPostCondition extends FailedAssertion
{
    final static long serialVersionUID = 0L;
    /**
     * Constructs an error indicating failure to meet a postcondition.
     *
     * @post Constructs a new failed postcondition
     *
     * @param reason String describing postcondition.
     */
    public FailedPostCondition(String reason)
    {
        super("\n Post Condition: " + reason);
    }
}
