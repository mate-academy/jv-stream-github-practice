package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR = 35;
    private static final String NATIONAL = "Ukrainian";
    private static final int PERIOD_IN_UKR = 10;
    private static final String SPLIT_ELEMENT_FROM_YEARS = "-";

    @Override
    public boolean test(Candidate candidate) {
        String [] dateFromPredicate = candidate.getPeriodsInUkr().split(SPLIT_ELEMENT_FROM_YEARS);
        return candidate.getAge() >= YEAR
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONAL)
                && Integer.parseInt(dateFromPredicate[1]) - Integer.parseInt((dateFromPredicate[0]))
                >= PERIOD_IN_UKR;
    }
}
