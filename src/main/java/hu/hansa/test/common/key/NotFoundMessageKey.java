package hu.hansa.test.common.key;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotFoundMessageKey implements MessageKey {

    USER("not-found.user");
    private final String key;
}
