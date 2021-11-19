package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && countYearsFromPeriod(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private int countYearsFromPeriod(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
