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
import java.util.Iterator;

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
	
	public static boolean isNumeric(String s)
	{
		if (s == null || s.equals("")) {
			return false;
		}

		return s.chars().allMatch(Character::isDigit);
	}

	public static String generarHashContrasenya(String password) {
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

		System.out.println(collectionBooks);
		mongoClient = new MongoClient(ipString, port);
		MongoDatabase database = mongoClient.getDatabase(bbddString);
		coleccionBooks = database.getCollection(collectionBooks);
		coleccionUsers = database.getCollection(collectionUsers);

	}

	public static String mostrarAmbFiltres(String campo, String filtro, String valor) {

		String resultado = "";
System.out.println(filtro);
		if (filtro.equals("")) {
			MongoCursor<Document> cursor = coleccionBooks.find().iterator();
			while (cursor.hasNext()) {
				System.out.println("el owo");
				JSONObject obj = new JSONObject(cursor.next().toJson());
				System.out.println(obj.getString("Titulo"));
				resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " +  obj.getString("Autor") + " "+  obj.getInt("Anyo_nacimiento") + ""+  obj.getInt("Anyo_publicacion") + ""+ obj.getString("Editorial")
				+ "\n";
				
			}
			System.out.println(resultado);
		} else {
			

			if (filtro.equals("eq")) {
				System.out.println("entramos en el eq");
				
				Bson query;
				int caracterInt;
				if (isNumeric(valor)) {
					caracterInt=Integer.parseInt(valor);
					 query = eq(campo, caracterInt);
				}else {
					 query = eq(campo, valor);
				}

			
				System.out.println(query);
				MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
				System.out.println(collectionBooks);
				System.out.println(cursor);
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					System.out.println(obj.getString("Titulo"));
					resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " +  obj.getString("Autor") + " "+  obj.getInt("Anyo_nacimiento") + ""+  obj.getInt("Anyo_publicacion") + ""+ obj.getString("Editorial")
					+ "\n";
				}
				System.out.println(resultado);
			} else if (filtro.equals("gte")) {
				System.out.println("FALTA POR ARREGLAR");
				Bson query;
				int caracterInt;
				if (isNumeric(valor)) {
					caracterInt=Integer.parseInt(valor);
					 query = eq(campo, caracterInt);
				}else {
					 query = eq(campo, valor);
				}
				
				MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					System.out.println(obj.getString("titulo"));
					resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " +  obj.getString("Autor") + " "+  obj.getInt("Anyo_nacimiento") + ""+  obj.getInt("Anyo_publicacion") + ""+ obj.getString("Editorial")
					+ "\n";
				}
				System.out.println(resultado);
			} else {
				System.out.println("FALTA POR ARREGLAR");
				Bson query;
				int caracterInt;
				if (isNumeric(valor)) {
					caracterInt=Integer.parseInt(valor);
					 query = eq(campo, caracterInt);
				}else {
					 query = eq(campo, valor);
				}
				MongoCursor<Document> cursor = coleccionBooks.find(query).iterator();
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					System.out.println(obj.getString("titulo"));
					resultado += obj.getInt("Id") + " " + obj.getString("Titulo") + " " +  obj.getString("Autor") + " "+  obj.getInt("Anyo_nacimiento") + ""+  obj.getInt("Anyo_publicacion") + ""+ obj.getString("Editorial")
					+ "\n";
				}
				System.out.println(resultado);
			}

		}

		return resultado;

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

	public static String transformarImagen(String imagen) throws IOException {
		File fitxer = new File(imagen);
		Image imatge = ImageIO.read(fitxer);
		ImageIcon imatgeIcona = new ImageIcon(imatge);
		JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, imatgeIcona);

		byte[] fileContent = Files.readAllBytes(fitxer.toPath());
		String encodedString = Base64.encodeBase64String(fileContent);
		System.out.println(encodedString);
		return encodedString;

	}

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

	public static void anyadir(int Id, String Titulo, String Autor, int Nacimiento, int Publicacion, String Editorial,
			int Paginas, String Imagen) {
		Document doc = new Document();
		doc.append("Id", Id);
		doc.append("Titulo", "roberto martinez");
		doc.append("Autor", "el owo");
		doc.append("Anyo_nacimiento", 1999);
		doc.append("Anyo_publicacion", 2003);
		doc.append("Editorial", "rayo");
		doc.append("Numero_paginas", 45);
		doc.append("Thumbnail", 45);
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

	// METODO POR ACABAR ESTA DANDO FALLOS
	public static boolean iniciarSesio(String usuari, String contrasenya) {

		Document filterDoc = new Document();
		boolean comprobacion = false;
		String hashString = generarHashContrasenya(contrasenya);

		System.out.println(hashString);
		MongoCursor<Document> cursor = coleccionUsers.find(and(eq("user", usuari), eq("pass", hashString))).iterator();
		System.out.println("w");
		if (cursor.hasNext()) {
			System.out.println("estoy");
			comprobacion = true;
		} else {
			System.out.println("no estoy");
			comprobacion = false;
		}

		return comprobacion;
	}

	public void cerrarConexion() {
		mongoClient.close();
	}

	public static void borrarColeccio(String nomColeccio) {
		if (nomColeccio.equals("llibres")) {
			coleccionBooks.drop();
		} else {
			coleccionUsers.drop();
		}
	}

	public static void main(String[] args) throws IOException {
		iniciarConexion();
////		generarHash("elowo");
////		anyadir(15,"sditulo","sdffdsd",2002,1920,"ew",123,"owo");
////		mostrarCamposLlibres();
////		mostrarCamposUsuari();
//
		iniciarSesio("roberto", "roberto");
//
		mongoClient.close();
	}

}
