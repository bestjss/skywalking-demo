package main

import (
	"github.com/gin-gonic/gin"

	controller "serverd/controller"
)

func main() {
	router := gin.Default()
	router.GET("/test/method-a", controller.GetMethodA)
	router.GET("/test/method-b/:sleep", controller.GetMethodB)
	router.GET("/test/method-c", controller.GetMethodC)

	// By default it serves on :8080 unless a
	// PORT environment variable was defined.
	// router.Run()
	router.Run(":8084")
}
