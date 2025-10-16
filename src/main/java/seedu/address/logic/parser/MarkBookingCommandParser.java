package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.MarkBookingCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses the input argument
 */
public class MarkBookingCommandParser implements Parser<MarkBookingCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ViewBookingCommand
     * and returns a ViewBookingCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public MarkBookingCommand parse(String args) throws ParseException {

        try {
            Index index = ParserUtil.parseIndex(args);
            return new MarkBookingCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkBookingCommand.MESSAGE_USAGE), pe);
        }
    }
}
