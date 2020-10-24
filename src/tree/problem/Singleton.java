package tree.problem;

/**
 * @author echo
 * @version V1.0
 * @Package tree.problem
 * @date 2020/10/20 12:38
 */
public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton(){}

    public Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {

    }
}
