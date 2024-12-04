package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        periodsInUkrValidator(candidate);
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]) > 10;
    }

    private void periodsInUkrValidator(Candidate candidate) {
        for (int i = 0; i < candidate.getPeriodsInUkr().length(); i++) {
            if (Character.isLetter(candidate.getPeriodsInUkr().charAt(i))) {
                throw new RuntimeException("Data contains letters");
            }
        }
    }
    //write your code here
}
