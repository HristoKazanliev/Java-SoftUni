public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar();
        jar.add("test");

        System.out.println(jar.remove());
    }
}