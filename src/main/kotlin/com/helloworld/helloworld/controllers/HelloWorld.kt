package com.helloworld.helloworld.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("helloworld")
class HelloWorld {

    @GetMapping
    fun helloWorld(): String {
        return "Hello World"
    }

}