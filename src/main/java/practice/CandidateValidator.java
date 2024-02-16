package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String YEAR_DATE_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_TO_VOTE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isEnoughYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean isEnoughYearsInUkraine(String period) {
        String[] years = period.split(YEAR_DATE_REGEX);
        int timeInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return timeInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
