package club.ldolin.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();
        //2.动态代理增强Lenovo对象
        /**
         * 3个参数
         * 1.类加载器：真实对象.getClass().getClassLoader()
         * 2.接口数组：真实对象.getClass().getInterfaces()
         * 3.处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * 代理逻辑编写的方法，所有代理对象调用的方法，都会触发该方法的执行
             * @param proxy： 代理对象
             * @param method：代理对象调用的方法，被封装为对象
             * @param args：代理对象调用的方法时，传递的实际对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("方法已执行");
                //判断是否是sale方法
                if(method.getName().equals("sale")){
                    //1.增强参数
                    Double money = (Double)args[0];
                    money = money*0.85;
                    //3.方法体增强
                    System.out.println("专车接送...");
                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货...");
                    //2.增强返回值
                    return obj+"_鼠标垫";
                }else {
                    //使用真实对象调用该方法
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }

            }
        });
        //3.调用对象
        String sale = proxy_lenovo.sale(8000);
        System.out.println(sale);
//        proxy_lenovo.show();
    }
}
