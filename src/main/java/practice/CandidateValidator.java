package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final int INDEX_OF_YEAR_FROM = 0;
    private static final int INDEX_OF_YEAR_TO = 1;
    private static final int ELIGIBLE_PERIOD = 10;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final String DATA_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] temp = candidate.getPeriodsInUkr().split(DATA_SPLITTER);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ELIGIBLE_AGE
                && Integer.parseInt(temp[INDEX_OF_YEAR_TO])
                - Integer.parseInt(temp[INDEX_OF_YEAR_FROM]) >= ELIGIBLE_PERIOD
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY);
    }
}
