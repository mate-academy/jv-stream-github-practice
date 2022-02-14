package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MIN_AGE_OF_CANDIDATE = 35;
    public static final int MIN_YEARS_IN_UKRAINE = 10;
    public static final int INDEX_OF_YEAR_TO = 1;
    public static final int INDEX_OF_YEAR_FROM = 0;
    public static final String UKRAINIAN = "Ukrainian";
    public static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int yearsInUkraine = Integer.parseInt(periodInUkraine[INDEX_OF_YEAR_TO])
                - Integer.parseInt(periodInUkraine[INDEX_OF_YEAR_FROM]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_OF_CANDIDATE
                && candidate.getNationality().equals(UKRAINIAN)
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
