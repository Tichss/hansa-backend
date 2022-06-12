package hu.hansa.test.common.exception;

import hu.hansa.test.common.key.MessageKey;

import java.io.Serial;

public class NotFoundException extends MessageException {

    @Serial
    private static final long serialVersionUID = 8762445480913308044L;

    /**
     * Constructor.
     *
     * @param notFoundMessageKey Type of the not found object.
     */
    public NotFoundException(final MessageKey notFoundMessageKey) {
        super(notFoundMessageKey);
    }
}
