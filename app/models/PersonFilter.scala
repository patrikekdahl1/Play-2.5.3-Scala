package models

import java.util.regex.Pattern

import com.mongodb.{BasicDBList, BasicDBObject}

class PersonFilter {
  private var queryIn: String = null
  private var fNameIn: String = null
  private var lNameIn: String = null
  private var fullNameIn: String = null
  private var query: BasicDBObject = null

  def this(queryIn: String, fNameIn: String, lNameIn: String, fullNameIn: String) {
    this()
    this.queryIn = queryIn
    this.fNameIn = fNameIn
    this.lNameIn = lNameIn
    this.fullNameIn = fullNameIn
  }

  def filterPeople {
    val regex: Pattern = Pattern.compile(queryIn, Pattern.CASE_INSENSITIVE)
    val fName: BasicDBObject = new BasicDBObject(fNameIn, regex)
    val lName: BasicDBObject = new BasicDBObject(lNameIn, regex)
    val fullName: BasicDBObject = new BasicDBObject(fullNameIn, regex)
    val or: BasicDBList = new BasicDBList
    or.add(fName)
    or.add(lName)
    or.add(fullName)
    query = new BasicDBObject("$or", or)
  }

  def getQuery: BasicDBObject = {
    return query
  }

}
