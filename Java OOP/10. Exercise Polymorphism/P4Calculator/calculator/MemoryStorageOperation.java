package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class MemoryStorageOperation implements Operation{
    private Deque<Integer> memory;

    public MemoryStorageOperation() {
        this.memory = new ArrayDeque<>();
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
