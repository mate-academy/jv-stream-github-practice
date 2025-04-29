package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERSON_AGE = 35;
    private static final int MIN_PERIOD_IN_UA = 10;
    @Override
    public boolean test(Candidate candidate) {
        boolean moreThanTenYears = false;

        int[] yearsArray = Arrays.stream(candidate.getPeriodsInUkr().split("\\-"))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();
        if (yearsArray[1] - yearsArray[0] >= MIN_PERIOD_IN_UA) {
            moreThanTenYears = true;
        }
        if (candidate.getAge() >= MIN_PERSON_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && moreThanTenYears) {
            return true;
        }

        return false;
    }
    //write your code here
}
