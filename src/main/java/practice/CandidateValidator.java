package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_OF_LAST_YEAR = 5;
    private static final int FIRST_INDEX_OF_FIRST_YEAR = 0;
    private static final int LAST_INDEX_OF_FIRST_YEAR = 4;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(candidate.getPeriodsInUkr().substring(INDEX_OF_LAST_YEAR))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(FIRST_INDEX_OF_FIRST_YEAR, LAST_INDEX_OF_FIRST_YEAR))) >= 10;
    }
}
