package com.han.important

object DSEntity {

  object Document {

    sealed trait FieldBucket {
      def columnName: String
      FieldBucket.fieldBucketsForColunmName += (this.columnName -> this)
    }

    object FieldBucket {
      var fieldBucketsForColunmName = Map.empty[String, FieldBucket]
    }

    case object FieldBucket1 extends FieldBucket { def columnName: String = "data" }
    case object FieldBucket2 extends FieldBucket { def columnName = "data2" }

    // Force initialization of FieldBucket when Document is initialized
    FieldBucket1
    FieldBucket2
  }

  trait Field

  trait MappedField extends Field

  trait CanPredict {this: Field =>}

  class CompanyField extends MappedField

  class SomeField {
    val id = new CompanyField with CanPredict {

    }
  }

  abstract class Sample {
    def loadConfig = (10, 20)
    val (c1, c2) = loadConfig
  }

  class BootSample extends Sample

  abstract class Document

  class Company extends Document

  def main(args: Array[String]): Unit = {
    import Document._
    val c = new Company
    Document
    println(Document.FieldBucket.fieldBucketsForColunmName)
    val bs = new BootSample
    println(bs.c1)
    println(bs.c2)
  }
}


