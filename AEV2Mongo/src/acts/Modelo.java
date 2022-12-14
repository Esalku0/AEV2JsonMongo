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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Modelo {

	static String ipString;
	static int port;
	static String bbddString;
	static String collectionBooks;
	static String collectionUsers;
	static MongoClient mongoClient;

	public static String generarHash(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();

		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void iniciarConexion() throws IOException {
		File f1 = new File("conexion.txt");

		FileReader fReader = new FileReader(f1);
		BufferedReader br = new BufferedReader(fReader);
		String linea = br.readLine();
		String cont = linea;

		do {
			linea = br.readLine();
			cont += linea;
		} while (linea != null);

		JSONObject obj = new JSONObject(cont);

		ipString = obj.getString("IP");
		port = obj.getInt("port");
		bbddString = obj.getString("bbdd");
		collectionBooks = obj.getString("coleccio1");
		collectionUsers = obj.getString("coleccio2");

		mongoClient = new MongoClient(ipString, port);
		MongoDatabase database = mongoClient.getDatabase(bbddString);
		MongoCollection<Document> coleccionBooks = database.getCollection(collectionBooks);
		MongoCollection<Document> coleccionUsers = database.getCollection(collectionUsers);

		System.out.println("ye bon dia");
	}

	public static void main(String[] args) throws IOException {

		generarHash("elowo");

		mongoClient.close();

	}

}
