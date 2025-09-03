package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final String SEPARATOR = "-";
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SEPARATOR);
        if (dates.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(dates[BEGIN_INDEX].trim());
            int endYear = Integer.parseInt(dates[END_INDEX].trim());
            return endYear - startYear >= REQUIRED_YEARS_IN_UKR;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}



