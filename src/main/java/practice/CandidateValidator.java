package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final String nationality = "Ukrainian";
    private final int age = 35;
    private final int minYearsInUkraine = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < age) {
            return false;
        }
        if (!(candidate.getNationality().equals(nationality))) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        String[]periods = candidate.getPeriodsInUkr().split("-");
        if (periods.length != 2) {
            return false;
        }
        int start = Integer.parseInt(periods[0]);
        int finish = Integer.parseInt(periods[1]);
        return (finish - start) >= minYearsInUkraine;

    }
}
