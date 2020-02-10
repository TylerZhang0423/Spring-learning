public class Singleton2 {

    //1 将构造方法私有化，不提供外界直接创建对象
    private Singleton2(){}


    //2 声明一个Singleton2类的唯一实例
    private static Singleton2 instance;

    //3 提供一个用于获取实例的方法，加入判断，如果实例非空，就创建
    public static Singleton2 getInstance2() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
