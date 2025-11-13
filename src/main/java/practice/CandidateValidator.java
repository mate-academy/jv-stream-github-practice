package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MIN_RESIDENCY_PERIOD = 10;
    //write your code here

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraine(candidate);
    }

    private boolean periodInUkraine(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(SEPARATOR);
        int years = Integer.parseInt(split[1]) - Integer.parseInt(split[0]);
        return years >= MIN_RESIDENCY_PERIOD;
    }
}
