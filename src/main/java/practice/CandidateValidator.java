package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String COMMA = ",";
    private static final String DASH = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVED_IN_COUNTRY = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

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
            int startYear = Integer.parseInt(dates[START_YEAR_INDEX].trim());
            int endYear = Integer.parseInt(dates[END_YEAR_INDEX].trim());
            totalYears += endYear - startYear;
        }
        return totalYears >= MIN_LIVED_IN_COUNTRY;
    }
}
