package main

import (
	//"net/http"
	//"os"
	//"log"
	"fmt"
	//"io/ioutil"
	"log"

	//"github.com/labstack/echo"
	//"github.com/labstack/echo/middleware"
	//"encoding/json"
	//"encoding/json"
	//"os"
	"gopkg.in/mgo.v2"
	"gopkg.in/mgo.v2/bson"
	"encoding/json"
	//"net/http"
	"net/http"
	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
	"os"
)

type data struct {
	Name string
	Cms string
	Gpa string
	Age string
}

type res struct {
	Data    []data
}

//func connectMongo(){
func handle(c echo.Context) error {
	session, err := mgo.Dial("127.0.0.1:27017")
	if err != nil {
		fmt.Println("ERROR FOUND:")
		panic(err)
	}
	defer session.Close()

	// Optional. Switch the session to a monotonic behavior.
	//session.SetMode(mgo.Monotonic, true)

	db := session.DB("player").C("player")
	full:=res{}
	err = db.Find(bson.M{"cms": "13936"}).All(&full.Data)
	//result := data{}
	//err = db.Find(bson.M{"cms": "13936"}).One(&result)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(full)


	buff, _ := json.Marshal(&full)

	fmt.Println(string(buff))

	json.Unmarshal(buff, &full)
	return c.JSON(http.StatusOK,&full)


}

//func handle(c echo.Context) error {
//
//	resp, err := http.Get("https://api.coinmarketcap.com/v1/ticker/ethereum/")
//	if err != nil {
//		// handle error
//	}
//	defer resp.Body.Close() // resp.Body.Close() this statement was next to defer,  defer is used to call any statement next to it, when a function is closed, okkor
//	// easy way to understand it is , if a for loop runs for 5 time, when lop is in tis 5th iterations and near to exit defer will execute state ment nect to it like in this case it was "resp.Body.Close()"
//	body, err := ioutil.ReadAll(resp.Body)
//	if err != nil {
//		log.Fatal(err)
//	}
//	var jsonBlob = []byte(body)
//	var d []data
//	error := json.Unmarshal(jsonBlob, &d)
//	if error != nil {
//		fmt.Println("error:", error)
//	}
//	var r res
//	r.Success = true
//	r.Data = d[0]
//
//	fmt.Println(r)
//
//	return c.JSON(http.StatusOK, r)
//}

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
	//connectMongo()
	e.GET("/", handle)
	//e.POST("/qasim", getEmail)
	e.Logger.Fatal(e.Start(":8080"))
	fmt.Println("start...")
}
