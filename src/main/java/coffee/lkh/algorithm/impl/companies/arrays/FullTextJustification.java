package coffee.lkh.algorithm.impl.companies.arrays;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FullTextJustification extends DetailedAlgorithmBase {
    private final static String WORDS = "words";
    private final static String MAX_WIDTH = "maxWidth";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {

        if (!isParametersValid(params)) {
            throw new RuntimeException("Params of FullTextJustify are incorrect!");
        }

        final String[] words = (String[]) params.get(WORDS);
        final int maxWidth = ((AtomicInteger) params.get(MAX_WIDTH)).get();
        params.put("result", fullJustify(words, maxWidth));
        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(MAX_WIDTH) && params.containsKey(WORDS)
                && params.get(MAX_WIDTH) instanceof AtomicInteger && params.get(WORDS) instanceof String[];
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            // Find the words that can fit in the current line
            int lineLength = words[i].length();
            int j = i + 1;
            while (j < n && (lineLength + words[j].length() + (j - i - 1)) < maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            // Build the line string based on the justification requirements
            StringBuilder line = new StringBuilder();
            int numWords = j - i;

            if (numWords == 1 || j == n) {
                // If there is only one word or we have reached the last word, left justify the line
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) {
                        line.append(" ");
                    }
                }

                // Add spaces to the right of the line to reach the maxWidth
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // If there are multiple words, distribute the spaces evenly between them
                int totalSpaces = maxWidth - lineLength;
                int spacesBetweenWords = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k != j - 1) {
                        int spaces = spacesBetweenWords;
                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        line.append(" ".repeat(spaces));
                    }
                }
            }

            result.add(line.toString());
            i = j; // Move the pointer i to the next word
        }

        return result;
    }
}
