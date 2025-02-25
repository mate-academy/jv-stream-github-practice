package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                    && candidate.isAllowedToVote()
                    && "Ukrainian".equals(candidate.getNationality())
                    && hasLivedInUkraineForAtLeast10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForAtLeast10Years(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return false;
        }

        String[] periods = periodsInUkr.split("-");
        if (periods.length == 2) {
            try {
                int startYear = Integer.parseInt(periods[0]);
                int endYear = Integer.parseInt(periods[1]);

                return (endYear - startYear) >= 10;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return false;
    }
}
