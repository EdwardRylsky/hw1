package org.example;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {
    private static final HomeWork HOME_WORK = new HomeWork();
    private static final Predicate<Integer> PRED_LESS_4 = integer -> integer.compareTo(4) < 0;
    private static final Predicate<Integer> PRED_LESS_10 = integer -> integer.compareTo(10) < 0;

    @Test
    void partitionBy() {
        Node<Integer> root = new Node<>(1);
        assertEquals(1, HOME_WORK.partitionBy(root, PRED_LESS_4));
        root.add(2);
        assertEquals(2, HOME_WORK.partitionBy(root, PRED_LESS_4));
        root.add(3);
        assertEquals(3, HOME_WORK.partitionBy(root, PRED_LESS_4));
        root.add(4);
        root.add(5);

        assertEquals(3, HOME_WORK.partitionBy(root, PRED_LESS_4));

        // Exceptions check
        assertThrows(IllegalArgumentException.class, () -> HOME_WORK.partitionBy(null, PRED_LESS_4));
        assertThrows(IllegalArgumentException.class, () -> HOME_WORK.partitionBy(root, null));

        // 1 size list nullable
        assertEquals(0, HOME_WORK.partitionBy(new Node<>(null), PRED_LESS_4));

        // 1 size list not-nullable pred true
        assertEquals(1, HOME_WORK.partitionBy(new Node<>(1), PRED_LESS_4));

        // 1 size list not-nullable pred false
        assertEquals(0, HOME_WORK.partitionBy(new Node<>(10), PRED_LESS_4));

        // pred true for all nodes
        assertEquals(5, HOME_WORK.partitionBy(root, PRED_LESS_10));

        // don't count null and stop
        root.add(null);
        root.add(6);
        assertEquals(5, HOME_WORK.partitionBy(root, PRED_LESS_10));

    }

    @Test
    void findNthElement() {
        Node<Integer> root = new Node<>(1);
        root.add(2).add(3).add(4).add(5).add(5);

        assertEquals(3, HOME_WORK.findNthElement(root,3));

        // negative n
        assertThrows(IndexOutOfBoundsException.class, () -> HOME_WORK.findNthElement(root, -1));
        // nullable list
        assertThrows(IllegalArgumentException.class, () -> HOME_WORK.findNthElement(null, 1));

        // N-th element is null
        root.getNext().getNext().setNext(null);
        assertNull(HOME_WORK.findNthElement(root, 4));

        // unreachable element
        assertThrows(NullPointerException.class, () -> HOME_WORK.findNthElement(root, 5));
    }
}