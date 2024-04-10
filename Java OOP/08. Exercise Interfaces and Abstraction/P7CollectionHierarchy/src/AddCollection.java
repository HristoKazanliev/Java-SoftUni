public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String item) {
        super.addItem(item);
        return super.getItems().size() - 1;
    }
}
