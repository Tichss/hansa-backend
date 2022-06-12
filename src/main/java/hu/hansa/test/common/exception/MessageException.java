package hu.hansa.test.common.exception;

import hu.hansa.test.common.key.MessageKey;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class MessageException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -4100877607484339067L;

    private Map<String, String> extraMessages;

    public MessageException(final @NonNull MessageKey messageKey) {
        super(messageKey.getKey());
        this.extraMessages = new HashMap<>();
    }

    public MessageException(final @NonNull MessageKey messageKey, final Map<String, String> extraMessages) {
        super(messageKey.getKey());
        this.setExtraMessages(extraMessages);
    }

    public MessageException(final @NonNull MessageKey messageKey, final @NonNull Throwable cause) {
        super(messageKey.getKey(), cause);
    }

}
