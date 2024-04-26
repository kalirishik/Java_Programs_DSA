import java.util.*;

public class WaterWorldProblem {

    static String findKey(HashMap<String,String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int clusters = scanner.nextInt();
        String[] names = new String[clusters];
        HashMap<String,Integer> nameMapper = new HashMap<>();
        int[] dayLimit = new int[clusters];
        int[] tankCapacity = new int[clusters];
        int[] currWater = new int[clusters];

        for (int i = 0; i < clusters; i++) {
            names[i] = scanner.next();
            dayLimit[i] = scanner.nextInt();
            tankCapacity[i] = scanner.nextInt();
            currWater[i] = 0;
            nameMapper.put(names[i], i + 1);
        }

        int links = scanner.nextInt();
        String temp;
        HashMap<String,String> map1 = new HashMap<>();
        for (int i = 0; i < links; i++) {
            temp = scanner.next();
            int j;
            for (j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '_')
                    break;
            }
            map1.put(temp.substring(0, j), temp.substring(j + 1));
        }

        int waterConsumed = 0;
        boolean flag = true;
        boolean[] visited = new boolean[clusters];

        while (days-- > 0) {
            Arrays.fill(visited, false);
            for (int i = 0; i < clusters; i++) {
                if (visited[i])
                    continue;

                if (dayLimit[i] > currWater[i]) {
                    visited[i] = true;
                    temp = names[i];
                    waterConsumed += tankCapacity[i];
                    currWater[i] = tankCapacity[i];
                    while (true) {
                        temp = findKey(map1, temp);
                        if (temp == null)
                            break;
                        if (temp.equals("F")) {
                            break;
                        }
                        if (!visited[nameMapper.get(temp) - 1]) {
                            waterConsumed += tankCapacity[nameMapper.get(temp) - 1];
                        }

                        currWater[nameMapper.get(temp) - 1] = tankCapacity[nameMapper.get(temp) - 1];
                    }
                }
            }

            for (int i = 0; i < clusters; i++)
                currWater[i] -= dayLimit[i];
        }

        System.out.println(waterConsumed);
    }
}
