package specmath;

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {


    public static ArrayList<Object> Shuffle(ArrayList<Integer> table){
        Random r = new Random();
        long seed = r.nextLong();
        r.setSeed(seed);
        for(int e = table.size()-1; e > 0; e--){
            int index = Math.round(r.nextFloat() *(e-1)),
                    tempor = table.get(e);

            table.set(e, table.get(index));
            table.set(index, tempor);
        }
        ArrayList<Object> returned = new ArrayList();
        returned.add(table);
        returned.add(seed);
        return returned;
    }

    public static ArrayList<Integer> Shuffle(ArrayList<Integer> table, long seed){
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
