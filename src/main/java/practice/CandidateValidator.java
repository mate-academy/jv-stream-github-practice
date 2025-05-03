package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) >= REQUIRED_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getPeriodInUkraine(String date) {
        String[] yearsInUkraine = date.split("-");
        return Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]);
    }
}
