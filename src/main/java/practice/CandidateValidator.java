package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN = "Ukrainian";
    public static final int FROM_INDEX = 2;
    private static final int YEAR_NECESSARY_IN_UKRAINE = 10;
    private static final int NECESSARY_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= NECESSARY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && isLivedTenYears(candidate);
    }

    private boolean isLivedTenYears(Candidate candidate) {
        int ageLived = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf("2", FROM_INDEX)))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        return ageLived >= YEAR_NECESSARY_IN_UKRAINE;
    }
}
