package barracksWars.core.commands;

import barracksWars.core.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command{
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String output = repository.getStatistics();
		return output;
    }
}
