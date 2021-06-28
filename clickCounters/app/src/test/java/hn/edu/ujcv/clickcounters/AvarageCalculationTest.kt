package hn.edu.ujcv.clickcounters

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class AvarageCalculationTest{
    @Test
    fun `Avarage returns number`(){
            val counter  =100
        var result  = AvarageCalculation.avarage(counter)
        assertThat(result).isNotNaN()
    }


}