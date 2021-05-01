

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Score implements Serializable {
    private HashMap<String, Integer> allScores;

    Score() {
        allScores = new HashMap<>();
    }

    public void addScore(Player player) {
        if (allScores.containsKey(player.getPlayerName())) {
            if (player.getScore() > allScores.get(player.getPlayerName())) {
                allScores.replace(player.getPlayerName(), player.getScore());
            }
        } else {
            allScores.put(player.getPlayerName(),player.getScore());
        }
    }

    public void printScore() {
        System.out.println("История побед");
        LinkedList<Map.Entry<String, Integer>> sortScores = new LinkedList<>(allScores.entrySet());
        sortScores.sort(Map.Entry.comparingByValue());
        sortScores.descendingIterator().forEachRemaining(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
