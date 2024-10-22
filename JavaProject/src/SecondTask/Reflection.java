package SecondTask;

import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) {
        TestClass c = new TestClass();
        int sum = 0;
        

        Field[] fs = c.getClass().getDeclaredFields();

        for(int i = 0;i < fs.length;i++) {
            fs[i].setAccessible(true);
            try {
                if(fs[i].getType().getTypeName() == "int")
                    sum += (int) fs[i].get(c);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(sum);

    }




}
