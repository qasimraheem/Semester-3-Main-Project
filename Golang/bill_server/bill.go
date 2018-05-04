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
type getProduct struct{
	Name string
	Quantity string
	BuyPrice string
	SellPrice string
}
type getData struct {
	ID      bson.ObjectId `json:"_id" bson:"_id,omitempty"`
	Id string
	TotalItems string
	TotalPrice string
	Date string
	Product []getProduct
}
type res struct {
	Data    []getData
}

//data from post********************************************************************
type postProduct struct {
	Name string `json:"name"`
	Quantity string `json:"quantity"`
	BuyPrice string `json:"buyprice"`
	SellPrice string `json:"sellprice"`
}
type postData struct {
	ID      bson.ObjectId `json:"_id" bson:"_id,omitempty"`
	Id string `json:"billid"`
	TotalItems string `json:"totalitems"`
	TotalPrice string `json:"totalprice"`
	Date string `json:"date"`
	Product []postProduct `json:"Product"`
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
	db := session.DB(DBName).C(CName)
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
	db := session.DB(DBName).C(CName)
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
	db := session.DB(DBName).C(CName)
	results:=res{}
	//err = db.Find(bson.M{}).All(&results)

	//  |  for one result
	//  V
	//result := getData{}
	billid :=c.FormValue("billid")
	fmt.Println(billid)
	totalitems:=c.FormValue("totalitems")
	fmt.Println(totalitems)
	totalprice:=c.FormValue("totalprice")
	fmt.Println(totalprice)
	date :=c.FormValue("date")
	fmt.Println(date)

	//err = db.Find(bson.M{"$or":[]bson.M{bson.M{"cms":cms},bson.M{"billid":billid}}}).All(&results.Data)
	if (totalitems == "" && totalprice== "" && date== "")||(totalitems == "null" && totalprice== "null" && date== "null"){
		err = db.Find(bson.M{"billid":billid}).All(&results.Data)
	}else if (billid=="" && totalprice=="" && date=="")||(billid=="null" && totalprice=="null" && date=="null"){
		err = db.Find(bson.M{"totalitems":totalitems}).All(&results.Data)
	}else if (billid=="" && totalitems=="" && date=="")||(billid=="null" && totalitems=="null" && date=="null"){
		err = db.Find(bson.M{"totalprice":totalprice}).All(&results.Data)
	}else if (billid=="" && totalitems=="" && totalprice=="")||(billid=="null" && totalitems=="null" && totalprice=="null"){
		err = db.Find(bson.M{"date":date}).All(&results.Data)
	}else if (totalprice=="" && date=="")||(totalprice=="null" && date=="null"){
		err = db.Find(bson.M{"billid":billid,"totalitems":totalitems}).All(&results.Data)
	}else if (totalitems=="" && date=="")||(totalitems=="null" && date=="null"){
		err = db.Find(bson.M{"billid":billid,"totalprice":totalprice}).All(&results.Data)
	}else if (totalitems=="" && totalprice=="")||(totalitems=="null" && totalprice=="null"){
		err = db.Find(bson.M{"billid":billid,"date":date}).All(&results.Data)
	}else if (billid=="" && date=="")||(billid=="null" && date=="null"){
		err = db.Find(bson.M{"totalitems":totalitems,"totalprice":totalprice}).All(&results.Data)
	}else if (billid=="" && totalprice=="")||(billid=="null" && totalprice=="null"){
		err = db.Find(bson.M{"totalitems":totalitems,"date":date}).All(&results.Data)
	}else if (billid=="" && totalitems=="")||(billid=="null" && totalitems=="null"){
		err = db.Find(bson.M{"totalprice":totalprice,"date":date}).All(&results.Data)
	}else if (billid=="")||(billid=="null"){
		err = db.Find(bson.M{"totalitems":totalitems,"totalprice":totalprice,"date":date}).All(&results.Data)
	}else if (totalitems=="")||(totalitems=="null"){
		err = db.Find(bson.M{"billid":billid,"totalprice":totalprice,"date":date}).All(&results.Data)
	}else if (totalprice=="")||(totalprice=="null"){
		err = db.Find(bson.M{"billid":billid,"totalitems":totalitems,"date":date}).All(&results.Data)
	}else if (date=="")||(date=="null"){
		err = db.Find(bson.M{"billid":billid,"totalitems":totalitems,"totalprice":totalprice}).All(&results.Data)
	}else if (billid!="" && totalitems != "" && totalprice!= "" && date!= "")||(billid!="null" && totalitems != "null" && totalprice!= "null" && date!= "null"){
		err = db.Find(bson.M{"billid":billid,"totalitems":totalitems,"totalprice":totalprice,"date":date}).All(&results.Data)
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
	db := session.DB(DBName).C(CName)
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
	db := session.DB(DBName).C(CName)
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
	result := getData{}
	//var get_data getData
	//(db.Find(res.Data[0]).One(&get_data)
	err = db.Find(bson.M{"billid": res.Data[0].Id,"totalitems":res.Data[0].TotalItems,"totalprice":res.Data[0].TotalPrice,"date":res.Data[0].Date}).One(&result)
	fmt.Println("new is",res.Data[0].Id," ",res.Data[0].TotalItems," ",res.Data[0].TotalPrice)
	fmt.Println("result is",result.Id," ",result.TotalItems," ",result.TotalPrice)
	fmt.Println("new is",res.Data[1].Id," ",res.Data[1].TotalItems," ",res.Data[1].TotalPrice)
	db.Update(res.Data[0],res.Data[1])
	return c.JSON(http.StatusOK, &r)


}
func removeOne(c echo.Context)(err error){

	session, err := mgo.Dial("127.0.0.1:27017")
	db := session.DB(DBName).C(CName)
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
	//e.GET("/get", getOne)
	e.GET("/search", search)
	e.POST("/post", postOne)
	e.DELETE("/remove",removeOne)
	e.PUT("/update",put)
	e.Logger.Fatal(e.Start(":8082"))
	fmt.Println("start...")
}
