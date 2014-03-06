import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;
import java.util.Date;

@BTrace(unsafe=true) 
public class TraceMethodExecuteTimeUnsafe{
    
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
      println(strcat(strcat("CaseObject.execute time is:",str(timeMillis()-beginTime)),"ms"));
	  try {  
            Thread.sleep(2000); 
			println(strcat("now:",str(new Date())));
      } catch (InterruptedException e) {  
      }  
   }
}