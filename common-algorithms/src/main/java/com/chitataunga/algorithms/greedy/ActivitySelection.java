package com.chitataunga.algorithms.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * Activity selection uses greedy approach to solve problem of:
 * given a set of activities, we want a maximum number 
 * of activities we can schedule without one activity
 * overlapping another on a timeline
 * The approach:
 * - sort activities by end times in an increasing order
 * - push the first activity on to a stack/linked list
 * iterate the remaining items:
 * - for each of the remain item, 
 * push it to the stack if it does not overlap with the item on the peek of the
 * stack
 */
public class ActivitySelection<T extends Comparable<T>> {
    private ActivityPair<T>[] activities = null;
    private Comparator<ActivityPair<T>> comparator 
    = (left, right) -> left.getEnd().compareTo(right.getEnd());

    private LinkedList<ActivityPair<T>> stack = null;

    public  
    static <T extends Comparable<T>> 
            ActivitySelection<T> from(Collection<ActivityPair<T>> activities) {
        return new ActivitySelection<T>(activities);
    }
    
    public  
    static <T extends Comparable<T>> 
    ActivitySelection<T> from(Queue<ActivityPair<T>> activities) {
        return new ActivitySelection<T>(activities);
    }

    protected ActivitySelection(Collection<ActivityPair<T>> activities) {
        Arr
        this.activities = (ActivityPair<T>[]) activities.stream().toArray();
    }
    
    protected ActivitySelection(Queue<ActivityPair<T>> activities) {

        this.activities = (ActivityPair<T>[]) activities.stream().toArray();
    }

    private void checkIfStateIsValid() {
        if (isEmpty()) {
            throw new RuntimeException("no activity item was found.");
        }
    }

    public boolean isEmpty() {
        return null == activities || activities.length == 0; }

    public Optional<List<ActivityPair<T>>> findMaxActivities() {
        checkIfStateIsValid();
        sortByEndTime();
        scheduleIfNotOverlappingWithLastMinRange();
        return Optional.ofNullable(stack);
    }

    public int findMaxActivitiesCount() {
        sortByEndTime();
        return countIfNotOverlappingWithLastMinRange();
    }

    private void sortByEndTime() {
        Arrays.sort(activities, comparator);
    }

    private void scheduleIfNotOverlappingWithLastMinRange() {
        stack = new LinkedList<>();
        stack.addLast(activities[0]);
        for (ActivityPair<T> act : activities) {
            if (act == activities[0]) {
                continue;
            }
            if (act.overlaps(stack.peekLast())) {
                continue;
            }
            stack.addLast(act);
        }

    }

    private int countIfNotOverlappingWithLastMinRange() {
        if (isEmpty()) {
            return 0;
        }
        var current = activities[0];
        int cnt = 1;
        for (ActivityPair<T> act : activities) {
            if (act == activities[0]) {
                continue;
            }
            if (act.overlaps(current)) {
                continue;
            }
            current = act;
        }
        return cnt;

    }

    public void setComparator(Comparator<ActivityPair<T>> cmp) {
        this.comparator = cmp;
    }

}
