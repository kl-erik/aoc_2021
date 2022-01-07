package day_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Part_1 {
  public static int solve_1(HashMap<String, Set<String>> mappings) {
    return dfs(mappings, "start", new HashSet<>());
  }

  private static int dfs(HashMap<String, Set<String>> mappings, String currentNode, Set<String> visited) {
    if (currentNode.equals("end")) {
      return 1;
    }

    int paths = 0;

    for (String node : mappings.get(currentNode)) {
      if (isUpperCase(node) || !visited.contains(node)) {
        Set<String> newVisited = new HashSet<>();
        newVisited.addAll(visited);
        newVisited.add(node);
        paths += dfs(mappings, node, newVisited);
      }
    }

    return paths;
  }

  private static boolean isUpperCase(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isLowerCase(c)) {
        return false;
      }
    }

    return true;
  }
}
