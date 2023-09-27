package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARSINUKRAINE = 10;
    private static final String SPLIT_MARKER = "-";

    private int getCandidateYearsInUkraine(Candidate candidate) {
        String [] periodsInUkr = candidate.getPeriodsInUkr().split(SPLIT_MARKER);
        return Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]);

    }

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= REQUIRED_AGE)
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getCandidateYearsInUkraine(candidate) >= REQUIRED_YEARSINUKRAINE;
    }
}
