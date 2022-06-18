package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int firstDate = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        int lastDate = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        return (candidate.getAge() >= MIN_AGE) && candidate.isAllowedToVote()
                && (candidate.getNationality().equals(NATIONALITY))
                && ((lastDate - firstDate) > MIN_YEARS);
    }
}
