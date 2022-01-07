package day_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static day_12.Part_1.isUpperCase;

public class Part_2 {
  public static int solve_2(HashMap<String, Set<String>> mappings) {
    return dfs(mappings, "start", new HashSet<>(), false);
  }

  private static int dfs(HashMap<String, Set<String>> mappings, String current, Set<String> visited, boolean visitedSmallTwice) {
    if (current.equals("end")) {
      return 1;
    }

    int paths = 0;

    for (String node : mappings.get(current)) {
      Set<String> newVisited = new HashSet<>(visited);
      newVisited.add(node);

      if (isUpperCase(node) || !visited.contains(node)) {
        paths += dfs(mappings, node, newVisited, visitedSmallTwice);
      } else if (!visitedSmallTwice) {
        paths += dfs(mappings, node, newVisited, true);
      }
    }

    return paths;
  }
}
