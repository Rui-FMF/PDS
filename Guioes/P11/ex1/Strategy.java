public interface Strategy{
    Phone[] sort(Phone[] phones);
}

class BubbleSort implements Strategy{
    public Phone[] sort(Phone[] phones){
        return phones;
    }
}

class QuickSort implements Strategy{
    public Phone[] sort(Phone[] phones){
        return phones;
    }
}

class InsertionSort implements Strategy{
    public Phone[] sort(Phone[] phones){
        return phones;
    }
}