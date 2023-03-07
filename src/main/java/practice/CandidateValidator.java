package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_CITIZENSHIP_TIME = 10;
    private static final String UKR_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && getCitizenshipTime(candidate) >= MIN_CITIZENSHIP_TIME;
    }

    private int getCitizenshipTime(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-")).mapToInt(Integer::parseInt)
                .reduce((left, right) -> right - left).getAsInt();
    }
}
