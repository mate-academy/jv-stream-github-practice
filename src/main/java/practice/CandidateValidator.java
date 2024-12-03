package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final int MINIMAL_PERIOD = 10;
    private static final int MINIMAL_AGE = 35;
    private static final String SPLITERATOR = "-";
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITERATOR);
        if (Integer.parseInt(years[YEAR_TO]) - Integer.parseInt(years[YEAR_FROM])
                < MINIMAL_PERIOD) {
            return false;
        }
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY);
    }
}
