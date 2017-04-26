package za.co.kholofelo.architecture.designpatterns.threadsafe;

/**
 * @author Kholofelo Maloma
 * @Explained: See explanations at method level
 * @since 2017/04/26.
 */
public class ThreadSafeSingleton {


    private static ThreadSafeSingleton singleton;

    private ThreadSafeSingleton() {
    }


    /**
     * This works fine, just like the LazyInitialisation example here <link>za.co.kholofelo.architecture.designpatterns.lazy.LazyInitSingleton</link>
     * However, it may throttle performance. That is, if #getInstance() was called by many threads at once, say, a million threads, there would be a LONG queue, each waiting for the thread ahead of it to release this resource
     */
    public static synchronized ThreadSafeSingleton getSingleton() {
        if (singleton == null) {
            singleton = new ThreadSafeSingleton();
        }
        return singleton;
    }

    /**
     * Now stay with me. You see the above #getSingleton() method? It will line-up ALL million threads which are asking for the singleton
     * But as soon as the Singleton is created, we no longer need synchronisation because we only sync for object creation.
     *
     */
    public static ThreadSafeSingleton getSingletonWithTwoChecks() {
        if (singleton == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (singleton == null) {
                    singleton = new ThreadSafeSingleton();
                }
            }
        }
        return singleton;
    }
}
