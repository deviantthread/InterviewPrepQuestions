import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LeetQuestion1 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 1, 8, 1 };
        int k = 3;

        System.out.println(new LeetQuestion1().containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, List<Integer>> values = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (!values.containsKey(nums[i])) {
                values.put(nums[i], new ArrayList<Integer>());
            }
            values.get(nums[i]).add(i);
        }

        for (Entry<Integer, List<Integer>> entry : values.entrySet()) {
            if (hasNearbyDuplicates(entry.getValue(), k)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNearbyDuplicates(List<Integer> value, int k) {
        for (int i = 1; i < value.size(); i++) {
            int prev = value.get(i - 1);
            int curr = value.get(i);

            int delta = curr - prev;
            if (delta <= k) {
                return true;
            }
        }

        return false;
    }
}
