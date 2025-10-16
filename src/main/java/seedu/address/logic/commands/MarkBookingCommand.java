package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.booking.Booking;

/**
 *Mark the status of a booking section in a given index
 */
public class MarkBookingCommand extends Command {

    public static final String COMMAND_WORD = "markbooking";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Mark the status of booking in the INDEX. \n"
            + "Parameters: "
            + "INDEX (must be a positive integer) "
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_SUCCESS = "Booking %1$s has been marked";
    public static final String MESSAGE_NOTFOUND = "Invalid booking ID: %1$s";
    public static final String MESSAGE_DUPLICATE = "you have already marked this booking";

    private final Index bookingindex;

    public MarkBookingCommand(Index bookingindex) { this.bookingindex = bookingindex; }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Booking> lastShownList = model.getFilteredBookingList();

        if (bookingindex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_NOTFOUND);
        }

        Booking booking = lastShownList.get(bookingindex.getZeroBased());
        if (booking.isDone()) {
            throw new CommandException(MESSAGE_DUPLICATE);
        }
        Booking markedbooking = booking.markBooking();
        model.setBooking(booking, markedbooking);

        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(markedbooking)));
    }
}
