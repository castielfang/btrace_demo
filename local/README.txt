1.±‡“ÎCaseObject.java\Case1.java\Case2.java : 
	javac CaseObject.java 
	javac Case1.java 
	javac Case2.java 
2.∆Ù∂ØCase1.class: java Case1 java Case2

3.btrace demos: 
	jpsªÒ»°java id 
	${BTRACE_HOME}\bin\btrace -cp ..\java [pid] TraceMethodArgsAndReturn.java 
	${BTRACE_HOME}\bin\btrace -cp ..\java [pid] TraceMethodExecuteTimeOnTime.java