package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private Predicate<Candidate> checkAge35 = c -> c.getAge() >= 30;
    private Predicate<Candidate> allowedToVote = Candidate::isAllowedToVote;
    private Predicate<Candidate> nationality = c ->
            "Ukrainian".equalsIgnoreCase(c.getNationality());
    private Predicate<Candidate> liveInUA = c -> {
        String[] years = c.getPeriodsInUkr().split("-");
        int diff = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return diff >= 10;
    };

    @Override
    public boolean test(Candidate candidate) {
        return checkAge35
                .and(allowedToVote)
                .and(nationality)
                .and(liveInUA)
                .test(candidate);
    }
}
