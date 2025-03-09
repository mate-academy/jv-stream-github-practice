package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final String properNationality = "UKRAINIAN";
    public static final int properAge = 35;
    public static final int properPeriodsInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(properNationality)
                && candidate.getAge() >= properAge
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[0])) >= properPeriodsInUkr) {
            return true;
        }
        return false;
    }
}
