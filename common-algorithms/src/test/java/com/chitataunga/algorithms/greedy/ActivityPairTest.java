package com.chitataunga.algorithms.greedy;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ActivityPairTest {
    
    
    @Test
    public void shouldReturnTrueIfOverlap() {
        ActivityPair<Integer> one = ActivityPair.from(0, 3);
        ActivityPair<Integer> two = ActivityPair.from(1, 2);
        ActivityPair<Integer> three = ActivityPair.from(3, 4);
        assertThat(one.overlaps(two))
                .as("[%d - %d] overlaps with [%d - %d]",
                        one.getStart(), one.getEnd(), two.getStart(), two.getEnd())
                .isTrue();

        assertThat(two.overlaps(one))
                .as("[%d - %d] overlaps with [%d - %d]",
                        two.getStart(), two.getEnd(), one.getStart(), one.getEnd())
                .isTrue();

        assertThat(one.overlaps(three))
                .as("[%d - %d] does not overlaps with [%d - %d]",
                        one.getStart(), one.getEnd(), three.getStart(), three.getEnd())
                .isFalse();
        assertThat(two.overlaps(three))
                .as("[%d - %d] does not overlaps with [%d - %d]",
                        two.getStart(), two.getEnd(), three.getStart(), three.getEnd())
                .isFalse();
        assertThat(three.overlaps(two))
                .as("[%d - %d] overlaps with [%d - %d]",
                        three.getStart(), three.getEnd(), two.getStart(), two.getEnd())
                .isFalse();
    }
    
    @Test
    public void shouldThrowExceptionIfStartIsGreaterOrEqualToEnd() {
        assertThatThrownBy(() -> {
             ActivityPair.from(0, 0);
        })
        .as("starting from 0 to 0")
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("start should be always be less than end")
        ;
        assertThatThrownBy(() -> {
            ActivityPair.from(2, 1);
        })
        .as("starting from 2 to 1")
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("start should be always be less than end")
        ;
    }
}
