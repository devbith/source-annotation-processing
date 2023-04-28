
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.ExecutableElement;
import javax.tools.Diagnostic;
import java.util.Set;


@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes("FinalMethod")
public class FinalMethodAnnotationProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    System.out.println("Annotation Processor called");

    for (Element element : roundEnv.getElementsAnnotatedWith(FinalMethod.class)) {
      if (element.getKind() == ElementKind.METHOD) {
          ExecutableElement methodElement = (ExecutableElement) element;
          if (!methodElement.getModifiers().contains(Modifier.FINAL)) {
             String errorMessage = methodElement.getEnclosingElement().getSimpleName() + "." + methodElement.getSimpleName() + "() is annotated with @FinalMethod but does not have the final modifier";
             throw new RuntimeException(errorMessage);
          }
      }
    }
   return true;
  }

}
