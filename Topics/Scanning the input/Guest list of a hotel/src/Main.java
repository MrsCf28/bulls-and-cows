import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        while (scanner.hasNext()) {
            String room = scanner.next();
            List<String> namesInRoom = List.of(room.split(" "));
            names.addAll(namesInRoom);
        }

        IntStream.range(0, names.size()).mapToObj(i -> names.get(names.size() - 1 - i)).forEach(System.out::println);
    }
}