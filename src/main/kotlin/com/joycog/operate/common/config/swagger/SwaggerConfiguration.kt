package com.joycog.operate.common.config.swagger

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

/**
 * @fileName SwaggerConfigurer
 * @author kimkihyeon
 * @since 2023/05/09
 * @version 1.0
 *
 * @Modification Information
 * @
 * @    DATE           AUTHOR          NOTE
 * @ -----------     ----------    -------------------
 * @ 2023/05/09     kimkihyeon       최초 작성
 */
@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Value("\${application.host}")
    private lateinit var host: String

    @Value("\${application.license}")
    private lateinit var license: String

    @Value("\${application.version}")
    private lateinit var version: String

    @Value("\${application.title}")
    private lateinit var title: String

    @Value("\${application.description}")
    private lateinit var description: String

    @Value("\${application.name}")
    private lateinit var name: String

    @Value("\${application.email}")
    private lateinit var email: String

    private fun documentInformation(): ApiInfo {
        return ApiInfoBuilder()
            .title(title)
            .description(description)
            .license("BackEnd Developer ::: $license")
            .contact(Contact(name, host, email))
            .version(version)
            .build()
    }

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .useDefaultResponseMessages(false)
            .apiInfo(this.documentInformation())
            .securitySchemes(listOf(apiKey()))
            .securityContexts(listOf(securityContext()))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.joycog.operate"))
            .paths(PathSelectors.ant("/**"))
            .build()
    }

    fun defaultAuth(): List<SecurityReference?>? {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        return listOf(SecurityReference("JWT", authorizationScopes))
    }

    private fun apiKey(): ApiKey {
        return ApiKey("JWT", "Authorization", "header")
    }

    private fun securityContext(): SecurityContext {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .build()
    }

    private fun getConsumeContentTypes(): MutableSet<String> {
        val consumes: MutableSet<String> = mutableSetOf()
        consumes.add("application/json;charset=UTF-8")
        consumes.add("application/x-www-form-urlencoded")
        return consumes
    }

    private fun getProduceContentTypes(): Set<String> {
        val produces: Set<String> = HashSet()
        produces.plus("application/json;charset=UTF-8")
        return produces
    }


    @Bean
    fun swaggerVersionController(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("00. 테스트")
            .consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .apiInfo(documentInformation()).select()
            .apis(RequestHandlerSelectors.basePackage("com.joycog.operate.api.login"))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false)
            .securityContexts(Collections.singletonList(securityContext()))
            .securitySchemes(listOf(apiKey()))
    }

}