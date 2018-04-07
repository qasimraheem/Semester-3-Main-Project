package data

import (
	"gopkg.in/mgo.v2"
	"log"
)

const (
	DBName="golang"
	CName="users"

)

var session *mgo.Session

func createDBSession(){
	var err error
	session, err =mgo.Dial("localhost")
	if err != nil {
		log.Fatal(err)
	}
}
func getSession() *mgo.Session{
	if session==nil{
		createDBSession()
	}
	return session
}
func Init(){
	createDBSession()
}