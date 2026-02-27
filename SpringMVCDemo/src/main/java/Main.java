import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        User user=(User) context.getBean("testUser");
        System.out.println(user);


        Product product=Product.builder().name("Laptop").build();
        System.out.println(product);
    }
}
