package br.edu.fatec.sjc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberAscOrderTest {
    private CustomStack<Integer> stack;
    private CalculableStrategy<Integer> calculableStrategy;

    @BeforeEach
    public void setup() {
        calculableStrategy = Mockito.mock(CalculableStrategy.class);
    }

    @Test
    public void testSortWithSixNumbers() throws StackFullException, StackEmptyException {
        stack = new CustomStack<>(6, calculableStrategy);

        // Simula que a estratégia apenas retorna o mesmo número
        Mockito.when(calculableStrategy.calculateValue(Mockito.anyInt()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        stack.push(45);
        stack.push(10);
        stack.push(22);
        stack.push(8);
        stack.push(33);
        stack.push(19);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> sorted = sorter.sort();

        assertEquals(6, sorted.size());
        assertIterableEquals(List.of(8, 10, 19, 22, 33, 45), sorted);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSortWithEmptyStack() throws StackEmptyException {
        stack = new CustomStack<>(6, calculableStrategy);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> sorted = sorter.sort();

        assertTrue(sorted.isEmpty());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testConstructorWithNullStackThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new NumberAscOrder<>(null));
    }
}

