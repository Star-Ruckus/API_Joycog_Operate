package com.joycog.operate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan
@SpringBootApplication
class ApiJoycogOperateApplication

fun main(args: Array<String>) {
    runApplication<ApiJoycogOperateApplication>(*args)
}
