package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_VALID_PERIOD = 10;
    private static final int INDEX_YEAR_TO = 1;
    private static final int INDEX_YEAR_FROM = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && validPeriodsInUkraine(candidate) >= MIN_VALID_PERIOD;
    }

    private int validPeriodsInUkraine(Candidate candidate) {
        String[] splitedArray = candidate.getPeriodsInUkr().split("-");
        Integer[] integersArray = new Integer[splitedArray.length];
        for (int i = 0; i < splitedArray.length; i++) {
            integersArray[i] = Integer.parseInt(splitedArray[i]);
        }
        return integersArray[INDEX_YEAR_TO] - integersArray[INDEX_YEAR_FROM];
    }
}
