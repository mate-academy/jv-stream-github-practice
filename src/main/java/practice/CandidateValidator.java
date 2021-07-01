package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String DATE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String [] periodInUkr = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        return (candidate != null
                && candidate.getAge() >= 35
                && (Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]) >= 10)
                && (candidate.getNationality().equals("Ukrainian"))
                && (candidate.isAllowedToVote()));
    }
    //write your code here
}
