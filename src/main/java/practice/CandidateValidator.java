package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String RIGHT_NATIONALITY = "Ukrainian";
    public static final int INDEX_YEAR_FROM = 0;
    public static final int INDEX_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && RIGHT_NATIONALITY.equals(candidate.getNationality())
                && getPeriod(candidate) >= 10;
    }

    private int getPeriod(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_YEAR_TO])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_YEAR_FROM]);
    }
}
