package za.co.kholofelo.architecture.designpatterns.billpugh;

/**
 * @author Kholofelo Maloma
 * @explained : Bill Pugh came up with this genius Singleton Creation Model. It is thread safe and does not create a bottleneck (does not use synchronised).
 * When BillPughSingleton is loaded in memory, BillPughSingletonHolder is not loaded. So the singleton is not created.
 * But when #getInstance() is called, BillPughSingletonHolder is loaded for the first time, creating the singleton.
 * <p>
 * How does it work?
 * Well, remember class loading is Thread safe. So if a thousand threads call #getSingleton() at once, that would mean that:
 * 1) They would all have to wait for the inner class to be loaded.
 * 2) Class loading is thread safe, and as part of class loading, all static members, including the static initialisers are executed
 * 3) After BillPughSingleton Holder is loaded, the singleton instance would be created as part of class loading. So there is no way all 1000 threads would get different instances
 * @since 2017/04/26.
 */
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class BillPughSingletonHolder {
        /**
         * Please note: We could use the static initialiser to handle any constructional exceptions. Oh God I love this Bill guy!
         */
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return BillPughSingletonHolder.INSTANCE;
    }
}
