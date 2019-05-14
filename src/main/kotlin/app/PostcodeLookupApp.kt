package app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class))
@ComponentScan(basePackages = arrayOf("controllers"))
class PostcodeLookupApp {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(PostcodeLookupApp::class.java, *args)
        }
    }
}
