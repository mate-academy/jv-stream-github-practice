package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private Predicate<Candidate> toVote = Candidate::isAllowedToVote;
    final static int AGE = 35;
    final static String NATIONALITY = "Ukrainian";
    private Predicate<Candidate> period = p -> {
        String[] periodOfYear = p.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodOfYear[1]) - Integer.parseInt(periodOfYear[0]) >= 10;
    };

    @Override
    public boolean test(Candidate candidate) {
        return toVote.test(candidate) && age.test(candidate)
                && isNationality.test(candidate) && period.test(candidate);
    }
}
