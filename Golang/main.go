package main

import (
	"net/http"
	"os"
	//"log"
	"fmt"
	"io/ioutil"
	"log"

	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
	//"encoding/json"
	"encoding/json"
	//"os"
)

type data struct {
	Id     string
	Name   string
	Symbol string
	Rank   string
}

type res struct {
	Success bool
	Data    data
}

func handle(c echo.Context) error {
	resp, err := http.Get("https://api.coinmarketcap.com/v1/ticker/ethereum/")
	if err != nil {
		// handle error
		fmt.Println("error")
	}
	defer resp.Body.Close() // resp.Body.Close() this statement was next to defer,  defer is used to call any statement next to it, when a function is closed, okkor
	// easy way to understand it is , if a for loop runs for 5 time, when lop is in tis 5th iterations and near to exit defer will execute state ment nect to it like in this case it was "resp.Body.Close()"
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Fatal(err)
	}
	var jsonBlob = []byte(body)
	var d []data
	error := json.Unmarshal(jsonBlob, &d)
	if error != nil {
		fmt.Println("error:", error)
	}
	var r res
	r.Success = true
	r.Data = d[0]

	fmt.Println(r)

	return c.JSON(http.StatusOK, r)
}

type emailRes struct {
	Success bool
	Data    data
}

func getEmail(c echo.Context) error {

	res := emailRes{
		Success: true,
	}

	b, err := json.Marshal(res)
	if err != nil {
		fmt.Println("error:", err)
	}
	fmt.Println("this is b=", b)
	os.Stdout.Write(b)

	var jsonBlob = []byte(b)
	var r emailRes
	error := json.Unmarshal(jsonBlob, &r)
	if error != nil {
		fmt.Println("error:", error)
	}
	fmt.Println(r)

	return c.JSON(http.StatusOK, &r)
}

func main() {
	e := echo.New()
	e.Use(middleware.CORSWithConfig(middleware.CORSConfig{
		AllowOrigins: []string{"*"},
		AllowMethods: []string{echo.GET, echo.PUT, echo.POST, echo.DELETE},
	}))
	e.GET("/", handle)
	e.POST("/qasim", getEmail)
	e.Logger.Fatal(e.Start(":7070"))
	fmt.Println("start...")
}
