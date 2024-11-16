package practice;

import model.Candidate;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return Stream.of(
                candidate.getAge() > 35,
                candidate.isAllowedToVote(),
                "Ukrainian".equals(candidate.getNationality()),
                validatePeriodsInUkraine(candidate.getPeriodsInUkr())
        ).allMatch(condition -> condition);
    }

    private boolean validatePeriodsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        if (periods.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(periods[0]);
            int endYear = Integer.parseInt(periods[1]);
            return endYear - startYear >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}