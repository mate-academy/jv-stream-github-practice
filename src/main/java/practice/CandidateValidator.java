package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int MIN_CANDIDATE_BEEN_IN_UKRAINE = 10;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && getYearWhenCandidateBeenInUkraine(candidate.getPeriodsInUkr())
                >= MIN_CANDIDATE_BEEN_IN_UKRAINE
                && Objects.equals(candidate.getNationality(), CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote();
    }

    private int getYearWhenCandidateBeenInUkraine(String date) {
        String[] dateInt = date.split("-");
        return Integer.parseInt(dateInt[1]) - Integer.parseInt(dateInt[0]);
    }
}
