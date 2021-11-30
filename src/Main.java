import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void addRandomNumber(ArrayList<Integer> list) {
        int originalSize = list.size();
        Random random = new Random();
        while (originalSize + 1 != list.size()){
            int n = random.nextInt(100);
            list.add(n);
        }
    }

    public static void addConditionNumber(ArrayList<Integer> list) {
        Random random = new Random();
        int n = random.nextInt(100);
        if (list instanceof ConditionArrayList) {
            ConditionArrayList conditionList = (ConditionArrayList) list;
            while(!conditionList.isCorrect(n)) {
                n = random.nextInt(100);
            }
        }
        list.add(n);
    }

    public static void main(String[] args) {

        ConditionArrayList conditionOddList = new ConditionArrayList(n-> Math.abs(n) % 2 == 1);
        conditionOddList.add(1);
        conditionOddList.add(2);
        addConditionNumber(conditionOddList);
        System.out.println("condition odd list:");
        System.out.println(conditionOddList);

        ConditionArrayList conditionEvenList = new ConditionArrayList(n-> Math.abs(n) % 2 == 0);
        conditionEvenList.add(1);
        conditionEvenList.add(2);
        addConditionNumber(conditionEvenList);
        System.out.println("condition even list:");
        System.out.println(conditionEvenList);

        OddArrayList oddList = new OddArrayList(3, 4);
        addRandomNumber(oddList);
        addConditionNumber(oddList);
        System.out.println("odd list:");
        System.out.println(oddList);
        System.out.println("size: " + oddList.size());

        ArrayList<Integer> regularList = new ArrayList<>();
        regularList.add(3);
        regularList.add(4);
        addRandomNumber(regularList);
        addConditionNumber(regularList);
        System.out.println("regular list:");
        System.out.println(regularList);
        System.out.println("size: " + regularList.size());
    }
}
