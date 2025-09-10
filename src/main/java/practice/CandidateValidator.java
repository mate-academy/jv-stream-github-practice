package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        boolean ageValid = candidate.getAge() >= 35;
        boolean allowed = candidate.isAllowedToVote();
        boolean ukrainian = "Ukrainian".equalsIgnoreCase(candidate.getNationality());

        String[] years = candidate.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            return false;
        }
        int from = Integer.parseInt(years[0].trim());
        int to = Integer.parseInt(years[1].trim());
        boolean lived10Years = (to - from) >= 10;

        return ageValid && allowed && ukrainian && lived10Years;
    }
}
