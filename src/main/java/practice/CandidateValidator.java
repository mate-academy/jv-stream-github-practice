package practice;

import java.util.List;
import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return true;
    }
}
