class LunchDirector{
    private LunchBuilder lunchbuilder;

    public LunchDirector(LunchBuilder lb){
        lunchbuilder = lb;
    }

    public Lunch getMeal(){
        return lunchbuilder.getMeal();
    }

    public void constructMeal(){
        lunchbuilder.buildDrink();
        lunchbuilder.buildMainCourse();
        lunchbuilder.buildSide();
    }
}