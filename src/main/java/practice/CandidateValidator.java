package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_BETWEEN_DATES = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR_BETWEEN_DATES);
        return candidate.getAge() >= MAX_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(period[1])
                - Integer.parseInt(period[0]) >= PERIOD_IN_UKRAINE)
                && candidate.isAllowedToVote();
    }
}
