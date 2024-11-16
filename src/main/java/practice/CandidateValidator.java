package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        System.out.println("Testing candidate: " + candidate.getName());
        return Stream.of(
                candidate.getAge() >= 35,
                candidate.isAllowedToVote(),
                "Ukrainian".equals(candidate.getNationality()),
                validatePeriodsInUkraine(candidate.getPeriodsInUkr())
        ).allMatch(Boolean::booleanValue);
    }

    private boolean validatePeriodsInUkraine(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return false;
        }

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
