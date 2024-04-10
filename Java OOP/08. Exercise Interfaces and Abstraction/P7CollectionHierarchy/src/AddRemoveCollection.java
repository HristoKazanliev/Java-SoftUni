public class AddRemoveCollection extends Collection implements Addable, AddRemovable{
    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }

    @Override
    public String remove() {
        return super.removeLast();
    }
}
