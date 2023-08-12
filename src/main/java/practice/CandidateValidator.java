package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PERSON_NATIONALITY = "Ukrainian";
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int ALLOWED_AGE = 35;
    private static final int ALLOWED_LIVE_IN = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split("-");
        boolean period = Integer.parseInt(arr[INDEX_1]) - Integer.parseInt(arr[INDEX_0])
                >= ALLOWED_LIVE_IN;
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(PERSON_NATIONALITY)
                && period && candidate.isAllowedToVote();
    }
}

//write your code here


