package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's client status in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class ClientStatus {

    public static final String MESSAGE_CONSTRAINTS =
            "Client status must be either “active”, “unresponsive”, “potential”, or “old”(case sensitive).";

    private static final String ACTIVE = "active";
    private static final String OLD = "old";
    private static final String POTENTIAL = "potential";
    private static final String UNRESPONSIVE = "unresponsive";

    private final String value;

    /**
     * Constructs a {@code ClientStatus}.
     *
     * @param status A valid client status.
     */
    public ClientStatus(String status) {
        requireNonNull(status);
        checkArgument(isValidClientStatus(status), MESSAGE_CONSTRAINTS);
        value = parseStatus(status);
    }

    /**
     * Returns true if the given string is a valid client status.
     */
    public static boolean isValidClientStatus(String test) {
        return test.equals(ACTIVE) || test.equals(UNRESPONSIVE)
                || test.equals(POTENTIAL) || test.equals(OLD);
    }

    /**
     * Parses the status into the relevant client status string
     * @param status The client status string
     * @return The client's client status as string
     */
    private static String parseStatus(String status) {
        switch (status) {
        case ACTIVE:
            return ACTIVE;
        case UNRESPONSIVE:
            return UNRESPONSIVE;
        case OLD:
            return OLD;
        case POTENTIAL:
            return POTENTIAL;
        default:
            return status;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ClientStatus)) {
            return false;
        }

        ClientStatus otherStatus = (ClientStatus) other;
        return value == otherStatus.value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}