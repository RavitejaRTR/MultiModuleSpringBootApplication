rootProject.name = "MultiModule-SpringBootApplication"
include(":application", ":service")
project(":application").projectDir = file("application")
project(":service").projectDir = file("service")
