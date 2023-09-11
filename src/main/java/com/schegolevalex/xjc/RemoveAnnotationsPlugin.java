package com.schegolevalex.xjc;

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JFieldVar;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.Outline;
import org.xml.sax.ErrorHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RemoveAnnotationsPlugin extends Plugin {
    public String getOptionName() {
        return "XRemoveAnnotationsPlugin";
    }

    public String getUsage() {
        return "  -XRemoveAnnotationsPlugin    :  xjc plugin for remove all annotations from generated jaxb files";
    }

    public boolean run(Outline model, Options options, ErrorHandler errorHandler) {
        for (ClassOutline classOutline : model.getClasses()) {
            Collection<JAnnotationUse> removedClassAnnotations = classOutline.getImplClass().annotations();
            List<JAnnotationUse> clonedRemovedClassAnnotations = new ArrayList<>(removedClassAnnotations);
            for (JAnnotationUse removedAnnotation : clonedRemovedClassAnnotations) {
                classOutline.getImplClass().removeAnnotation(removedAnnotation);
            }

            Collection<JFieldVar> fields = classOutline.getImplClass().fields().values();
            for (JFieldVar jFieldVar : fields) {
                Collection<JAnnotationUse> removedFieldAnnotations = jFieldVar.annotations();
                ArrayList<JAnnotationUse> clonedRemovedFieldAnnotations = new ArrayList<>(removedFieldAnnotations);
                for (JAnnotationUse removedFieldAnnotation : clonedRemovedFieldAnnotations) {
                    jFieldVar.removeAnnotation(removedFieldAnnotation);
                }
            }
        }
        return true;
    }
}
