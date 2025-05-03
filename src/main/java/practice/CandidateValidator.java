package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_PERSON = 35;
    private static final int MIN_YEARS_LIVING_IN_UKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_PERSON
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && getPeriod(candidate) >= MIN_YEARS_LIVING_IN_UKRAINE;
    }

    private int getPeriod(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
