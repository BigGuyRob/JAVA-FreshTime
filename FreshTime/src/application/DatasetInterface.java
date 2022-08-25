package application;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.ClusterDescription;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
 
/**
 * MongoInterface class for interfacing with MongoDB.
 * MongoDB Version 3.12.10
 * @author Kiernan King
 * 
 */
public class DatasetInterface {
	private MongoClient client;
	private static MongoCollection<Document> LocationCollection;
	private MongoDatabase database;
	private static String key;
	
	/**
	 * MongoInterface creates a MongoDB Client that interfaces with the cluster created on mongodb.com
	 */
	public DatasetInterface(String key) {
		try {
			this.client = MongoClients.create(key);
			this.key = key;
			this.database = client.getDatabase("LDB");
			this.LocationCollection = database.getCollection("LC");
		}catch (Exception e){
			
		}
	}
	
	/**
	 * getDocuments returns the list of locations unformatted.
	 * @return Locations Object of type List<Document>
	 */
	public List<Document> getDocuments() {
		List<Document> Locations = (List<Document>) LocationCollection.find().into(new ArrayList<Document>());
		return Locations;
	}
	
	
	/**
	 * main holds the logic for testing outputs.
	 * @param args Object of type String[]
	 */
	public static void main(String[] args) {
		DatasetInterface MI = new DatasetInterface(key);
		List<Document> Locs = MI.getDocuments();
		for(Document d : Locs) {
			System.out.println(d);
		}
	}
	
	public Exception pingDB() {
		try {
		    ClusterDescription addr = client.getClusterDescription();
		    return null;
		} catch (Exception e) {
		    return e;
		}
	}
}


