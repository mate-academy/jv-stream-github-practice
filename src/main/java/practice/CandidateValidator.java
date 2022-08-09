package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_FROM_PERIOD = 0;
    private static final int INDEX_TO_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedData = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(splitedData[INDEX_TO_PERIOD])
                - Integer.parseInt(splitedData[INDEX_FROM_PERIOD]) >= 10;
    }
}
