package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        boolean allowedToVote = candidate.isAllowedToVote();
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(
                periods[END_PERIOD_INDEX]) - Integer.parseInt(periods[START_PERIOD_INDEX]);
        String nationality = candidate.getNationality();
        return age >= MIN_AGE
                && allowedToVote
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE
                && nationality.equals(NATIONALITY);
    }
}
