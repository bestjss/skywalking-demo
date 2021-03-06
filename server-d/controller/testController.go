package controller

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func GetMethodA(c *gin.Context) {
	c.String(http.StatusOK, "this is Server D Method A")
}

func GetMethodB(c *gin.Context) {
	sleep := c.Param("sleep")
	c.String(http.StatusOK, "this is Server D Method B %s", sleep)
}

func GetMethodC(c *gin.Context) {
	c.String(http.StatusOK, "this is Server D Method C")
}
