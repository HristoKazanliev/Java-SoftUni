public class MyListImpl extends Collection implements Addable, AddRemovable, MyList{
    @Override
    public int getUsed() {
        return super.getItems().size();
    }

    @Override
    public String remove() {
        return super.removeFirst();
    }

    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }
}
