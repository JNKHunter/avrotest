import org.apache.avro.generic.IndexedRecord
import org.apache.kafka.clients.producer.Producer

/**
  * Created by John on 11/6/17.
  */
case class Sink[K,V](producer:Producer[K,V]) {

}
