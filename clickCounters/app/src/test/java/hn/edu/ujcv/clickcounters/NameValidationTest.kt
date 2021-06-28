package hn.edu.ujcv.clickcounters

import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NameValidationTest {
    @Test
    fun `name is empty return false`(){
        val name   =""
        var result  = NameValidation.playerName(name)
        Truth.assertThat(result).isFalse()
    }
    @Test
    fun `name is less than 3 letters `(){
        val name  = "ab"
        var result = NameValidation.playerName(name)
        Truth.assertThat(result).isFalse()
    }

}