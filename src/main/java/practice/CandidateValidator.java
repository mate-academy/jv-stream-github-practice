package practice;

import java.io.File;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY = "Ukrainian";
    public static final String DASH = "-";
    public static final int FIRST_YEAR = 0;
    public static final int SECOND_YEAR = 1;
    public static final int MIN_PER = 10;
    public static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE &&
                candidate.getNationality().equals(NATIONALITY) &&
                candidate.isAllowedToVote() &&
                CheckYear(candidate);
    }
    public boolean CheckYear(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(ages[SECOND_YEAR]) - Integer.parseInt(ages[FIRST_YEAR]) >= MIN_PER;
    }
}
    //write your code here
