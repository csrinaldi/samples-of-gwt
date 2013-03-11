package org.jboss.errai.ioc.client;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import org.jboss.errai.ioc.client.api.ReplyTo;
import org.jboss.errai.ioc.client.api.ToSubject;

public class QualifierEqualityFactoryImpl implements QualifierEqualityFactory {
  private HashMap<String, AnnotationComparator> comparatorMap = new HashMap<String, AnnotationComparator>();
  public QualifierEqualityFactoryImpl() {
    comparatorMap.put("org.jboss.errai.ioc.client.api.ReplyTo", new AnnotationComparator<ReplyTo>() {
      @Override public boolean isEqual(ReplyTo a1, ReplyTo a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(ReplyTo a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.jboss.errai.ioc.client.api.ToSubject", new AnnotationComparator<ToSubject>() {
      @Override public boolean isEqual(ToSubject a1, ToSubject a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(ToSubject a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
  }

  public boolean isEqual(Annotation a1, Annotation a2) {
    if (QualifierUtil.isSameType(a1, a2)) {
      if (comparatorMap.containsKey(a1.annotationType().getName())) {
        return ((AnnotationComparator) comparatorMap.get(a1.annotationType().getName())).isEqual(a1, a2);
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

  public int hashCodeOf(Annotation a1) {
    if (comparatorMap.containsKey(a1.annotationType().getName())) {
      return ((AnnotationComparator) comparatorMap.get(a1.annotationType().getName())).hashCodeOf(a1);
    } else {
      return a1.annotationType().hashCode();
    }
  }
}