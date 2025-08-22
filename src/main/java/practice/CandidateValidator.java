package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate c) {
        if (c == null) {
            return false;
        }
        if (c.getAge() <= 35) {
            return false;
        }
        if (!"Ukrainian".equals(c.getNationality())) {
            return false;
        }
        if (!c.isAllowedToVote()) {
            return false;
        }
        try {
            String[] years = c.getPeriodsInUkr().split("-");
            int start = Integer.parseInt(years[0].trim());
            int end = Integer.parseInt(years[1].trim());
            return (end - start) >= 10;
        } catch (Exception e) {
            return false;
        }
    }
}

