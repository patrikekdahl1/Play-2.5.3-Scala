package models

import com.mongodb.{BasicDBObject, MongoClient}
import com.mongodb.client.{FindIterable, MongoDatabase}
import com.mongodb.util.JSON
import org.bson.Document

class PersonDB(var host: String, var address: Int, var dbName: String, var collection: String) {
  private var mongoClient: MongoClient = null
  private var database: MongoDatabase = null

  def startDb {
    mongoClient = new MongoClient(host, address)
    database = mongoClient.getDatabase(dbName)
  }

  def findPeople(personList: List[Person], query: BasicDBObject): List[Person] = {

    val iterable: FindIterable[Document] = database.getCollection(collection).find(query);

    /*
    for (document <- iterable) {
      personList :+ document
    }
    */
    personList
  }
}