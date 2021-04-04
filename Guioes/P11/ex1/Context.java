class Context{
    private Strategy strat;

    public Context(Strategy strat){
        this.strat = strat;
    }

    public void setStrategy(Strategy strat){
        this.strat = strat;
    }

    public Phone[] sort(Phone[] phones){
        return this.strat.sort(phones);
    }
}