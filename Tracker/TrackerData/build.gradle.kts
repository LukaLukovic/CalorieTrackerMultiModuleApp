apply {
    from("$rootDir/base-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.trackerDomain))


    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.moshiConverter)


    "implementation"(Room.roomKtx)
    "implementation"(Room.roomRuntime)
    "kapt"(Room.roomCompiler)
}
