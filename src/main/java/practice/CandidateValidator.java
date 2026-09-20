package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String YEARS_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return 0;
        }
        String[] years = periodsInUkr.split(YEARS_SPLITTER);
        int startYear = Integer.parseInt(years[0].trim());
        int endYear = Integer.parseInt(years[1].trim());
        return endYear - startYear;
    }
}
