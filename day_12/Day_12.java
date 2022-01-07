package day_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static day_12.Part_1.solve_1;

public class Day_12 {
  public static void main(String[] args) {
    HashMap<String, Set<String>> mappings = parse("input.txt");
    System.out.println(solve_1(mappings));
  }

  private static HashMap<String, Set<String>> parse(String string) {
    File file = new File("day_12/" + string);
    HashMap<String, Set<String>> mappings = new HashMap<>();

    try (Scanner sc = new Scanner(file)) {
      while (sc.hasNext()) {
        String[] names = sc.nextLine().split("-");
        String from = names[0];
        String to = names[1];

        Set<String> nodes1 = mappings.getOrDefault(from, new HashSet<>());
        Set<String> nodes2 = mappings.getOrDefault(to, new HashSet<>());

        if (from.equals("start") || to.equals("end")) {
          nodes1.add(to);
          mappings.put(from, nodes1);
        } else if (from.equals("end") || to.equals("start")) {
          nodes2.add(from);
          mappings.put(to, nodes2);
        } else {
          nodes1.add(to);
          mappings.put(from, nodes1);
          nodes2.add(from);
          mappings.put(to, nodes2);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return mappings;
  }
}
