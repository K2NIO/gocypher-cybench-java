package com.gocypher.cybench.core.annotation;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

import com.google.auto.service.AutoService;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.util.Name;

@SupportedAnnotationTypes("org.openjdk.jmh.annotations.Benchmark")
@SupportedSourceVersion(SourceVersion.RELEASE_8)

@AutoService(Processor.class)
public class BenchmarkJavaDocProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
            Properties p = new Properties();

            annotatedElements.forEach(element -> {
                String docComment = processingEnv.getElementUtils().getDocComment(element);
                if (docComment != null) {
                    Symbol.ClassSymbol classSymbol = ((Symbol.MethodSymbol) element).enclClass();
                    // Name nm =
                    // classSymbol.getQualifiedName().subName(classSymbol.getQualifiedName().lastIndexOf((byte) '.') +
                    // 1, classSymbol.getQualifiedName().length());
                    // Name pck = classSymbol.getQualifiedName().subName(0,
                    // classSymbol.getQualifiedName().lastIndexOf((byte) '.'));
                    Name qualifiedName = ((Symbol.MethodSymbol) element).getQualifiedName();

                    processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
                            "Found " + ((Symbol.MethodSymbol) element).getQualifiedName());
                    p.put(classSymbol + "." + qualifiedName, docComment);
                }
            });

            if (!p.isEmpty()) {
                try {
                    FileObject file = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "",
                            "benchJavaDoc");
                    try (Writer fw = file.openWriter()) {
                        p.store(fw, "");
                    }
                } catch (IOException e) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getMessage());
                }
            }
        }

        return false;
    }
}
