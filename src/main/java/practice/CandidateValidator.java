package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {

    public static Predicate<Candidate> isEligible() {
        return c -> c.getAge() > 35
                && c.isAllowedToVote()
                && "Ukrainian".equals(c.getNationality())
                && yearsInUkraine(c.getPeriodsInUkr()) >= 10;
    }

    private static int yearsInUkraine(String periods) {
        String[] years = periods.split("-");
        int start = Integer.parseInt(years[0]);
        int end = Integer.parseInt(years[1]);
        return end - start;
    }
}