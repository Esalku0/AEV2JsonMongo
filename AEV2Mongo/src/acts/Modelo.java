package acts;

import org.apache.commons.codec.binary.Base64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import static com.mongodb.client.model.Filters.*;

public class Modelo {

	static String ipString;
	static int port;
	static String bbddString;
	static String collectionBooks;
	static String collectionUsers;
	static MongoClient mongoClient;
	static MongoCollection<Document> coleccionBooks;
	static MongoCollection<Document> coleccionUsers;
	static int contadorLlibres = 0;
	static int contadorUsuaris = 0;

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
		File f1 = new File("./conexion.txt");

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
		coleccionBooks = database.getCollection(collectionBooks);
		coleccionUsers = database.getCollection(collectionUsers);

	}

	public static String mostrarCamposLlibres() {
		String contenidoString = "";

		MongoCursor<Document> cursor = coleccionBooks.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			contadorLlibres++;
			System.out.println(contadorLlibres + "- " + obj.getString("Titulo"));
			contenidoString += contadorLlibres + "- " + obj.getString("Titulo") + "\n";
		}
		return contenidoString;
	}

	public static String mostrarCamposUsuari() {

		String contenidoString = "";

		MongoCursor<Document> cursor = coleccionUsers.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			contadorUsuaris++;
			System.out.println(contadorUsuaris + "- " + obj.getString("user"));
			contenidoString += contadorUsuaris + "- " + obj.getString("user") + "\n";
		}
		return contenidoString;
	}

//	public String transformarImagen(String imagen) throws IOException {
//		File fitxer = new File(imagen);
//		Image imatge = ImageIO.read(fitxer);
//		ImageIcon imatgeIcona = new ImageIcon(imatge);
//		JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, imatgeIcona);
//
//		byte[] fileContent = Files.readAllBytes(fitxer.toPath());
//		String encodedString = Base64.encodeBase64String(fileContent);
//
//		return encodedString;
//	}

	public static void anyadirLlibre(int Id, String Titulo, String Autor, int Nacimiento, int Publicacion,
			String Editorial, int Paginas, String Imagen) {
		Document doc = new Document();
		doc.append("Id", Id);
		doc.append("Titulo", Titulo);
		doc.append("Autor", Autor);
		doc.append("Anyo_nacimiento", Nacimiento);
		doc.append("Anyo_publicacion", Publicacion);
		doc.append("Editorial", Editorial);
		doc.append("Numero_paginas", Paginas);
		doc.append("Thumbnail", Imagen);
		coleccionBooks.insertOne(doc);
	}

	
	public static void borrarLlibre(String Titulo) {
		coleccionBooks.deleteMany(eq("Titulo", Titulo));
	}
	
	public static void actualitzarLlibre(int Id, String Titulo, String Autor, int Nacimiento, int Publicacion,
			String Editorial, int Paginas, String Imagen) {
		Document doc = new Document();
		doc.append("Id", Id);
		doc.append("Titulo", Titulo);
		doc.append("Autor", Autor);
		doc.append("Anyo_nacimiento", Nacimiento);
		doc.append("Anyo_publicacion", Publicacion);
		doc.append("Editorial", Editorial);
		doc.append("Numero_paginas", Paginas);
		doc.append("Thumbnail", Imagen);
		
		coleccionBooks.updateMany(eq("Titulo", Titulo), new Document("$set", doc));
	}
	

	public static void main(String[] args) throws IOException {
		iniciarConexion();
//		generarHash("elowo");
//		anyadirLlibre(15,"sditulo","sdffdsd",2002,1920,"ew",123,"owo");
		mostrarCamposLlibres();
		mostrarCamposUsuari();
		mongoClient.close();
	}

}
