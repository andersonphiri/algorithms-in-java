package com.chitataunga.algorithms.greedy;


import java.util.Comparator;

/**
 * an activity pair contains a pair of two items
 * Start type and End type. when compared, the value of start, should always be less than
 * the value of end
 */
public class ActivityPair<T extends Comparable<T>>
implements Comparable<ActivityPair<T>> {
    private T start;
    private T end;
    private Comparator<ActivityPair<T>> comparator = null;

    protected ActivityPair(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public static <T extends Comparable<T>> ActivityPair<T> 
    from(T start, T end) {
        if (start.compareTo(end) >= 0) {
            throw new RuntimeException(
                "start should be always be less than end");
        }
        return new ActivityPair<T>(start, end);
    }

    public void setComparator(Comparator<ActivityPair<T>> cmp) {
        comparator = cmp;
    }

    public T getStart() {
        return this.start;
    }
    
    public T getEnd() {
        return this.end; }

    @Override
    public int compareTo(ActivityPair<T> o) {
        if (null == comparator) {
            return this.end.compareTo(o.getEnd());
        }
        return comparator.compare(this, o);
    }

    public boolean overlaps(ActivityPair<T> another) {
        if (this.valuesEqual(another)) {
            return true; }
        if (start.compareTo(another.getEnd()) >= 0) {
            return false;
        }
        return this.end.compareTo(another.getStart()) > 0;
        
    }

    public boolean startEqual(ActivityPair<T> another) {
        return this.start.compareTo(another.getStart()) == 0;
    }
    
    public boolean endEqual(ActivityPair<T> another) {
        return this.end.compareTo(another.getEnd()) == 0;
    }
    public boolean valuesEqual(ActivityPair<T> another) {
        return 
        this.startEqual(another) && this.endEqual(another)
        ;
    }

    
}
