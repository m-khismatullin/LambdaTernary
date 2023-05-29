import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class t230529t4 {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        /*
        @FunctionalInterface
        public interface Predicate<T> {
            boolean test(T t);
        }

        condition.test(x) IS EQUIVALENT FOR
        boolean test(String x) {
            return Objects.isNull(x);
        }
         */

        Function<Object, Integer> itTrue = obj -> 0;
        Function<CharSequence, Integer> itFalse = CharSequence::length;

        Function<String, Integer> safeStringLength = ternaryOperator(condition, itTrue, itFalse);

        System.out.println(safeStringLength.apply("Lambda"));
    }
    public static <T, U> Function<T, U>  ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> itTrue,
            Function<? super T, ? extends U> itFalse
    ) {
        return x -> condition.test(x) ? itTrue.apply(x) : itFalse.apply(x);
        // при значении параметра равном x
        // необходимо вызвать для него предикат condition
        // и в зависимости от результата
        // вызвать для него ifTrue
        // или ifFalse
    }
}
