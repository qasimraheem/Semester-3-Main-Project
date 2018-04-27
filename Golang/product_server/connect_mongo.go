package main

import
(
	"fmt"
	"gopkg.in/mgo.v2"
	"gopkg.in/mgo.v2/bson"
	"log"

)

type Player struct {
	Name string
	Cms string
	Gpa string
	Age string
}

func main() {

	session, err := mgo.Dial("127.0.0.1:27017")
	if err != nil {
		fmt.Println("ERROR FOUND:")
		panic(err)
	}
	defer session.Close()

	// Optional. Switch the session to a monotonic behavior.
	//session.SetMode(mgo.Monotonic, true)

	c := session.DB("player").C("player")
	//err = c.Insert(&Player{"one", "13936","4.45","20"},
	//	&Player{"two", "13936","5.00","20"})
	//if err != nil {
	//	log.Fatal(err)
	//}

	result := Player{}
	err = c.Find(bson.M{"name": "two"}).One(&result)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Cms:", result.Cms)
}