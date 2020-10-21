import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        //BeanFactory container = new ClassPathXmlApplicationContext("configFullTime.xml","configPartTime.xml");

        ApplicationContext container = new ClassPathXmlApplicationContext("configFullTime.xml","configPartTime.xml");

//        Mentor fullTimeMentor = (Mentor)container.getBean("fullTimeMentor");
//        Mentor partTimeMentor = (Mentor)container.getBean("partTimeMentor");
//        fullTimeMentor.createAccount();
//        partTimeMentor.createAccount();

        Mentor fullTimeMentor = container.getBean("fullTimeMentor",Mentor.class);
        fullTimeMentor.createAccount();
        Mentor partTimeMentor = container.getBean("partTimeMentor",Mentor.class);
        partTimeMentor.createAccount();

    }
}
