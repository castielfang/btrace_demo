import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class LogFactoryTrace{
   @OnMethod(
      clazz="+org.apache.commons.logging.LogFactory",
      method="/.*/"
   )

   public static void m(@Self Object obj) {
        println(strcat("\t object of: ", Reflective.name(Reflective.classOf(obj))));
   }

}
