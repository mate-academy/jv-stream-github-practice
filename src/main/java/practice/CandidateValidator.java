package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int AGE_MIN = 35;
    public static final int MIN_OF_YEARS_IN_UKR = 10;
    public static final String NATIONAL = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= AGE_MIN && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONAL)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) >= MIN_OF_YEARS_IN_UKR);
    }

    private static int getPeriodInUkraine(String value) {
        int convertToInt = 0;
        for (String output : value.split("-")) {
            int parseInt = Integer.parseInt(output);
            convertToInt = parseInt - convertToInt;
        }
        return convertToInt;
    }
}
