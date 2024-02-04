package lamda.spamFilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
