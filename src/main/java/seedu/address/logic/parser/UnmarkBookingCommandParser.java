package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UnmarkBookingCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses the input argument index
 */
public class UnmarkBookingCommandParser implements Parser<UnmarkBookingCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ViewBookingCommand
     * and returns a ViewBookingCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnmarkBookingCommand parse(String args) throws ParseException {

        try {
            Index index = ParserUtil.parseIndex(args);
            return new UnmarkBookingCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnmarkBookingCommand.MESSAGE_USAGE), pe);
        }
    }
}
