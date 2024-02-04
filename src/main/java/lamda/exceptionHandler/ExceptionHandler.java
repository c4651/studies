package lamda.exceptionHandler;

public interface ExceptionHandler<T> {
    T handleException(Exception e);
}


