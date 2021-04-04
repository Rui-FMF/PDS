class CrastoLunchBuilder implements LunchBuilder{
    protected unch lunch;

    public CrastoLunchBuilder(){
        lunch = new Lunch();
    }

    public void buildDrink(){
        lunch.setDrink("Vinho Tinto");
    }
    public void buildMainCourse(){
        lunch.setMainCourse("Bacalhau à lagareiro");
    }
    public void buildSide(){
        lunch.setSide("Broa");
    }

    public Lunch getMeal(){
        return lunch;
    }
}

class SnackLunchBuilder implements LunchBuilder{
    protected unch lunch;

    public SnackLunchBuilder(){
        lunch = new Lunch();
    }

    public void buildDrink(){
        lunch.setDrink("Sumo");
    }
    public void buildMainCourse(){
        lunch.setMainCourse("Pão com Panado");
    }
    public void buildSide(){
        lunch.setSide("Rissol");
    }

    public Lunch getMeal(){
        return lunch;
    }
}

class CentralCantineLunchBuilder implements LunchBuilder{
    protected Lunch lunch;

    public CentralCantineLunchBuilder(){
        lunch = new Lunch();
    }

    public void buildDrink(){
        lunch.setDrink("Água");
    }
    public void buildMainCourse(){
        lunch.setMainCourse("Grelhada mista");
    }
    public void buildSide(){
        lunch.setSide("Queijo fresco");
    }

    public Lunch getMeal(){
        return lunch;
    }
}