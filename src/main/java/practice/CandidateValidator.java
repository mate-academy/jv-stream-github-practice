package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS_IN_COUNTRY = 10;
    private static final int INDEX_FIRST = 0;
    private static final int INDEX_SECOND = 1;

    @Override
    public boolean test(Candidate candidate) {
        return  candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_SECOND])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_FIRST]) > YEARS_IN_COUNTRY;
    }
}
