package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_EDGE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX_DUSH = "-";
    private static final int MIN_EDGE_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_EDGE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf(REGEX_DUSH) + 1))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, candidate.getPeriodsInUkr()
                .indexOf(REGEX_DUSH))) >= MIN_EDGE_PERIOD_IN_UKR;
    }
}
