package za.co.kholofelo.architecture.designpatterns.serialisation;

import java.io.Serializable;

/**
 * @author Kholofelo Maloma
 * @since 2017/04/26.
 */
public class SerialisedBillPughSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerialisedBillPughSingleton() {
    }

    private static class BillPughSingletonHolder {

        private static final SerialisedBillPughSingleton INSTANCE = new SerialisedBillPughSingleton();
    }

    public static SerialisedBillPughSingleton getInstance() {
        return BillPughSingletonHolder.INSTANCE;
    }

    /**
     *
     * this makes sure not to create another instance but return the same instance! It will deny the second creation of this instance either using Reflection (throws exeption) or serialisation (just returns the same instance)
     */
    protected Object readResolve() {
        return getInstance();
    }
}
