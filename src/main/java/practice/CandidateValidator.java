package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MINIMAL_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLITERATOR = ",";
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();

        String[] years = periodsInUkr.split("-");
        if (years.length != 2) {
            return false;
        }

        try {
            int yearFrom = Integer.parseInt(years[0]);
            int yearTo = Integer.parseInt(years[1]);

            if (yearTo - yearFrom < MINIMAL_PERIOD) {
                return false;
            }

            return candidate.getAge() >= MIN_AGE
                    && candidate.isAllowedToVote()
                    && REQUIRED_NATIONALITY.equals(candidate.getNationality());
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
