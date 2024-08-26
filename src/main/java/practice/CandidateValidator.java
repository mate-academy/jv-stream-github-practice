package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIODS;
    }

    public int periodsInUkraine(String periods) {
        String[] newPeriods = periods.split("-");
        return Integer.parseInt(newPeriods[1].trim()) - Integer.parseInt(newPeriods[0].trim());
    }
}
