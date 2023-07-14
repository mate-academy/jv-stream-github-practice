package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final int YEARS_LIVED_IN_COUNTRY_THRESHOLD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEARS_SPLITTER = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsLivedInCountry = candidate.getPeriodsInUkr().split(YEARS_SPLITTER);
        return candidate.getAge() >= AGE_THRESHOLD
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(yearsLivedInCountry[END_YEAR_INDEX])
                    - Integer.parseInt(yearsLivedInCountry[START_YEAR_INDEX])
                    >= YEARS_LIVED_IN_COUNTRY_THRESHOLD;
    }
}
