package za.co.kholofelo.architecture.designpatterns.serialisation;

import java.io.*;

/**
 * @author Kholofelo Maloma
 * @since 2017/04/26.
 */
public class SerialisedSingletonTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerialisedBillPughSingleton instanceOne = SerialisedBillPughSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "bill-out.obj"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "bill-out.obj"));
        SerialisedBillPughSingleton instanceTwo = (SerialisedBillPughSingleton) in.readObject();
        in.close();

        System.out.println("Comparing the two instances\n");
        System.out.println("is instanceOne == instanceTwo? " + (instanceOne == instanceTwo));

    }
}
