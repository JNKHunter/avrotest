import java.util.{Properties, Random}

import com.events.ClickRecord
import org.apache.avro.generic.{GenericData, IndexedRecord}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
  * Created by John on 11/5/17.
  */
object HelloAvro extends App {
  val topic = "test"
  val brokers = "localhost:9092"

  val rnd = new Random()
  val props = new Properties()


  props.put("bootstrap.servers", brokers)
  props.put("client.id", "ScalaProducerExample")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer")
  props.put("schema.registry.url", "http://localhost:8081")

  //val producer = new KafkaProducer[String, IndexedRecord](props)
  val sink = new Sink(new KafkaProducer[String, ClickRecord](props))
  val record = new ClickRecord("123")

  val data = new ProducerRecord[String, ClickRecord](topic, record)

  sink.producer.send(data)
  sink.producer.close()
}
