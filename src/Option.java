import java.util.HashMap;
import java.util.Map;

public enum Option {SHOW_OPTIONS(1), RUN_TESTS(2), RUN_BASIC_PROGRAM(3), RUN_EXTENDED_PROGRAM(4), EXIT(5);
    private final int operation;
    private static final Map<Integer, Option> BY_LABEL = new HashMap<>();

    private Option(int operation) {
        this.operation = operation;
    }

    static {
        for (Option e : values()) {
            BY_LABEL.put(e.operation, e);
        }
    }

    public static Option valueOfOperation(int operation) {
        return BY_LABEL.get(operation);
    }
}