package com.rspl.kmmmvvmexample.user.data.datasource
import com.rspl.kmmmvvmexample.core.Resource
import com.rspl.kmmmvvmexample.user.data.model.UserModel
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.call.ReceivePipelineException
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import io.ktor.http.HttpMethod
import io.ktor.http.takeFrom
import io.ktor.http.encodedPath
import io.ktor.http.path

class UserDataSourceImpl: UserDataSource {
    private val _httpClient = HttpClient()
    private val json = Json
    override suspend fun login(username: String, password: String): UserModel {
        val builder = HttpRequestBuilder()
        builder.method = HttpMethod.Post
        builder.url {
            takeFrom("http://172.16.6.88:83")
            encodedPath = encodedPath.let { startingPath ->
                path("/api/login")
                return@let startingPath + encodedPath.substring(1)
            }
            @Suppress("UNNECESSARY_SAFE_CALL")
            with(parameters) {
                append("email", username)
                append("password", password)
            }
        }

        with(builder.headers) {
            append("Accept", "application/json")
        }

        try {
            val serializer = UserModel.serializer()

            val result: HttpResponse = _httpClient.request(builder)
            val responseText = result.bodyAsText()
            return json.decodeFromString(serializer,responseText)
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }
}