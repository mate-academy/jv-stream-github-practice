package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }

        String[] candidateList = candidate.getPeriodsInUkr().split(",");
        int yearsInUkr = Arrays.stream(candidateList)
                .mapToInt(period -> {
                    String[] periods = period.split("-");
                    int startYear = Integer.parseInt(periods[0]);
                    int endYear = Integer.parseInt(periods[1]);
                    return endYear - startYear;
                })
                .sum();
        return yearsInUkr >= 10;
    }
}
