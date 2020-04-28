package specmath;

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
    public static ArrayList<Integer> Shuffle(ArrayList<Integer> table){
        Random r = new Random();
        for(int e = table.size()-1; e > 0; e--){
            int index = Math.round(r.nextFloat() *(e-1)),
                    tempor = table.get(e);

            table.set(e, table.get(index));
            table.set(index, tempor);
        }
        return table;
    }

    public static ArrayList<Integer> Shuffle(ArrayList<Integer> table, int seed){
        Random r = new Random(seed);
        for(int e = table.size()-1; e > 0; e--){
            int index = Math.round(r.nextFloat() *(e-1)),
                    tempor = table.get(e);

            table.set(e, table.get(index));
            table.set(index, tempor);
        }
        return table;
    }
}
