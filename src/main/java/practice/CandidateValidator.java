package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String COMMA = ",";
    private static final String DASH = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVED_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(COMMA);
        int totalYears = 0;
        for (String period : periods) {
            String[] dates = period.split(DASH);
            int startYear = Integer.parseInt(dates[0].trim());
            int endYear = Integer.parseInt(dates[1].trim());
            totalYears += endYear - startYear;
        }
        return totalYears >= MIN_LIVED_IN_COUNTRY;
    }
}
