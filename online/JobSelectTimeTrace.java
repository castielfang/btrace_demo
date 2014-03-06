import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace 
public class JobSelectTimeTrace {
        @TLS private static long startTime;

        @OnMethod(
                clazz="com.taobao.pamirs.kongur.pvm.job.DefaultJobExecutor",
                method="jobExecute",
                location=@Location(value=Kind.LINE, line=93)
        )
        public static void onbefore() {
                startTime = timeMillis();
        }

        @OnMethod(
                clazz="com.taobao.pamirs.kongur.pvm.job.DefaultJobExecutor",
                method="jobExecute",
                location=@Location(value=Kind.LINE, line=133)
        )
        public static void onreturn() {
                println(strcat("selectActiveJob Timetaken(msec) ", str(timeMillis() - startTime)));
        }
}