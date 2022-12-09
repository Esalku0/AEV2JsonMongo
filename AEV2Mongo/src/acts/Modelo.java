package acts;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Modelo {

	public static void main(String[] args) throws IOException {
		
		String ipString;
		int port;
		String bbddString;
		String collectionBooks;
		String collectionUsers;
		
		
		File f1 = new File("conexion.txt");
		
		FileReader fReader = new FileReader(f1);
		BufferedReader br = new BufferedReader(fReader);
		String linea = br.readLine();
		String cont=linea;
		
		do {
			linea = br.readLine();
			cont+=linea;
		} while (linea!=null);

		
		JSONObject obj = new JSONObject(cont);

		ipString=obj.getString("IP");
		port=obj.getInt("port");
		bbddString=obj.getString("bbdd");
		collectionBooks=obj.getString("coleccio1");
		collectionUsers=obj.getString("coleccio2");
		System.out.println(ipString);
		System.out.println(port);
		System.out.println(bbddString);
		System.out.println(collectionBooks);
		
		MongoClient mongoClient = new MongoClient(ipString, port);
		MongoDatabase database = mongoClient.getDatabase(bbddString);
		MongoCollection<Document>  coleccionBooks = database.getCollection(collectionBooks);
//		MongoCollection<Document>  coleccionUsers = database.getCollection(collectionUsers);

		
		System.out.println("ye bon dia");
		
		mongoClient.close();

	}

}
