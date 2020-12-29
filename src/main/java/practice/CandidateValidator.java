package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= VALID_PERIOD;
    }

    private int yearsInUkraine(String years) {
        String[] dates = years.split("-");
        return Integer.parseInt(dates[1]) - Integer.parseInt(dates[0]);
    }
}
