package org.jboss.errai.marshalling.server.impl;

import com.logikas.samples.errai.client.shared.Customer;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.enterprise.context.Dependent;
import org.jboss.errai.bus.client.api.base.MessageDeliveryFailure;
import org.jboss.errai.bus.client.api.base.TransportIOException;
import org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent;
import org.jboss.errai.marshalling.client.api.Marshaller;
import org.jboss.errai.marshalling.client.api.MarshallerFactory;
import org.jboss.errai.marshalling.client.api.MarshallingSession;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.BigDecimalMarshaller;
import org.jboss.errai.marshalling.client.marshallers.BigIntegerMarshaller;
import org.jboss.errai.marshalling.client.marshallers.BooleanMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ByteMarshaller;
import org.jboss.errai.marshalling.client.marshallers.CharacterMarshaller;
import org.jboss.errai.marshalling.client.marshallers.DateMarshaller;
import org.jboss.errai.marshalling.client.marshallers.DoubleMarshaller;
import org.jboss.errai.marshalling.client.marshallers.FloatMarshaller;
import org.jboss.errai.marshalling.client.marshallers.IntegerMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LinkedHashSetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LinkedListMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LinkedMapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ListMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LongMarshaller;
import org.jboss.errai.marshalling.client.marshallers.MapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.marshalling.client.marshallers.PriorityQueueMarshaller;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.jboss.errai.marshalling.client.marshallers.QueueMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SQLDateMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ShortMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SortedMapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SortedSetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringBufferMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringBuilderMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringMarshaller;
import org.jboss.errai.marshalling.client.marshallers.TimeMarshaller;
import org.jboss.errai.marshalling.client.marshallers.TimestampMarshaller;
@Dependent public class ServerMarshallingFactoryImpl implements MarshallerFactory {
  private Map<String, Marshaller> marshallers = new HashMap<String, Marshaller>();
  private FloatMarshaller java_lang_Float;
  private LinkedListMarshaller java_util_LinkedList;
  private ListMarshaller java_util_Vector;
  private QueueMarshaller java_util_Queue;
  private SetMarshaller java_util_HashSet;
  private LongMarshaller java_lang_Long;
  private ShortMarshaller java_lang_Short;
  private PriorityQueueMarshaller java_util_PriorityQueue;
  private ListMarshaller java_util_List;
  private SortedSetMarshaller java_util_SortedSet;
  private QualifyingMarshallerWrapper<AbstractMap> java_util_AbstractMap;
  private QueueMarshaller java_util_AbstractQueue;
  private QualifyingMarshallerWrapper<LinkedHashMap> java_util_LinkedHashMap;
  private StringBuilderMarshaller java_lang_StringBuilder;
  private DoubleMarshaller java_lang_Double;
  private QualifyingMarshallerWrapper<Map> java_util_Map;
  private IntegerMarshaller java_lang_Integer;
  private BooleanMarshaller java_lang_Boolean;
  private ObjectMarshaller java_lang_Object;
  private TimestampMarshaller java_sql_Timestamp;
  private SortedSetMarshaller java_util_TreeSet;
  private QualifyingMarshallerWrapper<SortedMap> java_util_SortedMap;
  private SQLDateMarshaller java_sql_Date;
  private BigDecimalMarshaller java_math_BigDecimal;
  private StringMarshaller java_lang_String;
  private QualifyingMarshallerWrapper<HashMap> java_util_HashMap;
  private SetMarshaller java_util_AbstractSet;
  private ListMarshaller java_util_Stack;
  private DateMarshaller java_util_Date;
  private StringBufferMarshaller java_lang_StringBuffer;
  private TimeMarshaller java_sql_Time;
  private BigIntegerMarshaller java_math_BigInteger;
  private LinkedHashSetMarshaller java_util_LinkedHashSet;
  private CharacterMarshaller java_lang_Character;
  private QualifyingMarshallerWrapper<TreeMap> java_util_TreeMap;
  private ListMarshaller java_util_AbstractList;
  private SetMarshaller java_util_Set;
  private ListMarshaller java_util_ArrayList;
  private ByteMarshaller java_lang_Byte;
  private QualifyingMarshallerWrapper<StackTraceElement[]> arrayOf_java_lang_StackTraceElement_D1;
  private Marshaller<Throwable> java_lang_Throwable;
  private Marshaller<IllegalArgumentException> java_lang_IllegalArgumentException;
  private Marshaller<UnsupportedOperationException> java_lang_UnsupportedOperationException;
  private Marshaller<AssertionError> java_lang_AssertionError;
  private Marshaller<ArrayStoreException> java_lang_ArrayStoreException;
  private Marshaller<IOException> java_io_IOException;
  private Marshaller<ClassCastException> java_lang_ClassCastException;
  private Marshaller<StackTraceElement> java_lang_StackTraceElement;
  private Marshaller<IndexOutOfBoundsException> java_lang_IndexOutOfBoundsException;
  private Marshaller<StringIndexOutOfBoundsException> java_lang_StringIndexOutOfBoundsException;
  private Marshaller<BusReadyEvent> org_jboss_errai_enterprise_client_cdi_events_BusReadyEvent;
  private Marshaller<ConcurrentModificationException> java_util_ConcurrentModificationException;
  private Marshaller<EmptyStackException> java_util_EmptyStackException;
  private Marshaller<RuntimeException> java_lang_RuntimeException;
  private Marshaller<NullPointerException> java_lang_NullPointerException;
  private Marshaller<NegativeArraySizeException> java_lang_NegativeArraySizeException;
  private Marshaller<TransportIOException> org_jboss_errai_bus_client_api_base_TransportIOException;
  private Marshaller<Customer> com_logikas_samples_errai_client_shared_Customer;
  private Marshaller<ArithmeticException> java_lang_ArithmeticException;
  private Marshaller<MessageDeliveryFailure> org_jboss_errai_bus_client_api_base_MessageDeliveryFailure;
  private QualifyingMarshallerWrapper<Object[]> arrayOf_java_lang_Object_D1;
  private QualifyingMarshallerWrapper<String[]> arrayOf_java_lang_String_D1;
  private QualifyingMarshallerWrapper<int[]> arrayOf_int_D1;
  private QualifyingMarshallerWrapper<long[]> arrayOf_long_D1;
  private QualifyingMarshallerWrapper<double[]> arrayOf_double_D1;
  private QualifyingMarshallerWrapper<float[]> arrayOf_float_D1;
  private QualifyingMarshallerWrapper<short[]> arrayOf_short_D1;
  private QualifyingMarshallerWrapper<boolean[]> arrayOf_boolean_D1;
  private QualifyingMarshallerWrapper<byte[]> arrayOf_byte_D1;
  private QualifyingMarshallerWrapper<char[]> arrayOf_char_D1;
  private QualifyingMarshallerWrapper<Integer[]> arrayOf_java_lang_Integer_D1;
  private QualifyingMarshallerWrapper<Long[]> arrayOf_java_lang_Long_D1;
  private QualifyingMarshallerWrapper<Double[]> arrayOf_java_lang_Double_D1;
  private QualifyingMarshallerWrapper<Float[]> arrayOf_java_lang_Float_D1;
  private QualifyingMarshallerWrapper<Short[]> arrayOf_java_lang_Short_D1;
  private QualifyingMarshallerWrapper<Boolean[]> arrayOf_java_lang_Boolean_D1;
  private QualifyingMarshallerWrapper<Byte[]> arrayOf_java_lang_Byte_D1;
  private QualifyingMarshallerWrapper<Character[]> arrayOf_java_lang_Character_D1;
  public ServerMarshallingFactoryImpl() {
    java_lang_Float = new FloatMarshaller();
    marshallers.put("java.lang.Float", java_lang_Float);
    java_util_LinkedList = new LinkedListMarshaller();
    marshallers.put("java.util.LinkedList", java_util_LinkedList);
    java_util_Vector = new ListMarshaller();
    marshallers.put("java.util.Vector", java_util_Vector);
    java_util_Queue = new QueueMarshaller();
    marshallers.put("java.util.Queue", java_util_Queue);
    marshallers.put("java.util.AbstractQueue", java_util_Queue);
    java_util_HashSet = new SetMarshaller();
    marshallers.put("java.util.HashSet", java_util_HashSet);
    java_lang_Long = new LongMarshaller();
    marshallers.put("java.lang.Long", java_lang_Long);
    java_lang_Short = new ShortMarshaller();
    marshallers.put("java.lang.Short", java_lang_Short);
    java_util_PriorityQueue = new PriorityQueueMarshaller();
    marshallers.put("java.util.PriorityQueue", java_util_PriorityQueue);
    java_util_List = new ListMarshaller();
    marshallers.put("java.util.List", java_util_List);
    marshallers.put("java.util.Collections$SynchronizedRandomAccessList", java_util_List);
    marshallers.put("java.util.Collections$UnmodifiableRandomAccessList", java_util_List);
    marshallers.put("java.util.Stack", java_util_List);
    marshallers.put("java.util.Vector", java_util_List);
    marshallers.put("java.util.ArrayList", java_util_List);
    marshallers.put("java.util.Collections$SingletonList", java_util_List);
    marshallers.put("java.util.Collections$SynchronizedList", java_util_List);
    marshallers.put("java.util.Collections$UnmodifiableList", java_util_List);
    marshallers.put("java.util.Collections$EmptyList", java_util_List);
    marshallers.put("java.util.Arrays$ArrayList", java_util_List);
    marshallers.put("java.util.AbstractList", java_util_List);
    java_util_SortedSet = new SortedSetMarshaller();
    marshallers.put("java.util.SortedSet", java_util_SortedSet);
    marshallers.put("java.util.Collections$UnmodifiableSortedSet", java_util_SortedSet);
    marshallers.put("java.util.TreeSet", java_util_SortedSet);
    marshallers.put("java.util.Collections$SynchronizedSortedSet", java_util_SortedSet);
    java_util_AbstractMap = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.AbstractMap", java_util_AbstractMap);
    java_util_AbstractQueue = new QueueMarshaller();
    marshallers.put("java.util.AbstractQueue", java_util_AbstractQueue);
    java_util_LinkedHashMap = new QualifyingMarshallerWrapper(new LinkedMapMarshaller());
    marshallers.put("java.util.LinkedHashMap", java_util_LinkedHashMap);
    java_lang_StringBuilder = new StringBuilderMarshaller();
    marshallers.put("java.lang.StringBuilder", java_lang_StringBuilder);
    java_lang_Double = new DoubleMarshaller();
    marshallers.put("java.lang.Double", java_lang_Double);
    java_util_Map = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.Map", java_util_Map);
    marshallers.put("java.util.Collections$SingletonMap", java_util_Map);
    marshallers.put("java.util.AbstractMap", java_util_Map);
    marshallers.put("java.util.Collections$SynchronizedMap", java_util_Map);
    marshallers.put("java.util.HashMap", java_util_Map);
    marshallers.put("java.util.Collections$UnmodifiableMap", java_util_Map);
    marshallers.put("java.util.Collections$EmptyMap", java_util_Map);
    java_lang_Integer = new IntegerMarshaller();
    marshallers.put("java.lang.Integer", java_lang_Integer);
    java_lang_Boolean = new BooleanMarshaller();
    marshallers.put("java.lang.Boolean", java_lang_Boolean);
    java_lang_Object = new ObjectMarshaller();
    marshallers.put("java.lang.Object", java_lang_Object);
    java_sql_Timestamp = new TimestampMarshaller();
    marshallers.put("java.sql.Timestamp", java_sql_Timestamp);
    java_util_TreeSet = new SortedSetMarshaller();
    marshallers.put("java.util.TreeSet", java_util_TreeSet);
    java_util_SortedMap = new QualifyingMarshallerWrapper(new SortedMapMarshaller());
    marshallers.put("java.util.SortedMap", java_util_SortedMap);
    marshallers.put("java.util.Collections$SynchronizedSortedMap", java_util_SortedMap);
    marshallers.put("java.util.Collections$UnmodifiableSortedMap", java_util_SortedMap);
    marshallers.put("java.util.TreeMap", java_util_SortedMap);
    java_sql_Date = new SQLDateMarshaller();
    marshallers.put("java.sql.Date", java_sql_Date);
    java_math_BigDecimal = new BigDecimalMarshaller();
    marshallers.put("java.math.BigDecimal", java_math_BigDecimal);
    java_lang_String = new StringMarshaller();
    marshallers.put("java.lang.String", java_lang_String);
    java_util_HashMap = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.HashMap", java_util_HashMap);
    java_util_AbstractSet = new SetMarshaller();
    marshallers.put("java.util.AbstractSet", java_util_AbstractSet);
    java_util_Stack = new ListMarshaller();
    marshallers.put("java.util.Stack", java_util_Stack);
    java_util_Date = new DateMarshaller();
    marshallers.put("java.util.Date", java_util_Date);
    java_lang_StringBuffer = new StringBufferMarshaller();
    marshallers.put("java.lang.StringBuffer", java_lang_StringBuffer);
    java_sql_Time = new TimeMarshaller();
    marshallers.put("java.sql.Time", java_sql_Time);
    java_math_BigInteger = new BigIntegerMarshaller();
    marshallers.put("java.math.BigInteger", java_math_BigInteger);
    java_util_LinkedHashSet = new LinkedHashSetMarshaller();
    marshallers.put("java.util.LinkedHashSet", java_util_LinkedHashSet);
    java_lang_Character = new CharacterMarshaller();
    marshallers.put("java.lang.Character", java_lang_Character);
    java_util_TreeMap = new QualifyingMarshallerWrapper(new SortedMapMarshaller());
    marshallers.put("java.util.TreeMap", java_util_TreeMap);
    java_util_AbstractList = new ListMarshaller();
    marshallers.put("java.util.AbstractList", java_util_AbstractList);
    java_util_Set = new SetMarshaller();
    marshallers.put("java.util.Set", java_util_Set);
    marshallers.put("java.util.Collections$SynchronizedSet", java_util_Set);
    marshallers.put("java.util.Collections$UnmodifiableSet", java_util_Set);
    marshallers.put("java.util.Collections$EmptySet", java_util_Set);
    marshallers.put("java.util.Collections$SingletonSet", java_util_Set);
    marshallers.put("java.util.AbstractSet", java_util_Set);
    marshallers.put("java.util.HashSet", java_util_Set);
    java_util_ArrayList = new ListMarshaller();
    marshallers.put("java.util.ArrayList", java_util_ArrayList);
    java_lang_Byte = new ByteMarshaller();
    marshallers.put("java.lang.Byte", java_lang_Byte);
    arrayOf_java_lang_StackTraceElement_D1 = new QualifyingMarshallerWrapper(new Marshaller<StackTraceElement[]>() {
      public java.lang.StackTraceElement[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private StackTraceElement[] _demarshall1(EJArray a0, MarshallingSession a1) {
        StackTraceElement[] newArray = new StackTraceElement[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_StackTraceElement.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(StackTraceElement[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return StackTraceElement.class;
      }
      public StackTraceElement[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(StackTraceElement[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.StackTraceElement;", arrayOf_java_lang_StackTraceElement_D1);
    java_lang_Throwable = new Marshaller<Throwable>() {
      private Throwable[] EMPTY_ARRAY = new Throwable[0];
      public Throwable[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return Throwable.class;
      }
      public Throwable demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(Throwable.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          Throwable entity = new Throwable(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.Throwable", t);
        }
      }
      public String marshall(Throwable a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.Throwable\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3072).append("{\"^EncodedType\":\"java.lang.Throwable\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.Throwable", java_lang_Throwable);
    java_lang_IllegalArgumentException = new Marshaller<IllegalArgumentException>() {
      private IllegalArgumentException[] EMPTY_ARRAY = new IllegalArgumentException[0];
      public IllegalArgumentException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return IllegalArgumentException.class;
      }
      public IllegalArgumentException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(IllegalArgumentException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          IllegalArgumentException entity = new IllegalArgumentException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.IllegalArgumentException", t);
        }
      }
      public String marshall(IllegalArgumentException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.IllegalArgumentException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.IllegalArgumentException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.IllegalArgumentException", java_lang_IllegalArgumentException);
    java_lang_UnsupportedOperationException = new Marshaller<UnsupportedOperationException>() {
      private UnsupportedOperationException[] EMPTY_ARRAY = new UnsupportedOperationException[0];
      public UnsupportedOperationException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return UnsupportedOperationException.class;
      }
      public UnsupportedOperationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(UnsupportedOperationException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          UnsupportedOperationException entity = new UnsupportedOperationException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.UnsupportedOperationException", t);
        }
      }
      public String marshall(UnsupportedOperationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.UnsupportedOperationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.UnsupportedOperationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.UnsupportedOperationException", java_lang_UnsupportedOperationException);
    java_lang_AssertionError = new Marshaller<AssertionError>() {
      private AssertionError[] EMPTY_ARRAY = new AssertionError[0];
      public AssertionError[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return AssertionError.class;
      }
      public AssertionError demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(AssertionError.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          AssertionError entity = new AssertionError(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.AssertionError", t);
        }
      }
      public String marshall(AssertionError a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.AssertionError\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.AssertionError\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.AssertionError", java_lang_AssertionError);
    java_lang_ArrayStoreException = new Marshaller<ArrayStoreException>() {
      private ArrayStoreException[] EMPTY_ARRAY = new ArrayStoreException[0];
      public ArrayStoreException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ArrayStoreException.class;
      }
      public ArrayStoreException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ArrayStoreException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ArrayStoreException entity = new ArrayStoreException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ArrayStoreException", t);
        }
      }
      public String marshall(ArrayStoreException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ArrayStoreException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ArrayStoreException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.ArrayStoreException", java_lang_ArrayStoreException);
    java_io_IOException = new Marshaller<IOException>() {
      private IOException[] EMPTY_ARRAY = new IOException[0];
      public IOException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return IOException.class;
      }
      public IOException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(IOException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          IOException entity = new IOException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.io.IOException", t);
        }
      }
      public String marshall(IOException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.io.IOException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.io.IOException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.io.IOException", java_io_IOException);
    java_lang_ClassCastException = new Marshaller<ClassCastException>() {
      private ClassCastException[] EMPTY_ARRAY = new ClassCastException[0];
      public ClassCastException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ClassCastException.class;
      }
      public ClassCastException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ClassCastException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ClassCastException entity = new ClassCastException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ClassCastException", t);
        }
      }
      public String marshall(ClassCastException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ClassCastException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ClassCastException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.ClassCastException", java_lang_ClassCastException);
    java_lang_StackTraceElement = new Marshaller<StackTraceElement>() {
      private StackTraceElement[] EMPTY_ARRAY = new StackTraceElement[0];
      public StackTraceElement[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return StackTraceElement.class;
      }
      public StackTraceElement demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(StackTraceElement.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("declaringClass"), a1);
          final String c1 = java_lang_String.demarshall(obj.get("methodName"), a1);
          final String c2 = java_lang_String.demarshall(obj.get("fileName"), a1);
          final Integer c3 = java_lang_Integer.demarshall(obj.get("lineNumber"), a1);
          StackTraceElement entity = new StackTraceElement(c0, c1, c2, c3);
          a1.recordObject(objId, entity);
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.StackTraceElement", t);
        }
      }
      public String marshall(StackTraceElement a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.StackTraceElement\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(640).append("{\"^EncodedType\":\"java.lang.StackTraceElement\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"fileName\" : ").append(java_lang_String.marshall(a0.getFileName(), a1)).append(",").append("\"methodName\" : ").append(java_lang_String.marshall(a0.getMethodName(), a1)).append(",").append("\"lineNumber\" : ").append(java_lang_Integer.marshall(a0.getLineNumber(), a1)).append(",").append("\"declaringClass\" : ").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.StackTraceElement", java_lang_StackTraceElement);
    java_lang_IndexOutOfBoundsException = new Marshaller<IndexOutOfBoundsException>() {
      private IndexOutOfBoundsException[] EMPTY_ARRAY = new IndexOutOfBoundsException[0];
      public IndexOutOfBoundsException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return IndexOutOfBoundsException.class;
      }
      public IndexOutOfBoundsException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(IndexOutOfBoundsException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          IndexOutOfBoundsException entity = new IndexOutOfBoundsException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.IndexOutOfBoundsException", t);
        }
      }
      public String marshall(IndexOutOfBoundsException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.IndexOutOfBoundsException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.IndexOutOfBoundsException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.IndexOutOfBoundsException", java_lang_IndexOutOfBoundsException);
    java_lang_StringIndexOutOfBoundsException = new Marshaller<StringIndexOutOfBoundsException>() {
      private StringIndexOutOfBoundsException[] EMPTY_ARRAY = new StringIndexOutOfBoundsException[0];
      public StringIndexOutOfBoundsException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return StringIndexOutOfBoundsException.class;
      }
      public StringIndexOutOfBoundsException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(StringIndexOutOfBoundsException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          StringIndexOutOfBoundsException entity = new StringIndexOutOfBoundsException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.StringIndexOutOfBoundsException", t);
        }
      }
      public String marshall(StringIndexOutOfBoundsException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.StringIndexOutOfBoundsException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.StringIndexOutOfBoundsException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.StringIndexOutOfBoundsException", java_lang_StringIndexOutOfBoundsException);
    org_jboss_errai_enterprise_client_cdi_events_BusReadyEvent = new Marshaller<BusReadyEvent>() {
      private BusReadyEvent[] EMPTY_ARRAY = new BusReadyEvent[0];
      public BusReadyEvent[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return BusReadyEvent.class;
      }
      public BusReadyEvent demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(BusReadyEvent.class, objId);
          }
          BusReadyEvent entity = new BusReadyEvent();
          a1.recordObject(objId, entity);
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent", t);
        }
      }
      public String marshall(BusReadyEvent a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent\",\"^ObjectID\":\"").append(objId).append("\"").append(",\"^InstantiateOnly\":true").append("}").toString();
      }
    };
    marshallers.put("org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent", org_jboss_errai_enterprise_client_cdi_events_BusReadyEvent);
    java_util_ConcurrentModificationException = new Marshaller<ConcurrentModificationException>() {
      private ConcurrentModificationException[] EMPTY_ARRAY = new ConcurrentModificationException[0];
      public ConcurrentModificationException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ConcurrentModificationException.class;
      }
      public ConcurrentModificationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ConcurrentModificationException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ConcurrentModificationException entity = new ConcurrentModificationException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.util.ConcurrentModificationException", t);
        }
      }
      public String marshall(ConcurrentModificationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.util.ConcurrentModificationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.util.ConcurrentModificationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.util.ConcurrentModificationException", java_util_ConcurrentModificationException);
    java_util_EmptyStackException = new Marshaller<EmptyStackException>() {
      private EmptyStackException[] EMPTY_ARRAY = new EmptyStackException[0];
      public EmptyStackException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return EmptyStackException.class;
      }
      public EmptyStackException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(EmptyStackException.class, objId);
          }
          EmptyStackException entity = new EmptyStackException();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.util.EmptyStackException", t);
        }
      }
      public String marshall(EmptyStackException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.util.EmptyStackException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.util.EmptyStackException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.util.EmptyStackException", java_util_EmptyStackException);
    java_lang_RuntimeException = new Marshaller<RuntimeException>() {
      private RuntimeException[] EMPTY_ARRAY = new RuntimeException[0];
      public RuntimeException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return RuntimeException.class;
      }
      public RuntimeException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(RuntimeException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          RuntimeException entity = new RuntimeException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.RuntimeException", t);
        }
      }
      public String marshall(RuntimeException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.RuntimeException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.RuntimeException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.RuntimeException", java_lang_RuntimeException);
    java_lang_NullPointerException = new Marshaller<NullPointerException>() {
      private NullPointerException[] EMPTY_ARRAY = new NullPointerException[0];
      public NullPointerException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return NullPointerException.class;
      }
      public NullPointerException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(NullPointerException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          NullPointerException entity = new NullPointerException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.NullPointerException", t);
        }
      }
      public String marshall(NullPointerException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.NullPointerException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.NullPointerException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.NullPointerException", java_lang_NullPointerException);
    java_lang_NegativeArraySizeException = new Marshaller<NegativeArraySizeException>() {
      private NegativeArraySizeException[] EMPTY_ARRAY = new NegativeArraySizeException[0];
      public NegativeArraySizeException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return NegativeArraySizeException.class;
      }
      public NegativeArraySizeException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(NegativeArraySizeException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          NegativeArraySizeException entity = new NegativeArraySizeException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.NegativeArraySizeException", t);
        }
      }
      public String marshall(NegativeArraySizeException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.NegativeArraySizeException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.NegativeArraySizeException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.NegativeArraySizeException", java_lang_NegativeArraySizeException);
    org_jboss_errai_bus_client_api_base_TransportIOException = new Marshaller<TransportIOException>() {
      private TransportIOException[] EMPTY_ARRAY = new TransportIOException[0];
      public TransportIOException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return TransportIOException.class;
      }
      public TransportIOException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(TransportIOException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          final Integer c1 = java_lang_Integer.demarshall(obj.get("errorCode"), a1);
          final String c2 = java_lang_String.demarshall(obj.get("errorMessage"), a1);
          TransportIOException entity = new TransportIOException(c0, c1, c2);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jboss.errai.bus.client.api.base.TransportIOException", t);
        }
      }
      public String marshall(TransportIOException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.TransportIOException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(4224).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.TransportIOException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"errorCode\" : ").append(java_lang_Integer.marshall(a0.errorCode(), a1)).append(",").append("\"errorMessage\" : ").append(java_lang_String.marshall(a0.getErrorMessage(), a1)).append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.jboss.errai.bus.client.api.base.TransportIOException", org_jboss_errai_bus_client_api_base_TransportIOException);
    com_logikas_samples_errai_client_shared_Customer = new Marshaller<Customer>() {
      private Customer[] EMPTY_ARRAY = new Customer[0];
      public Customer[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return Customer.class;
      }
      public Customer demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(Customer.class, objId);
          }
          Customer entity = new Customer();
          a1.recordObject(objId, entity);
          if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
            entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
          }
          if ((obj.containsKey("firstName")) && (!obj.get("firstName").isNull())) {
            entity.setFirstName(java_lang_String.demarshall(obj.get("firstName"), a1));
          }
          if ((obj.containsKey("lastName")) && (!obj.get("lastName").isNull())) {
            entity.setLastName(java_lang_String.demarshall(obj.get("lastName"), a1));
          }
          if ((obj.containsKey("postalCode")) && (!obj.get("postalCode").isNull())) {
            entity.setPostalCode(java_lang_String.demarshall(obj.get("postalCode"), a1));
          }
          if ((obj.containsKey("lastChanged")) && (!obj.get("lastChanged").isNull())) {
            entity.setLastChanged(java_util_Date.demarshall(obj.get("lastChanged"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: com.logikas.samples.errai.client.shared.Customer", t);
        }
      }
      public String marshall(Customer a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"com.logikas.samples.errai.client.shared.Customer\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(768).append("{\"^EncodedType\":\"com.logikas.samples.errai.client.shared.Customer\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"id\" : ").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"firstName\" : ").append(java_lang_String.marshall(a0.getFirstName(), a1)).append(",").append("\"lastName\" : ").append(java_lang_String.marshall(a0.getLastName(), a1)).append(",").append("\"postalCode\" : ").append(java_lang_String.marshall(a0.getPostalCode(), a1)).append(",").append("\"lastChanged\" : ").append(java_util_Date.marshall(a0.getLastChanged(), a1)).append("}").toString();
      }
    };
    marshallers.put("com.logikas.samples.errai.client.shared.Customer", com_logikas_samples_errai_client_shared_Customer);
    java_lang_ArithmeticException = new Marshaller<ArithmeticException>() {
      private ArithmeticException[] EMPTY_ARRAY = new ArithmeticException[0];
      public ArithmeticException[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return ArithmeticException.class;
      }
      public ArithmeticException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(ArithmeticException.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          ArithmeticException entity = new ArithmeticException(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ArithmeticException", t);
        }
      }
      public String marshall(ArithmeticException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ArithmeticException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ArithmeticException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("java.lang.ArithmeticException", java_lang_ArithmeticException);
    org_jboss_errai_bus_client_api_base_MessageDeliveryFailure = new Marshaller<MessageDeliveryFailure>() {
      private MessageDeliveryFailure[] EMPTY_ARRAY = new MessageDeliveryFailure[0];
      public MessageDeliveryFailure[] getEmptyArray() {
        return EMPTY_ARRAY;
      }
      public Class getTypeHandled() {
        return MessageDeliveryFailure.class;
      }
      public MessageDeliveryFailure demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull()) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObject(objId)) {
            return a1.getObject(MessageDeliveryFailure.class, objId);
          }
          final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
          MessageDeliveryFailure entity = new MessageDeliveryFailure(c0);
          a1.recordObject(objId, entity);
          if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
            entity.setStackTrace((StackTraceElement[]) arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: org.jboss.errai.bus.client.api.base.MessageDeliveryFailure", t);
        }
      }
      public String marshall(MessageDeliveryFailure a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObject(a0)) {
          String objId = a1.getObject(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.MessageDeliveryFailure\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObject(a0);
        a1.recordObject(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"org.jboss.errai.bus.client.api.base.MessageDeliveryFailure\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }
    };
    marshallers.put("org.jboss.errai.bus.client.api.base.MessageDeliveryFailure", org_jboss_errai_bus_client_api_base_MessageDeliveryFailure);
    arrayOf_java_lang_Object_D1 = new QualifyingMarshallerWrapper(new Marshaller<Object[]>() {
      public java.lang.Object[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Object[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Object[] newArray = new Object[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Object.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Object[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Object.class;
      }
      public Object[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Object[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Object;", arrayOf_java_lang_Object_D1);
    arrayOf_java_lang_String_D1 = new QualifyingMarshallerWrapper(new Marshaller<String[]>() {
      public java.lang.String[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private String[] _demarshall1(EJArray a0, MarshallingSession a1) {
        String[] newArray = new String[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_String.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(String[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return String.class;
      }
      public String[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(String[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.String;", arrayOf_java_lang_String_D1);
    arrayOf_int_D1 = new QualifyingMarshallerWrapper(new Marshaller<int[]>() {
      public int[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private int[] _demarshall1(EJArray a0, MarshallingSession a1) {
        int[] newArray = new int[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Integer.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(int[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return int.class;
      }
      public int[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(int[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[I", arrayOf_int_D1);
    arrayOf_long_D1 = new QualifyingMarshallerWrapper(new Marshaller<long[]>() {
      public long[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private long[] _demarshall1(EJArray a0, MarshallingSession a1) {
        long[] newArray = new long[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Long.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(long[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return long.class;
      }
      public long[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(long[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[J", arrayOf_long_D1);
    arrayOf_double_D1 = new QualifyingMarshallerWrapper(new Marshaller<double[]>() {
      public double[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private double[] _demarshall1(EJArray a0, MarshallingSession a1) {
        double[] newArray = new double[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Double.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(double[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return double.class;
      }
      public double[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(double[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[D", arrayOf_double_D1);
    arrayOf_float_D1 = new QualifyingMarshallerWrapper(new Marshaller<float[]>() {
      public float[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private float[] _demarshall1(EJArray a0, MarshallingSession a1) {
        float[] newArray = new float[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Float.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(float[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return float.class;
      }
      public float[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(float[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[F", arrayOf_float_D1);
    arrayOf_short_D1 = new QualifyingMarshallerWrapper(new Marshaller<short[]>() {
      public short[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private short[] _demarshall1(EJArray a0, MarshallingSession a1) {
        short[] newArray = new short[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Short.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(short[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return short.class;
      }
      public short[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(short[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[S", arrayOf_short_D1);
    arrayOf_boolean_D1 = new QualifyingMarshallerWrapper(new Marshaller<boolean[]>() {
      public boolean[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private boolean[] _demarshall1(EJArray a0, MarshallingSession a1) {
        boolean[] newArray = new boolean[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Boolean.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(boolean[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return boolean.class;
      }
      public boolean[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(boolean[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Z", arrayOf_boolean_D1);
    arrayOf_byte_D1 = new QualifyingMarshallerWrapper(new Marshaller<byte[]>() {
      public byte[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private byte[] _demarshall1(EJArray a0, MarshallingSession a1) {
        byte[] newArray = new byte[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Byte.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(byte[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return byte.class;
      }
      public byte[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(byte[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[B", arrayOf_byte_D1);
    arrayOf_char_D1 = new QualifyingMarshallerWrapper(new Marshaller<char[]>() {
      public char[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private char[] _demarshall1(EJArray a0, MarshallingSession a1) {
        char[] newArray = new char[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Character.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(char[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return char.class;
      }
      public char[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(char[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[C", arrayOf_char_D1);
    arrayOf_java_lang_Integer_D1 = new QualifyingMarshallerWrapper(new Marshaller<Integer[]>() {
      public java.lang.Integer[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Integer[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Integer[] newArray = new Integer[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Integer.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Integer[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Integer.class;
      }
      public Integer[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Integer[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Integer;", arrayOf_java_lang_Integer_D1);
    arrayOf_java_lang_Long_D1 = new QualifyingMarshallerWrapper(new Marshaller<Long[]>() {
      public java.lang.Long[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Long[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Long[] newArray = new Long[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Long.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Long[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Long.class;
      }
      public Long[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Long[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Long;", arrayOf_java_lang_Long_D1);
    arrayOf_java_lang_Double_D1 = new QualifyingMarshallerWrapper(new Marshaller<Double[]>() {
      public java.lang.Double[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Double[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Double[] newArray = new Double[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Double.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Double[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Double.class;
      }
      public Double[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Double[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Double;", arrayOf_java_lang_Double_D1);
    arrayOf_java_lang_Float_D1 = new QualifyingMarshallerWrapper(new Marshaller<Float[]>() {
      public java.lang.Float[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Float[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Float[] newArray = new Float[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Float.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Float[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Float.class;
      }
      public Float[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Float[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Float;", arrayOf_java_lang_Float_D1);
    arrayOf_java_lang_Short_D1 = new QualifyingMarshallerWrapper(new Marshaller<Short[]>() {
      public java.lang.Short[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Short[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Short[] newArray = new Short[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Short.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Short[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Short.class;
      }
      public Short[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Short[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Short;", arrayOf_java_lang_Short_D1);
    arrayOf_java_lang_Boolean_D1 = new QualifyingMarshallerWrapper(new Marshaller<Boolean[]>() {
      public java.lang.Boolean[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Boolean[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Boolean[] newArray = new Boolean[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Boolean.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Boolean[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Boolean.class;
      }
      public Boolean[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Boolean[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Boolean;", arrayOf_java_lang_Boolean_D1);
    arrayOf_java_lang_Byte_D1 = new QualifyingMarshallerWrapper(new Marshaller<Byte[]>() {
      public java.lang.Byte[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Byte[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Byte[] newArray = new Byte[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Byte.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Byte[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Byte.class;
      }
      public Byte[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Byte[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Byte;", arrayOf_java_lang_Byte_D1);
    arrayOf_java_lang_Character_D1 = new QualifyingMarshallerWrapper(new Marshaller<Character[]>() {
      public java.lang.Character[][] getEmptyArray() {
        throw new UnsupportedOperationException("Not implemented!");
      }

      private Character[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Character[] newArray = new Character[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Character.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Character[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }
      public Class getTypeHandled() {
        return Character.class;
      }
      public Character[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._demarshall1(a0.isArray(), a1);
        }
      }
      public String marshall(Character[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return this._marshall1(a0, a1);
        }
      }
    });
    marshallers.put("[Ljava.lang.Character;", arrayOf_java_lang_Character_D1);
  }

  public Marshaller getMarshaller(String a0, String a1) {
    return marshallers.get(a1);
  }
}