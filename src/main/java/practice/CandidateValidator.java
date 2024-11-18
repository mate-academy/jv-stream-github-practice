package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && periodMoreThanTen(candidate.getPeriodsInUkr())
                && candidate.isAllowedToVote();
    }

    private boolean periodMoreThanTen(String periodsInUkr) {
        String[] period = periodsInUkr.split("-");
        int start = Integer.parseInt(period[0]);
        int end = Integer.parseInt(period[1]);
        return (end - start) >= 10;
    }
}
