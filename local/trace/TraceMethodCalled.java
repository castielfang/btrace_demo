import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;
 
@BTrace public class TraceMethodCalled{
   @OnMethod(
      clazz="CaseObject",
      method="execute"
   )
   public static void traceExecute(){
     println("who call CaseObject.execute :");
     jstack(); 
   }
}