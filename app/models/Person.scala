package models

import org.bson.Document

class Person {
  private var fName: String = null
  private var lName: String = null
  private var fullName: String = null

  def this(document: Document) {
    this()
    this.fName = document.getString("fName")
    this.lName = document.getString("lName")
    this.fullName = document.getString("fullName")
  }

  def getfName: String = {
    return fName
  }

  def setfName(fName: String) {
    this.fName = fName
  }

  def getlName: String = {
    return lName
  }

  def setlName(lName: String) {
    this.lName = lName
  }

  def getFullName: String = {
    return fullName
  }

  def setFullName(fullName: String) {
    this.fullName = fullName
  }

}
