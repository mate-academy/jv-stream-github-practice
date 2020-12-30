package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_NEEDED = 35;
    private static final int MIN_YEARS_NEEDED = 10;
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_NEEDED && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && getYearsPeriodInUkraine(candidate.getPeriodsInUkr()
                .split("-")) > MIN_YEARS_NEEDED;
    }

    private int getYearsPeriodInUkraine(String[] years) {
        return Integer.parseInt(years[1])
                - Integer.parseInt(years[0]);
    }
}
