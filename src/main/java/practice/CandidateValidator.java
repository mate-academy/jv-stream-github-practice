package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPT_AGE = 35;
    private static final int NUMBER_YEAR_IN_UKRAINE = 10;
    private static final String ACCEPT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCEPT_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ACCEPT_NATIONALITY)
                && calculatePeriodInUkraine(candidate.getPeriodsInUkr()) >= NUMBER_YEAR_IN_UKRAINE;
    }

    private int calculatePeriodInUkraine(String st) {
        String[] yearInUkraine = st.split("-");
        return Integer.parseInt(yearInUkraine[1]) - Integer.parseInt(yearInUkraine[0]);
    }
}
