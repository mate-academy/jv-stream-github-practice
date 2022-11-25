package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        int[] calculate = new int[2];
        String [] years = candidate.getPeriodsInUkr().split("-");
        for (int i = 0; i < years.length; i++) {
            calculate[i] = Integer.parseInt(years[i]);
        }
        int peroid = calculate[1] - calculate[0];
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && peroid >= 10;
    }
}

