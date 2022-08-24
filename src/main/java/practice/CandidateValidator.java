package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromTo = candidate.getPeriodsInUkr().split("-");
        boolean livedForTenYears =
                Integer.parseInt(fromTo[TO_INDEX]) - Integer.parseInt(fromTo[FROM_INDEX]) >= 10;
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && livedForTenYears;
    }
}
