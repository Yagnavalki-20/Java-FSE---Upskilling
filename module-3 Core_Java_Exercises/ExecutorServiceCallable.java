import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int taskNum = i;
            tasks.add(() -> "Result from Task " + taskNum);
        }

        List<Future<String>> results = service.invokeAll(tasks);
        for (Future<String> future : results) {
            System.out.println(future.get());
        }

        service.shutdown();
    }
}
