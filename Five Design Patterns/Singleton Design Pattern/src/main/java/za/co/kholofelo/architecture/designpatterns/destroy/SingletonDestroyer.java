package za.co.kholofelo.architecture.designpatterns.destroy;

import za.co.kholofelo.architecture.designpatterns.billpugh.BillPughSingleton;

import java.lang.reflect.Constructor;

/**
 * @author Kholofelo Maloma
 * @explained: Ok, the purpose of having a singleton is to have a singleton - a single instance of an object in the VM at a given lifecycle.
 * But back doors always break the rules. Using Java Reflection, we can create more instances of a class with a private constructor.
 * Yup!
 * @since 2017/04/26.
 */
public class SingletonDestroyer {

    public static void main(String[] args) {
        BillPughSingleton firstSingleton = BillPughSingleton.getInstance();
        BillPughSingleton secondSingleton = BillPughSingleton.getInstance();

        System.out.println("Checking to see if both first and second singletons indeed point to the same instance in memory");
        System.out.println("firstSingleton == secondSingleton? " + (firstSingleton == secondSingleton));
        System.out.println("Yes, they are the same instance, just pointed to by two different handlers, firstSingleton and secondSingleton");

        System.out.println("Now let's see if we can break the rules...\nCreating an instance of BillPughSingleton which would be a second one in memory.");
        BillPughSingleton thirdSingleton = null;
        try {
            Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();

            Constructor constructor = constructors[0];//There's always at least 1 constructor (default or overriden otherwise)
            constructor.setAccessible(true);// this right here, break 'em rules!
            thirdSingleton = (BillPughSingleton) constructor.newInstance();


        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("Failed to break the rules!", e);
        }

        System.out.println("Alright, let's see if thirdSingleton is the same as firstSingleton and secondSingleton, shall we?\n\n");
        System.out.println("firstSingleton == thirdSingleton ? " + (firstSingleton == thirdSingleton));
        System.out.println("secondSingleton == thirdSingleton ? " + (secondSingleton == thirdSingleton));
        System.out.println("firstSingleton == secondSingleton? " + (firstSingleton == secondSingleton));

        System.out.println("\n\t\t----------> RULES BROKEN <----------");
    }


}
