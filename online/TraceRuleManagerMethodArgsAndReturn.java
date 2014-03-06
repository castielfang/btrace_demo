import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;
 
@BTrace
public class TraceRuleManagerMethodArgsAndReturn{
   @OnMethod(
      clazz="com.taobao.pamirs.qogir.rule.manager.impl.RuleManagerImpl",
      method="updateRule",
      location=@Location(value=Kind.RETURN)
   )
   public static void m(com.taobao.pamirs.qogir.rule.dataobject.RuleDO rule,@Return com.taobao.pamirs.qogir.common.result.QogirResult result) {
        print(strcat("rule:",str(rule)));
        println(strcat(" :return  ", str(result)));
        jstack();
    }     

}