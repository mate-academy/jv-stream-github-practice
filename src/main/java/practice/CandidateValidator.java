package practice;

import model.Candidate;

import java.util.Objects;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), "Ukrainian")
                && checkPeriod(candidate.getPeriodsInUkr());
                /*&& ((Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]))
        - (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])) >= 10);*/
    }
    private boolean checkPeriod (String period) {
        String[] limits = period.split("-");
        int difference = Integer.parseInt(limits[1]) - Integer.parseInt(limits[0]);
        return difference >= 10;
    }
}
