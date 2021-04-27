package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final int NUMBERS_OF_YEARS = 10;
    private static final int ALLOW_AGE = 35;
    private static final String SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsSpentInCountry = candidate.getPeriodsInUkr().split(SPLIT);

        return candidate.getAge() >= ALLOW_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(yearsSpentInCountry[YEAR_TO])
                - Integer.parseInt(yearsSpentInCountry[YEAR_FROM])
                >= NUMBERS_OF_YEARS;
    }
}
