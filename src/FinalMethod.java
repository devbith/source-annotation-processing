
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

 // Three retention policy
 // - SOURCE 
 // - RUNTIME
 // - CLASS 

@Retention(RetentionPolicy.SOURCE)  
@Target(ElementType.METHOD)
public @interface FinalMethod {

}
