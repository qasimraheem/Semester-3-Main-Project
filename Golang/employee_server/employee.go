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
	"io"

	"path/filepath"
)

//data to get from db ***********************************************************
type getData struct {
	ID      bson.ObjectId `json:"_id" bson:"_id,omitempty"`
	UserName string
	Password string
	Image string
}
type res struct {
	Data    []getData
}

//data from post********************************************************************
type postData struct {
	ID      bson.ObjectId `json:"_id" bson:"_id,omitempty"`
	UserName string `json:"username"`
	Password string `json:"password"`
	Image string `json:"image"`
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
	DBName="employee"
	CName="employee"

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
	username:=c.FormValue("username")
	fmt.Println(username)
	password :=c.FormValue("password")
	fmt.Println(password)
	err = db.Find(bson.M{"username":username}).One(&result)
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
	username:=c.FormValue("username")
	fmt.Println(username)
	password :=c.FormValue("password")
	fmt.Println(password)
	image :=c.FormValue("image")
	fmt.Println(image)

	//err = db.Find(bson.M{"$or":[]bson.M{bson.M{"cms":cms},bson.M{"name":name}}}).All(&results.Data)
	if (username == "" && password== "")||(username == "null" && password== "null"){
		err = db.Find(bson.M{"image":image}).All(&results.Data)
	}else if (image=="" && password=="")||(image=="null" && password=="null"){
		err = db.Find(bson.M{"username":username}).All(&results.Data)
	}else if (image=="" && username=="")||(image=="null" && username=="null"){
		err = db.Find(bson.M{"password":password}).All(&results.Data)
	}else if (password=="")||(password=="null" ){
		err = db.Find(bson.M{"image":image,"username":username}).All(&results.Data)
	}else if (username=="")||(username=="null"){
		err = db.Find(bson.M{"image":image,"password":password}).All(&results.Data)
	}else if (image=="" )||(image=="null"){
		err = db.Find(bson.M{"username":username,"password":password}).All(&results.Data)
	}else if (image!="" && username != "" && password!= "" )||(image!="null" && username != "null" && password!= "null"){
		err = db.Find(bson.M{"image":image,"username":username,"password":password}).All(&results.Data)
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

	Image_server := "Image_server/Images/"
	ImageFormate:=(filepath.Ext(res.Image))
	ImageName:=Image_server+res.UserName+ImageFormate
	CopyFile(res.Image,ImageName)

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
	result := getData{}

	err = db.Find(bson.M{"username":res.Data[0].UserName,"password":res.Data[0].Password,"image": res.Data[0].Image,}).One(&result)

	db.Update(result,res.Data[1])
	Image_server := "Image_server/Images/"
	ImageName:=Image_server+res.Data[1].UserName
	ImageFormate:=(filepath.Ext(result.Image))
	ImageName=ImageName+ImageFormate

	CopyFile(result.Image,ImageName)
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
	//CopyFile("C:/Users/qasim/Desktop/a.jpg","Image_server/Images/b.jpg")
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
	e.Logger.Fatal(e.Start(":8081"))
	fmt.Println("start...")
}

func CopyFile(src, dst string) (err error) {
	sfi, err := os.Stat(src)
	if err != nil {
		return
	}
	if !sfi.Mode().IsRegular() {
		// cannot copy non-regular files (e.g., directories,
		// symlinks, devices, etc.)
		return fmt.Errorf("CopyFile: non-regular source file %s (%q)", sfi.Name(), sfi.Mode().String())
	}
	dfi, err := os.Stat(dst)
	if err != nil {
		if !os.IsNotExist(err) {
			return
		}
	} else {
		if !(dfi.Mode().IsRegular()) {
			return fmt.Errorf("CopyFile: non-regular destination file %s (%q)", dfi.Name(), dfi.Mode().String())
		}
		if os.SameFile(sfi, dfi) {
			return
		}
	}
	if err = os.Link(src, dst); err == nil {
		return
	}
	err = copyFileContents(src, dst)
	return
}

// copyFileContents copies the contents of the file named src to the file named
// by dst. The file will be created if it does not already exist. If the
// destination file exists, all it's contents will be replaced by the contents
// of the source file.
func copyFileContents(src, dst string) (err error) {
	in, err := os.Open(src)
	if err != nil {
		return
	}
	defer in.Close()
	out, err := os.Create(dst)
	if err != nil {
		return
	}
	defer func() {
		cerr := out.Close()
		if err == nil {
			err = cerr
		}
	}()
	if _, err = io.Copy(out, in); err != nil {
		return
	}
	err = out.Sync()
	return
}