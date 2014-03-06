import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;
 import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@BTrace public class TraceMethodExecuteTimeOnEvent{
   private static Map<String, AtomicInteger> histo = Collections.newHashMap();

   @TLS static long beginTime;
 
   @OnMethod(
      clazz="CaseObject",
      method="execute"
   )
   public static void traceExecuteBegin(){
     beginTime=timeMillis();
   }
 
   @OnMethod(
      clazz="CaseObject",
      method="execute",
      location=@Location(Kind.RETURN)
   )

   public static void traceExecute(int sleepTime,@Return boolean result){
	  String executeTime = str(timeMillis()-beginTime);
	  AtomicInteger ai = Collections.get(histo, executeTime);
        if (ai == null) {
            ai = Atomic.newAtomicInteger(1);
            Collections.put(histo, executeTime, ai);
        } else {
            Atomic.incrementAndGet(ai);
        }    
   }

   @OnEvent
   public static void onEvent() {
	      if (Collections.size(histo) != 0) {
            printNumberMap("Component Histogram", histo);
        }
   }
}