package mono.server

import mono.idl.v1.user.RegisterUserRequest
import mono.idl.v1.user.RegisterUserResponse
import mono.idl.v1.user.UserServiceGrpcKt
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GrpcUserService : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    companion object {
        val log = LoggerFactory.getLogger(GrpcUserService::class.java)!!
    }

    override suspend fun registerUser(request: RegisterUserRequest): RegisterUserResponse {
        log.info(request.loginId)

        return RegisterUserResponse
            .newBuilder()
            .setLoginId(request.loginId)
            .build()
    }
}