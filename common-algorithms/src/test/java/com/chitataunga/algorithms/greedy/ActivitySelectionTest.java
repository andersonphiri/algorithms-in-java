package com.chitataunga.algorithms.greedy;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ActivitySelectionTest {

    @Test
    public void shouldReturnCorrectCountOfActivities() {
        List<ActivityPair<Integer>> activities = 
        new ArrayList<ActivityPair<Integer>>(
            
                );
        activities.add(ActivityPair.from(2, 3));
        activities.add(ActivityPair.from(1, 4));
        activities.add(ActivityPair.from(5, 8));
        activities.add(ActivityPair.from(6, 10));
        int expectedCount = 2; // 
        ActivitySelection<Integer> as = 
         ActivitySelection.<Integer>from(activities);
        var actual = as.findMaxActivitiesCount();
        assertThat(actual).isEqualTo(expectedCount);
    }
}
