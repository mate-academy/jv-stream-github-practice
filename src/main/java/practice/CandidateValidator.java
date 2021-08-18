package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_IN_UKR = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int livePeriodInUkr = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate
                .getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && livePeriodInUkr >= YEAR_IN_UKR;
    }
}
