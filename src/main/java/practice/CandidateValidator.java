package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String DELIMITED_SYMBOL = "-";
    public static final int MAX_ELECTION_AGE = 35;
    public static final String ALLOWED_NATIONALITY = "Ukrainian";
    public static final int YEARS_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] strArr = candidate.getPeriodsInUkr().split(DELIMITED_SYMBOL);
        int firstDate = Integer.parseInt(strArr[0]);
        int secondDate = Integer.parseInt(strArr[1]);
        return candidate.getAge() >= MAX_ELECTION_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), ALLOWED_NATIONALITY)
                && secondDate - firstDate >= YEARS_IN_COUNTRY;
    }
}
