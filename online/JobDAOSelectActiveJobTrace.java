import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;
import java.util.List;
import com.taobao.pamirs.kongur.model.Job;
import java.lang.reflect.Field;

@BTrace
public class JobDAOSelectActiveJobTrace{
   private static Field listField = Reflective.field("java.util.ArrayList", "size");
   @OnMethod(
      clazz="com.taobao.pamirs.kongur.dal.JobDAOImpl",
      method="selectActiveJob",
      location=@Location(value=Kind.RETURN)
   )
   public static void m(String bizApp,String runtimeEnv,@Return List<Job> list) {
        print(strcat("bizapp:",bizApp));
        print(strcat("\t runtimeEnv:",runtimeEnv));
        println(strcat("\t return  list.size ", str(Reflective.get(listField,list))));
        //jstack();
    }     

}