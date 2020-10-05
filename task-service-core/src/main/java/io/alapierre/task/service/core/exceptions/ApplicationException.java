package io.alapierre.task.service.core.exceptions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created 04.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@SuppressWarnings({"unused", "RedundantSuppression"})
public class ApplicationException extends RuntimeException {

    private ExceptionLevel level;
    private Map<String, String> params;

    public ApplicationException() {
        this.level = ExceptionLevel.ERROR;
        this.params = new LinkedHashMap<>();
    }

    public ApplicationException(String message) {
        super(message);
        this.level = ExceptionLevel.ERROR;
        this.params = new LinkedHashMap<>();
    }

    public ApplicationException(ExceptionLevel level, String message, Object... params) {
        super(message);
        this.level = ExceptionLevel.ERROR;
        this.params = new LinkedHashMap<>();
        this.level = level;
        this.params = this.prepareParamMap(params);
    }

    public ApplicationException(String message, Object... params) {
        super(message);
        this.level = ExceptionLevel.ERROR;
        this.params = new LinkedHashMap<>();
        this.params = this.prepareParamMap(params);
    }

    public ApplicationException(ExceptionLevel level, String message, Map<String, String> params) {
        super(message);
        this.level = ExceptionLevel.ERROR;
        this.params = new LinkedHashMap<>();
        this.level = level;
        this.params = params;
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        this.level = ExceptionLevel.ERROR;
        this.params = new LinkedHashMap<>();
    }

    public ApplicationException(Throwable message) {
        super(message);
        this.level = ExceptionLevel.ERROR;
        this.params = new LinkedHashMap<>();
    }

    public ExceptionLevel getLevel() {
        return this.level;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    private Map<String, String> prepareParamMap(Object... params) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(params).sequential()
                .map(Object::toString).collect(
                        Collectors.toMap(s -> String.valueOf(index.getAndIncrement()), s -> s, (oldV, newV) -> newV));
    }

}
