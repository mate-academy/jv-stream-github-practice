package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_ELEMENT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] date = candidate.getPeriodsInUkr().split(SPLIT_ELEMENT);
        return candidate.getAge() >= YEARS
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(date[1]) - Integer.parseInt(date[0]) >= PERIOD_IN_UKRAINE;
    }
}
