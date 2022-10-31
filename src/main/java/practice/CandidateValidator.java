package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PRESIDENT_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UA = 10;
    private static final String DATE_SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] fromYearToYearInUA = candidate.getPeriodsInUkr().split(DATE_SPLITERATOR);
        int totalYearsInUA = Integer.parseInt(fromYearToYearInUA[1])
                - Integer.parseInt(fromYearToYearInUA[0]);
        return candidate.getAge() >= MIN_PRESIDENT_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && totalYearsInUA >= MIN_YEARS_IN_UA;
    }
}
