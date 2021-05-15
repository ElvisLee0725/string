import java.util.*;
// You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
//
// It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

// Destination City: A city never goes out
// Iterate the paths List, and use a hashmap to store <City, is destination, true by default>
// Get the city at index 0 from map an set value to false
// After the iteration, iterate the hashmap and find the only city that remains true in value. return it
// Time: O(n+m) n is the length of paths and m is the number of cities, Space: O(m)
class Solution {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList(new String[]{"B","C"}));
        paths.add(Arrays.asList(new String[]{"D","B"}));
        paths.add(Arrays.asList(new String[]{"C","A"}));
        System.out.println(new Solution().destCity(paths));
    }
    public String destCity(List<List<String>> paths) {
        HashMap<String, Boolean> map = new HashMap();
        for(List<String> list : paths) {
            String city1 = list.get(0);
            String city2 = list.get(1);
            map.put(city1, false);
            map.putIfAbsent(city2, true);
        }

        String res = "";
        for(Map.Entry<String, Boolean> entry : map.entrySet()) {
            if(entry.getValue() == true) {
                res = entry.getKey();
            }
        }
        return res;
    }
}
