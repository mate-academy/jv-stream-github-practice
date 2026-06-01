package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int MIN_AGE = 35;
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        int period = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && period >= MIN_PERIOD_IN_UKR && candidate.isAllowedToVote();
    }
}
