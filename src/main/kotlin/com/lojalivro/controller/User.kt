package com.lojalivro.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class User {

    @GetMapping
    fun getTest(): String {
        println("Test")
        return "Test"
    }
}