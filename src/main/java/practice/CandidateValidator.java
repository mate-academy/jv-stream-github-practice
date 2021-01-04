package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final Integer MIN_AGE = 35;
    private static final Integer MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int period = Integer.parseInt(yearsInUkraine[1])
                - Integer.parseInt(yearsInUkraine[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && period >= MIN_YEARS_IN_UKRAINE;
    }
}
