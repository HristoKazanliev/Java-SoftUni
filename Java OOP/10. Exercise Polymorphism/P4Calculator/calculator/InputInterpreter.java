package calculator;

public class InputInterpreter {
    private CalculationEngine engine;
    private MemoryStorageOperation memoryStorageOperation;
    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memoryStorageOperation = new MemoryStorageOperation();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivideOperation();
        } else if (operation.equals("ms")) {
            return this.memoryStorageOperation;
        } else if (operation.equals("mr")) {
            return new MemoryRecallOperation(this.memoryStorageOperation);
        }

        return null;
    }
}
