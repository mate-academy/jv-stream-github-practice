package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && ageInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR);
    }

    private int ageInUkr(String period) {
        String[] periodInUkr = period.split(SEPARATOR);
        return Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]);
    }
}
