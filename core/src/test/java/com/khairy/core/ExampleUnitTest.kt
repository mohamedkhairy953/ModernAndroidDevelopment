package com.khairy.core

import io.kotest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class ExampleUnitTest : StringSpec({
    "additionTest"{
        (1+2).shouldBe(3)
    }
    "subtraction test"{
        (2-1).shouldBe(1)
    }
})