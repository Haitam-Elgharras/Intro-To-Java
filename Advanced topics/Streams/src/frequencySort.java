import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class frequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> mapp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapp.put(c, mapp.getOrDefault(c, 0) + 1);
        }

        return mapp.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(entry -> entry.getKey().toString().repeat(entry.getValue()))
                .collect(Collectors.joining());
    }
}
