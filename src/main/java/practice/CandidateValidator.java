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

        String[] years = candidate.getPeriodsInUkr().split(YEARS_SPLITTER);
        int yearsInUkr = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equalsIgnoreCase(candidate.getNationality())
                && yearsInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}