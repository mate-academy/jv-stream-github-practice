package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int FROM_YEAR_INDEX = 0;
    public static final int TO_YEAR_INDEX = 1;
    public static final int MIN_PERMITTED_AGE = 35;
    public static final int MIN_PERIOD_OF_STAY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedPeriods = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(splitedPeriods[FROM_YEAR_INDEX]);
        int toYear = Integer.parseInt(splitedPeriods[TO_YEAR_INDEX]);
        int result = toYear - fromYear;
        return candidate.getAge() >= MIN_PERMITTED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && result >= MIN_PERIOD_OF_STAY;
    }
}
