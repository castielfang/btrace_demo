import java.util.Random;
public class Case2{
 
   public static void main(String[] args) throws Exception{
      Random random=new Random();
      CaseObject object=new CaseObject();
      boolean result=true;
      while(result){
         result=object.execute(random.nextInt(100));
         Thread.sleep(1000);
      }
   }
 
}