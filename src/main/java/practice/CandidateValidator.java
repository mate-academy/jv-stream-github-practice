package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    final int min_years_in = 10;
    final int min_years_old = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int from = Integer.parseInt(period[0].trim());
        int to = Integer.parseInt(period[1].trim());
        boolean validPeriod = to - from >= min_years_in;

        return candidate.getAge() >= min_years_old
                && validPeriod
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian");
    }
}
