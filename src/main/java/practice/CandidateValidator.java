package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int YEAR_FROM = 0;
    private final static int YEAR_TO = 1;
    private final static int MINIMAL_PERIOD = 10;
    private final static int MINIMAL_AGE = 35;
    private final static String SPLITERATOR = "-";
    private final static String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITERATOR);
        if (Integer.parseInt(years[YEAR_TO]) - Integer.parseInt(years[YEAR_FROM]) < MINIMAL_PERIOD) {
            return false;
        }
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY);
    }
}
