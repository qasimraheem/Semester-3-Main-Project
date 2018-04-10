package main

import (
	"fmt"
	"log"
	"gopkg.in/mgo.v2"
	"gopkg.in/mgo.v2/bson"
	"encoding/json"
	"net/http"
	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
	"os"
)

//data to get from db ***********************************************************
type getData struct {
	ID      bson.ObjectId `json:"_id" bson:"_id,omitempty"`
	Name string
	Quantity string
	BuyPrice string
	SellPrice string
}
type res struct {
	Data    []getData
}

//data from post********************************************************************
type postData struct {
	ID      bson.ObjectId `json:"_id" bson:"_id,omitempty"`
	Name string `json:"name"`
	Quantity string `json:"quantity"`
	BuyPrice string `json:"buyprice"`
	SellPrice string `json:"sellprice"`
}
type Res struct {
	Data []postData`json:"Data"`
}
type updateData struct {
	old postData
	change postData
}

//connection to mongo ***************************************************************
const (
	DBName="golang"
	CName="users"

)
var session *mgo.Session
var err error
func connectMongo(url string) (*mgo.Session , error){

	if(session == nil){
		session, err = mgo.Dial(url)
		// Optional. Switch the session to a monotonic behavior.
		//session.SetMode(mgo.Monotonic, true)
		if err != nil {
			fmt.Println("ERROR FOUND:")
			panic(err)
		}
	}
	return session,err
}

//GET *********************************************************************************
func getAll(c echo.Context) error {

	session ,err := connectMongo("127.0.0.1:27017")
	db := session.DB("product").C("product")
	results:=res{}
	err = db.Find(bson.M{}).All(&results.Data)

	//  |  for one result
	//  V
	//result := getData{}
	//err = db.Find(bson.M{"name": "two"}).One(&result)

	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(results)
	buff, _ := json.Marshal(&results)
	fmt.Println(string(buff))

	json.Unmarshal(buff, &results)
	return c.JSON(http.StatusOK,&results)

}
func getOne(c echo.Context) error {

	session ,err := connectMongo("127.0.0.1:27017")
	db := session.DB("player").C("player")
	//results:=res{}
	//err = db.Find(bson.M{}).All(&results.Data)

	//  |  for one result
	//  V
	result := getData{}
	cms:=c.FormValue("cms")
	fmt.Println(cms)
	name :=c.FormValue("name")
	fmt.Println(name)
	err = db.Find(bson.M{"name": name}).One(&result)
	if err != nil {
		//log.Fatal(err)
	}
	fmt.Println(result)
	buff, _ := json.Marshal(&result)
	fmt.Println(string(buff))

	json.Unmarshal(buff, &result)
	return c.JSON(http.StatusOK,&result)

}

func search(c echo.Context) error {

	session ,err := connectMongo("127.0.0.1:27017")
	db := session.DB("product").C("product")
	results:=res{}
	//err = db.Find(bson.M{}).All(&results)

	//  |  for one result
	//  V
	//result := getData{}
	name :=c.FormValue("name")
	fmt.Println(name)
	quantity:=c.FormValue("quantity")
	fmt.Println(quantity)
	buyprice :=c.FormValue("buyprice")
	fmt.Println(buyprice)
	sellprice :=c.FormValue("sellprice")
	fmt.Println(sellprice)

	//err = db.Find(bson.M{"$or":[]bson.M{bson.M{"cms":cms},bson.M{"name":name}}}).All(&results.Data)
	if quantity == "" && buyprice== "" && sellprice== ""{
		err = db.Find(bson.M{"name":name}).All(&results.Data)
	}else if name=="" && buyprice=="" && sellprice==""{
		err = db.Find(bson.M{"quantity":quantity}).All(&results.Data)
	}else if name=="" && quantity=="" && sellprice==""{
		err = db.Find(bson.M{"buyprice":buyprice}).All(&results.Data)
	}else if name=="" && quantity=="" && buyprice==""{
		err = db.Find(bson.M{"sellprice":sellprice}).All(&results.Data)
	}else if buyprice=="" && sellprice==""{
		err = db.Find(bson.M{"name":name,"quantity":quantity}).All(&results.Data)
	}else if quantity=="" && sellprice==""{
		err = db.Find(bson.M{"name":name,"buyprice":buyprice}).All(&results.Data)
	}else if quantity=="" && buyprice==""{
		err = db.Find(bson.M{"name":name,"sellprice":sellprice}).All(&results.Data)
	}else if name=="" && sellprice==""{
		err = db.Find(bson.M{"quantity":quantity,"buyprice":buyprice}).All(&results.Data)
	}else if name=="" && buyprice==""{
		err = db.Find(bson.M{"quantity":quantity,"sellprice":sellprice}).All(&results.Data)
	}else if name=="" && quantity==""{
		err = db.Find(bson.M{"buyprice":buyprice,"sellprice":sellprice}).All(&results.Data)
	}else if name==""{
		err = db.Find(bson.M{"quantity":quantity,"buyprice":buyprice,"sellprice":sellprice}).All(&results.Data)
	}else if quantity==""{
		err = db.Find(bson.M{"name":name,"buyprice":buyprice,"sellprice":sellprice}).All(&results.Data)
	}else if buyprice==""{
		err = db.Find(bson.M{"name":name,"quantity":quantity,"sellprice":sellprice}).All(&results.Data)
	}else if sellprice==""{
		err = db.Find(bson.M{"name":name,"quantity":quantity,"buyprice":buyprice}).All(&results.Data)
	}else if name!="" && quantity != "" && buyprice!= "" && sellprice!= ""{
		err = db.Find(bson.M{"name":name,"quantity":quantity,"buyprice":buyprice,"sellprice":sellprice}).All(&results.Data)
	}else{

	}

	if err != nil {
		//log.Fatal(err)
	}
	fmt.Println(results)
	buff, _ := json.Marshal(&results)
	fmt.Println(string(buff))

	json.Unmarshal(buff, &results)
	return c.JSON(http.StatusOK,&results)

}
//POST *********************************************************************************
func postOne(c echo.Context)(err error){

	session, err := mgo.Dial("127.0.0.1:27017")
	db := session.DB("product").C("product")
	//name:=c.FormValue("Cms")
	//fmt.Println(name)
	//name =c.FormValue("name")
	//fmt.Println(name)
	//u:=new (postData)
	u := new(postData)
	if err = c.Bind(&u);err != nil{
	}
	res := postData{}
	//fmt.Println("this is C:",postData{})
	res = *u
	b, err := json.Marshal(res)
	if err != nil {
		fmt.Println("error:", err)
	}
	//fmt.Println("this is res=", res)
	os.Stdout.Write(b)

	var jsonBlob = []byte(b)
	var r Res
	error := json.Unmarshal(jsonBlob, &r)
	if error != nil {
		fmt.Println("error:", error)
	}
	fmt.Println(res)
	db.Insert(res)
	return c.JSON(http.StatusOK, &r)


}
func put(c echo.Context)(err error){

	session, err := mgo.Dial("127.0.0.1:27017")
	db := session.DB("product").C("product")
	//name:=c.FormValue("Cms")
	//fmt.Println(name)
	//name =c.FormValue("name")
	//fmt.Println(name)
	//u:=new (postData)
	u := new(Res)
	if err = c.Bind(&u);err != nil{
	}
	res := Res{}
	//fmt.Println("this is C:",postData{})
	res = *u
	b, err := json.Marshal(res)
	if err != nil {
		fmt.Println("error:", err)
	}
	//fmt.Println("this is res=", res)
	os.Stdout.Write(b)

	var jsonBlob = []byte(b)
	var r Res
	error := json.Unmarshal(jsonBlob, &r)
	if error != nil {
		fmt.Println("error:", error)
	}
	fmt.Println(res)
	db.Update(res.Data[0],res.Data[1])
	return c.JSON(http.StatusOK, &r)


}
func removeOne(c echo.Context)(err error){

	session, err := mgo.Dial("127.0.0.1:27017")
	db := session.DB("product").C("product")
	//name:=c.FormValue("Cms")
	//fmt.Println(name)
	//name =c.FormValue("name")
	//fmt.Println(name)
	//u:=new (postData)
	u := new(postData)
	if err = c.Bind(&u);err != nil{
	}
	res := postData{}
	//fmt.Println("this is C:",postData{})
	res = *u
	b, err := json.Marshal(res)
	if err != nil {
		fmt.Println("error:", err)
	}
	//fmt.Println("this is res=", res)
	os.Stdout.Write(b)

	var jsonBlob = []byte(b)
	var r Res
	error := json.Unmarshal(jsonBlob, &r)
	if error != nil {
		fmt.Println("error:", error)
	}
	fmt.Println(res)
	db.Remove(res)
	return c.JSON(http.StatusOK, &r)


}


func main() {
	e := echo.New()
	e.Use(middleware.CORSWithConfig(middleware.CORSConfig{
		AllowOrigins: []string{"*"},
		AllowMethods: []string{echo.GET, echo.PUT, echo.POST, echo.DELETE},
	}))

	e.GET("/", getAll)
	e.GET("/get", getOne)
	e.GET("/search", search)
	e.POST("/post", postOne)
	e.DELETE("/remove",removeOne)
	e.PUT("/update",put)
	e.Logger.Fatal(e.Start(":8080"))
	fmt.Println("start...")
}
