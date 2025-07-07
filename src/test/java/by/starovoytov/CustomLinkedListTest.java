package by.starovoytov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

    private CustomLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new CustomLinkedList<>();
    }

    @Test
    @DisplayName("New list should be empty")
    void newListShouldBeEmpty() {
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
        assertThrows(NoSuchElementException.class, () -> list.getLast());
    }

    @Test
    @DisplayName("addFirst should correctly add elements to the beginning")
    void addFirstShouldAddElementsToBeginning() {
        list.addFirst(10);
        assertEquals(1, list.size());
        assertEquals(10, list.getFirst());
        assertEquals(10, list.getLast());

        list.addFirst(20);
        assertEquals(2, list.size());
        assertEquals(20, list.getFirst());
        assertEquals(10, list.getLast());
    }

    @Test
    @DisplayName("addLast should correctly add elements to the end")
    void addLastShouldAddElementsToEnd() {
        list.addLast(10);
        assertEquals(1, list.size());
        assertEquals(10, list.getFirst());
        assertEquals(10, list.getLast());

        list.addLast(20);
        assertEquals(2, list.size());
        assertEquals(10, list.getFirst());
        assertEquals(20, list.getLast());
    }

    @Test
    @DisplayName("add by index should insert elements at correct positions")
    void addAtIndexShouldInsertElements() {
        list.addLast(10);
        list.addLast(30);

        list.add(1, 20);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));

        list.add(0, 5);
        assertEquals(4, list.size());
        assertEquals(5, list.getFirst());

        list.add(4, 40);
        assertEquals(5, list.size());
        assertEquals(40, list.getLast());
    }

    @Test
    @DisplayName("add with invalid index should throw IndexOutOfBoundsException")
    void addWithInvalidIndexShouldThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 10));
    }

    @Test
    @DisplayName("get by index should return the correct element")
    void getByIndexShouldReturnCorrectElement() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    @DisplayName("get with invalid index should throw IndexOutOfBoundsException")
    void getWithInvalidIndexShouldThrowException() {
        list.addFirst(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    @DisplayName("removeFirst should remove and return the first element")
    void removeFirstShouldReturnFirstElement() {
        list.addLast(10);
        list.addLast(20);

        Integer removedElement = list.removeFirst();
        assertEquals(10, removedElement);
        assertEquals(1, list.size());
        assertEquals(20, list.getFirst());
    }

    @Test
    @DisplayName("removeFirst on a single-element list should make the list empty")
    void removeFirstOnSingleElementListShouldMakeListEmpty() {
        list.addFirst(10);
        list.removeFirst();
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    @Test
    @DisplayName("removeFirst on an empty list should throw NoSuchElementException")
    void removeFirstOnEmptyListShouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }

    @Test
    @DisplayName("removeLast should remove and return the last element")
    void removeLastShouldReturnLastElement() {
        list.addLast(10);
        list.addLast(20);

        Integer removedElement = list.removeLast();
        assertEquals(20, removedElement);
        assertEquals(1, list.size());
        assertEquals(10, list.getLast());
    }

    @Test
    @DisplayName("removeLast on a single-element list should make the list empty")
    void removeLastOnSingleElementListShouldMakeListEmpty() {
        list.addFirst(10);
        list.removeLast();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("removeLast on an empty list should throw NoSuchElementException")
    void removeLastOnEmptyListShouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }

    @Test
    @DisplayName("remove by index should remove and return the correct element")
    void removeByIndexShouldReturnCorrectElement() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        Integer removed = list.remove(1);
        assertEquals(20, removed);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    @DisplayName("remove at index 0 should work like removeFirst")
    void removeAtIndexZeroShouldWorkLikeRemoveFirst() {
        list.addLast(10);
        list.addLast(20);

        Integer removed = list.remove(0);
        assertEquals(10, removed);
        assertEquals(1, list.size());
        assertEquals(20, list.getFirst());
    }

    @Test
    @DisplayName("remove at the last index should work like removeLast")
    void removeAtLastIndexShouldWorkLikeRemoveLast() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        Integer removed = list.remove(2);
        assertEquals(30, removed);
        assertEquals(2, list.size());
        assertEquals(20, list.getLast());
    }
}