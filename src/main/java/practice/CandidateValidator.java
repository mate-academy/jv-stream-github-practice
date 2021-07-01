package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATE_SEPARATOR = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String [] periodInUkr = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        return (candidate != null
                && candidate.getAge() >= MIN_AGE
                && (Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0])
                >= MIN_PERIOD_IN_UKRAINE)
                && (candidate.getNationality().equals(NATIONALITY))
                && (candidate.isAllowedToVote()));
    }
}
