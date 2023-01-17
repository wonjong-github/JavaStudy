package chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        try {
            String k = processFile((BufferedReader br) -> br.readLine());
        }catch (IOException e){
            System.out.println("IOException");
        }
        List<Integer> result = map(
                Arrays.asList("asdf", "adsfee", "qww"),
                (String s) -> s.length()
        );
    }
    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
    public static <T, R> List<R> map(List<T> list, Function<T, R> f){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
