package coffee.lkh.algorithm.impl.companies;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Arrays;
import java.util.Map;

public class Candy extends DetailedAlgorithmBase {
    private static final String RATINGS = "ratings";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new RuntimeException("Parameters are not valid!");
        }
        final int[] ratings = (int[]) params.get(RATINGS);
        params.put("result", candy(ratings));
        return params;
    }

    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int[] candies = new int[ratings.length];
        // provide a candy to each student
        Arrays.fill(candies, 1);

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // give i one more candy than i-1 if rating of i is higher than i-1
                candies[i] = candies[i - 1] + 1;
            }
        }

        int totalCandies = candies[candies.length - 1]; //start from last student

        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // give i the max candies of (i+1 + 1) and itself if rating of i is higher than i+1
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }

            totalCandies += candies[i];
        }

        return totalCandies;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(RATINGS) && params.get(RATINGS) instanceof int[];
    }
}
