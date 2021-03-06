package main

import (
	"log"
	controller "serverd/controller"

	"github.com/SkyAPM/go2sky"
	v3 "github.com/SkyAPM/go2sky-plugins/gin/v3"
	"github.com/SkyAPM/go2sky/reporter"
	"github.com/gin-gonic/gin"
)

func main() {
	re, err := reporter.NewGRPCReporter("127.0.0.1:11800")
	if err != nil {
		log.Fatalf("new reporter error %v \n", err)
	}
	defer re.Close()

	tracer, err := go2sky.NewTracer("server-d", go2sky.WithReporter(re))
	if err != nil {
		log.Fatalf("create tracer error %v \n", err)
	}

	gin.SetMode(gin.ReleaseMode)
	r := gin.New()

	//Use go2sky middleware with tracing
	r.Use(v3.Middleware(r, tracer))

	r.GET("/test/method-a", controller.GetMethodA)
	r.GET("/test/method-b/:sleep", controller.GetMethodB)
	r.GET("/test/method-c", controller.GetMethodC)
	r.Run(":8084")
}
