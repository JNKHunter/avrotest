import java.util.Properties

import com.events.ClickRecord
import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.apache.kafka.clients.producer.{KafkaProducer, MockProducer}
import org.apache.kafka.common.serialization.StringSerializer
import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by John on 11/6/17.
  */
class SinkTest extends FunSuite with BeforeAndAfterEach {
  var sink:Sink[String, ClickRecord] = _

  override def beforeEach() {
    println("before")
    //sink = new Sink(new MockProducer[String, ClickRecord](true, new StringSerializer(), new KafkaAvroSerializer()))
  }

  override def afterEach() {
    println("after")
  }

  test("Hello world test") {
    println("hello world")
  }
}
