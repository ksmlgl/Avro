package com.ksmlgl;

import com.ksmlgl.avro.model.Active;
import com.ksmlgl.avro.model.AvroHttpRequest;
import com.ksmlgl.avro.model.ClientIdentifier;
import com.ksmlgl.util.AvroClassGenerator;
import com.ksmlgl.util.AvroSchemaBuilder;
import com.ksmlgl.util.serealization.AvroDeSerealizer;
import com.ksmlgl.util.serealization.AvroSerealizer;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KSM
 * @since 29.06.2021 23:18
 */
public class Avro {

	public static void main(String[] args) throws IOException {

	/*	AvroClassGenerator avroClassGenerator = new AvroClassGenerator();
		avroClassGenerator.generateAvroClasses();*/



		AvroSchemaBuilder avroSchemaBuilder = new AvroSchemaBuilder();
		Schema avroHttpRequestSchema = avroSchemaBuilder.createAvroHttpRequestSchema();

		List<CharSequence> names = new ArrayList<>();
		names.add("Kasım");
		names.add("Ali");
		names.add("GÜL");
		AvroHttpRequest avroHttpRequest = new AvroHttpRequest();
		avroHttpRequest.setRequestTime(System.currentTimeMillis());
		avroHttpRequest.setActive(Active.YES);
		avroHttpRequest.setEmployeeNames(names);

		ClientIdentifier clientIdentifier = new ClientIdentifier();
		clientIdentifier.setHostName("123456");
		clientIdentifier.setIpAddress("654321");
		avroHttpRequest.setClientIdentifier(clientIdentifier);

		AvroSerealizer avroSerealizer = new AvroSerealizer();
		byte[] bytes = avroSerealizer.serealizeAvroHttpRequestJSON(avroHttpRequest);

		AvroDeSerealizer avroDeSerealizer = new AvroDeSerealizer();
		AvroHttpRequest avroHttpRequest1 = avroDeSerealizer.deSerealizeAvroHttpRequestJSON(bytes);
		System.out.println(avroHttpRequest1.toString());


	}
}
