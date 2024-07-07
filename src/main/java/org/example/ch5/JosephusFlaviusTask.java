package org.example.ch5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Zheltyshev on 07.07.2024
 * Задача Иосифа Флавия
 */
public class JosephusFlaviusTask {

    private final CyclicList<Integer> peopleCircle;
    private final int interval;

    public JosephusFlaviusTask(int peopleCount, int interval) {
        this.peopleCircle = circleByCount(peopleCount);
        this.interval = interval;
    }

    private static CyclicList<Integer> circleByCount(int count) {
        CyclicList<Integer> peopleCircle = new CyclicList<>();
        for (int i = count; i > 0 ; i--) {
            peopleCircle.insert(i);
        }
        return peopleCircle;
    }

    public List<Integer> killedPeopleNums() {
        ArrayList<Integer> killedPeople = new ArrayList<>();
        while (!peopleCircle.isSingleElement()) {
            for (int i = 0; i < interval; i++) {
                peopleCircle.shift();
            }
            Integer killed = peopleCircle.deleteNext();
            System.out.print("People rest: ");
            peopleCircle.display();
            killedPeople.add(killed);
        }

        return killedPeople;
    }
}
