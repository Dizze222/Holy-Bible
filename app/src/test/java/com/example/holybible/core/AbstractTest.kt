package com.example.holybible.core

import junit.framework.Assert.assertTrue
import org.junit.Test
import java.io.IOException

class AbstractTest {

    @Test
    fun testSuccess(){
        val dataObject = TestDataObject.Success("a","b")
        val domainObject = dataObject.map(DataMapper.Base())
        assertTrue(domainObject is DomainObject.Success)
    }

    @Test
    fun testFail(){
        val dataObject = TestDataObject.Fail(IOException())
        val domainObject = dataObject.map(DataMapper.Base())
        assertTrue(domainObject is DomainObject.Fail)
    }
    sealed class TestDataObject : Abstract.Object<DomainObject,DataMapper>{
        abstract override fun map(mapper: DataMapper) : DomainObject

        class Success(private val textOne: String,private val textTwo: String) : TestDataObject(){
            override fun map(mapper: DataMapper) = mapper.map(textOne,textTwo)

        }
        class Fail(private val e: Exception) : TestDataObject(){
            override fun map(mapper: DataMapper) = mapper.map(e)

        }
    }
    sealed class DomainObject : Abstract.Object<UIObject,DomainToUIMapper>{

        class Success(private val textCombined: String) : DomainObject(){
            override fun map(mapper: DomainToUIMapper) : UIObject{
                TODO("not done yet")
            }

        }
        class Fail : DomainObject(){
            override fun map(mapper: DomainToUIMapper): UIObject {
                TODO("not done yet")
            }

        }
    }

    sealed class UIObject

    interface DomainToUIMapper : Abstract.Mapper{
        fun map(textOne: String,textTwo: String)

    }


    interface DataMapper : Abstract.Mapper{
        fun map(textOne: String,textTwo: String) : DomainObject
        fun map(e: Exception) : DomainObject
        class Base : DataMapper{
            override fun map(textOne: String, textTwo: String): DomainObject {
                return DomainObject.Success("$textOne $textTwo")
            }

            override fun map(e: Exception): DomainObject {
                return DomainObject.Fail()
            }

        }
    }


}

