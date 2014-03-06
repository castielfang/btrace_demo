import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;
 
@BTrace public class TraceMethodLine{
   @OnMethod(
      clazz="CaseObject",
      location=@Location(value=Kind.LINE,line=7)
   )
   public static void traceExecute(@ProbeClassName String pcn,@ProbeMethodName String pmn,int line){
     println(strcat(strcat(strcat("call ",pcn),"."),pmn));
   }
}