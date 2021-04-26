package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(periodsInUkr[0]);
        int toYear = Integer.parseInt(periodsInUkr[periodsInUkr.length - 1]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (toYear - fromYear >= 10);
    }
}
