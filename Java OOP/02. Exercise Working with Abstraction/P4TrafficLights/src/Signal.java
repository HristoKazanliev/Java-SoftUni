public enum Signal {
    RED,
    GREEN,
    YELLOW;

    public static void changeSignals(Signal[] signals){
        for (int i = 0; i < signals.length; i++) {
            //red -> green -> yellow -> red
            switch (signals[i]) {
                case RED: {
                    signals[i] = Signal.GREEN;
                    break;
                }
                case GREEN: {
                    signals[i] = Signal.YELLOW;
                    break;
                }
                case YELLOW: {
                    signals[i] = Signal.RED;
                    break;
                }
            }
        }
    }

    public static void print(Signal[] signals) {
        for (Signal signal : signals) {
            System.out.print(signal + " ");
        }
        System.out.println();
    }
}
