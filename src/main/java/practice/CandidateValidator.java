package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int CANDIDATE_MIN_AGE = 35;
    public static final String CANDIDATE_DEFAULT_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD_SPEND_IN_UKRAINE = 10;
    public static final int END_OF_PERIOD_INDEX = 1;
    public static final int START_OF_PERIOD_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidateYears = candidate.getPeriodsInUkr().split("-");
        int yearTill = Integer.parseInt(candidateYears[END_OF_PERIOD_INDEX]);
        int yearFrom = Integer.parseInt(candidateYears[START_OF_PERIOD_INDEX]);
        return candidate.getClass().equals(Candidate.class)
                && candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(CANDIDATE_DEFAULT_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearTill - yearFrom >= MIN_PERIOD_SPEND_IN_UKRAINE;
    }
}
