package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality() == NATIONALITY
                && periodMoreThanTen(candidate.getPeriodsInUkr())
                && candidate.isAllowedToVote();
    }

    private boolean periodMoreThanTen(String periodsInUkr) {
        String[] period = periodsInUkr.split("-");
        int start = Integer.parseInt(period[0]);
        int end = Integer.parseInt(period[1]);
        return end - start >= MIN_PERIOD_IN_UKRAINE;
    }
}
