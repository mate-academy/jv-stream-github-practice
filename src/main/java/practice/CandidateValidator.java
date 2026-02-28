package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && livedInUkraineEnough(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineEnough(String periods) {
        if (periods == null) {
            return false;
        }

        String[] years = periods.split("-");

        if (years.length != 2) {
            return false;
        }

        try {
            int from = Integer.parseInt(years[0].trim());
            int to = Integer.parseInt(years[1].trim());
            return to - from >= MIN_YEARS_IN_UKR;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


