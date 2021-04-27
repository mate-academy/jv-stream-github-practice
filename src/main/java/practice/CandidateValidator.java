package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int YEARS_IN_COUNTRY = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_CANDIDATE = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split(SPLIT_CANDIDATE);
        int result = Integer.parseInt(data[1]) - Integer.parseInt(data[0]);
        return result >= YEARS_IN_COUNTRY && candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(NATIONALITY) && candidate.isAllowedToVote();
    }
}
