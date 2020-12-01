public class Filter extends Command {

    private ClueService clueService;

    public Filter(IO io, ClueService clueService) {
        super(io);
        this.clueService = clueService;
    }


    @Override
    public void execute() {
    }

}

