package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int yearsInUkraine(String periodsInUkr) {
        return Integer.parseInt(periodsInUkr.substring(5, 9))
                    - Integer.parseInt(periodsInUkr.substring(0, 4));
    }
}
