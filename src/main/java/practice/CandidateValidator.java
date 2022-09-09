package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int RESIDENCE = 10;
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodResidence = candidate.getPeriodsInUkr().split(REGEX);
        int years = Integer.parseInt(periodResidence[1])
                - Integer.parseInt(periodResidence[0]);
        return candidate.getAge() >= FROM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && years >= RESIDENCE;
    }
}