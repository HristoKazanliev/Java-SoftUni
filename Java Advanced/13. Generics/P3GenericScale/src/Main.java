public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale1 = new Scale<>(1 , 2);
        System.out.println(scale1.getHeavier());

        Scale<Integer> scale2 = new Scale<>(1 , 1);
        System.out.println(scale2.getHeavier());
    }
}