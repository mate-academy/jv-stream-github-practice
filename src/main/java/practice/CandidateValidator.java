package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int SUITABLE_AGE = 35;
    private static final int SUITABLE_YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= SUITABLE_AGE
            && NATIONALITY.equals(candidate.getNationality())
            && candidate.isAllowedToVote()
            && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
            - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) >= SUITABLE_YEARS;
    }
}
