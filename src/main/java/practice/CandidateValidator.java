package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_RESIDENCE_TIME = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return hasRightOfResidence(candidate.getPeriodsInUkr())
                 && candidate.isAllowedToVote()
                 && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY);
    }

    private boolean hasRightOfResidence(String years) {
        String[] yearsInUkraine = years.split("-");
        return Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0])
                >= MIN_RESIDENCE_TIME;
    }
}
