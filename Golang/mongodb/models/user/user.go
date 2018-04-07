package user

import (
	"gopkg.in/mgo.v2/bson"
	"time"
)

type Storage interface {
	Create(user *User) error
	Update(user *User) error
	Delete(user *User) error
	GetAll() (Users,error)
	GetByID(user *User) error
}

var storage  Storage

func SetStorage(s Storage){
	storage = s
}


type User struct{
	ID bson.ObjectId `bson: "_id,omitempty" `
	UserName string
	Email string
	Password string
	HashPassword []byte
	CreateAt time.Time
	UpdateAt time.Time

}

func (u *User) Create() error {
	return storage.Create(u)

}

func (u *User) Update() error {
	return storage.Update(u)

}

func (u *User) Delete() error {
	return storage.Delete(u)

}

func (u *User) GetAll() (Users ,error) {
	return storage.GetAll()

}

func (u *User) GetByID() error {
	return storage.GetByID(u)

}

type Users []User

func new() *User {
	return &User{}
}