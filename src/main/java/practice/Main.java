package practice;

import java.util.ArrayList;
import java.util.List;
import model.Candidate;

public class Main {
    public static void main(String[] args) {
        Candidate john = new Candidate(30, "Ukrainian", false, "1985-2020");
        john.setName("John");
        Candidate fred = new Candidate(39, "German", true, "2000-2019");
        fred.setName("Fred");
        Candidate casey = new Candidate(61, "Ukrainian", true, "2011-2016");
        casey.setName("Casey");
        Candidate rick = new Candidate(44, "Ukrainian", false, "1990-2007");
        rick.setName("Rick");
        Candidate morty = new Candidate(35, "Frenchman", true, "2009-2020");
        morty.setName("Morty");
        Candidate ron = new Candidate(70, "Ukrainian", true, "2009-2020");
        ron.setName("Ron");
        Candidate tania = new Candidate(36, "Ukrainian", true, "1992-2020");
        tania.setName("Tania");
        Candidate artem = new Candidate(38, "Ukrainian", true, "1993-2020");
        artem.setName("Artem");
        Candidate phil = new Candidate(52, "Ukrainian", false, "1980-2013");
        phil.setName("Philip");
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(john);
        candidateList.add(fred);
        candidateList.add(casey);
        candidateList.add(rick);
        candidateList.add(morty);
        candidateList.add(ron);
        candidateList.add(phil);
        candidateList.add(tania);
        candidateList.add(artem);

        StreamPractice streamPractice = new StreamPractice();
        System.out.println(streamPractice.validateCandidates(candidateList));
    }
}
