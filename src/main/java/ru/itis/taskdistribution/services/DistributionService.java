package ru.itis.taskdistribution.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.taskdistribution.models.TaskNew;
import ru.itis.taskdistribution.repositories.TaskRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistributionService {

    @Autowired
    TaskRepository taskRepository;

    public void distributeTasks(TaskNew newTaskNew) throws IOException {
        List<TaskNew> allTaskNews = taskRepository.findAll();
        Map<TaskNew, Boolean> suitableTasks= new HashMap<>();
        for (TaskNew taskNew :
                allTaskNews) {
            if (isStringsEqual(newTaskNew.getTitle(), taskNew.getTitle())) {
                if (isStringsEqual(newTaskNew.getDescription(), taskNew.getDescription())){
                    suitableTasks.put(taskNew, true);
                }
            }
        }
        if (!suitableTasks.isEmpty()){
            for (TaskNew taskNew : suitableTasks.keySet()) {

            }

        }
    }


    public boolean isStringsEqual(String first, String second) throws IOException {
        return 0.25 <= compareStrings(first, second);
    }

    public double compareStrings(String first, String second) throws IOException {
        if (isNullOrWhitespace(first) && isNullOrWhitespace(second)) {
            return 1.0;
        }

        if (isNullOrWhitespace(first) || isNullOrWhitespace(second)) {
            return 0.0;
        }

        String normalizedFirst = textNormalization(first);
        String normalizedSecond = textNormalization(second);

        List<String> tokensFirst = getTokens(normalizedFirst);
        List<String> tokensSecond = getTokens(normalizedSecond);

        List<String> equalsTokens = GetTanimotoEqualsTokens(tokensFirst, tokensSecond);

        int equalsCount = equalsTokens.size();
        int firstCount = tokensFirst.size();
        int secondCount = tokensSecond.size();

        double resultValue = (1.0 * equalsCount) / (firstCount + secondCount - equalsCount);

        return resultValue;
    }
     

    public boolean isNullOrWhitespace(String s) {
        return s == null || isWhitespace(s);

    }

    private List<String> GetTanimotoEqualsTokens(List<String> tokensFirst, List<String> tokensSecond) {
        List<String> equalsTokens = new ArrayList<>();
        boolean[] usedToken = new boolean[tokensSecond.size()];
        for (int i = 0; i < tokensFirst.size(); i++) {
            for (int j = 0; j < tokensSecond.size(); j++) {
                if (!usedToken[j]) {
                    if (IsTokensTanimotoEqual(tokensFirst.get(i), tokensSecond.get(j))) {
                        equalsTokens.add(tokensFirst.get(i));
                        usedToken[j] = true;
                        break;
                    }
                }
            }
        }
        return equalsTokens;
    }

    private boolean IsTokensTanimotoEqual(String firstToken, String secondToken) {
        int equalSubtokensCount = 0;
        boolean[] usedTokens = new boolean[secondToken.length() - 2 + 1];
        for (int i = 0; i < firstToken.length() - 2 + 1; ++i) {
            String subtokenFirst = firstToken.substring(i, i + 2);
            for (int j = 0; j < secondToken.length() - 2 + 1; ++j) {
                if (!usedTokens[j]) {
                    String subtokenSecond = secondToken.substring(j, j + 2);
                    if (subtokenFirst.equals(subtokenSecond)) {
                        equalSubtokensCount++;
                        usedTokens[j] = true;
                        break;
                    }
                }
            }
        }

        int firstCount = firstToken.length() - 2 + 1;
        int secondCount = secondToken.length() - 2 + 1;

        double tanimoto = (1.0 * equalSubtokensCount) / (firstCount + secondCount - equalSubtokensCount);

        return 0.45 <= tanimoto;
    }

    private boolean isWhitespace(String s) {
        int length = s.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private List<String> getTokens(String text) {
        List<String> tokens = new ArrayList<>();
        String[] words = text.split(" ");
        for (String word :
                words) {
            if (word.length() >= 3) {
                tokens.add(word);
            }
        }
        return tokens;
    }

    private String textNormalization(String text) {
        StringBuilder resultContainer = new StringBuilder(100);
        String lowerSentece = text.toLowerCase();
        for (char c : lowerSentece.toCharArray()) {
            if (isLetterDigitOrSpace(c)) {
                resultContainer.append(c);
            }
        }

        return resultContainer.toString();
    }

    private boolean isLetterDigitOrSpace(char c) {
        return Character.isLetterOrDigit(c) || c == ' ';
    }


}
