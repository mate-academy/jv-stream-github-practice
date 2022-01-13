package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!VALID_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        return true;
    }
    //write your code here
}
