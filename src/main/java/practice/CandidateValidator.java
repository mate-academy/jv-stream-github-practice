package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE_OF_CANDIDATE = 35;
    public static final int MIN_YEARS_IN_UKRAINE = 10;
    public static final int INDEX_OF_YEAR_TO = 1;
    public static final int INDEX_OF_YEAR_FROM = 0;
    public static final String UKRAINIAN = "Ukrainian";
    public static final String SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_OF_CANDIDATE
                && candidate.getNationality().equals(UKRAINIAN)
                && checkPeriodInUkraine(candidate);
    }

    private boolean checkPeriodInUkraine(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(SPLIT_REGEX);
        int yearsInUkraine = Integer.parseInt(periodInUkraine[INDEX_OF_YEAR_TO])
                - Integer.parseInt(periodInUkraine[INDEX_OF_YEAR_FROM]);
        return yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
