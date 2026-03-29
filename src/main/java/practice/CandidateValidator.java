package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate c) {
        return c.getAge() > 35
                && c.isAllowedToVote()
                && "Ukrainian".equals(c.getNationality())
                && getYearsInUkraine(c.getPeriodsInUkr()) >= 10;
    }

    private int getYearsInUkraine(String period) {
        String[] parts = period.split("-");
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);
        return end - start;
    }
}